package Thread;
/*
    ʵ��һ���̵߳ĵڶ��ַ�ʽ����дһ����ʵ��java.lang.Runnable�ӿ�
 */
public class ThreadTest03 {
    public static void main(String[] args) {
//        ����һ�������еĶ���
//        MuRunnabnle r = new MuRunnabnle();
//        �������еĶ����װ��һ���̶߳���
//        Thread t = new Thread(r);

        //�ϲ�����

        Thread t = new Thread(new MyRunnabnle());
        //�����߳�
        t.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("���߳�---->" + i );
            System.out.println("---------------------");
        }

    }
    static class MyRunnabnle implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.println("���߳�---->" + i );
                System.out.println("---------------------");
            }
        }
    }

}
