package com.smb.mapper;

import com.smb.entity.SysRole;

import java.util.List;

public interface SysRoleMapper<T> extends BaseMapper<T> {

    int insert(SysRole record);

    /**
     * 查询全部有效的权限
     * @return
     */
    public List<T> queryAllList();

    /**
     * 根据用户ID查询权限
     * @param userid
     * @return
     */
    public List<T> queryByUserid(Integer userid);

}