package com.smb.controller;

import com.smb.entity.SysUser;
import com.smb.service.SysUserService;
import com.smb.utils.MethodUtil;
import com.smb.utils.SessionUtils;
import com.smb.utils.URLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController extends BaseController {

    @Autowired(required = false)
    private SysUserService<SysUser> sysUserService;

    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 登录验证
     */
    @RequestMapping("/toLogin")
    public void toLogin(String userName,String pwd,String captcha,HttpServletRequest request,HttpServletResponse response) throws Exception{
        //获取验证码
        Object simpleCaptcha = request.getSession().getAttribute("simpleCaptcha");
        //获取用户信息
        SysUser user = sysUserService.queryLogin(userName, MethodUtil.MD5(pwd));
        if(!captcha.equals(simpleCaptcha)){
            sendFailureMessage(response,"验证码错误！");
            return;
        }else if(user == null || "".equals(user)){
            sendFailureMessage(response,"账号或密码错误。");
            return;
        }else if(user.getState() == 1){
            sendFailureMessage(response,"该账号被禁用！");
            return;
        }
        SessionUtils.setUser(request,user);
        sendSuccessMessage(response,"登录成功");
    }


    //退出登录一：
    @RequestMapping("/outLogin")
    public String outLogin(HttpSession session){
        session.invalidate();
        return "login";
    }
    //退出登录二：
    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception{
        SessionUtils.removeUser(request);
        response.sendRedirect(URLUtils.get("smbUrl")+"/login.jsp");
    }


}
