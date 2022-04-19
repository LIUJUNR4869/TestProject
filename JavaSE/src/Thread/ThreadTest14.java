package Thread;
/*
	���³���ʹ���߳�ͬ�����Ʊ�֤���ݵİ�ȫ��
*/
public class ThreadTest14
{
    public static void main(String[] args){

        //����һ���������˻�
        Account1 act = new Account1("actno-001",5000.0);

        //�����̶߳�ͬһ���˻�ȡ��
        Thread t1 = new Thread(new Processor7(act));
        Thread t2 = new Thread(new Processor7(act));

        t1.start();

        t2.start();
    }
}

//ȡ���߳�
class Processor7 implements Runnable
{
    //�˻�
    Account1 act;

    //Constructor
    Processor7(Account1 act){
        this.act = act;
    }

    public void run(){
        act.withdraw(1000.0);
        System.out.println("ȡ��1000.0�ɹ�����" + act.getBalance());
    }
}

//�˻�
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

    //�����ṩһ��ȡ��ķ���
    public void withdraw(double money){ //�Ե�ǰ�˻�����ȡ�����

        //����Ҫͬ���Ĵ��룬�ŵ�ͬ��������.
		/*
			ԭ��t1�̺߳�t2�߳�.
			t1�߳�ִ�е��˴���������synchronized�ؼ��֣��ͻ�ȥ��this�Ķ�������
			����ҵ�this�������������ͬ��������ִ�г��򡣵�ͬ�������еĴ���
			ִ�н���֮��t1�̹߳黹this�Ķ�������

			��t1�߳�ִ��ͬ������Ĺ����У����t2�߳�Ҳ����ִ�����´��룬Ҳ����
			synchronized�ؼ��֣�����Ҳȥ��this�Ķ����������Ǹö�������t1�̳߳��У�
			ֻ������ȴ�this����Ĺ黹��

			����ʹ�ö��̹߳������ſ���
			���߳�����synchronized�ؼ��֣��߳��ڽ��������ҹ������Ķ�����ʱ�����ͷ�֮ǰռ�õ�CPUʱ��Ƭ��δ�ҵ�ʱ�������еȴ���
			�ҵ��˻�������״̬��������ʱ��Ƭ

		*/

        //ͬ�������ԽС��Ч��Խ��

        synchronized(this){
            //ThisΪ������---->����ʵ���߳�ͬ��
            //ʹ�þֲ������ǲ����Եģ�
            /*
                �ֲ�������ջ��----->��������̰߳�ȫ����
                ʵ������������
                ��̬�������ڷ�����
             */
            double after = balance - money;

            //�ӳ�
            try{Thread.sleep(1000);}catch(Exception e){}


            //����
            this.setBalance(after);
        }

        /*
            synchronized������ʵ�������ϵ�ʹ�ã��̶���Ϊthis�������������������Բ����
            ������ʵ�������ϣ����������嶼Ҫͬ�������ܻ��޹��������÷�Χ
            ���ʹ�þֲ�����-����ʹ��StreamBuilder
            ArrayList���̰߳�ȫ��
            Vector���̰߳�ȫ��
            HashMap��Hashset�Ƿ��̰߳�ȫ��
            Hashtable���̰߳�ȫ��
         */

        /*
        synchronized���ַ���
            synchronized���������{
            ��������
            }
            ʵ��������
            ��̬������
         */
    }
}