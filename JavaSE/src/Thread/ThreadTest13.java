package Thread;
/*
    * ******  *
    * �̰߳�ȫ *
    * ******  *
    �����У���Ŀ�����ڷ������У��������Ѿ�����̵߳Ķ��塢�̶߳���Ĵ�����������
    ���Ǳ�д�ĳ�����Ҫ�ڶ��̻߳��������У���Ҫ�����ע�����ڶ��̻߳������Ƿ�ȫ

    ���̱߳����� + �й������� + ���ݴ����޸���Ϊ----->���ܴ����̰߳�ȫ����
    �߳�ͬ������----Ϊ�����ݵİ�ȫ������Ӧ�ó����ʹ���ʽ��ͣ�����Ч�ʣ�������Ϊ�˱�֤�����ǰ�ȫ�ģ���������߳�ͬ�����ơ�
	�߳�ͬ������ʹ�������ˣ���ͬ�����̡߳�

    �첽���ģ�ͣ�t1�߳�ִ��t1�ģ�t2�߳�ִ��t2�ģ������߳�֮��˭Ҳ����˭��
	ͬ�����ģ�ͣ�t1�̺߳�t2�߳�ִ�У���t1�̱߳����t2�߳�ִ�н���֮��,t1�̲߳���ִ�У�����ͬ�����ģ�͡�

    * ģ���˻���
 */
public class ThreadTest13
{
    public static void main(String[] args){

        //����һ���������˻�
        Account act = new Account("actno-001",5000.0);

        //�����̶߳�ͬһ���˻�ȡ��
        Thread t1 = new Thread(new Processor6(act));
        Thread t2 = new Thread(new Processor6(act));

        t1.start();

        t2.start();
    }
}

//ȡ���߳�
class Processor6 implements Runnable
{
    //�˻�
    Account act;

    //Constructor
    Processor6(Account act){
        this.act = act;
    }

    public void run(){
        act.withdraw(1000.0);
        System.out.println("ȡ��1000.0�ɹ�����" + act.getBalance());
    }
}

//�˻�
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

    //�����ṩһ��ȡ��ķ���
    public void withdraw(double money){ //�Ե�ǰ�˻�����ȡ�����

        double after = balance - money;

        //�ӳ�
        try{Thread.sleep(1000);}catch(Exception e){}


        //����
        this.setBalance(after);
    }
}
