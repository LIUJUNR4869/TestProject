//package com.mr.draw;
//
//import com.mr.util.DrawImageUtil;
//import com.mr.util.FrameGetShape;
//import com.mr.util.ShapeWindow;
//import com.mr.util.Shapes;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.awt.geom.Ellipse2D;
//import java.awt.geom.Rectangle2D;
//import java.awt.image.BufferedImage;
//import java.util.concurrent.Callable;
//
///**
// * ��ͼ������
// */
//public class DrawPictureFrame extends JFrame implements FrameGetShape {
//    //����һ��8λBGR��ɫ������ͼ��
//    BufferedImage image = new BufferedImage(570, 390, BufferedImage.TYPE_INT_BGR);
//    Graphics gs = image.getGraphics(); //���ͼ��Ļ�ͼ����
//    Graphics2D g = (Graphics2D) gs;//��ͼ��������ת��
//    DrawPictureCanvas canvas = new DrawPictureCanvas();//������������
//    Color foreColor = Color.BLACK;//����ǰ��ɫ
//    Color backgroundColor = Color.CYAN;//���屳��
//    int x = -1;
//    int y = -1;
//    boolean rubber = false;
//    boolean drawShape = false;//��ͼ�α�ʶ����
//    Shapes shape;//�滭��ͼ
//
//    /**
//     * ����������
//     */
//
//    private JToolBar toolBar;
//    private JButton eraserButton;
//    private JToggleButton strokeButton1;
//    private JToggleButton strokeButton2;
//    private JToggleButton strokeButton3;
//    private JButton backgroundButton;
//    private JButton foregroundButton;
//    private JButton clearButton;
//    private JButton saveButton;
//    private JButton shapeButton;
//
//    private JMenuItem strokeMenuItem1;
//    private JMenuItem strokeMenuItem2;
//    private JMenuItem strokeMenuItem3;
//    private JMenuItem clearMenuItem;
//    private JMenuItem foregroundMenuItem;
//    private JMenuItem backgroundMenuItem;
//    private JMenuItem eraserMenuItem;
//    private JMenuItem exitMenuItem;
//    private JMenuItem saveMenuItem;
//    private JMenuItem shuiyinItem;
//
//    private String shuiyin = "";
//
//    private PictureWindow pictureWindow;
//    private JButton showPictureButton;
//
//
//    /**
//     * ���췽��
//     */
//    public DrawPictureFrame() {
//        setResizable(false);//Ĭ�ϲ��ɼ�
//        setTitle("��ͼ����(ˮӡ���ݣ�[" + shuiyin + "])");//�趨����
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBounds(500, 100, 574, 460);
//
//        init();
//        addListener();
//    }
//    //DrawPictureFrame����
//
//    /**
//     * �����ʼ��
//     */
//    private void init() {
//        g.setColor(backgroundColor);//�������û�ͼ�������ɫ
//        g.fillRect(0, 0, 570, 390);//����ɫ��仭��
//        g.setColor(foreColor);//����ǰ��ɫ
//        canvas.setImage(image);//���û���ͼ��
//        getContentPane().add(canvas);//������ӵ�Ĭ�ϴ�����м䲿��
//
//        //������
//
//        toolBar = new JToolBar();//��ʼ��������
//        getContentPane().add(toolBar, BorderLayout.NORTH);//�������ڴ������λ��
//
//        showPictureButton = new JButton("չ����ʻ�");
//        toolBar.add(showPictureButton);
//        saveButton = new JButton("����");
//        toolBar.add(saveButton);
//        toolBar.addSeparator();
//        strokeButton1 = new JToggleButton("ϸ��");
//        toolBar.add(strokeButton1);
//        strokeButton2 = new JToggleButton("����");
//        toolBar.add(strokeButton2);
//        strokeButton2.setSelected(true);
//        strokeButton3 = new JToggleButton("�ϴ�");
//        toolBar.add(strokeButton3);
//        ButtonGroup stroke = new ButtonGroup();
//        stroke.add(strokeButton1);
//        stroke.add(strokeButton2);
//        stroke.add(strokeButton3);
//        toolBar.addSeparator();
//
//        shapeButton = new JButton("ͼ��");
//        toolBar.add(shapeButton);
//        backgroundButton = new JButton("����ɫ");
//        toolBar.add(backgroundButton);
//        foregroundButton = new JButton("ǰ��ɫ");
//        toolBar.add(foregroundButton);
//        toolBar.addSeparator();
//        clearButton = new JButton("���");
//        toolBar.add(clearButton);
//        eraserButton = new JButton("��Ƥ");
//        toolBar.add(eraserButton);
//
//        //�˵���
//
//        JMenuBar menuBar = new JMenuBar(); //�����˵�
//        setJMenuBar(menuBar);
//
//        JMenu systemMenu = new JMenu("ϵͳ");
//        menuBar.add(systemMenu);
//
//        saveMenuItem = new JMenuItem("����");
//        systemMenu.add(saveMenuItem);
//        shuiyinItem = new JMenuItem("����ˮӡ");
//        systemMenu.add(shuiyinItem);
//        systemMenu.addSeparator();
//
//        exitMenuItem = new JMenuItem("�˳�");
//        systemMenu.add(exitMenuItem);
//
//        JMenu strokeMenu = new JMenu("����");
//        menuBar.add(strokeMenu);
//        strokeMenuItem1 = new JMenuItem("ϸ��");
//        strokeMenu.add(strokeMenuItem1);
//        strokeMenuItem2 = new JMenuItem("����");
//        strokeMenu.add(strokeMenuItem2);
//        strokeMenuItem3 = new JMenuItem("�ϴ�");
//        strokeMenu.add(strokeMenuItem3);
//
//        JMenu colorMenu = new JMenu("��ɫ");
//        menuBar.add(colorMenu);
//
//        foregroundMenuItem = new JMenuItem("ǰ��ɫ");
//        colorMenu.add(foregroundMenuItem);
//        backgroundMenuItem = new JMenuItem("����ɫ");
//        colorMenu.add(backgroundMenuItem);
//
//        JMenu editMenu = new JMenu("�༭");
//        menuBar.add(editMenu);
//        clearMenuItem = new JMenuItem("���");
//        editMenu.add(clearMenuItem);
//        eraserMenuItem = new JMenuItem("��Ƥ");
//        editMenu.add(eraserMenuItem);
//
//        //������ʻ�չʾ��� �������൱�����ĸ�����
//        pictureWindow = new PictureWindow(DrawPictureFrame.this);
//
//    }
//
//
//    private void addListener() {
//        canvas.addMouseMotionListener(new MouseAdapter() {
//            @Override
//            public void mouseDragged(MouseEvent e) {
//                super.mouseDragged(e);
//                if (x > 0 && y > 0) {
//                    if (rubber) {
//                        g.setColor(backgroundColor);
//                        g.fillRect(x, y, 10, 10);
//                    } else {
//                        g.drawLine(x, y, e.getX(), e.getY());
//                    }
//                }
//                x = e.getX();
//                y = e.getY();
//                canvas.repaint();
//            }
//
//            @Override
//            public void mouseMoved(final MouseEvent arg0) {
//                if (rubber) {
//                    //�������ָ�����״ΪͼƬ
//                    Toolkit kit = Toolkit.getDefaultToolkit();//���ϵͳĬ�ϵ�������߰�
//                    //����ϵͳ���߰���ȡͼƬ
//                    Image img = kit.createImage("src/img/icon/icon/�����Ƥ.png");
//                    //����ΪͼƬ������ȵ㣨д��0,0���У��͹�������ַ���
//                    Cursor c = kit.createCustomCursor(img, new Point(0, 0), "clear");
//                    setCursor(c);
//                } else
//                    setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
//
//            }
//        });
//
//        canvas.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                super.mouseReleased(e);
//                x = -1;
//                y = -1;
//            }
//        });
//
//        canvas.addMouseListener(new MouseAdapter() {
//
//
//            @Override
//            public void mouseReleased(final MouseEvent arg0) {
//                x = -1;
//                y = -1;
//
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//                super.mousePressed(e);
//                if (drawShape) {
//                    switch (shape.getType()) {
//                        case Shapes.YUAN:
//                            int yuanX = e.getX() - shape.getWidth() / 2;
//                            int yuanY = e.getY() - shape.getHeigth() / 2;
//                            Ellipse2D yuan = new Ellipse2D.Double(yuanX, yuanY, shape.getWidth(), shape.getHeigth());
//                            g.draw(yuan);
//                            break;
//                        case Shapes.FANG:
//                            int fangX = e.getX() - shape.getWidth() / 2;
//                            int fangY = e.getY() - shape.getHeigth() / 2;
//                            Rectangle2D fang = new Rectangle2D.Double(fangX, fangY, shape.getWidth(), shape.getHeigth());
//                            g.draw(fang);
//                            break;
//                    }
//                    canvas.repaint();
//                    drawShape = false;
//                }
//            }
//        });
//
//        toolBar.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseMoved(MouseEvent e) {
//                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
//
//            }
//        });
//
//        strokeButton1.addActionListener(args -> {
//            BasicStroke bs = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
//            g.setStroke(bs);
//        });
//
//        strokeButton2.addActionListener(args -> {
//            BasicStroke bs = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
//            g.setStroke(bs);
//        });
//        strokeButton3.addActionListener(args -> {
//            BasicStroke bs = new BasicStroke(4, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
//            g.setStroke(bs);
//        });
//
//        backgroundButton.addActionListener(args0 -> {
//            Color bgColor = JColorChooser.showDialog(DrawPictureFrame.this, "ѡ����ɫ�Ի���", Color.CYAN);
//            if (bgColor != null) {
//                backgroundColor = bgColor;
//            }
//            backgroundButton.setBackground(backgroundColor);
//            g.setColor(backgroundColor);
//            g.fillRect(0, 0, 570, 390);
//            g.setColor(foreColor);
//            canvas.repaint();
//        });
//
//        foregroundButton.addActionListener(args -> {
//            Color fColor = JColorChooser.showDialog(DrawPictureFrame.this, "ѡ����ɫ�Ի���", Color.CYAN);
//            if (fColor != null) {
//                foreColor = fColor;
//            }
//            foregroundButton.setBackground(foreColor);
//            g.setColor(foreColor);
//        });
//
//
//        clearButton.addActionListener(e -> {
//            g.setColor(backgroundColor);
//            g.fillRect(0, 0, 570, 390);
//            g.setColor(foreColor);
//            canvas.repaint();
//        });
//
//
//        eraserButton.addActionListener(e -> {
//            if (eraserButton.getText().equals("��Ƥ")) {
//                rubber = true;
//                eraserButton.setText("��ͼ");
//            } else {
//                rubber = false;
//                eraserButton.setText("��Ƥ");
//                g.setColor(foreColor);
//            }
//        });
//
//        shapeButton.addActionListener(
//                e -> {
//                    //����ͼ��ѡ�����
//                    ShapeWindow shapeWindow = new ShapeWindow(DrawPictureFrame.this);
//                    //��ȡͼ�ΰ�ť�ĺ������ꡢ��ȡ��߶�
//                    int shapeButtonWidth = shapeButton.getWidth();
//                    int shapeWindowHeight = shapeWindow.getHeight();
//                    int shapeButtonX = shapeButton.getX();
//                    int shapeButtonY = shapeButton.getY();
//
//                    //����ͼ�ΰ�ť�����꣬�������ͼ�ΰ�ť���ж���
//                    int shapeWindowX = getX() + shapeButtonX - (shapeWindowHeight - shapeButtonWidth) / 2;
//                    int shapeWindowY = getY() + shapeButtonY + 80;
//                    //��ȡͼ���������λ��
//                    shapeWindow.setLocation(shapeWindowX, shapeWindowY);
//                    shapeWindow.setVisible(true);
//                });
//
//        saveButton.addActionListener(e -> {
//            addWatermark();
//            DrawImageUtil.saveImage(DrawPictureFrame.this, image);
//        });
//
//
//        exitMenuItem.addActionListener(e -> {
//            System.exit(0);//����ʱ����ر�
//        });
//
//        eraserMenuItem.addActionListener(e -> {
//            if (eraserMenuItem.getText().equals("��Ƥ")) {
//                rubber = true;
//                eraserButton.setText("��ͼ");
//                eraserMenuItem.setText("��ͼ");
//            } else {
//                rubber = false;
//                eraserButton.setText("��Ƥ");
//                eraserMenuItem.setText("��Ƥ");
//                g.setColor(foreColor);
//            }
//        });
//
//        clearMenuItem.addActionListener(e -> {
//            g.setColor(backgroundColor);
//            g.fillRect(0, 0, 570, 390);
//            g.setColor(foreColor);
//            canvas.repaint();
//        });
//
//        /*
//            �����������ԣ���ϸ�����ء�����ĩ������������ߴ���ʽ
//         */
//        strokeMenuItem1.addActionListener(e -> {
//            BasicStroke bs = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
//            g.setStroke(bs);//��ͼ����ʹ�ô˻���
//            strokeButton1.setSelected(true);//����ϸ����ť��Ϊѡ��״̬
//        });
//
//        strokeMenuItem2.addActionListener(e -> {
//            BasicStroke bs = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
//            g.setStroke(bs);
//            strokeButton2.setSelected(true);
//        });
//
//        strokeMenuItem3.addActionListener(e -> {
//            BasicStroke bs = new BasicStroke(4, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
//            g.setStroke(bs);
//            strokeButton3.setSelected(true);
//        });
//
//        foregroundMenuItem.addActionListener(e -> {
//            Color fColor = JColorChooser.showDialog(DrawPictureFrame.this, "ѡ����ɫ�Ի���", Color.CYAN);
//            if (fColor != null)
//                foreColor = fColor;
//            foregroundButton.setForeground(foreColor);//��ť��������ɫҲ���и���
//            g.setColor(foreColor);//��ͼ����ʹ�ô���ɫ
//        });
//
//        backgroundMenuItem.addActionListener(e -> {
//            Color bgColor = JColorChooser.showDialog(DrawPictureFrame.this, "������ɫ�Ի���", Color.CYAN);
//            if (bgColor != null)
//                backgroundColor = bgColor;
//            backgroundButton.setBackground(backgroundColor);
//            g.setColor(backgroundColor);
//            g.fillRect(0, 0, 570, 390);
//            g.setColor(foreColor);
//            canvas.repaint();
//        });
//
//        saveMenuItem.addActionListener(e -> {
//            addWatermark();
//            DrawImageUtil.saveImage(DrawPictureFrame.this, image);
//        });
//
//        shuiyinItem.addActionListener(e -> {
//            shuiyin = JOptionPane.showInputDialog(DrawPictureFrame.this, "����Ҫʲôˮӡ");
//            if (null == shuiyin)
//                shuiyin = "";
//            else
//                setTitle("��ͼ����ˮӡ���ݣ�[" + shuiyin + "]��");
//        });
//
//        showPictureButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                boolean isVisible = pictureWindow.isVisible();//��ȡ��ʻ���ʾ����ɼ�״̬
//                if (isVisible){
//                    showPictureButton.setText("չ����ʻ�");
//                    pictureWindow.setVisible(false);
//                }else {
//                    showPictureButton.setText("���ؼ�ʻ�");
//                    //����ָ����ʻ���ʾ�������ʾλ��
//                    //������ = ����������� - ��ʻ������� - 5��
//                    //������ = ������������
//                    pictureWindow.setLocation(getX() - pictureWindow.getWidth() - 5,getY());
//                    pictureWindow.setVisible(true);
//                }
//            }
//        });
//    }
//
//    public void initShowPicButton(){
//        showPictureButton.setText("չ����ʻ�");
//    }
//    private void addWatermark() {
//        if (!"".equals(shuiyin.trim())) {//���ˮӡ�ֶβ��ǿ��ַ���
//            g.rotate(Math.toRadians(-30));//��ת����ʮ����
//            Font font = new Font("����", Font.BOLD, 72);//��������
//            g.setFont(font);
//            g.setColor(Color.GRAY);
//            AlphaComposite alpha = AlphaComposite.SrcOver.derive(0.4f);//����͸����Ч��
//            g.setComposite(alpha);
//            g.drawString(shuiyin, 150, 500);
//            canvas.repaint();//�����ػ�
//            g.rotate(Math.toRadians(30));
//            alpha = AlphaComposite.SrcOver.derive(1f);
//            g.setComposite(alpha);
//            g.setColor(foreColor);
//
//
//        }
//    }
//
//    public static void main(String[] args) {
//        DrawPictureFrame frame = new DrawPictureFrame();
//        frame.setVisible(true);
//    }
//
//    @Override
//    public void getShape(Shapes shape) {
//        this.shape = shape;
//        drawShape = true;
//    }
//}

package com.mr.draw;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import com.mr.util.DrawImageUtil;
import com.mr.util.FrameGetShape;
import com.mr.util.ShapeWindow;
import com.mr.util.Shapes;

/**
 * ��ͼ������
 *
 * @������λ ����ʡ���տƼ����޹�˾
 * @��˾��ַ www.mingribook.com
 */
public class DrawPictureFrame extends JFrame implements FrameGetShape {
    BufferedImage image = new BufferedImage(570, 390,
            BufferedImage.TYPE_INT_BGR); // ����һ��8 λ BGR ��ɫ������ͼ��
    Graphics gs = image.getGraphics(); // ���ͼ��Ļ�ͼ����
    Graphics2D g = (Graphics2D) gs; // ����ͼ����ת��ΪGraphics2D����
    DrawPictureCanvas canvas = new DrawPictureCanvas(); // ������������
    Color foreColor = Color.BLACK; // ����ǰ��ɫ
    Color backgroundColor = Color.WHITE; // ���屳��ɫ
    boolean rubber = false; // ��Ƥ��ʶ����
    boolean drawShape = false; // ��ͼ�α�ʶ����
    Shapes shape;// �滭��ͼ��
    int x = -1; // ��һ�������Ƶ�ĺ�����
    int y = -1; // ��һ�������Ƶ��������

    private JToolBar toolBar;// ������
    private JButton eraserButton;// ��Ƥ��ť
    private JToggleButton strokeButton1;// ϸ�߰�ť
    private JToggleButton strokeButton2;// ���߰�ť
    private JToggleButton strokeButton3;// �ϴְ�ť
    private JButton backgroundButton;// ����ɫ��ť
    private JButton foregroundButton;// ǰ��ɫ��ť
    private JButton clearButton;// �����ť
    private JButton saveButton;// ���水ť
    private JButton shapeButton;// ͼ�ΰ�ť
    private JMenuItem strokeMenuItem1;// ϸ�߲˵�
    private JMenuItem strokeMenuItem2;// ���߲˵�
    private JMenuItem strokeMenuItem3;// �ϴֲ˵�
    private JMenuItem clearMenuItem;// ����˵�
    private JMenuItem foregroundMenuItem;// ǰ��ɫ�˵�
    private JMenuItem backgroundMenuItem;// ����ɫ�˵�
    private JMenuItem eraserMenuItem;// ��Ƥ�˵�
    private JMenuItem exitMenuItem;// �˳��˵�
    private JMenuItem saveMenuItem;// ����˵�
    private JMenuItem shuiyinMenuItem;// ˮӡ�˵�
    private String shuiyin = "";// ˮӡ�ַ�����

    private PictureWindow picWindow;// ��ʻ�չʾ����
    private JButton showPicButton;// չ����ʻ���ť

    /**
     * ���췽��
     */
    public DrawPictureFrame() {
        setResizable(false);// ���岻�ܸı��С
        setTitle("��ͼ����(ˮӡ���ݣ�[ " + shuiyin + " ] )");// ���ñ��⣬���ˮӡ������ʾ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ����ر���ֹͣ����
        setBounds(500, 100, 574, 460);// ���ô���λ�úͿ��

        init();// �����ʼ��
        addListener();// ����������
    }

    /**
     * �����ʼ��
     */
    private void init() {
        g.setColor(backgroundColor); // �ñ���ɫ���û�ͼ�������ɫ
        g.fillRect(0, 0, 583, 498); // �ñ���ɫ�����������
        g.setColor(foreColor); // ��ǰ��ɫ���û�ͼ�������ɫ
        canvas.setImage(image); // ���û�����ͼ��
        getContentPane().add(canvas); // ��������ӵ���������Ĭ�ϲ��ֵ��в�λ��
        toolBar = new JToolBar();// ��ʼ��������
        getContentPane().add(toolBar, BorderLayout.NORTH);// ��������ӵ������λ��

        showPicButton = new JButton();// ��ʼ����ť���󣬲�����ı�����
        showPicButton.setToolTipText("չ����ʻ�");// ���ð�ť�����ͣ��ʾ
        showPicButton.setIcon(new ImageIcon("src/img/icon/չ��.png"));// ���ð�ťͼ��
        toolBar.add(showPicButton);// ��������Ӱ�ť

        saveButton = new JButton();// ��ʼ����ť���󣬲�����ı�����
        saveButton.setToolTipText("����");// ���ð�ť�����ͣ��ʾ
        saveButton.setIcon(new ImageIcon("src/img/icon/����.png"));// ���ð�ťͼ��
        toolBar.add(saveButton);// ��������Ӱ�ť
        toolBar.addSeparator();// ��ӷָ���

        strokeButton1 = new JToggleButton();// ��ʼ����ѡ��״̬�İ�ť���󣬲�����ı�����
        strokeButton1.setToolTipText("ϸ��");// ���ð�ť�����ͣ��ʾ
        strokeButton1.setIcon(new ImageIcon("src/img/icon/1��������.png"));// ���ð�ťͼ��
        strokeButton1.setSelected(true);// ϸ�߰�ť���ڱ�ѡ��״̬
        toolBar.add(strokeButton1);// ��������Ӱ�ť
        strokeButton2 = new JToggleButton();// ��ʼ����ѡ��״̬�İ�ť���󣬲�����ı�����
        strokeButton2.setToolTipText("����");// ���ð�ť�����ͣ��ʾ
        strokeButton2.setIcon(new ImageIcon("src/img/icon/2��������.png"));// ���ð�ťͼ��
        toolBar.add(strokeButton2);// ��������Ӱ�ť
        strokeButton3 = new JToggleButton();// ��ʼ����ѡ��״̬�İ�ť���󣬲�����ı�����
        strokeButton3.setToolTipText("�ϴ�");// ���ð�ť�����ͣ��ʾ
        strokeButton3.setIcon(new ImageIcon("src/img/icon/4��������.png"));// ���ð�ťͼ��
        ButtonGroup strokeGroup = new ButtonGroup();// ���ʴ�ϸ��ť�飬��֤ͬʱֻ��һ����ť��ѡ��
        strokeGroup.add(strokeButton1);// ��ť����Ӱ�ť
        strokeGroup.add(strokeButton2);// ��ť����Ӱ�ť
        strokeGroup.add(strokeButton3);// ��ť����Ӱ�ť
        toolBar.add(strokeButton3);// ��������Ӱ�ť
        toolBar.addSeparator();// ��ӷָ�
        backgroundButton = new JButton();// ��ʼ����ť���󣬲�����ı�����
        backgroundButton.setToolTipText("������ɫ");// ���ð�ť�����ͣ��ʾ
        backgroundButton.setIcon(new ImageIcon("src/img/icon/����ɫ.png"));// ���ð�ťͼ��
        toolBar.add(backgroundButton);// ��������Ӱ�ť
        foregroundButton = new JButton();// ��ʼ����ť���󣬲�����ı�����
        foregroundButton.setToolTipText("ǰ����ɫ");// ���ð�ť�����ͣ��ʾ
        foregroundButton.setIcon(new ImageIcon("src/img/icon/ǰ��ɫ.png"));// ���ð�ťͼ��
        toolBar.add(foregroundButton);// ��������Ӱ�ť
        toolBar.addSeparator();// ��ӷָ���

        shapeButton = new JButton();// ��ʼ����ť���󣬲�����ı�����
        shapeButton.setToolTipText("ͼ��");// ���ð�ť�����ͣ��ʾ
        shapeButton.setIcon(new ImageIcon("src/img/icon/��״.png"));// ���ð�ťͼ��
        toolBar.add(shapeButton);// ��������Ӱ�ť
        clearButton = new JButton();// ��ʼ����ť���󣬲�����ı�����
        clearButton.setToolTipText("���");// ���ð�ť�����ͣ��ʾ
        clearButton.setIcon(new ImageIcon("src/img/icon/���.png"));// ���ð�ťͼ��
        toolBar.add(clearButton);// ��������Ӱ�ť
        eraserButton = new JButton();// ��ʼ����ť���󣬲�����ı�����
        eraserButton.setToolTipText("��Ƥ");// ���ð�ť�����ͣ��ʾ
        eraserButton.setIcon(new ImageIcon("src/img/icon/��Ƥ.png"));// ���ð�ťͼ��
        toolBar.add(eraserButton);// ��������Ӱ�ť

        JMenuBar menuBar = new JMenuBar();// �����˵���
        setJMenuBar(menuBar);// ��������˵���

        JMenu systemMenu = new JMenu("ϵͳ");// ��ʼ���˵����󣬲�����ı�����
        menuBar.add(systemMenu);// �˵�����Ӳ˵�����
        shuiyinMenuItem = new JMenuItem("����ˮӡ");// ��ʼ���˵�����󣬲�����ı�����
        systemMenu.add(shuiyinMenuItem);// �˵���Ӳ˵���
        saveMenuItem = new JMenuItem("����");// ��ʼ���˵�����󣬲�����ı�����
        systemMenu.add(saveMenuItem);// �˵���Ӳ˵���
        systemMenu.addSeparator();// ��ӷָ���
        exitMenuItem = new JMenuItem("�˳�");// ��ʼ���˵�����󣬲�����ı�����
        systemMenu.add(exitMenuItem);// �˵���Ӳ˵���

        JMenu strokeMenu = new JMenu("����");// ��ʼ���˵����󣬲�����ı�����
        menuBar.add(strokeMenu);// �˵�����Ӳ˵�����
        strokeMenuItem1 = new JMenuItem("ϸ��");// ��ʼ���˵�����󣬲�����ı�����
        strokeMenu.add(strokeMenuItem1);// �˵���Ӳ˵���
        strokeMenuItem2 = new JMenuItem("����");// ��ʼ���˵�����󣬲�����ı�����
        strokeMenu.add(strokeMenuItem2);// �˵���Ӳ˵���
        strokeMenuItem3 = new JMenuItem("�ϴ�");// ��ʼ���˵�����󣬲�����ı�����
        strokeMenu.add(strokeMenuItem3);// �˵���Ӳ˵���

        JMenu colorMenu = new JMenu("��ɫ");// ��ʼ���˵����󣬲�����ı�����
        menuBar.add(colorMenu);// �˵�����Ӳ˵�����
        foregroundMenuItem = new JMenuItem("ǰ����ɫ");// ��ʼ���˵�����󣬲�����ı�����
        colorMenu.add(foregroundMenuItem);// �˵���Ӳ˵���
        backgroundMenuItem = new JMenuItem("������ɫ");// ��ʼ���˵�����󣬲�����ı�����
        colorMenu.add(backgroundMenuItem);// �˵���Ӳ˵���

        JMenu editMenu = new JMenu("�༭");// ��ʼ���˵����󣬲�����ı�����
        menuBar.add(editMenu);// �˵�����Ӳ˵�����
        clearMenuItem = new JMenuItem("���");// ��ʼ���˵�����󣬲�����ı�����
        editMenu.add(clearMenuItem);// �˵���Ӳ˵���
        eraserMenuItem = new JMenuItem("��Ƥ");// ��ʼ���˵�����󣬲�����ı�����
        editMenu.add(eraserMenuItem);// �˵���Ӳ˵���

        picWindow = new PictureWindow(DrawPictureFrame.this);// ������ʻ�չʾ��壬�������൱�����ĸ�����

    }

    /**
     * �������Ӷ�������
     */
    private void addListener() {
        // �����������ƶ��¼�����
        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(final MouseEvent e) {// �������קʱ
                if (x > 0 && y > 0) {// ���x��y��������¼
                    if (rubber) {// ��Ƥ��ʶΪtrue����ʾʹ����Ƥ
                        g.setColor(backgroundColor); // ��ͼ����ʹ�ñ���ɫ
                        g.fillRect(x, y, 10, 10); // ����껮����λ�û�����������
                    } else { // �����Ƥ��ʶΪfalse����ʾ�û��ʻ�ͼ
                        g.drawLine(x, y, e.getX(), e.getY());// ����껮����λ�û�ֱ��
                    }// else����
                }// if����
                x = e.getX(); // ��һ�������Ƶ�ĺ�����
                y = e.getY(); // ��һ�������Ƶ��������
                canvas.repaint(); // ���»���
            }

            public void mouseMoved(final MouseEvent arg0) {// ������ƶ�ʱ
                if (rubber) {// ���ʹ����Ƥ
                    // �������ָ�����״ΪͼƬ
                    Toolkit kit = Toolkit.getDefaultToolkit();// ���ϵͳĬ�ϵ�������߰�
                    Image img = kit.createImage("src/img/icon/�����Ƥ.png");// ���ù��߰���ȡͼƬ
                    // ���ù��߰�����һ���Զ���Ĺ�����,����ΪͼƬ������ȵ�(д��0,0����)�͹������
                    Cursor c = kit.createCustomCursor(img, new Point(0, 0),
                            "clear");
                    setCursor(c);// ʹ���Զ���Ĺ��
                } else {
                    // �������ָ�����״
                    setCursor(Cursor
                            .getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));// �������ָ�����״Ϊʮ�ֹ��
                }
            }
        });

        canvas.addMouseListener(new MouseAdapter() {// ����������¼������¼�
            public void mouseReleased(final MouseEvent arg0) {// ������̧��ʱ
                x = -1; // ����¼��һ�������Ƶ�ĺ�����ָ���-1
                y = -1; // ����¼��һ�������Ƶ��������ָ���-1
            }

            public void mousePressed(MouseEvent e) {// ����������ʱ
                if (drawShape) {// �����ʱ��껭����ͼ��
                    switch (shape.getType()) {// �ж�ͼ�ε�����
                        case Shapes.YUAN:// �����Բ��
                            // �������꣬����괦��ͼ�ε�����λ��
                            int yuanX = e.getX() - shape.getWidth() / 2;
                            int yuanY = e.getY() - shape.getHeigth() / 2;
                            // ����Բ��ͼ�Σ���ָ������Ϳ��
                            Ellipse2D yuan = new Ellipse2D.Double(yuanX, yuanY,
                                    shape.getWidth(), shape.getHeigth());
                            g.draw(yuan);// ��ͼ���߻���Բ��
                            break;// ����switch���
                        case Shapes.FANG:// ����Ƿ���
                            // �������꣬����괦��ͼ�ε�����λ��
                            int fangX = e.getX() - shape.getWidth() / 2;
                            int fangY = e.getY() - shape.getHeigth() / 2;
                            // ��������ͼ�Σ���ָ������Ϳ��
                            Rectangle2D fang = new Rectangle2D.Double(fangX, fangY,
                                    shape.getWidth(), shape.getHeigth());
                            g.draw(fang);// ��ͼ���߻��˷���
                            break;// ����switch���
                    }
                    canvas.repaint(); // ���»���
                    drawShape = false;
                }
            }
        });

        toolBar.addMouseMotionListener(new MouseMotionAdapter() {// �������������ƶ�����
            public void mouseMoved(final MouseEvent arg0) {// ������ƶ�ʱ
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));// �������ָ�����״ΪĬ�Ϲ��
            }
        });

        // �˳��˵�����Ӷ�������
        exitMenuItem.addActionListener(e -> {// ���ʱ
            System.exit(0);// ����ر�
        });

        // ��Ƥ�˵�����Ӷ�������
        eraserMenuItem.addActionListener(e -> {// ���ʱ
            if (rubber) { // ����˵�����������Ϊ����Ƥ��
                eraserButton.setToolTipText("��Ƥ");// ���ð�ť�����ͣ��ʾ
                // ���ð�ťͼ��
                eraserButton.setIcon(new ImageIcon("src/img/icon/��Ƥ.png"));
                eraserMenuItem.setText("��Ƥ"); // �ı�˵�����ʾ���ı�Ϊ��Ƥ
                g.setColor(foreColor); // ���û�ͼ�����ǰ��ɫ
                rubber = false;// ��Ƥ��ʶ������Ϊfasle����ʾ��ǰʹ�û���
            } else { // �����������ϵĻ�ͼ��ť��ʹ�û���
                eraserMenuItem.setText("��ͼ"); // �ı�˵�����ʾ���ı�Ϊ��ͼ
                eraserButton.setToolTipText("��ͼ"); // ���ð�ť�����ͣ��ʾ
                // ���ð�ťͼ��
                eraserButton.setIcon(null);
                g.setColor(backgroundColor); // ���û�ͼ�����ǰ��ɫ
                rubber = true;// ��Ƥ��ʶ������Ϊtrue����ʾ��ǰʹ����Ƥ
            }
        });

        // ��ϸ�ߡ���ť��Ӷ�������
        strokeButton1.addActionListener(arg0 -> {// ���ʱ
            // �������ʵ����ԣ���ϸΪ1���أ�����ĩ�������Σ����ߴ��ʼ��
            BasicStroke bs = new BasicStroke(1,
                    BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
            g.setStroke(bs); // ��ͼ����ʹ�ô˻���
        });

        // �����ߡ���ť��Ӷ�������
        strokeButton2.addActionListener(arg0 -> {
            // �������ʵ����ԣ���ϸΪ2���أ�����ĩ�������Σ����ߴ��ʼ��
            BasicStroke bs = new BasicStroke(2,
                    BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
            g.setStroke(bs); // ��ͼ����ʹ�ô˻���
        });

        // ���ϴ֡���ť��Ӷ�������
        strokeButton3.addActionListener(arg0 -> {
            // �������ʵ����ԣ���ϸΪ4���أ�����ĩ�������Σ����ߴ��ʼ��
            BasicStroke bs = new BasicStroke(4,
                    BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
            g.setStroke(bs); // ��ͼ����ʹ�ô˻���
        });

        // ������ɫ��ť��Ӷ�������
        backgroundButton.addActionListener(arg0 -> {// ���ʱ
            // ��ѡ����ɫ�Ի��򣬲�������Ϊ�������塢���⡢Ĭ��ѡ�е���ɫ����ɫ��
            Color bgColor = JColorChooser.showDialog(
                    DrawPictureFrame.this, "ѡ����ɫ�Ի���", Color.CYAN);
            if (bgColor != null) {// ���ѡ�е���ɫ���ǿյ�
                backgroundColor = bgColor;// ��ѡ�е���ɫ��������ɫ����
            }
            backgroundButton.setBackground(backgroundColor);// ����ɫ��ť��Ҳ����Ϊ���ֱ�����ɫ
            g.setColor(backgroundColor); // ��ͼ����ʹ�ñ���ɫ
            g.fillRect(0, 0, 570, 390); // ��һ��������ɫ�ķ���������������
            g.setColor(foreColor); // ��ͼ����ʹ��ǰ��ɫ
            canvas.repaint(); // ���»���
        });
        // ǰ��ɫ��ɫ��ť��Ӷ�������
        foregroundButton.addActionListener(arg0 -> {// ���ʱ
            // ��ѡ����ɫ�Ի���,��������Ϊ�������塢���⡢Ĭ��ѡ�е���ɫ����ɫ��
            Color fColor = JColorChooser.showDialog(
                    DrawPictureFrame.this, "ѡ����ɫ�Ի���", Color.CYAN);
            if (fColor != null) {// ���ѡ�е���ɫ���ǿյ�
                foreColor = fColor;// ��ѡ�е���ɫ����ǰ��ɫ����
            }
            foregroundButton.setBackground(foreColor);// ǰ��ɫ��ť������Ҳ����Ϊ������ɫ
            g.setColor(foreColor); // ��ͼ����ʹ��ǰ��ɫ
        });
        // �����ť��Ӷ�������
        clearButton.addActionListener(arg0 -> {// ���ʱ
            g.setColor(backgroundColor); // ��ͼ����ʹ�ñ���ɫ
            g.fillRect(0, 0, 570, 390); // ��һ��������ɫ�ķ���������������
            g.setColor(foreColor); // ��ͼ����ʹ��ǰ��ɫ
            canvas.repaint(); // ���»���
        });

        // ��Ƥ��ť��Ӷ�������
        eraserButton.addActionListener(arg0 -> {// ���ʱ
            if (rubber) { // ����˵�����������Ϊ����Ƥ��
                eraserButton.setToolTipText("��Ƥ");// ���ð�ť�����ͣ��ʾ
                // ���ð�ťͼ��
                eraserButton.setIcon(new ImageIcon(
                        "src/img/icon/��Ƥ.png"));
                eraserMenuItem.setText("��Ƥ"); // �ı�˵�����ʾ���ı�Ϊ��Ƥ
                g.setColor(foreColor); // ���û�ͼ�����ǰ��ɫ
                rubber = false;// ��Ƥ��ʶ������Ϊfasle����ʾ��ǰʹ�û���
            } else { // �����������ϵĻ�ͼ��ť��ʹ�û���
                eraserMenuItem.setText("��ͼ"); // �ı�˵�����ʾ���ı�Ϊ��ͼ
                eraserButton.setToolTipText("��ͼ"); // ���ð�ť�����ͣ��ʾ
                // ���ð�ťͼ��
                eraserButton.setIcon(new ImageIcon(
                        "src/img/icon/����.png"));
                g.setColor(backgroundColor); // ���û�ͼ�����ǰ��ɫ
                rubber = true;// ��Ƥ��ʶ������Ϊtrue����ʾ��ǰʹ����Ƥ
            }
        });

        // ����˵���Ӷ�������
        clearMenuItem.addActionListener(e -> {// ���ʱ
            g.setColor(backgroundColor); // ��ͼ����ʹ�ñ���ɫ
            g.fillRect(0, 0, 570, 390); // ��һ��������ɫ�ķ���������������
            g.setColor(foreColor); // ��ͼ����ʹ��ǰ��ɫ
            canvas.repaint(); // ���»���
        });

        // "ϸ��"�˵���Ӷ�������
        strokeMenuItem1.addActionListener(e -> {// ���ʱ
            // �������ʵ����ԣ���ϸΪ1���أ�����ĩ�������Σ����ߴ��ʼ��
            BasicStroke bs = new BasicStroke(1,
                    BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
            g.setStroke(bs);// ��ͼ����ʹ�ô˻���
            strokeButton1.setSelected(true);// "ϸ��"��ť��Ϊѡ��״̬
        });
        // "����"�˵���Ӷ�������
        strokeMenuItem2.addActionListener(e -> {// ���ʱ
            // �������ʵ����ԣ���ϸΪ2���أ�����ĩ�������Σ����ߴ��ʼ��
            BasicStroke bs = new BasicStroke(2,
                    BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
            g.setStroke(bs); // ��ͼ����ʹ�ô˻���
            strokeButton2.setSelected(true);// "����"��ť��Ϊѡ��״̬
        });
        // "�ϴ�"�˵���Ӷ�������
        strokeMenuItem3.addActionListener(e -> {// ���ʱ
            // �������ʵ����ԣ���ϸΪ4���أ�����ĩ�������Σ����ߴ��ʼ��
            BasicStroke bs = new BasicStroke(4,
                    BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
            g.setStroke(bs); // ��ͼ����ʹ�ô˻���
            strokeButton3.setSelected(true);// "�ϴ�"��ť��Ϊѡ��״̬
        });
        // ǰ��ɫ�˵���Ӷ�������
        foregroundMenuItem.addActionListener(e -> {// ���ʱ
            // ��ѡ����ɫ�Ի���,��������Ϊ�������塢���⡢Ĭ��ѡ�е���ɫ����ɫ��
            Color fColor = JColorChooser.showDialog(
                    DrawPictureFrame.this, "ѡ����ɫ�Ի���", Color.CYAN);
            if (fColor != null) {// ���ѡ�е���ɫ���ǿյ�
                foreColor = fColor;// ��ѡ�е���ɫ����ǰ��ɫ����
            }
            foregroundButton.setForeground(foreColor);// ǰ��ɫ��ť������Ҳ����Ϊ������ɫ
            g.setColor(foreColor); // ��ͼ����ʹ��ǰ��ɫ
        });
        // ����ɫ�˵���Ӷ�������
        backgroundMenuItem.addActionListener(e -> {// ���ʱ
            // ��ѡ����ɫ�Ի��򣬲�������Ϊ�������塢���⡢Ĭ��ѡ�е���ɫ����ɫ��
            Color bgColor = JColorChooser.showDialog(
                    DrawPictureFrame.this, "ѡ����ɫ�Ի���", Color.CYAN);
            if (bgColor != null) {// ���ѡ�е���ɫ���ǿյ�
                backgroundColor = bgColor;// ��ѡ�е���ɫ��������ɫ����
            }
            backgroundButton.setBackground(backgroundColor);// ����ɫ��ť��Ҳ����Ϊ���ֱ�����ɫ
            g.setColor(backgroundColor); // ��ͼ����ʹ�ñ���ɫ
            g.fillRect(0, 0, 570, 390); // ��һ��������ɫ�ķ���������������
            g.setColor(foreColor); // ��ͼ����ʹ��ǰ��ɫ
            canvas.repaint(); // ���»���
        });
        // ���水ť��Ӷ�������
        saveButton.addActionListener(arg0 -> {// ���ʱ
            addWatermark();// ���ˮӡ
            DrawImageUtil.saveImage(DrawPictureFrame.this, image);// ��ӡͼƬ
        });
        // ����˵���Ӷ�������
        saveMenuItem.addActionListener(e -> {// ���ʱ
            addWatermark();// ���ˮӡ
            DrawImageUtil.saveImage(DrawPictureFrame.this, image);// ��ӡͼƬ
        });

        // ͼ�ΰ�ť��Ӷ�������
        shapeButton.addActionListener(e -> {// ���ʱ
            ShapeWindow shapeWindow = new ShapeWindow(
                    DrawPictureFrame.this);// ����ͼ��ѡ�����
            int shapeButtonWidth = shapeButton.getWidth();// ��ȡͼ��ť���
            int shapeWindowWidth = shapeWindow.getWidth();// ��ȡͼ�ΰ�ť�߶�
            int shapeButtonX = shapeButton.getX();// ��ȡͼ�ΰ�ť������
            int shapeButtonY = shapeButton.getY();// ��ȡͼ�ΰ�ť������
            // ����ͼ����������꣬Ϊͼ�ΰ�ť�·��밴ť���ж���
            int shapeWindowX = getX() + shapeButtonX
                    - (shapeWindowWidth - shapeButtonWidth) / 2;
            // ����ͼ����������꣬Ϊͼ�ΰ�ť�·�
            int shapeWindowY = getY() + shapeButtonY + 80;
            // ����ͼ���������λ��
            shapeWindow.setLocation(shapeWindowX, shapeWindowY);
            shapeWindow.setVisible(true);// ͼ������ɼ�
        });
        // ˮӡ�˵�����Ӷ�������
        shuiyinMenuItem.addActionListener(e -> {// ���ʱ
            // ��������Ի���
            shuiyin = JOptionPane.showInputDialog(
                    DrawPictureFrame.this, "�������ʲôˮӡ��");
            if (null == shuiyin) {// �������Ի��򷵻ص���null
                shuiyin = "";// �ַ�����Ϊ������
            } else {// �������null
                setTitle("��ͼ����(ˮӡ���ݣ�[ " + shuiyin + " ] )");// �޸Ĵ������
            }
        });
        // չʾ��ʻ���ť��Ӷ�������
        showPicButton.addActionListener(e -> {// ���ʱ
            boolean isVisible = picWindow.isVisible();// ��ȡ��ʻ�չʾ����ɼ�״̬
            if (isVisible) {// �����ʻ�չʾ�����ǿɼ���
                showPicButton.setToolTipText("չ����ʻ�");// �޸İ�ť���ı�
                showPicButton.setIcon(new ImageIcon(
                        "src/img/icon/չ��.png"));// ���ð�ťͼ��
                picWindow.setVisible(false);// ���ؼ�ʻ�չʾ����
            } else {// ��������ص�
                showPicButton.setToolTipText("���ؼ�ʻ�");// �޸İ�ť���ı�
                showPicButton.setIcon(new ImageIcon(
                        "src/img/icon/����.png"));// ���ð�ťͼ��
                // ����ָ����ʻ�չʾ�������ʾλ��
                // ������ = ����������� - ��ʻ������� - 5
                // ������ = ������������
                picWindow.setLocation(getX() - picWindow.getWidth()
                        - 5, getY());
                picWindow.setVisible(true);// ��ʻ�չʾ����ɼ�
            }
        });
    }

    /**
     * ���ˮӡ
     */
    private void addWatermark() {
        if (!"".equals(shuiyin.trim())) {// ���ˮӡ�ֶβ��ǿ��ַ���
            g.rotate(Math.toRadians(-30));// ��ͼƬ��ת-30����
            Font font = new Font("����", Font.BOLD, 60);// ��������
            g.setFont(font);// ��������
            g.setColor(Color.GRAY);// ʹ�û�ɫ
            AlphaComposite alpha = AlphaComposite.SrcOver.derive(0.4f);// ����͸��Ч��
            g.setComposite(alpha);// ʹ��͸��Ч��
            g.drawString(shuiyin, 150, 500);// ��������
            canvas.repaint();// ����ػ�
            g.rotate(Math.toRadians(30));// ����ת��ͼƬ��ת����
            alpha = AlphaComposite.SrcOver.derive(1f);// ��͸��Ч��
            g.setComposite(alpha);// ʹ�ò�͸��Ч��
            g.setColor(foreColor);// ���ʻָ�֮ǰ��ɫ
        }
    }

    /**
     * FrameGetShape�ӿ�ʵ���࣬���ڻ��ͼ�οռ䷵�صı�ѡ�е�ͼ��
     */
    public void getShape(Shapes shape) {
        this.shape = shape;// �����ص�ͼ�ζ��󸶸����ȫ�ֱ���
        drawShape = true;// ��ͼ�α�ʶ����Ϊtrue��˵��ѡ����껭����ͼ�Σ���������
    }// getShape()����

    /**
     * �ָ�չ����ʻ���ť���ı����ݣ��˷�������ʻ����ġ����ء���ť����
     */
    public void initShowPicButton() {
        showPicButton.setToolTipText("չ����ʻ�");// �޸İ�ť���ı�
        showPicButton.setIcon(new ImageIcon("src/img/icon/չ��.png"));// ���ð�ťͼ��
    }// initShowPicButton()����

    /**
     * ����������������
     *
     * @param args �C ����ʱ�������������ò���
     */
    public static void main(String[] args) {
        DrawPictureFrame frame = new DrawPictureFrame();// �����������
        frame.setVisible(true);// �ô���ɼ�
    }// main()����

}// DrawPictureFrame�����
