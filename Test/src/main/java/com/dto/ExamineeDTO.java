package com.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("ExamineeDTO")
public class ExamineeDTO {

	private String eno;
	private String eid;
	private String ename;
	private String ebrith;
	private String qcode;
	private String qname;
	private String seat;
	
	// 면제과목
	private List<String> subject;

	public ExamineeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExamineeDTO(String eno, String eid, String ename, String ebrith, String qcode, String qname, String seat) {
		super();
		this.eno = eno;
		this.eid = eid;
		this.ename = ename;
		this.ebrith = ebrith;
		this.qcode = qcode;
		this.qname = qname;
		this.seat = seat;
	}
	
	public ExamineeDTO(String eno, String eid, String ename, String ebrith, String qcode, String qname, String seat, List<String> subject) {
		super();
		this.eno = eno;
		this.eid = eid;
		this.ename = ename;
		this.ebrith = ebrith;
		this.qcode = qcode;
		this.qname = qname;
		this.seat = seat;
		this.subject = subject;
	}

	public String getEno() {
		return eno;
	}

	public void setEno(String eno) {
		this.eno = eno;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEbrith() {
		return ebrith;
	}

	public void setEbrith(String ebrith) {
		this.ebrith = ebrith;
	}

	public String getQcode() {
		return qcode;
	}

	public void setQcode(String qcode) {
		this.qcode = qcode;
	}
	
	public String getQname() {
		return qname;
	}

	public void setQname(String qname) {
		this.qname = qname;
	}
	
	
	public List<String> getSubject() {
		return subject;
	}

	public void setSubject(List<String> subject) {
		this.subject = subject;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	@Override
	public String toString() {
		return "ExamineeDTO [eno=" + eno + ", eid=" + eid + ", ename=" + ename + ", ebrith=" + ebrith + ", qcode="
				+ qcode + ", qname=" + qname + ", seat=" + seat + ", subject=" + subject + "]";
	}
	
	


}
