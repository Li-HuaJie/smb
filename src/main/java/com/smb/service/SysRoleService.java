package com.smb.service;

import com.smb.entity.SysRoleRel;
import com.smb.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysRoleService")
public class SysRoleService<T> extends BaseService<T> {

    @Autowired
    private SysRoleRelService<SysRoleRel> sysRoleRelService;


    /**
     * 查询全部有效的权限
     * @return
     */
    public List<T> queryAllList(){
        return getMapper().queryAllList();
    }

    /**
     * 根据id查询权限
     * @param userid
     * @return
     */
    public List<T> queryByUserid(Integer userid){
        return getMapper().queryByUserid(userid);
    }

    @Autowired
    private SysRoleMapper<T> mapper;

    public SysRoleMapper<T> getMapper(){
        return mapper;
    }

}
