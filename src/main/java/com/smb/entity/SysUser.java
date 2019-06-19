package com.smb.entity;

import java.util.Date;

public class SysUser extends Base {
    private Integer id;//主键

    private String username;//账号

    private String pwd;//密码

    private String nickname;//昵称

    private Integer state;//状态 0=可用，1=不可用

    private Integer logincount;//登录次数

    private Date logintime;//最后登录时间

    private Date createtime;//创建时间

    private Date updatetime;//修改时间

    private Integer superadmin;//超级管理员 0=不是，1=是

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getLogincount() {
        return logincount;
    }

    public void setLogincount(Integer logincount) {
        this.logincount = logincount;
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getSuperadmin() {
        return superadmin;
    }

    public void setSuperadmin(Integer superadmin) {
        this.superadmin = superadmin;
    }

    /**
    * 超级管理员常量
    */
    public static enum SuperAdmin{
        NO(0, "否"),YES(1, "是");
        public int key;
        public String value;
        private SuperAdmin(int key,String value){
            this.key = key;
            this.value = value;
        }
        public static SuperAdmin get(int key){
            SuperAdmin[] values = SuperAdmin.values();
            for (SuperAdmin object : values){
                if(object.key == key){
                    return object;
                }
            }
            return null;
        }
    }

}