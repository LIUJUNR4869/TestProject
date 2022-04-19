package Stream;


/*
		java.io.FileInputStream
		字节的方式完成输入/读的操作
		按照字节方式读取文件.
*/
import java.io.*;
public class FileInputStreamTest01
{
    public static void main(String[] args){

        //创建文件输入流对象
        //idea会自动将“\”变成“\\”，或者使用“/”



        FileInputStream fis = null;

        try{
            //1.要读取某文件，先与这个文件创建一个“输入流”
            //文件路径
            //String filePath = "temp01"; //相对路径，相对当前而言，在当前路径下找。
            //String filePath = "D:\\course\\JavaProjects\\02-JavaSE\\chapter08\\temp01";
            String filePath = "D:/course/JavaProjects/02-JavaSE/chapter08/temp01";
            fis = new FileInputStream(filePath);

            //2.开始读
            int i1 = fis.read(); //以字节的方式读取.
            int i2 = fis.read();
            int i3 = fis.read();
            int i4 = fis.read();
            int i5 = fis.read();
            int i6 = fis.read();

            int i7 = fis.read();

            System.out.println(i1); //97
            System.out.println(i2); //98
            System.out.println(i3); //99
            System.out.println(i4); //100
            System.out.println(i5); //101
            System.out.println(i6); //102
            System.out.println(i7); //-1  //如果已经读取到文件的末尾，就会返回-1

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{

            //为了保证流一定会释放，所以在finally语句块中执行
            if(fis!=null){
                try{
                    fis.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}