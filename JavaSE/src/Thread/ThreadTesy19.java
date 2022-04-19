package Thread;

import java.util.ArrayList;
import java.util.List;

/*
	Object���е� wait �� notify �����������ߺ�������ģʽ��
	wait ��notify ���������̶߳���ķ�������������java����ķ���

	wait�������ã�
		Object o = new Object();
		o.wait();
		��ʾ��������O�����ϻ���߳̽���ȴ�״̬�������޵ȴ���ֱ������Ϊֹ
		��ǰ�߳̽���ȴ�״̬��ֱ�����յ���o.notify�����ټ���

	������-������ģʽӦ�ó���
	wait:o.wait();��O�����ϵ��߳̽���ȴ�״̬�������ͷ�t�߳�֮ǰռ�õ�o�������
	notify:o.notify����o�����ϵȴ����̻߳��ѣ��������ͷ���
*/
/*
    ģ������
        �ֿ����list����
        List�����м���ֻ�ܴ���һ��Ԫ��
        1��Ԫ�ؾͱ�ʾ�ֿ��Ѿ�����
        ���List������Ԫ�ظ�����0�ͱ�ʾ�ֿ����
        ��֤List��������Զ���ֻ��һ��Ԫ��

 */
public class ThreadTesy19 {
    public static void main(String[] args) {
        //����һ������Ĳֿ����
        List list = new ArrayList();
        //���������̶߳���
        //�������߳�
        Thread t1 = new Thread(new Producer(list));
        //������
        Thread t2 = new Thread(new Consumer(list));

        t1.setName("������");
        t2.setName("������");
    }
}
//�����߳�
class Producer implements Runnable {
    private List list;

    public Producer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        //һֱ����
        while (true){
            synchronized (list){
                if (list.size()>0){
                    try {
                        //��ǰ�߳̽���ȴ�״̬,�ͷ�Producer֮ǰռ�õ�List���ϵ���
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //����ִ�е��⣬֤����������
                Object obj = new Object();
                list.add(obj);
                System.out.println(Thread.currentThread().getName() + "----->" + obj);

                //���������߽�������
                list.notifyAll();
            }
        }
    }
}


//�����߳�
class Consumer implements Runnable{

    private List list;

    public Consumer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        //һֱ����
        while (true){
            synchronized (list){
                if (list.size() == 0){
                    try {
                        //�ֿ��Ѿ����ˣ��������߳̽���ȴ����ͷ�list���ϵ���
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //�����ܹ�ִ�е��˴���֤���ֿ��������ݣ���������
                Object obj = list.remove(0);
                System.out.println(Thread.currentThread().getName() + "---------->" + obj);

                //��������������
                list.notifyAll();

            }
        }
    }
}