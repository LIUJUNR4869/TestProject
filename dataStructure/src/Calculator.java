public class Calculator {
    public static void main(String[] args) {
//完成表达式运算
        String expression = "33+2*6-2";
        //创建两个栈，数栈，符号栈
       ArrayStack2 numStack = new ArrayStack2(10);
       ArrayStack2 operStack = new ArrayStack2(10);

       //定义相关变量
        int index = 0;//用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        while (true){
            //依次得到expression 的每一个字符
            ch = expression.substring(index,index+1).charAt(0);//取出字符串
        }


    }
}
class ArrayStack2 {


    private int maxStack;

    private int[] stack;

    /**
     * 表示栈顶所在的位置，默认情况下如果没有数据时，使用-1
     */
    private int top = -1;

    /**
     * 构造器--构造栈的栈的大小
     */
    public ArrayStack2(int maxStack){
        this.maxStack = maxStack;
        stack = new int[maxStack];
    }


    public boolean isFull(){
        return this.top == this.maxStack-1;
    }

    /**
     * 判断栈是否是空栈
     */
    public boolean isEmpty(){
        return this.top == -1;
    }


    /**
     * 压栈
     */
    public void push(int value){
        //是否已经栈满
        if (isFull()){
            System.out.println("此栈已满");return;
        }
        top += 1;
        stack[top] = value;

    }

    public int pop(){
        //如果栈中是空
        if (isEmpty()){
            throw new RuntimeException("空栈，未找到数据");
        }

        int value = stack[top];
        top--;
        return value;

    }


    /**
     * 查看栈中所有元素,遍历栈，需要从栈顶开始显示数据
     */
    public void list(){

        //是否是空栈
        if (isEmpty()){
            System.out.println("空栈，未找到数据");
            return;
        }
        //将i视为栈顶,从栈顶开始遍历
        for (int i=top;i>=0;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }

    }

    /**
     * 栈中元素存在的个数
     * @return
     */
    public int length(){
        return this.top+1;
    }


    /**
     * 判断是否是一个运算符  + - * /
     */
    public boolean isOper(char val){
        return val=='+'||val=='-'||val=='*'||val=='/';
    }

    /**
     * 判断运算符优先级  使用数字表示优先级大小，数字越大的优先级越大
     */

    public int priority(int oper){
        if (oper=='*'||oper=='/'){
            return 1;
        }else if (oper=='+'||oper=='-'){
            return 0;
        }else {
            return -1;
        }
    }

    /**
     * 获取栈顶数据
     */
    public int peek(){
        return this.stack[top];
    }

    /**
     * 获取栈的容量
     */
    public int stackLength(){
        return this.stack.length;
    }

    /**
     * 计算两个数进行运算后的结果
     * 2-3
     * 3:num1,2:num2
     */
    public int calculate(int num1,int num2,int oper){
        //计算结果
        int result = 0;//存放结果
        switch (oper){
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num2-num1;
                break;
            case '*':
                result = num1*num2;
                break;
            case '/':
                result = num2/num1;
                break;

            default:
                break;

        }
        return result;
    }


}