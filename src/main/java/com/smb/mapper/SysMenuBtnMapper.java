package com.smb.mapper;

import com.smb.entity.SysMenuBtn;

import java.util.List;

public interface SysMenuBtnMapper<T> extends BaseMapper<T> {

    int insert(SysMenuBtn record);

    public List<T> queryByMenuid(Integer menuid);

    public List<T> queryByMenuUrl(String url);

    public void deleteByMenuid(Integer menuid);

    public List<T> getMenuBtnByUser(Integer userid);

    public List<T> queryByAll();

}