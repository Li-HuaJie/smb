package com.smb.service;

import com.smb.entity.SysUser;
import com.smb.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysUserService")
public class SysUserService<T> extends BaseService<T> {

    /**
     * 检查登录
     * @param userName
     * @param pwd
     * @return
     */
    public T queryLogin(String userName,String pwd){
        SysUser sysUser = new SysUser();
        sysUser.setUsername(userName);
        sysUser.setPwd(pwd);
        return getMapper().queryLogin(sysUser);
    }


    @Autowired
    private SysUserMapper<T> mapper;

    public SysUserMapper<T> getMapper(){
        return mapper;
    }

}
