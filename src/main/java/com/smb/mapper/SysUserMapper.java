package com.smb.mapper;

import com.smb.entity.SysUser;

public interface SysUserMapper<T> extends BaseMapper<T> {

    /**
     * 检查登录
     * @param model
     * @return
     */
    public T queryLogin(SysUser model);

}