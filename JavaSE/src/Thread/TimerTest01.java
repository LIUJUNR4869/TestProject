package Thread;

/*
	���ڶ�ʱ����Ӧ��.
	���ã�ÿ��һ�ι̶���ʱ��ִ��һ�δ���.
*/
import java.text.*;
import java.util.*;

public class TimerTest01
{
    public static void main(String[] args) throws Exception{

        //1.������ʱ��
        Timer t = new Timer();

        //2.ָ����ʱ����
//        t.schedule(
//                new LogTimerTask(),//��ʱ���񡢵�һ��ִ��ʱ�䡢������ִ��һ��
//                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").parse("2012-08-03 17:37:00 000"),
//                1000*10);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date firstTime = sdf.parse("2022-02-28 14:04:30");
                t.schedule(new LogTimerTask(),firstTime,1000*10);
    }
}

//��д��ʱ������----ָ������
class LogTimerTask extends TimerTask//������
{
    public void run(){
       // System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strTime = sdf.format(new Date());
        System.out.println(strTime + "finish");
    }
}
