package Stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
    Io + Properties������Ӧ��
    �����ı�����ݷ���һ�������ļ��У�ʹ�ó���̬��ȡ�������ļ����ݽ����ٴθĶ�����Ķ�Java���룬�������±��룬����������Ҫ�������Ϳ����õ���̬������

    java�����������ļ��н�����properties��β��
 */
public class IoPropertiesTest01 {
    public static void main(String[] args) throws IOException {
/*
properties ��һ��Map���ϣ�key �� value����String����
�뽫useringfo�ļ��е����ݼ��ص�Properties������
 */
        //�½�һ������������
        FileReader reader = new FileReader("Stream/userfo");

        //�½�һ��Map����
        Properties pro = new Properties();

        //����properties�����Loud�������ļ��е����ݼ��ص�Map������
        pro.load(reader);//�ļ��е�����˳�Źܵ����ص�Map�����У����еȺ�=�����Key�ұ���Value

        String username = pro.getProperty("username");
        System.out.println(username);
    }
}

