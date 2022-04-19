package Reflect;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReflectTest03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //ͨ��IO����ȡ classinfo.paoperties�ļ�
        FileReader reader = new FileReader("JavaSE/classinfo.properties");
        //�������������Map
        Properties pro = new Properties();
        //����
        pro.load(reader);
        //�ر���
        reader.close();

        //ͨ��key���value
        String className = pro.getProperty("className");

        //ͨ���������ʵ��������
        Class c = Class.forName(className);
        Object obj = c.newInstance();
        System.out.println(obj);

    }
}
