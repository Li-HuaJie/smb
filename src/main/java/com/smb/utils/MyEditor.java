package com.smb.utils;

import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;

/**
 * 类型转换器
 * */
public class MyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        if(text == null || text.equals("")){
            text = "0";
        }else if(!StringUtils.hasText(text)){

        }else{
            setValue(Integer.parseInt(text));//通过传入参数的类型来匹配相应的databing
        }
    }

    /**
     * 使用指定的DateFormat将日期格式化为字符串。
     * */
    public String getAsText(){
        return getValue().toString();
    }

}
