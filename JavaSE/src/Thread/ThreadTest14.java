package Thread;
/*
	以下程序使用线程同步机制保证数据的安全。
*/
public class ThreadTest14
{
    public static void main(String[] args){

        //创建一个公共的账户
        Account1 act = new Account1("actno-001",5000.0);

        //创建线程对同一个账户取款
        Thread t1 = new Thread(new Processor7(act));
        Thread t2 = new Thread(new Processor7(act));

        t1.start();

        t2.start();
    }
}

//取款线程
class Processor7 implements Runnable
{
    //账户
    Account1 act;

    //Constructor
    Processor7(Account1 act){
        this.act = act;
    }

    public void run(){
        act.withdraw(1000.0);
        System.out.println("取款1000.0成功，余额：" + act.getBalance());
    }
}

//账户
class Account1
{
    private String actno;
    private double balance;

    public Account1(){}
    public Account1(String actno,double balance){
        this.actno = actno;
        this.balance = balance;
    }

    //setter and getter
    public void setActno(String actno){
        this.actno = actno;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public String getActno(){
        return actno;
    }

    public double getBalance(){
        return balance;
    }

    //对外提供一个取款的方法
    public void withdraw(double money){ //对当前账户进行取款操作

        //把需要同步的代码，放到同步语句块中.
		/*
			原理：t1线程和t2线程.
			t1线程执行到此处，遇到了synchronized关键字，就会去找this的对象锁，
			如果找到this对象锁，则进入同步语句块中执行程序。当同步语句块中的代码
			执行结束之后，t1线程归还this的对象锁。

			在t1线程执行同步语句块的过程中，如果t2线程也过来执行以下代码，也遇到
			synchronized关键字，所以也去找this的对象锁，但是该对象锁被t1线程持有，
			只能在这等待this对象的归还。

			必须使用多线程共享对象才可以
			当线程遇到synchronized关键字，线程在进入锁池找共享对象的对象锁时，会释放之前占用的CPU时间片，未找到时在锁池中等待，
			找到了会进入就绪状态继续抢夺时间片

		*/

        //同步代码块越小，效率越高

        synchronized(this){
            //This为对象锁---->锁上实现线程同步
            //使用局部变量是不可以的，
            /*
                局部变量：栈中----->不会存在线程安全问题
                实例变量：堆中
                静态变量：在方法区
             */
            double after = balance - money;

            //延迟
            try{Thread.sleep(1000);}catch(Exception e){}


            //更新
            this.setBalance(after);
        }

        /*
            synchronized可以在实例方法上的使用，固定锁为this，不会是其他对象，所以不灵活
            作用在实例方法上，两个方法体都要同步，可能会无故扩大作用范围
            如果使用局部变量-建议使用StreamBuilder
            ArrayList是线程安全的
            Vector是线程安全的
            HashMap、Hashset是非线程安全的
            Hashtable是线程安全的
         */

        /*
        synchronized三种方法
            synchronized（共享对象）{
            共享代码块
            }
            实例方法中
            静态方法中
         */
    }
}