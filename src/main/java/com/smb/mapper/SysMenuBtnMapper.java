package com.smb.mapper;

import com.smb.entity.SysMenuBtn;

public interface SysMenuBtnMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMenuBtn record);

    int insertSelective(SysMenuBtn record);

    SysMenuBtn selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMenuBtn record);

    int updateByPrimaryKey(SysMenuBtn record);
}