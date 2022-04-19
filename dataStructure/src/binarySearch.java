import java.util.ArrayList;
import java.util.List;

/**
 * @author YLPJFR
 * @date 2022年04月10日 14:21
 */
public class binarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 9, 11, 11, 13};
        int index = binarySearch(arr, 3, 0, arr.length - 1);
        if (index == -1) {
            System.out.println("数字不存在");
        } else
            System.out.println(index);

        List<Integer> resIndexlist = binarySearch2(arr, 11, 0, arr.length - 1);
        System.out.println(resIndexlist);
    }

    /**
     * @param arr
     * @param findVal
     * @param left
     * @param right
     * @return int
     * @author YPLFJR
     * @date 2022/4/10 14:38
     */
    public static int binarySearch(int[] arr, int findVal, int left, int right) {
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal) {
            left = mid + 1;
            binarySearch(arr, findVal, left, right);
        } else if (findVal < midVal) {
            right = mid - 1;
            binarySearch(arr, findVal, left, right);
        } else if (findVal == midVal) {
            return mid;
        } else if (left > right) {
            mid = -1;
        }
        return mid;
    }

    //完成一个课后思考题:
    /*
     * 课后思考题： {1,8, 10, 89, 1000, 1000，1234} 当一个有序数组中，
     * 有多个相同的数值时，如何将所有的数值都查找到，比如这里的 1000
     *
     * 思路分析
     * 1. 在找到mid 索引值，不要马上返回
     * 2. 向mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
     * 3. 向mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
     * 4. 将Arraylist返回
     */
    public static List<Integer> binarySearch2(int[] arr, int findVal, int left, int right) {
        if (left > right) {
            return new ArrayList<Integer>();
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal) {
            return binarySearch2(arr, findVal, left + 1, right);
        }
        if (findVal < midVal) {
            return binarySearch2(arr, findVal, left, right - 1);
        } else {
            List<Integer> resIndexlist = new ArrayList<>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                resIndexlist.add(temp);
                temp -= 1;
            }
            resIndexlist.add(mid);
            temp = mid + 1;
            while (true) {
                if (temp > arr.length || arr[temp] != findVal) {
                    break;
                }
                resIndexlist.add(temp);
                temp += 1;
            }
            return resIndexlist;
        }
    }
}
