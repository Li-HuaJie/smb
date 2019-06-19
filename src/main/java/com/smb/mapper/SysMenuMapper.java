package com.smb.mapper;

import com.smb.entity.SysMenu;

import java.util.List;
import java.util.Map;

public interface SysMenuMapper<T> extends BaseMapper<T> {

    /**
     * 查询所有系统菜单
     * @return
     */
    public List<T> queryByAll();

    /**
     * 获取顶级菜单
     * @param map
     * @return
     */
    public List<T> getRootMenu(Map map);

    /**
     * 获取子菜单
     * @return
     */
    public List<T> getChildMenu();

    /**
     * 根据权限id查询菜单
     * @param roleId
     * @return
     */
    public List<T> getMenuByRoleId(Integer roleId);

    /**
     * 根据用户id查询父菜单
     * @param userId
     * @return
     */
    public List<T> getRootMenuByUser(Integer userId);

    /**
     * 根据用户id查询子菜单菜单
     * @param userId
     * @return
     */
    public List<T> getChildMenuByUser(Integer userId);

}