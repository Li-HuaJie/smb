package com.smb.service;

import com.smb.entity.SysMenu;
import com.smb.entity.SysMenuBtn;
import com.smb.entity.SysRoleRel;
import com.smb.mapper.SysMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("sysMenuService")
public class SysMenuService<T> extends BaseService<T> {

    @Autowired
    private SysRoleRelService<SysRoleRel> sysRoleRelService;

    @Autowired
    private SysMenuBtnService<SysMenuBtn> sysMenuBtnService;

    @Autowired
    private SysMenuMapper mapper;

    /**
     * 保存菜单btn
     * @throws Exception
     */
    public void saveBtns(Integer menuid, List<SysMenuBtn> btns) throws Exception{
        if (btns == null || btns.isEmpty()){
            return;
        }
        for (SysMenuBtn btn : btns){
            if (btn.getId() != null){
                sysMenuBtnService.delete(btn.getId());
                continue;
            }
            btn.setMenuid(menuid);
            if (btn.getId() == null){
                sysMenuBtnService.add(btn);
            }else {
                sysMenuBtnService.update(btn);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void add(SysMenu menu) throws Exception{
        super.add((T)menu);
        saveBtns(menu.getId(),menu.getBtns());
    }

    @SuppressWarnings("unchecked")
    public void update(SysMenu menu)throws Exception{
        super.update((T)menu);
        saveBtns(menu.getId(),menu.getBtns());
    }

    /**
     * 查询所有系统菜单列表
     */
    public List<T> queryByAll(){
        return mapper.queryByAll();
    }

    /**
     * 获取顶级菜单
     * @param menuId
     * @return
     */
    public List<T> getRootMenu(Integer menuId){
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("menuId",menuId);
        return mapper.getRootMenu(map);
    }

    /**
     * 获取子菜单
     * @return
     */
    public List<T> getChildMenu(){
        return mapper.getChildMenu();
    }

    /**
     * 根据用户id查询父菜单
     * @param userId
     * @return
     */
    public List<T> getRootMenuByUser(Integer userId){
        return getMapper().getRootMenuByUser(userId);
    }

    /**
     * 根据用户id查询子菜单
     * @param userId
     * @return
     */
    public List<T> getChildMenuByUser(Integer userId){
        return getMapper().getChildMenuByUser(userId);
    }

    /**
     * 根据权限id查询菜单
     * @param roleId
     * @return
     */
    public List<T> getMenuByRoleId(Integer roleId){
        return getMapper().getMenuByRoleId(roleId);
    }

    @Override
    public void delete(Object[] ids) throws Exception{
        super.delete(ids);
        for (Object id : ids){
//            sysRoleRelService
        }
    }

    public SysMenuMapper<T> getMapper(){
        return mapper;
    }

}




