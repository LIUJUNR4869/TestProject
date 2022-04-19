package Stream;
import java.io.*;

/*
	int read(byte[] bytes);
	读取之前在内存中准备一个byte数组，每次读取多个字节存储到byte数组中。
	一次读取多个字节，不是单字节读取了。

	效率高。
*/

public class FileInputStreamTest03
{
    public static void main(String[] args) throws Exception{

        //1.创建输入流
        FileInputStream fis = new FileInputStream("temp01");

        //2.开始读
        //准备一个byte数组
        byte[] bytes = new byte[3]; //每一次最多读取3个字节

        //int read(byte[] bytes); 该方法返回的int类型的值代表的是，这次读取了多少个字节。
        int i1 = fis.read(bytes); //3

        //将byte数组转换成字符串
        System.out.println(new String(bytes)); //abc

        int i2 = fis.read(bytes); //3

        System.out.println(new String(bytes)); //def

        int i3 = fis.read(bytes); //1

        //System.out.println(new String(bytes)); //gef
        System.out.println(new String(bytes,0,i3)); //g

        int i4 = fis.read(bytes); //-1  已经到达文件的末尾，返回-1

        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);


        //关闭
        fis.close();

    }
}