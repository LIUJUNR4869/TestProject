package Thread;
/*

 */
public class ThreadTest04
{
    public static void main(String[] args){

        //如何获取当前线程对象？
        Thread t = Thread.currentThread(); //t保存的内存地址指向的线程是“主线程对象”

        //获取线程的名字
        System.out.println(t.getName()); //main


        Thread t1 = new Thread(new Processor());

        //给线程起名
        t1.setName("t1");

        t1.start();

        Thread t2 = new Thread(new Processor());

        //给线程起名
        t2.setName("t2");

        t2.start();
    }
}

class Processor implements Runnable {
    public void run() {
        Thread t = Thread.currentThread(); //t保存的内存地址指向的线程是“t1线程对象”
        System.out.println(t.getName()); //Thread-0 Thread-1
        for (int i = 0; i < 10; i++) {
            System.out.println(t.getName() + "---->"+ i);
        }
    }
}
