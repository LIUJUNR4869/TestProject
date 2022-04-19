package Thread;

/*
	关于定时器的应用.
	作用：每隔一段固定的时间执行一段代码.
*/
import java.text.*;
import java.util.*;

public class TimerTest01
{
    public static void main(String[] args) throws Exception{

        //1.创建定时器
        Timer t = new Timer();

        //2.指定定时任务
//        t.schedule(
//                new LogTimerTask(),//定时任务、第一次执行时间、间隔多久执行一次
//                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").parse("2012-08-03 17:37:00 000"),
//                1000*10);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date firstTime = sdf.parse("2022-02-28 14:04:30");
                t.schedule(new LogTimerTask(),firstTime,1000*10);
    }
}

//编写定时任务类----指定任务
class LogTimerTask extends TimerTask//抽象类
{
    public void run(){
       // System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strTime = sdf.format(new Date());
        System.out.println(strTime + "finish");
    }
}
