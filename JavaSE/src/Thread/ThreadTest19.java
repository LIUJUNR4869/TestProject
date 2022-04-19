package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;//java并发包

public class ThreadTest19 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {//call()方法相当于run（）方法，但是有返回值
                //线程执行后可能会有一个返回值
                //模拟执行
                System.out.println("call method begin");
                Thread.sleep(1000*10);
                System.out.println("call method end");
                int a = 100;
                int b = 200;

                return a+b;

            }
        });
        //创建线程对象
        Thread t = new Thread(task);
        t.start();

        //在主线程获取t线程的返回值
        //get（）方法的执行会导致当前线程阻塞
        //当前线程只在等待线程结果时效率较低
        Object obj = task.get();
        System.out.println(obj);
        //main方法这里要执行，需要等待t线程的a+b 执行结果
        System.out.println("over");

    }
}
