/**
 * @author YLPJFR
 * @date 2022年04月10日 13:44
 */
public class seqSearch {
    public static void main(String[] args) {
        int[] arr = {1,9,11,-1,4,59};
        int index =seqSearch(arr,11);
        if (index == -1){
            System.out.println("不存在此数字");
        }else
            System.out.println("您所查找的数字下标为" + index);
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
        // 线性查找是逐一比对，发现有相同值，就返回下标
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
