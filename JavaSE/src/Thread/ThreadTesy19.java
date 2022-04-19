package Thread;

import java.util.ArrayList;
import java.util.List;

/*
	Object类中的 wait 和 notify 方法（生产者和消费者模式）
	wait 和notify 方法不是线程对象的方法，而是任意java对象的方法

	wait方法作用：
		Object o = new Object();
		o.wait();
		表示：让正在O对象上活动的线程进入等待状态，无期限等待，直到唤醒为止
		当前线程进入等待状态，直到最终调用o.notify方法再继续

	生产者-消费者模式应用场景
	wait:o.wait();让O对象上的线程进入等待状态，并且释放t线程之前占用的o对象的锁
	notify:o.notify让在o对象上等待的线程唤醒，但不会释放锁
*/
/*
    模拟需求
        仓库采用list集合
        List集合中假设只能储存一个元素
        1个元素就表示仓库已经满了
        如果List集合中元素个数是0就表示仓库空了
        保证List集合中永远最多只有一个元素

 */
public class ThreadTesy19 {
    public static void main(String[] args) {
        //创建一个共享的仓库对象
        List list = new ArrayList();
        //创建两个线程对象
        //生产者线程
        Thread t1 = new Thread(new Producer(list));
        //消费者
        Thread t2 = new Thread(new Consumer(list));

        t1.setName("生产者");
        t2.setName("消费者");
    }
}
//生产线程
class Producer implements Runnable {
    private List list;

    public Producer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        //一直生产
        while (true){
            synchronized (list){
                if (list.size()>0){
                    try {
                        //当前线程进入等待状态,释放Producer之前占用的List集合的锁
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //程序执行到这，证明可以生产
                Object obj = new Object();
                list.add(obj);
                System.out.println(Thread.currentThread().getName() + "----->" + obj);

                //唤醒消费者进行消费
                list.notifyAll();
            }
        }
    }
}


//消费线程
class Consumer implements Runnable{

    private List list;

    public Consumer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        //一直消费
        while (true){
            synchronized (list){
                if (list.size() == 0){
                    try {
                        //仓库已经空了，消费者线程进入等待，释放list集合的锁
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //程序能够执行到此处，证明仓库中有数据，进行消费
                Object obj = list.remove(0);
                System.out.println(Thread.currentThread().getName() + "---------->" + obj);

                //唤醒生产者生产
                list.notifyAll();

            }
        }
    }
}