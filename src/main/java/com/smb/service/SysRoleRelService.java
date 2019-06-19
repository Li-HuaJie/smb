package com.smb.service;

import com.smb.entity.SysRoleRel;
import com.smb.mapper.SysRoleRelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("sysRoleRelService")
public class SysRoleRelService<T> extends BaseService<T> {

    public List<SysRoleRel> queryByRoleId(Integer roleId,Integer relType){
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("roleId",roleId);
        param.put("relType",relType);
        return getMapper().queryByRoleId(param);
    }

    public List<SysRoleRel> queryByObjId(Integer objId,Integer relType){
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("objId",objId);
        param.put("relType",relType);
        return getMapper().queryByObjId(param);
    }

    /**
     * 根据关联对象id,关联类型删除
     * @param objId
     * @param relType
     */
    public void deleteByObjId(Integer objId,Integer relType){
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("objId",objId);
        param.put("relType",relType);
        getMapper().deleteByObjId(param);
    }

    /**
     * 根据角色id删除
     * @param roleId
     */
    public void deleteByRoleId(Integer roleId){
        deleteByRoleId(roleId,null);
    }

    /**
     * 根据角色di，关联类型删除
     * @param roleId
     * @param relType
     */
    public void deleteByRoleId(Integer roleId,Integer relType){
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("roleId",roleId);
        param.put("relType",relType);
        getMapper().deleteByRoleId(param);
    }

    @Autowired
    private SysRoleRelMapper<T> mapper;

    public SysRoleRelMapper<T> getMapper(){
        return mapper;
    }

}
