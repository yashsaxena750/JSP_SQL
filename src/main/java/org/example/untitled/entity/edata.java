package org.example.untitled.entity;

public class edata {

    private int userid;
    private String uname;
    private String uemail;
    private String upassword;

    public edata(int userid, String uname, String uemail, String upassword) {
        this.userid = userid;
        this.uname = uname;
        this.uemail = uemail;
        this.upassword = upassword;
    }

    public int getUserid() {

        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }




}
