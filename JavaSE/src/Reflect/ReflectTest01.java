package Reflect;

import java.util.Date;

/*
    ͨ��������ƿ��Բ����ֽ����ļ�������Ƭ�Σ�.class�ļ���
    ��java.lang.reflect.*����

    Class.forName()
        1.��̬����
        2.�����Ĳ�����һ���ַ���
        3.�ַ�����Ҫ��һ����������
        4.�������������а���
 */
public class ReflectTest01 {
    public static void main(String[] args) {
        Class c1 = null;
        Class c2 =null;
        try {
            c1 = Class.forName("java.lang.String");
            c2 = Class.forName("java.until.Date");
            Class c3 = Class.forName("Java.lang.Interge");
            Class c4 = Class.forName("java.lang.System");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //java���κζ�����һ��������getClass()
        String s= "abc";
        Class x = s.getClass();//x����string.class�ֽ����ļ���x����
        System.out.println(c1 == x);//˫�Ⱥ��жϱ�������ĵ�ַ

        Date time = new Date();
        Class t = time.getClass();
        System.out.println(c2 == t);

        //java��ÿ�����Ͷ��� class ����.
        Class z = String.class;

    }
}
