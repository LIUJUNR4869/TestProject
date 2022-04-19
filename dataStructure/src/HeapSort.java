import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author YLPJFR
 * @date 2022��04��12�� 14:49
 */
public class HeapSort {
    public static void main(String[] args) {
        //     int[] arr = {4, 6, 8, 5, 9};
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 8000000) ��
        }


        System.out.println("������ǰ");
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr1 = simpleDateFormat.format(date1);
        System.out.println(dateStr1);

        heapSort(arr);

        System.out.println("�������");
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateStr2 = simpleDateFormat1.format(date2);
        System.out.println(dateStr2);

    }

    public static void heapSort(int arr[]) {
        System.out.println("�����򣡣�");
        int temp = 0;
        //�ֲ����

        //�ֲ����
//        adjustHeap(arr, 1, arr.length);
//        System.out.println("��1��" + Arrays.toString(arr)); // 4, 9, 8, 5, 6
//
//        adjustHeap(arr, 0, arr.length);
//        System.out.println("��2��" + Arrays.toString(arr)); // 9,6,8,5,4

        //������մ���
        //���������й�����һ���ѣ�Ȼ���������������ѡ��󶥶�/С����

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        /*
         *
         * @author YPLFJR
         * @date 2022/4/12 21:07
         * @param arr
         */
        for (int j = arr.length - 1; j > 0; j--) {
            //����
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
    }


    /**
     * ���ܣ����ƽ��� I ��Ӧ��Ҷ�ӽڵ���������ɴ󶥶�
     * ������
     * int arr[] = {4, 6, 8, 5, 9}; => i = 1 => adjustHeap => �õ� {4, 9, 8, 5, 6}
     * ��������ٴε���  adjustHeap ������� i = 0 => �õ� {4, 9, 8, 5, 6} => {9,6,8,5, 4}
     *
     * @param arr    �ɵ�������
     * @param i      ��Ҷ�ӽڵ������
     * @param length ��ʾ���ڶ���Ԫ�ؽ��е���
     * @author YPLFJR
     * @date 2022/4/12 14:50
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];//���浱ǰԪ�ص�ֵ
        //��ʼ����
        //1. k = i * 2 + 1 k �� i�������ӽ��
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        //forѭ�������� ��iΪ���ڵ�����ֵ�����˾ֲ��Ķ���--��ʼʱ i ��Ӧ��λ��
        arr[i] = temp;
        //��tmp��ֵ�ŵ��˵������λ��

    }

}
