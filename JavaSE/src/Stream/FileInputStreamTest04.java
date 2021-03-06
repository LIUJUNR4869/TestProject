package Stream;

import java.io.*;

//循环读取

public class FileInputStreamTest04
{
    public static void main(String[] args) throws Exception{

        FileInputStream fis = new FileInputStream("FileInputStreamTest01.java");

        //循环读取
        byte[] bytes = new byte[1024]; //每次读取1KB

		/*
		while(true){

			int temp = fis.read(bytes);
			if(temp==-1) break;

			//将byte数组中有效的数据转换成字符串.
			System.out.print(new String(bytes,0,temp));
		}
		*/

        //升级循环
        int temp = 0;
        while((temp=fis.read(bytes)) != -1){
            System.out.print(new String(bytes,0,temp));
        }

        fis.close();
    }
}