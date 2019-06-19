package com.smb.service;

import com.smb.mapper.SysMenuBtnMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysMenuBtnService")
public class SysMenuBtnService<T> extends BaseService<T>{

    public List<T> queryByAll(){
        return getMapper().queryByAll();
    }

    public List<T> queryByMenuid(Integer menuid){
        return getMapper().queryByMenuid(menuid);
    }

    public List<T> queryByMenuUrl(String url){
        return getMapper().queryByMenuUrl(url);
    }

    public void deleteByMenuid(Integer menuid){
        getMapper().deleteByMenuid(menuid);
    }

    public List<T> getMenuBtnByUser(Integer userid){
        return getMapper().getMenuBtnByUser(userid);
    }

    @Autowired
    private SysMenuBtnMapper<T> mapper;

    public SysMenuBtnMapper<T> getMapper(){
        return mapper;
    }

}
