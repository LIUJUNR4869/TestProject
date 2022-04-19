
import java.util.Arrays;

public class TestApp {

    public static void main(String[] args) {

        /**
         * 回文数据
         * 回文：   aba   racecar
         * 需求：通过上面以数组模拟栈来判断一个字符串是否是一个回文数据
         */
        System.out.println( detecation("hello"));
    }


    public static boolean detecation(String val){
        /**
         * 初始化栈对象
         */
        ArrayStack arrayStack = new ArrayStack(10);

        /**
         * 获取字符串长度
         */
        int length = val.length();

        //把字符串数据逐次获取字符压栈至数组中
        for(int i=0;i<length;i++){
            arrayStack.push(val.charAt(i));

        }

        /**
         * 获取
         */
        String newVal = "";
        int length1 = arrayStack.length();
        for (int i=0;i<length1;i++){
            //是否是一个空栈
            if (!arrayStack.isEmpty()){
                char pop = (char)arrayStack.pop();
                newVal=newVal+pop;
            }
        }

        if (val.equals(newVal)){
            return true;
        }

        return false;

    }

}