package Thread;
/*
���̷߳��߳̽�����У����е��߳��ŵ���ִ��Ȩ
����ʹ�������ڲ���  Thread t = new Thread(new MyRunnabnle(){public void run(){}});


 */
public class ThreadTest02 {
    public static void main(String[] args) {
        Mythread mythread = new Mythread();
        //�����߳�
        //start��������������������һ����֧�̣߳���jvm�п���һ��ջ�ռ䣬��δ���������ɺ�˲��ͽ�����
        //Ҫ�µ�ջ�ռ俪�ٳ����������ִ�н����ˣ������ɹ����̻߳��Զ�����run�����������´���ײ�ѹջ
        //run�����ڷ��߳��еĵײ�
        mythread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("���߳�---->" + i );
            System.out.println("---------------------");
        }
    }
    static class  Mythread extends Thread{

        public void  run(){

            for(int i = 0 ; i < 1000;i++){
                System.out.println("��֧�߳�---->" + i);
                System.out.println("*******************");
            }

        }
    }
}
