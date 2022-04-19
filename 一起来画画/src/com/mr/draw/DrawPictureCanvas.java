package com.mr.draw;

import java.awt.*;

public class DrawPictureCanvas extends Canvas {
    private Image image = null;
    /**
     * 设置画板中的图片
     *
     */
    public void setImage (Image image){
        this.image =image;//为成员变量赋值
    }

    /**
     * 重写paint方法
     */
    public void paint(Graphics g){
        g.drawImage(image,0,0,null);//画布上绘制图像
    }
    /**
     * 重写update方法，解决屏幕闪烁问题
     */
    public void update(Graphics g){
        paint(g);
    }
}
