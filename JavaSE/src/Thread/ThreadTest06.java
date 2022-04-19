package Thread;
/*
    面试题
 */
public class ThreadTest06 {
    public static void main(String[] args) {
        //创建线程
        Thread t = new Processor1();
        t.setName("t");

        //启动线程
        t.start();

        //休眠
        try {
            t.sleep(5000);               //等同于Thread.sleep(5000); 阻塞的还是当前线程，和t线程无关。----出现在main方法中，所以main休眠
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("HelloWorld!");


        A a = null;
        a.m1(); //不会出现空指针异常。
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