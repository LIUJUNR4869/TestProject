package Thread;
/*+
    ��ֹһ���̵߳�ִ��
    ~.stop();
    ��ֱ��ɱ���������׶�ʧ����

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
        //5s��ǿ����ֹ

        t.stop();//�ѹ�ʱ
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
