package Thread;
/*
	1.Thread.sleep(����);
	2.sleep������һ����̬����.
	3.�÷��������ã�������ǰ�߳�.�ڳ�CPU���ø������̡߳�---�õ�ǰ�߳̽������ߣ�������״̬��
*/
public class ThreadTest05 {
    public static void main(String[] args) {
//        try {
//            Thread.sleep(1000*5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Hello World!");//5����֮��ִ��

        //��ʵ��ÿ��һ��ʱ���ض�ʵ��ĳ�δ���
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
