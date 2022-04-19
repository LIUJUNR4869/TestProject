package Reflect;
/*
    newInstance()���������޲ι��췽��
 */
import java.util.concurrent.Callable;

public class ReflectTest02 {
    public static void main(String[] args) {

        //��ʹ�÷�����ƴ�������
        User user = new User();
        System.out.println(user);



        //ͨ��������ƣ���ȡClass����������--->�������
        try {
            Class c = Class.forName("Reflect.User");

            //�����   �޲������췽��   ����ɶ���Ĵ���---->�������޲ι���
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
