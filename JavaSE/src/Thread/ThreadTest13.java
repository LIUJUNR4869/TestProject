package Thread;
/*
    * ******  *
    * 线程安全 *
    * ******  *
    开发中，项目运行在服务器中，服务器已经完成线程的定义、线程对象的创建、启动等
    我们编写的程序需要在多线程环境下运行，需要更多关注数据在多线程环境下是否安全

    多线程兵并发 + 有共享数据 + 数据存在修改行为----->可能存在线程安全问题
    线程同步机制----为了数据的安全。尽管应用程序的使用率降低（牺牲效率），但是为了保证数据是安全的，必须加入线程同步机制。
	线程同步机制使程序变成了（等同）单线程。

    异步编程模型：t1线程执行t1的，t2线程执行t2的，两个线程之间谁也不等谁。
	同步编程模型：t1线程和t2线程执行，当t1线程必须等t2线程执行结束之后,t1线程才能执行，这是同步编程模型。

    * 模拟账户类
 */
public class ThreadTest13
{
    public static void main(String[] args){

        //创建一个公共的账户
        Account act = new Account("actno-001",5000.0);

        //创建线程对同一个账户取款
        Thread t1 = new Thread(new Processor6(act));
        Thread t2 = new Thread(new Processor6(act));

        t1.start();

        t2.start();
    }
}

//取款线程
class Processor6 implements Runnable
{
    //账户
    Account act;

    //Constructor
    Processor6(Account act){
        this.act = act;
    }

    public void run(){
        act.withdraw(1000.0);
        System.out.println("取款1000.0成功，余额：" + act.getBalance());
    }
}

//账户
class Account
{
    private String actno;
    private double balance;

    public Account(){}
    public Account(String actno,double balance){
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

        double after = balance - money;

        //延迟
        try{Thread.sleep(1000);}catch(Exception e){}


        //更新
        this.setBalance(after);
    }
}
