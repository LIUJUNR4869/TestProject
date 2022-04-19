package Thread;
/*+
    终止一个线程的执行
    ~.stop();
    会直接杀死程序，容易丢失数据

 */
public class ThreadTest08 {
    public static void main(String[] args) {
        Thread t = new Thread();
        t.setName("t");
        t.start();
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //5s后强行终止

        t.stop();//已过时
    }
}

class MyRunnable implements  Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "---->" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
