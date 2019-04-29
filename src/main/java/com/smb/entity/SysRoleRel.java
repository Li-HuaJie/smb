package com.smb.entity;

public class SysRoleRel extends Base {
    private Integer roleid;

    private Integer objid;

    private Integer reltype;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getObjid() {
        return objid;
    }

    public void setObjid(Integer objid) {
        this.objid = objid;
    }

    public Integer getReltype() {
        return reltype;
    }

    public void setReltype(Integer reltype) {
        this.reltype = reltype;
    }
}