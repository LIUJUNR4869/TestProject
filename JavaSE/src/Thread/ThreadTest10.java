package Thread;

public class ThreadTest10 {
    public static void main(String[] args) {
//        System.out.println("�߳����ȼ�" + Thread.MAX_PRIORITY);
//        System.out.println("�߳����ȼ�" + Thread.MIN_PRIORITY);
//        System.out.println("Ĭ�����ȼ�" + Thread.NORM_PRIORITY);

        Thread.currentThread().setPriority(1);
        //��ȡ��ǰ�̶߳���
        Thread currentThread = Thread.currentThread();
        //System.out.println(currentThread.getName() + "�߳����ȼ�" + currentThread.getPriority());

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
        System.out.println(Thread.currentThread().getName() + "�߳����ȼ�" + Thread.currentThread().getPriority());
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "---------->" + i);
        }
    }
}