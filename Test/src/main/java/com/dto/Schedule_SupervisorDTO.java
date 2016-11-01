package com.dto;

import org.apache.ibatis.type.Alias;

@Alias("Schedule_SupervisorDTO")
public class Schedule_SupervisorDTO {

	private String tsno;
	private String ssid;
	private String s_code;
	
	public Schedule_SupervisorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Schedule_SupervisorDTO(String tsno, String ssid, String s_code) {
		super();
		this.tsno = tsno;
		this.ssid = ssid;
		this.s_code = s_code;
	}

	public String getTsno() {
		return tsno;
	}

	public void setTsno(String tsno) {
		this.tsno = tsno;
	}

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public String getS_code() {
		return s_code;
	}

	public void setS_code(String s_code) {
		this.s_code = s_code;
	}

	@Override
	public String toString() {
		return "Schedule_SupervisorDTO [tsno=" + tsno + ", ssid=" + ssid + ", s_code=" + s_code + "]";
	}
	
	
	
	
}
