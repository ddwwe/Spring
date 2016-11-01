package com.dto;

import org.apache.ibatis.type.Alias;

@Alias("Write_SubjectDTO")
public class Write_SubjectDTO {

	private String wscode;
	private String wsname;

	public Write_SubjectDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Write_SubjectDTO(String wscode, String wsname) {
		super();
		this.wscode = wscode;
		this.wsname = wsname;
	}

	public String getWscode() {
		return wscode;
	}

	public void setWscode(String wscode) {
		this.wscode = wscode;
	}

	public String getWsname() {
		return wsname;
	}

	public void setWsname(String wsname) {
		this.wsname = wsname;
	}

	@Override
	public String toString() {
		return "Write_SubjectDTO [wscode=" + wscode + ", wsname=" + wsname + "]";
	}

}
