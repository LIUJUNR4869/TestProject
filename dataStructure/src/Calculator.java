public class Calculator {
    public static void main(String[] args) {
//��ɱ��ʽ����
        String expression = "33+2*6-2";
        //��������ջ����ջ������ջ
       ArrayStack2 numStack = new ArrayStack2(10);
       ArrayStack2 operStack = new ArrayStack2(10);

       //������ر���
        int index = 0;//����ɨ��
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        while (true){
            //���εõ�expression ��ÿһ���ַ�
            ch = expression.substring(index,index+1).charAt(0);//ȡ���ַ���
        }


    }
}
class ArrayStack2 {


    private int maxStack;

    private int[] stack;

    /**
     * ��ʾջ�����ڵ�λ�ã�Ĭ����������û������ʱ��ʹ��-1
     */
    private int top = -1;

    /**
     * ������--����ջ��ջ�Ĵ�С
     */
    public ArrayStack2(int maxStack){
        this.maxStack = maxStack;
        stack = new int[maxStack];
    }


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
     */
    public boolean isOper(char val){
        return val=='+'||val=='-'||val=='*'||val=='/';
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
        int result = 0;//��Ž��
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