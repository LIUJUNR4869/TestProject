package Thread;
/*
	�ػ��߳�.
	Java���̷߳�Ϊ�����ࣺ�û��̡߳��ػ��̣߳�������������Ϊ����
	�ػ��߳��ص㣺�ػ��߳�һ�㶼������ִ�еģ���һ����ѭ���������û��߳�ֻҪ�������ػ��߳��Զ�����
	���߳�main��һ���û��߳�

	�ػ��߳�ʹ�ã�ʹ�ö�ʱ����������ʱ������Ϊ�ػ��߳�

*/
public class TreadTest18 {
    public static void main(String[] args) {
        Thread t = new BakDataThread();
        t.setName("�������ݵ��߳�");
        //����֮ǰ���������߳����ó��ػ��߳�
        t.setDaemon(true);
        t.start();

        //���߳�
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
