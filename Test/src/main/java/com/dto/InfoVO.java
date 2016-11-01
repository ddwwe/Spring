package com.dto;

import java.util.List;

public class InfoVO {

	private Test_ScheduleDTO dtoTS;
	private List<ExamineeDTO> listE;

	public InfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InfoVO(Test_ScheduleDTO dtoTS, List<ExamineeDTO> listE) {
		super();
		this.dtoTS = dtoTS;
		this.listE = listE;
	}

	public Test_ScheduleDTO getDtoTS() {
		return dtoTS;
	}

	public void setDtoTS(Test_ScheduleDTO dtoTS) {
		this.dtoTS = dtoTS;
	}

	public List<ExamineeDTO> getListE() {
		return listE;
	}

	public void setListE(List<ExamineeDTO> listE) {
		this.listE = listE;
	}

}
