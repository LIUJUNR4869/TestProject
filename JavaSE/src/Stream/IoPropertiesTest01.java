package Stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
    Io + Properties的联合应用
    经常改变的数据放在一个联合文件中，使用程序动态读取，对于文件内容进行再次改动不需改动Java代码，不需重新编译，服务器不需要重启，就可以拿到动态的数据

    java的属性配置文件中建议以properties结尾，
 */
public class IoPropertiesTest01 {
    public static void main(String[] args) throws IOException {
/*
properties 是一个Map集合，key 和 value都是String类型
想将useringfo文件中的数据加载到Properties对象中
 */
        //新建一个输入流对象
        FileReader reader = new FileReader("Stream/userfo");

        //新建一个Map集合
        Properties pro = new Properties();

        //调用properties对象的Loud方法将文件中的数据加载到Map集合中
        pro.load(reader);//文件中的数据顺着管道加载到Map集合中，其中等号=左边做Key右边做Value

        String username = pro.getProperty("username");
        System.out.println(username);
    }
}

