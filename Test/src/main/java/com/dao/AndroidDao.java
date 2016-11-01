package com.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.ExamineeDTO;
import com.dto.Personal_DataDTO;
import com.dto.QualificationDTO;
import com.dto.Schedule_SupervisorDTO;
import com.dto.SupervisorDTO;
import com.dto.Test_ScheduleDTO;
import com.exception.CommonException;

@Repository
public class AndroidDao {
	
	@Autowired
	SqlSessionTemplate template;
	
	public SupervisorDTO login(HashMap<String, String> map) {
		
		SupervisorDTO dto = template.selectOne("android.login", map);
		
		return dto;
	}
	
	public SupervisorDTO supervisorInfo(String ssid) {
		
		SupervisorDTO dto = template.selectOne("android.supervisorInfo", ssid);
		
		return dto;
	}
	
	public Schedule_SupervisorDTO selectSS(String ssid) throws CommonException{
		
		 Schedule_SupervisorDTO dto = template.selectOne("android.selectSS", ssid);
		
		if(dto == null) {
			throw new CommonException("맞는 일정이 없습니다");
		}
		
		return dto;
	}
	
	public Test_ScheduleDTO selectTS(String ssid) {
		
		 Test_ScheduleDTO dto = template.selectOne("android.selectTS", ssid);
		
		return dto;
	}
	
	public QualificationDTO selectQ(String qcode) throws CommonException {
		
		QualificationDTO dto = template.selectOne("android.selectQ", qcode);
		
		if(dto == null) {
			throw new  CommonException("종목 불러오기 실패");
		}
		
		return dto;
	}
	
	public List<String> getLicense(String eid) {

		List<String> list = template.selectList("android.license", eid);
				
		return list;
	}
	
	public List<ExamineeDTO> selectE(String ssid) {

		 List<ExamineeDTO> list = template.selectList("android.selectE", ssid);
				
		return list;
	}
	
	public void update(Personal_DataDTO dto) throws CommonException {
		
		int n = 0;
		
		try {
			n = template.update("android.update", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(n == 0) {
			throw new CommonException("수정 실패!");
		}
			
		
	}
	
	
	
	
}
