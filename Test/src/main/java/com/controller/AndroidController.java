package com.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dto.ExamineeDTO;
import com.dto.InfoVO;
import com.dto.Personal_DataDTO;
import com.dto.QualificationDTO;
import com.dto.Schedule_SupervisorDTO;
import com.dto.SupervisorDTO;
import com.dto.Test_ScheduleDTO;
import com.dto.Write_SubjectDTO;
import com.exception.CommonException;
import com.service.AndroidService;

@Controller
public class AndroidController {
	
	@Autowired
	AndroidService service;
	
	@ExceptionHandler
	public String error() {
		return "error";
	}
	
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public void test() {
		Personal_DataDTO dto = new Personal_DataDTO("10003010201608", "b", "y", null);
		System.out.println(dto);
		
		try {
			service.update(dto);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 안드로이드 로그인
	@RequestMapping(value = "/supervisor/{ssid}/{spw}", method = RequestMethod.GET)
	public @ResponseBody String login(@PathVariable String ssid, @PathVariable String spw) {
		
		HashMap<String, String> map = new HashMap<>();
		map.put("userid", ssid);
		map.put("passwd", spw);
		
		SupervisorDTO dto = service.login(map);
		
		// 로그인 실패시 처리
		if( dto == null) {
			return "fail";
		} else {
			return "success";
		}
		
	}
	
	// 안드로이드 감독 정보
	@RequestMapping(value = "/supervisor/{ssid}", method = RequestMethod.GET)
	public @ResponseBody SupervisorDTO supervisorInfo(@PathVariable String ssid) {
		
		SupervisorDTO dto = service.supervisorInfo(ssid);
		
		return dto;
		
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public @ResponseBody Personal_DataDTO update(@RequestBody Personal_DataDTO dto) {		
	
		try {
			service.update(dto);
		} catch (CommonException e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	
	@RequestMapping(value = "/image/{eid}", method = RequestMethod.GET, produces = "image/jpg")
	public @ResponseBody byte[] getFile(@PathVariable String eid)  {
	    try {
	    	
	        // Retrieve image from the classpath.
	        InputStream is = this.getClass().getResourceAsStream("/Image/" + eid + ".jpg"); 

	        // Prepare buffered image.
	        BufferedImage img = ImageIO.read(is);

	        // Create a byte array output stream.
	        ByteArrayOutputStream bao = new ByteArrayOutputStream();

	        // Write to output stream
	        ImageIO.write(img, "jpg", bao);

	        return bao.toByteArray();
	    } catch (IOException e) {
	        e.printStackTrace();
	        // throw new RuntimeException(e);
	        return null;
	    }
	}
	
	
	@RequestMapping(value = "/test/supervisor/{ssid}", method = RequestMethod.GET)
	public @ResponseBody InfoVO info(@PathVariable String ssid) {
		
		InfoVO vo = new InfoVO();
		Schedule_SupervisorDTO ssdto = null;
		try {
			ssdto = service.selectSS(ssid);
			
			Test_ScheduleDTO dtoTS = service.selectTS(ssdto.getTsno());
			List<ExamineeDTO> listE = service.selectE(ssdto.getSsid());
			
			// 면제 과목 얻어오기
			for (ExamineeDTO examineeDTO : listE) {
				List<String> subject = pass(examineeDTO);
				examineeDTO.setSubject(subject);
			}
			
			vo.setDtoTS(dtoTS);
			vo.setListE(listE);
			
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return vo;
		
	}
				
	// 면제 과목 얻어오기
	private List<String> pass(ExamineeDTO dto) {
		
		QualificationDTO license = null;
		QualificationDTO test = null;
		List<String> subject = new ArrayList<>();
		
		List<String> getLicense = service.getLicense(dto.getEid());	
		if(getLicense.size() != 0) {
			
			for(int i = 0; i<getLicense.size(); i++) {
				try {
					
					license = service.selectQ(getLicense.get(i));
					test = service.selectQ(dto.getQcode());
					
					if(license.getQclass().equalsIgnoreCase(test.getQclass())) {
						if(license.getQfield().equalsIgnoreCase(test.getQfield())) {
							
							List<Write_SubjectDTO> li = license.getList();

							List<Write_SubjectDTO> te = test.getList();
							
							for(int j =0; j < li.size(); j++) {
								for(int k =0; k < te.size(); k++) {
									
									if(li.get(j).getWsname().equalsIgnoreCase(te.get(k).getWsname())) {
										subject.add(li.get(j).getWsname());
									}
									
								}
							}
						}
					}
					
					
				} catch (CommonException e) {
					System.out.println(e.getMessage());
				}
				
			}
					
		}
		
		return subject;	
	}
	
}
