import java.util.ArrayList;
import java.util.List;

/**
 * @author YLPJFR
 * @date 2022��04��10�� 14:21
 */
public class binarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 9, 11, 11, 13};
        int index = binarySearch(arr, 3, 0, arr.length - 1);
        if (index == -1) {
            System.out.println("���ֲ�����");
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

    //���һ���κ�˼����:
    /*
     * �κ�˼���⣺ {1,8, 10, 89, 1000, 1000��1234} ��һ�����������У�
     * �ж����ͬ����ֵʱ����ν����е���ֵ�����ҵ������������ 1000
     *
     * ˼·����
     * 1. ���ҵ�mid ����ֵ����Ҫ���Ϸ���
     * 2. ��mid ����ֵ�����ɨ�裬���������� 1000�� ��Ԫ�ص��±꣬���뵽����ArrayList
     * 3. ��mid ����ֵ���ұ�ɨ�裬���������� 1000�� ��Ԫ�ص��±꣬���뵽����ArrayList
     * 4. ��Arraylist����
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
