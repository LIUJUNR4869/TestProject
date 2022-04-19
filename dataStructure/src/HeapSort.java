import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author YLPJFR
 * @date 2022年04月12日 14:49
 */
public class HeapSort {
    public static void main(String[] args) {
        //     int[] arr = {4, 6, 8, 5, 9};
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }


        System.out.println("堆排序前");
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr1 = simpleDateFormat.format(date1);
        System.out.println(dateStr1);

        heapSort(arr);

        System.out.println("堆排序后");
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateStr2 = simpleDateFormat1.format(date2);
        System.out.println(dateStr2);

    }

    public static void heapSort(int arr[]) {
        System.out.println("堆排序！！");
        int temp = 0;
        //分布完成

        //分步完成
//        adjustHeap(arr, 1, arr.length);
//        System.out.println("第1次" + Arrays.toString(arr)); // 4, 9, 8, 5, 6
//
//        adjustHeap(arr, 0, arr.length);
//        System.out.println("第2次" + Arrays.toString(arr)); // 9,6,8,5,4

        //完成最终代码
        //将无序序列构建成一个堆，然后根据升降序需求选择大顶堆/小顶堆

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
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
    }


    /**
     * 功能：完善将以 I 对应的叶子节点的树调整成大顶堆
     * 举例：
     * int arr[] = {4, 6, 8, 5, 9}; => i = 1 => adjustHeap => 得到 {4, 9, 8, 5, 6}
     * 如果我们再次调用  adjustHeap 传入的是 i = 0 => 得到 {4, 9, 8, 5, 6} => {9,6,8,5, 4}
     *
     * @param arr    可调整数组
     * @param i      非叶子节点的索引
     * @param length 表示对于多少元素进行调整
     * @author YPLFJR
     * @date 2022/4/12 14:50
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];//保存当前元素的值
        //开始调整
        //1. k = i * 2 + 1 k 是 i结点的左子结点
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
        //for循环结束后 将i为父节点的最大值放在了局部的顶部--初始时 i 对应的位置
        arr[i] = temp;
        //将tmp的值放到了调整后的位置

    }

}
