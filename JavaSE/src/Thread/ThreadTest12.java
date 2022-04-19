package Thread;
/*
	线程的合并
*/
public class ThreadTest12 {
    public static void main(String[] args) throws Exception{

        Thread t = new Thread(new Processor5());

        t.setName("t");

        t.start();

        //合并线程
        t.join(); //t和主线程合并. 单线程的程序.

        //主线程
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"-->"+i);
        }


    }
}


class Processor5 implements Runnable
{
    public void run(){

        for(int i=0;i<5;i++){

            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){}

            System.out.println(Thread.currentThread().getName()+"-->"+i);
        }

    }
}