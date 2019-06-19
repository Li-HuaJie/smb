package com.smb.controller;

import com.smb.entity.SysMenu;
import com.smb.entity.SysMenuBtn;
import com.smb.entity.SysUser;
import com.smb.entity.TreeNode;
import com.smb.service.SysMenuBtnService;
import com.smb.service.SysMenuService;
import com.smb.service.SysUserService;
import com.smb.utils.MethodUtil;
import com.smb.utils.SessionUtils;
import com.smb.utils.TreeUtil;
import com.smb.utils.URLUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController extends BaseController{

    @Autowired(required = false)
    private SysUserService<SysUser> sysUserService;

    @Autowired
    private SysMenuService<SysMenu> sysMenuService;

    @Autowired
    private SysMenuBtnService<SysMenuBtn> sysMenuBtnService;

    /**
     * 登录首页
     * @param request
     * @return
     */
    @RequestMapping("/main")
    public ModelAndView main(HttpServletRequest request){
        Map<String, Object> context = getRootMap();
        SysUser user = SessionUtils.getUser(request);
        List<SysMenu> rootMenus = null;
        List<SysMenu> childMenus = null;
        List<SysMenuBtn> childBtns = null;
        //超级管理员
        if (user != null && SysUser.SuperAdmin.YES.key == user.getSuperadmin()){
            rootMenus = sysMenuService.getRootMenu(null);//查询所有根节点
            childMenus = sysMenuService.getChildMenu();//查询所有子节点
        }else{
            rootMenus = sysMenuService.getRootMenuByUser(user.getId());//根节点
            childMenus = sysMenuService.getChildMenuByUser(user.getId());//子节点
            childBtns = sysMenuBtnService.getMenuBtnByUser(user.getId());//按钮操作
            buildDdata(childMenus,childBtns,request);
        }
        context.put("user",user);
        context.put("menuList",treeMenu(rootMenus,childMenus));
        return forword("main/index",context);
    }

    /**
     * 构建树形数据
     * @param rootMenus
     * @param childMenus
     * @return
     */
    private List<TreeNode> treeMenu(List<SysMenu> rootMenus,List<SysMenu> childMenus){
        TreeUtil util = new TreeUtil(rootMenus,childMenus);
        return util.getTreeNode();
    }

    /**
     * 构建树形数据
     * @param childMenus
     * @param childBtns
     * @param request
     */
    private void buildDdata(List<SysMenu> childMenus, List<SysMenuBtn> childBtns,HttpServletRequest request){
        //能够访问的url列表
        List<String> accessUrls = new ArrayList<String>();
        //菜单对应的按钮
        Map<String,List> menuBtnMap = new HashMap<String, List>();
        for (SysMenu menu : childMenus){
            //判断URL是否为空
            if(StringUtils.isNotBlank(menu.getUrl())){
                List<String> btnTypes = new ArrayList<String>();
                for (SysMenuBtn btn : childBtns){
                    if (menu.getId().equals(btn.getMenuid())){
                        btnTypes.add(btn.getBtntype());
                    }
                }
                menuBtnMap.put(menu.getUrl(),btnTypes);
                accessUrls.add(menu.getUrl());
            }
        }
        SessionUtils.setAccessUrl(request,accessUrls);//设置可访问的URL
        SessionUtils.setMemuBtnMap(request,menuBtnMap);//设置可用的按钮
    }

}
