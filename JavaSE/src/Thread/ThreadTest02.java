package Thread;
/*
主线程分线程交替进行，是有的线程桥到了执行权
可以使用匿名内部类  Thread t = new Thread(new MyRunnabnle(){public void run(){}});


 */
public class ThreadTest02 {
    public static void main(String[] args) {
        Mythread mythread = new Mythread();
        //启动线程
        //start（）方法的作用是启动一个分支线程，在jvm中开辟一个栈空间，这段代码任务完成后瞬间就结束了
        //要新的栈空间开辟出来，代码就执行结束了，启动成功的线程会自动调用run方法，并在新代码底部压栈
        //run方法在分线程中的底部
        mythread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程---->" + i );
            System.out.println("---------------------");
        }
    }
    static class  Mythread extends Thread{

        public void  run(){

            for(int i = 0 ; i < 1000;i++){
                System.out.println("分支线程---->" + i);
                System.out.println("*******************");
            }

        }
    }
}
