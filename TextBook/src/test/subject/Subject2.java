package test.subject;
public class Subject2 {
    public static void main(String[] args) {
        getPrimeNumber(101,200);

    }

    /**
     * �ж�a��b֮���ж��ٸ�����
     * @param a
     * @param b
     */
    public static void getPrimeNumber(int a,int b){
        int sum = 0;
        if(a >= b){
            System.out.println("a���ܴ��ڵ���b��");
        }
        System.out.print("������");
        for(int i=a;i<=b;i++){
            if(isPrimeNumber(i)){
                sum += 1;
                System.out.print(i+" ");
            }
        }
        System.out.println();
        System.out.println("��������������"+sum);
    }

    /**
     * �ж�num�Ƿ���һ������
     * @param i
     * @return
     */
    private static boolean isPrimeNumber(int i) {
        boolean flag = true;
        for(int j=2;j <= i/2;j++){
            if(i%j == 0){
                flag = false;
                break;
            }
        }
        return flag;
    }
}