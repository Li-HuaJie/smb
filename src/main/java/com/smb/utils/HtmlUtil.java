package com.smb.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONException;
import com.smb.utils.json.JSONUtil;

public class HtmlUtil {

    /**
     * 输出json格式
     * @param response
     * @param jsonStr
     */
    public static void writerJson(HttpServletResponse response,String jsonStr){
        writer(response,jsonStr);
    }

    public static void writerJson(HttpServletResponse response,Object object){
        try{
            response.setContentType("application/json");
            writer(response, JSONUtil.toJSONString(object));
        } catch (JSONException e){
            e.printStackTrace();
        }
    }

    /**
     * 输出HTML代码
     * @param response
     * @param htmlStr
     */
    public static void writerHtml(HttpServletResponse response,String htmlStr){
        writer(response,htmlStr);
    }

    private static void writer(HttpServletResponse response,String str){
        try{
            StringBuffer result = new StringBuffer();
            //设置页面不缓存
            response.setHeader("Pragma","No-cache");
            response.setHeader("Cache-Control","no-cache");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = null;
            out = response.getWriter();
            out.print(str);
            out.flush();
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
