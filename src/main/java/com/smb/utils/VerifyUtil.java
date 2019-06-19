package com.smb.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class VerifyUtil {

    //方法一：
    //验证码字符集
    private static final char[] chars = {
      '0','1','2','3','4','5','6','7','8','9',
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n',
            'o','p','q','r','s','t','u','v','w','x','y','z',
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
            'O','P','Q','R','S','T','U','V','W','X','Y','Z'
    };

    //字符数量
    private static final int SIZE = 4;
    //干扰线数量
    private static final int LINES = 5;
    //宽度
    private static final int WIDTH = 80;
    //高度
    private static final int HEIGHT = 40;
    //字体大小
    private static final int FONT_SIZE = 30;

    /**
     * 生成随机验证码及图片
     */
    public static Object[] createImage(){
        StringBuffer sb = new StringBuffer();
        //创建空白图片
        BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
        //获取图片画笔
        Graphics graphic = image.getGraphics();
        //设置画笔颜色
        graphic.setColor(Color.LIGHT_GRAY);
        //绘制矩形背景
        graphic.fillRect(0,0,WIDTH,HEIGHT);
        //画随机字符
        Random ran = new Random();
        for (int i = 0; i < SIZE; i++){
            //取随机字符索引
            int n = ran.nextInt(chars.length);
            //设置随机颜色
            graphic.setColor(getRandomColor());
            //设置字体大小
            graphic.setFont(new Font(null,Font.BOLD+Font.ITALIC,FONT_SIZE));
            //画字符
            graphic.drawString(chars[n] + "",i * WIDTH / SIZE, HEIGHT * 2 / 3);
            //记录字符
            sb.append(chars[n]);
        }
        //画干扰线
        for (int i = 0; i < LINES; i++){
            //设置随机颜色
            graphic.setColor(getRandomColor());
            //随机画线
            graphic.drawLine(ran.nextInt(WIDTH),ran.nextInt(HEIGHT),ran.nextInt(WIDTH),ran.nextInt(HEIGHT));
        }
        //返回验证码和图片
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try{
            ImageIO.write(image,"jpeg",baos);
        } catch (IOException e){
            e.printStackTrace();
        }
        return new Object[]{sb.toString(),baos.toByteArray()};


    }

    /**
     * 随机取色
     */
    public static Color getRandomColor(){
        Random ran = new Random();
        Color color = new Color(ran.nextInt(256),ran.nextInt(256),ran.nextInt(256));
        return color;
    }


    /**
     * 方法二：
     */
    private static char mapTable[] = {
            '0','1','2','3','4','5','6','7','8','9',
            '0','1','2','3','4','5','6','7','8','9'
    };

    public static Map<String ,Object> getImageCode(int width, int height, OutputStream os){
        Map<String,Object> returnMap = new HashMap<String, Object>();
        if(width <= 0)width = 60;
        if(height <= 0)height = 20;
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //获取图形上下文
        Graphics g = image.getGraphics();
        //生成随机类
        Random random = new Random();
        //设定背景色
        g.setColor(getRandColor(200,250));
        g.fillRect(0, 0, width, height);
        //设定字体
        g.setFont(new Font("Times New Roman",Font.PLAIN,18));
        //随机产生168条干扰线，使图像中的认证码不易被其他程序探测到
        g.setColor(getRandColor(160,200));
        for (int i = 0; i < 168; i++){
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x+xl, y+yl);
        }
        //取随机产生的码
        String strEnsure = "";
        //4代表4位验证码
        for (int i = 0;i < 4;i++){
            strEnsure += mapTable[(int)(mapTable.length * Math.random())];
            //将认证码显示到图像中
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110),20 + random.nextInt(110)));
            //直接生成
            String str = strEnsure.substring(i, i+1);
            //设置随机码在背景图片上的位置
            g.drawString(str, 13 * i + 20, 25);
        }
        //释放图形上下文
        g.dispose();
        returnMap.put("image",image);
        returnMap.put("strEnsure",strEnsure);
        return returnMap;
    }

    /**
     * 给定防卫获取随机颜色
     */
    static Color getRandColor(int fc,int bc){
        Random random = new Random();
        if(fc > 255) fc = 255;
        if(bc > 255) bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r,g,b);
    }

}
