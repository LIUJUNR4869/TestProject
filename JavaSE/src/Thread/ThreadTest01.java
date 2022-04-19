package Thread;
/*
 进程是一个执行程序，线程是一个进程中的执行场景/执行单元。一个进程可以启动多个线程。
 java中

	分析以下程序有几个线程？
		以下程序只有一个线程，就是主线程.
		main,m1,m2,m3这四个方法在同一个栈空间中。
		没有启动其他任何线程。

	不同进程的内存独立不共享
	同一进程的不同线程，其堆内存和方法区内存共享
	互不干扰，各自运行，----多线程并发，提高程序的处理效率
	使用多线程，main方法执行结束，可能程序并没有结束，main方法只是主线程结束了，主栈空了，其他栈仍存在压栈弹栈的可能

	单核CPU是否可实现多线程并发？
	    不能实现真正的多线程并发，但可以给人多线程并发的感觉
	    方法：CPU处理速度极快，可以在不同进程之间频繁切换执行，但人类的反应速度很慢，所以会产生多线程并发的感觉

	什么是真正的多线程并发？
	    A线程执行A线程的，B线程执行B线程的，回想那个不影响


*/
public class ThreadTest01 {
    public static void main(String[] args) {
        System.out.println("mani begin");
        m1();
        System.out.println("main over");
    }

    private static void m1() {
        System.out.println("main begin");
        m2();
        System.out.println("m2 over");
    }

    private static void m2() {
        System.out.println("m2 begin");
        m3();
        System.out.println("m3 over");
    }

    private static void m3() {
        System.out.println("m3 execute");
    }
}
