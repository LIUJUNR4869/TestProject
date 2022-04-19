package Thread;
/*
	ĳ�߳��������ߣ���������������.

	���·�ʽ��������java�쳣������ơ�
*/
public class ThreadTest07 {
    public static void main(String[] args) throws Exception{

        //���������̣߳�5S֮�����̵߳�����.
        Thread t = new Thread(new Processor2());

        //����
        t.setName("t");

        //����
        t.start();

        //5S֮��
        Thread.sleep(5000);

        //���t������.--->ִ�У��׳��쳣����Processor�е�catch��׽
        t.interrupt();

    }
}

//run����������ֻ��ʹ��try catch ������throws ----->run()������û���׳��κ��쳣�����಻�ܱȸ����׳������쳣
class Processor2 implements Runnable
{
    public void run(){

        try{
            Thread.sleep(100000000000L);

            System.out.println("HelloWorld!");

        }catch(InterruptedException e){
            //e.printStackTrace();
        }

        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"-->"+i);
        }

    }
}
