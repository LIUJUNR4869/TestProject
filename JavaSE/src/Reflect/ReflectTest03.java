package Reflect;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReflectTest03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //通过IO流读取 classinfo.paoperties文件
        FileReader reader = new FileReader("JavaSE/classinfo.properties");
        //创建属性类对象Map
        Properties pro = new Properties();
        //加载
        pro.load(reader);
        //关闭流
        reader.close();

        //通过key获得value
        String className = pro.getProperty("className");

        //通过反射机制实例化对象
        Class c = Class.forName(className);
        Object obj = c.newInstance();
        System.out.println(obj);

    }
}
