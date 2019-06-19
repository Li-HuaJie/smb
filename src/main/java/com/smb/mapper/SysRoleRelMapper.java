package com.smb.mapper;

import com.smb.entity.SysRoleRel;

import java.util.List;
import java.util.Map;

public interface SysRoleRelMapper<T> extends BaseMapper<T> {

    int insert(SysRoleRel record);

    int insertSelective(SysRoleRel record);

    public void deleteByRoleId(Map<String,Object> param);

    public void deleteByObjId(Map<String,Object> param);

    public List<SysRoleRel> queryByRoleId(Map<String,Object> param);

    public List<SysRoleRel> queryByObjId(Map<String,Object> param);
}