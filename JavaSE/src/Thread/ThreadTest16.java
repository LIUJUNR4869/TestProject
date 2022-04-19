package Thread;

/*
    ����,��ֻ��һ�������������༶��ģ�ֻ��һ��.
*/
public class ThreadTest16
{
    public static void main(String[] args) throws Exception{

        Thread t1 = new Thread(new Processor8());
        Thread t2 = new Thread(new Processor8());

        t1.setName("t1");
        t2.setName("t2");

        t1.start();

        //�ӳ٣���֤t1��ִ��
        Thread.sleep(1000);

        t2.start();

    }
}

class Processor8 implements Runnable
{
    public void run(){

        if("t1".equals(Thread.currentThread().getName())){
            MyClass2.m1();
        }

        if("t2".equals(Thread.currentThread().getName())){
            MyClass2.m2();
        }
    }
}

class MyClass2
{
    //synchronized��ӵ���̬�����ϣ��߳�ִ�д˷�����ʱ�����������
    public synchronized static void m1(){

        try{Thread.sleep(10000);}catch(Exception e){}

        System.out.println("m1....");
    }

    //�����m1��������Ϊ�÷���û�б�synchronized����
	/*
	public static void m2(){
		System.out.println("m2...");
	}
	*/

    //m2������m1����֮�����ִ�У��÷�����synchronized
    //�߳�ִ�иô�����Ҫ����������������ֻ��һ����
    public synchronized static void m2(){
        System.out.println("m2...");
    }
}