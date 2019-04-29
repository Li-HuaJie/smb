package com.smb.controller;

import com.smb.entity.SysUser;
import com.smb.service.SysUserService;
import com.smb.utils.MethodUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class MainController extends BaseController{

    @Autowired(required = false)
    private SysUserService<SysUser> sysUserService;

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Map<String,Object> map = getRootMap();
        return forword("login",map);
    }

    @RequestMapping("/toLogin")
    public void toLogin(String userName,String pwd){
       SysUser user = sysUserService.queryLogin(userName, MethodUtil.MD5(pwd));
//        sendSuccessMessage(response,"登录成功");
    }

}
