package com.smb.controller;

import com.smb.utils.HtmlUtil;
import com.smb.utils.MyEditor;
import com.smb.utils.URLUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BaseController {

    public final static String SUCCESS = "success";

    public final static String MSG = "msg";

    public final static String DATA = "data";

    public final static String LOGOUT_FLAG = "logoutFlag";

    private HttpServletRequest request;

    /**
     * 类型转换，时间
     * @param binder
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),true));
        binder.registerCustomEditor(int.class,new MyEditor());
    }

    /**
     * 所有ControllerMap统一从这获取
     * */
    public Map<String,Object> getRootMap(){
        Map<String,Object> rootMap = new HashMap<String, Object>();
        //添加url到Map中
        rootMap.putAll(URLUtils.getUrlsMap());
        return rootMap;
    }

    public  ModelAndView forword(String viewName, Map context){
        return new ModelAndView(viewName, context);
    }

    public ModelAndView error(String errMsg){
        return new ModelAndView("error");
    }

    /**
     * 获取属性名的值
     */
    public String getPara(String name){
        return request.getParameter(name);
    }

    /**
     * 提示成功信息
     * */
    public void sendSuccessMessage(HttpServletResponse response,String message){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put(SUCCESS,true);
        result.put(MSG,message);
        HtmlUtil.writerJson(response,result);
    }

    /**
     * 提示失败信息
     * */
    public void sendFailureMessage(HttpServletResponse response,String message) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(SUCCESS, false);
        result.put(MSG, message);
        HtmlUtil.writerJson(response, result);
    }


}
