package Thread;

/*
	�����ȷ�ĸ��õ���ֹһ������ִ�е��߳�.
	�����߳�����5S֮����ֹ��

	�������̵߳���ģ�ͣ�
	    ��ռʽ����ģ��
	        ���ȼ��ߵ��̣߳���ռCPU��ʱ��Ƭ���ʸ�---java
	     ����ʽ����ģ��
	        ƽ������CPUʱ��Ƭ��ÿ���߳�ռ�õ�CPUʱ��Ƭʱ�䳤��һ��
	        ƽ������һ��ƽ��

	 java�����̵߳����йصķ���
	 ʵ��������
	        void setPriority(int newPriority) �����߳����ȼ�
	        int getPriority() ��ȡ�߳����ȼ�
	        ������ȼ�
	        Ĭ�����ȼ���5
	        ������ȼ���10
	  ��̬����
	        ��λ����-----��ͣ�����̣߳���ִ�������߳�

*/
public class ThreadTest09
{
    public static void main(String[] args) throws Exception{

        Processor3 p = new Processor3();
        Thread t = new Thread(p);

        t.setName("t");

        t.start();

        //5S֮����ֹ.
        Thread.sleep(5000);

        //��ֹ---->������޸�Ϊfalse
        p.run = false;

    }
}

class Processor3 implements Runnable
{
    //��һ��boolean���
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
