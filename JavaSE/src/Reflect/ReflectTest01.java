package Reflect;

import java.util.Date;

/*
    通过反射机制可以操作字节码文件、代码片段（.class文件）
    在java.lang.reflect.*包下

    Class.forName()
        1.静态方法
        2.方法的参数是一个字符串
        3.字符串需要是一个完整的类
        4.完整类名必须有包名
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

        //java中任何对象都有一个方法：getClass()
        String s= "abc";
        Class x = s.getClass();//x代表string.class字节码文件，x代表
        System.out.println(c1 == x);//双等号判断变量保存的地址

        Date time = new Date();
        Class t = time.getClass();
        System.out.println(c2 == t);

        //java中每个类型都有 class 属性.
        Class z = String.class;

    }
}
