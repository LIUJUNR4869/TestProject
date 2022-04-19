package Thread;
/*

 */
public class ThreadTest04
{
    public static void main(String[] args){

        //��λ�ȡ��ǰ�̶߳���
        Thread t = Thread.currentThread(); //t������ڴ��ַָ����߳��ǡ����̶߳���

        //��ȡ�̵߳�����
        System.out.println(t.getName()); //main


        Thread t1 = new Thread(new Processor());

        //���߳�����
        t1.setName("t1");

        t1.start();

        Thread t2 = new Thread(new Processor());

        //���߳�����
        t2.setName("t2");

        t2.start();
    }
}

class Processor implements Runnable {
    public void run() {
        Thread t = Thread.currentThread(); //t������ڴ��ַָ����߳��ǡ�t1�̶߳���
        System.out.println(t.getName()); //Thread-0 Thread-1
        for (int i = 0; i < 10; i++) {
            System.out.println(t.getName() + "---->"+ i);
        }
    }
}
