package com.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("QualificationDTO")
public class QualificationDTO {

	private String qcode;
	private String qname;
	private String qfield;
	private String qclass;
	
	List<Write_SubjectDTO> wslist;

	public QualificationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QualificationDTO(String qcode, String qname, String qfield, String qclass) {
		super();
		this.qcode = qcode;
		this.qname = qname;
		this.qfield = qfield;
		this.qclass = qclass;
	}

	public QualificationDTO(String qcode, String qname, String qfield, String qclass, List<Write_SubjectDTO> wslist) {
		super();
		this.qcode = qcode;
		this.qname = qname;
		this.qfield = qfield;
		this.qclass = qclass;
		this.wslist = wslist;
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

	public String getQfield() {
		return qfield;
	}

	public void setQfield(String qfield) {
		this.qfield = qfield;
	}

	public String getQclass() {
		return qclass;
	}

	public void setQclass(String qclass) {
		this.qclass = qclass;
	}

	public List<Write_SubjectDTO> getList() {
		return wslist;
	}

	public void setList(List<Write_SubjectDTO> wslist) {
		this.wslist = wslist;
	}

	@Override
	public String toString() {
		return "QualificationDTO [qcode=" + qcode + ", qname=" + qname + ", qfield=" + qfield + ", qclass=" + qclass
				+ ", wslist=" + wslist + "]";
	}

}
