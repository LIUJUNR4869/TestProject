import java.util.Scanner;

/*


 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;//控制是否退出菜单
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("show:表示显示栈");
            System.out.println("exit：退出程序");
            System.out.println("push：表示添加数据到栈（压栈）");
            System.out.println("pop：表示从栈中取出数据（出栈）");
            System.out.println("请输入你的选择：");
            key = scanner.next();
            switch (key){
                case "show":
                    stack.list();;
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈输出的数据是%d\n",res);
                    } catch (Exception e) {
//                        e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                default:
                    break;
            }
        }
        //程序退出
    }
}
/**
 * author:韩国庆
 * version:1.0
 */
 class ArrayStack {

    /**
     * 栈的大小
     */
    private int maxStack;

    /**
     * 数组用来模拟栈
     */
    private int[] stack;

    /**
     * 表示栈顶所在的位置，默认情况下如果没有数据时，使用-1
     */
    private int top = -1;

    /**
     * 构造器--构造栈的栈的大小
     * @param maxStack
     */
    public ArrayStack(int maxStack){
        this.maxStack = maxStack;
        stack = new int[maxStack];
    }


    /**
     * 1.压栈
     * 2.弹栈
     * 3.判断是否是空栈
     * 4.当前栈中是否是满栈
     */

    /**
     * 判断是否已经满栈
     */
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

    /*
     * 弹栈，将栈顶的数据返回
     */
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
     *
     */
    public boolean isOper(char v){
        return v=='+'||v=='-'||v=='*'||v=='/';
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
     * @return
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
        int result1 = 0;
        switch (oper){
            case '+':
                result1 = num1+num2;
                break;
            case '-':
                result1 = num2-num1;
                break;
            case '*':
                result1 = num1*num2;
                break;
            case '/':
                result1 = num2/num1;
                break;

            default:
                break;

        }
        return result1;
    }


}