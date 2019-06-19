package com.smb.entity;

import java.util.Date;
import java.util.List;

public class SysMenu extends Base{
    private Integer id;//主键

    private String name;//菜单名

    private String url;//系统url

    private Integer parentid;//父id 关联sys_menu.id

    private Integer state;//是否使用，0=可用，1=禁用

    private Date createtime;

    private Date updatetime;

    private Integer rank;//排序

    private int subCount;//子菜单总数

    //菜单按钮
    private List<SysMenuBtn> btns;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public List<SysMenuBtn> getBtns() {
        return btns;
    }

    public void setBtns(List<SysMenuBtn> btns) {
        this.btns = btns;
    }

    public int getSubCount() {
        return subCount;
    }

    public void setSubCount(int subCount) {
        this.subCount = subCount;
    }
}