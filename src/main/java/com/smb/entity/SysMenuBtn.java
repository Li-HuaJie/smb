package com.smb.entity;

public class SysMenuBtn  extends Base{
    private Integer id;

    private Integer menuid;

    private String btnname;

    private String btntype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public String getBtnname() {
        return btnname;
    }

    public void setBtnname(String btnname) {
        this.btnname = btnname;
    }

    public String getBtntype() {
        return btntype;
    }

    public void setBtntype(String btntype) {
        this.btntype = btntype;
    }
}