package com.dto;

import org.apache.ibatis.type.Alias;

@Alias("Personal_DataDTO")
public class Personal_DataDTO {
    private String ppno;
    private String ptype;
    private String pattendance;
    private String pnote;

    public Personal_DataDTO() {
    }

    public Personal_DataDTO(String ppno, String ptype, String pattendance, String pnote) {
        this.ppno = ppno;
        this.ptype = ptype;
        this.pattendance = pattendance;
        this.pnote = pnote;
    }

    public String getPpno() {
        return ppno;
    }

    public void setPpno(String ppno) {
        this.ppno = ppno;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public String getPattendance() {
        return pattendance;
    }

    public void setPattendance(String pattendance) {
        this.pattendance = pattendance;
    }

    public String getPnote() {
        return pnote;
    }

    public void setPnote(String pnote) {
        this.pnote = pnote;
    }

    @Override
    public String toString() {
        return "Personal_DataDTO{" +
                "ppno='" + ppno + '\'' +
                ", ptype='" + ptype + '\'' +
                ", pattendance='" + pattendance + '\'' +
                ", pnote='" + pnote + '\'' +
                '}';
    }
}
