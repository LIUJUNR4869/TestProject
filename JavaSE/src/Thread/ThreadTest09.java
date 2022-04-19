package Thread;

/*
	如何正确的更好的终止一个正在执行的线程.
	需求：线程启动5S之后终止。

	常见的线程调度模型：
	    抢占式调度模型
	        优先级高的线程，抢占CPU的时间片概率高---java
	     均分式调度模型
	        平均分配CPU时间片，每个线程占用的CPU时间片时间长度一样
	        平均分配一切平等

	 java中与线程调度有关的方法
	 实例方法：
	        void setPriority(int newPriority) 设置线程优先级
	        int getPriority() 获取线程优先级
	        最低优先级
	        默认优先级是5
	        最高优先级是10
	  静态方法
	        让位方法-----暂停现在线程，并执行其他线程

*/
public class ThreadTest09
{
    public static void main(String[] args) throws Exception{

        Processor3 p = new Processor3();
        Thread t = new Thread(p);

        t.setName("t");

        t.start();

        //5S之后终止.
        Thread.sleep(5000);

        //终止---->将标记修改为false
        p.run = false;

    }
}

class Processor3 implements Runnable
{
    //打一个boolean标记
    boolean run = true;

    public void run(){

        for(int i=0;i<10;i++){

            if(run){
                try{Thread.sleep(1000);}catch(Exception e){}
                System.out.println(Thread.currentThread().getName()+"-->" + i);
            }else{
                return;
            }
        }
    }
}
