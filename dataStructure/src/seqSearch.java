/**
 * @author YLPJFR
 * @date 2022��04��10�� 13:44
 */
public class seqSearch {
    public static void main(String[] args) {
        int[] arr = {1,9,11,-1,4,59};
        int index =seqSearch(arr,11);
        if (index == -1){
            System.out.println("�����ڴ�����");
        }else
            System.out.println("�������ҵ������±�Ϊ" + index);
    }
/** 
 *
 * @author YPLFJR
 * @date 2022/4/10 13:54
 * @param arr
 * @param value 
 * @return int
 */
    public static int seqSearch(int[] arr, int value) {
        // ���Բ�������һ�ȶԣ���������ֵͬ���ͷ����±�
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
