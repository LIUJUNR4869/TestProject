package Thread;
/*
	守护线程.
	Java中线程分为两大类：用户线程、守护线程（以垃圾回收器为代表）
	守护线程特点：守护线程一般都是无限执行的，是一个死循环，所有用户线程只要结束，守护线程自动结束
	主线程main是一个用户线程

	守护线程使用：使用定时器，并将定时器设置为守护线程

*/
public class TreadTest18 {
    public static void main(String[] args) {
        Thread t = new BakDataThread();
        t.setName("备份数据的线程");
        //启动之前，将备份线程设置成守护线程
        t.setDaemon(true);
        t.start();

        //主线程
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "-------->" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class BakDataThread extends  Thread{
    public void run(){
        int i = 0;
        while(true){
            System.out.println(Thread.currentThread().getName() + "-------->" + (++i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
