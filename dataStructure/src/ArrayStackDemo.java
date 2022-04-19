import java.util.Scanner;

/*


 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;//�����Ƿ��˳��˵�
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("show:��ʾ��ʾջ");
            System.out.println("exit���˳�����");
            System.out.println("push����ʾ������ݵ�ջ��ѹջ��");
            System.out.println("pop����ʾ��ջ��ȡ�����ݣ���ջ��");
            System.out.println("���������ѡ��");
            key = scanner.next();
            switch (key){
                case "show":
                    stack.list();;
                    break;
                case "push":
                    System.out.println("������һ����");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("��ջ�����������%d\n",res);
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
        //�����˳�
    }
}
/**
 * author:������
 * version:1.0
 */
 class ArrayStack {

    /**
     * ջ�Ĵ�С
     */
    private int maxStack;

    /**
     * ��������ģ��ջ
     */
    private int[] stack;

    /**
     * ��ʾջ�����ڵ�λ�ã�Ĭ����������û������ʱ��ʹ��-1
     */
    private int top = -1;

    /**
     * ������--����ջ��ջ�Ĵ�С
     * @param maxStack
     */
    public ArrayStack(int maxStack){
        this.maxStack = maxStack;
        stack = new int[maxStack];
    }


    /**
     * 1.ѹջ
     * 2.��ջ
     * 3.�ж��Ƿ��ǿ�ջ
     * 4.��ǰջ���Ƿ�����ջ
     */

    /**
     * �ж��Ƿ��Ѿ���ջ
     */
    public boolean isFull(){
        return this.top == this.maxStack-1;
    }

    /**
     * �ж�ջ�Ƿ��ǿ�ջ
     */
    public boolean isEmpty(){
        return this.top == -1;
    }


    /**
     * ѹջ
     */
    public void push(int value){
        //�Ƿ��Ѿ�ջ��
        if (isFull()){
            System.out.println("��ջ����");return;
        }
        top += 1;
        stack[top] = value;

    }

    /*
     * ��ջ����ջ�������ݷ���
     */
    public int pop(){
        //���ջ���ǿ�
        if (isEmpty()){
            throw new RuntimeException("��ջ��δ�ҵ�����");
        }

        int value = stack[top];
        top--;
        return value;

    }


    /**
     * �鿴ջ������Ԫ��,����ջ����Ҫ��ջ����ʼ��ʾ����
     */
    public void list(){

        //�Ƿ��ǿ�ջ
        if (isEmpty()){
            System.out.println("��ջ��δ�ҵ�����");
            return;
        }
        //��i��Ϊջ��,��ջ����ʼ����
        for (int i=top;i>=0;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }

    }

    /**
     * ջ��Ԫ�ش��ڵĸ���
     * @return
     */
    public int length(){
        return this.top+1;
    }


    /**
     * �ж��Ƿ���һ�������  + - * /
     *
     */
    public boolean isOper(char v){
        return v=='+'||v=='-'||v=='*'||v=='/';
    }

    /**
     * �ж���������ȼ�  ʹ�����ֱ�ʾ���ȼ���С������Խ������ȼ�Խ��
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
     * ��ȡջ������
     * @return
     */
    public int peek(){
        return this.stack[top];
    }

    /**
     * ��ȡջ������
     */
    public int stackLength(){
        return this.stack.length;
    }

    /**
     * �������������������Ľ��
     * 2-3
     * 3:num1,2:num2
     */
    public int calculate(int num1,int num2,int oper){
        //������
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