
import java.awt.*;
import java.lang.annotation.ElementType;
public class TestStack {

    public static void main(String[] args) {

        String str = "4+3*2-1";
        /**
         * 1.需要遍历字符串，获取每一个字符
         * 2.判断当前字符是一个运算符还是一个数字
         * 3.把数字存放在数字栈中，把运算符放在运算符栈
         * 4.运算符栈：  如果是一个空栈，那么直接运算符入栈，如果运算符栈中已经了其他运算符
         * 就需要先对比运算符优先级，新进来的运算符如果小于等于原栈中运算符，那么需要把原运算符弹栈
         * ，数字栈中数字进行弹栈，进行运算，运算后的结果重新放入数字栈中，新运算符入栈。
         * 如果新运算符优先级大于原符号栈中运算符，那么新的符号直接入栈
         */
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack symbolStack = new ArrayStack(10);

        /**
         * 获取字符串长度
         */

        int temp1 = 0;
        int temp2 = 0;
        int symbolChar = 0;
        int result = 0;
        int length = str.length();

        String values = "";
        for (int i=0;i<length;i++){//33+44
            char c = str.charAt(i);
            /**
             * 是否是一个运算符
             */
            if (symbolStack.isOper(c)){
                /**
                 * 如果不是一个空符号栈
                 */
                if (!symbolStack.isEmpty()){

                    //比较运算符的优先级
                    if (symbolStack.priority(c)<=symbolStack.priority(symbolStack.peek())){

                        /**
                         * 1.去符号栈中获取栈顶的符号
                         * 2.去数字栈中获取两个数字
                         */
                        temp1 = numStack.pop();
                        temp2 = numStack.pop();
                        symbolChar = symbolStack.pop();
                        result = numStack.calculate(temp1,temp2,symbolChar);

                        //把运算结果再次放入数字栈中
                        numStack.push(result);

                        //把当前符号压入符号栈中
                        symbolStack.push(c);
                    }else {
                        symbolStack.push(c);
                    }

                }else {
                    //如果是空符号栈，讲运算符直接压栈
                    symbolStack.push(c);
                }
            }else {
                //比如   33+44
                values+=c;

                if (i==length-1){
                    numStack.push(Integer.parseInt(values));
                }else {
                    char data = str.substring(i+1,i+2).charAt(0);
                    if (symbolStack.isOper(data)){
                        numStack.push(Integer.parseInt(values));
                        values="";
                    }
                }


            }
        }


        while (true){
            if (symbolStack.isEmpty()){
                break;
            }

            temp1 = numStack.pop();
            temp2 = numStack.pop();

            symbolChar = symbolStack.pop();
            result = numStack.calculate(temp1,temp2,symbolChar);
            numStack.push(result);
        }

        int res =  numStack.pop();

        System.out.println("结果是: "+res);

    }

}
