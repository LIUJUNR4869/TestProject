package Thread;
/*
	1.Thread.sleep(毫秒);
	2.sleep方法是一个静态方法.
	3.该方法的作用：阻塞当前线程.腾出CPU，让给其他线程。---让当前线程进入休眠，“阻塞状态”
*/
public class ThreadTest05 {
    public static void main(String[] args) {
//        try {
//            Thread.sleep(1000*5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Hello World!");//5秒钟之后执行

        //可实现每隔一段时间特定实现某段代码
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
