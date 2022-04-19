package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;//java������

public class ThreadTest19 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {//call()�����൱��run���������������з���ֵ
                //�߳�ִ�к���ܻ���һ������ֵ
                //ģ��ִ��
                System.out.println("call method begin");
                Thread.sleep(1000*10);
                System.out.println("call method end");
                int a = 100;
                int b = 200;

                return a+b;

            }
        });
        //�����̶߳���
        Thread t = new Thread(task);
        t.start();

        //�����̻߳�ȡt�̵߳ķ���ֵ
        //get����������ִ�лᵼ�µ�ǰ�߳�����
        //��ǰ�߳�ֻ�ڵȴ��߳̽��ʱЧ�ʽϵ�
        Object obj = task.get();
        System.out.println(obj);
        //main��������Ҫִ�У���Ҫ�ȴ�t�̵߳�a+b ִ�н��
        System.out.println("over");

    }
}
