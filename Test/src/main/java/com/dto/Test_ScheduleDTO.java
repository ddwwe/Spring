package com.dto;

import org.apache.ibatis.type.Alias;

@Alias("Test_ScheduleDTO")
public class Test_ScheduleDTO {

	private String tsno;
	private String tstitle;
	private String tpdate;
	
	public Test_ScheduleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Test_ScheduleDTO(String tsno, String tstitle, String tpdate) {
		super();
		this.tsno = tsno;
		this.tstitle = tstitle;
		this.tpdate = tpdate;
	}

	public String getTsno() {
		return tsno;
	}

	public void setTsno(String tsno) {
		this.tsno = tsno;
	}

	public String getTstitle() {
		return tstitle;
	}

	public void setTstitle(String tstitle) {
		this.tstitle = tstitle;
	}

	public String getTpdate() {
		return tpdate;
	}

	public void setTpdate(String tpdate) {
		this.tpdate = tpdate;
	}

	@Override
	public String toString() {
		return "Test_ScheduleDTO [tsno=" + tsno + ", tstitle=" + tstitle + ", tpdate=" + tpdate + "]";
	}
	
	
	
	
}
