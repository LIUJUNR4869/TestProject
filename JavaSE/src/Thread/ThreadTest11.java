package Thread;
/*
	Thread.yield();

	1.�÷�����һ����̬����.

	2.���ã���ͬһ�����ȼ����߳���λ��������λʱ�䲻�̶���

	3.��sleep������ͬ������yieldʱ�䲻�̶���
*/
public class ThreadTest11 {
    public static void main(String[] args){

        Thread t = new Processor4();

        t.setName("t");

        t.start();

        //���߳���
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"-->"+i);
        }
    }
}

class Processor4 extends Thread
{
    public void run(){

        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"-->"+i);
            if(i%20==0){
                Thread.yield();
            }

        }
    }
}