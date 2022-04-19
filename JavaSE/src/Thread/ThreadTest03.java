package Thread;
/*
    实现一个线程的第二种方式，编写一个类实现java.lang.Runnable接口
 */
public class ThreadTest03 {
    public static void main(String[] args) {
//        创建一个可运行的对象
//        MuRunnabnle r = new MuRunnabnle();
//        将可运行的对象封装成一个线程对象
//        Thread t = new Thread(r);

        //合并代码

        Thread t = new Thread(new MyRunnabnle());
        //启动线程
        t.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程---->" + i );
            System.out.println("---------------------");
        }

    }
    static class MyRunnabnle implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.println("分线程---->" + i );
                System.out.println("---------------------");
            }
        }
    }

}
