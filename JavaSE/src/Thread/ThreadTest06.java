package Thread;
/*
    ������
 */
public class ThreadTest06 {
    public static void main(String[] args) {
        //�����߳�
        Thread t = new Processor1();
        t.setName("t");

        //�����߳�
        t.start();

        //����
        try {
            t.sleep(5000);               //��ͬ��Thread.sleep(5000); �����Ļ��ǵ�ǰ�̣߳���t�߳��޹ء�----������main�����У�����main����
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("HelloWorld!");


        A a = null;
        a.m1(); //������ֿ�ָ���쳣��
    }


}
class Processor1 extends Thread
{
    public void run(){
        for(int i=0;i<200;i++){
            System.out.println(Thread.currentThread().getName()+"------->"+i);
        }
    }
}

class A
{
    public static void m1(){}
}