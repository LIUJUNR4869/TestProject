package com.mr.draw;

import java.awt.*;

public class DrawPictureCanvas extends Canvas {
    private Image image = null;
    /**
     * ���û����е�ͼƬ
     *
     */
    public void setImage (Image image){
        this.image =image;//Ϊ��Ա������ֵ
    }

    /**
     * ��дpaint����
     */
    public void paint(Graphics g){
        g.drawImage(image,0,0,null);//�����ϻ���ͼ��
    }
    /**
     * ��дupdate�����������Ļ��˸����
     */
    public void update(Graphics g){
        paint(g);
    }
}
