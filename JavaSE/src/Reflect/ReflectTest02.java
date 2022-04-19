package Reflect;
/*
    newInstance()，调用了无参构造方法
 */
import java.util.concurrent.Callable;

public class ReflectTest02 {
    public static void main(String[] args) {

        //不使用反射机制创建对象
        User user = new User();
        System.out.println(user);



        //通过反射机制，获取Class并创建对象--->更加灵活
        try {
            Class c = Class.forName("Reflect.User");

            //会调用   无参数构造方法   ，完成对象的创建---->必须有无参构造
            Object obj = c.newInstance();
            System.out.println(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
