package Thread;

public class ThreadTest10 {
    public static void main(String[] args) {
//        System.out.println("线程优先级" + Thread.MAX_PRIORITY);
//        System.out.println("线程优先级" + Thread.MIN_PRIORITY);
//        System.out.println("默认优先级" + Thread.NORM_PRIORITY);

        Thread.currentThread().setPriority(1);
        //获取当前线程对象
        Thread currentThread = Thread.currentThread();
        //System.out.println(currentThread.getName() + "线程优先级" + currentThread.getPriority());

        Thread t = new Thread(new MyRunnable1());
        t.setPriority(10);
        t.setName("t");
        t.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "---------->" + i);
        }
    }

}
class MyRunnable1 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程优先级" + Thread.currentThread().getPriority());
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "---------->" + i);
        }
    }
}