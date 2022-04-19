package Thread;
/*
	某线程正在休眠，如果打断它的休眠.

	以下方式依靠的是java异常处理机制。
*/
public class ThreadTest07 {
    public static void main(String[] args) throws Exception{

        //需求：启动线程，5S之后打断线程的休眠.
        Thread t = new Thread(new Processor2());

        //起名
        t.setName("t");

        //启动
        t.start();

        //5S之后
        Thread.sleep(5000);

        //打断t的休眠.--->执行，抛出异常，被Processor中的catch捕捉
        t.interrupt();

    }
}

//run（）方法中只能使用try catch 而不能throws ----->run()方法中没有抛出任何异常，子类不能比父类抛出更多异常
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
