package com.service;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AndroidDao;
import com.dto.ExamineeDTO;
import com.dto.Personal_DataDTO;
import com.dto.QualificationDTO;
import com.dto.Schedule_SupervisorDTO;
import com.dto.SupervisorDTO;
import com.dto.Test_ScheduleDTO;
import com.dto.Write_SubjectDTO;
import com.exception.CommonException;

@Service
public class AndroidService {
	
	@Autowired
	AndroidDao dao;
	
	@Autowired
	SqlSessionTemplate template;
		
	// 안드로이드 로그인
	public SupervisorDTO login(HashMap<String, String> map) {
		
		return dao.login(map);
	}
	
	// 감독관 정보 얻기
	public SupervisorDTO supervisorInfo(String ssid) {
		
		return dao.supervisorInfo(ssid);
	}
	
	// 감독관 시험 일정 및 장소
	public Schedule_SupervisorDTO selectSS(String ssid) throws CommonException{
		
		return dao.selectSS(ssid);
	}
	
	// 감독관 시험 일정 정보 얻기
	public Test_ScheduleDTO selectTS(String ssid) {
		
		return dao.selectTS(ssid);
	}
		
	// 수험생들 종목 얻기
	public QualificationDTO selectQ(String qcode) throws CommonException {

		return dao.selectQ(qcode);
	}
	
	// 수험생이 갖고 있는 자격증
	public List<String> getLicense(String eid) {

		return dao.getLicense(eid);
	}
	
	// 수험생 정보
	public List<ExamineeDTO> selectE(String ssid) {

		return dao.selectE(ssid);
	}
	
	public void update(Personal_DataDTO dto) throws CommonException {
		
		dao.update(dto);
		
	}
	

	
}
