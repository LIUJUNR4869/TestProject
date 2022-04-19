package Thread;

/*
    类锁,类只有一个，所以锁是类级别的，只有一个.
*/
public class ThreadTest16
{
    public static void main(String[] args) throws Exception{

        Thread t1 = new Thread(new Processor8());
        Thread t2 = new Thread(new Processor8());

        t1.setName("t1");
        t2.setName("t2");

        t1.start();

        //延迟，保证t1先执行
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
    //synchronized添加到静态方法上，线程执行此方法的时候会找类锁。
    public synchronized static void m1(){

        try{Thread.sleep(10000);}catch(Exception e){}

        System.out.println("m1....");
    }

    //不会等m1结束，因为该方法没有被synchronized修饰
	/*
	public static void m2(){
		System.out.println("m2...");
	}
	*/

    //m2方法等m1结束之后才能执行，该方法有synchronized
    //线程执行该代码需要“类锁”，而类锁只有一个。
    public synchronized static void m2(){
        System.out.println("m2...");
    }
}