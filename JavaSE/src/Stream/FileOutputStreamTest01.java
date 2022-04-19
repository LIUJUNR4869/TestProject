package Stream;

/*
	java.io.OutputStream;
		java.io.FileOutputStream; 文件字节输出流

		将计算机内存中的数据写入硬盘文件中.
*/
import java.io.*;

public class FileOutputStreamTest01
{
    public static void main(String[] args){

        FileOutputStream fos = null;

        try{

            //1.创建文件字节输出流
            //谨慎使用，会将源文件内容覆盖.
            //fos = new FileOutputStream("temp02"); //该文件不存在则自动创建.

            //以追加的方式写入
            fos = new FileOutputStream("temp02",true);

            //2.开始写
            String msg = "HelloWorld!";

            //将String转换成byte数组.
            byte[] bytes = msg.getBytes();

            //将byte数组中所有的数据全部写入
            //fos.write(bytes);

            //将byte数组的一部分写入
            fos.write(bytes,0,3);

            //推荐最后的时候为了保证数据完全写入硬盘，所以要刷新.
            fos.flush(); //强制写入.

        }catch(Exception e){
            e.printStackTrace();
        }finally{

            //关闭
            if(fos!=null){
                try{
                    fos.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}