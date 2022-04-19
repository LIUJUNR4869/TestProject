/**
 * @author YLPJFR
 * @date 2022��04��12�� 10:43
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {
                1, 2, 3, 4, 5, 6, 7
        };
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder1();
    }
}
/**
 *
 * @author YPLFJR
 * @date 2022/4/12 20:52
 *
 * @return null
 */
class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder1() {
        this.preOrder1(0);
    }

    public void preOrder1(int index) {
        if (arr == null && arr.length == 0) {
            System.out.println("����Ϊ�գ����ܰ��ն�������ǰ��˳�����");
        }
        System.out.println(arr[index]);
        if ((index * 2 + 1) < arr.length) {
            preOrder1(index * 2 + 1);
        }
        if ((index * 2 + 2) < arr.length) {
            preOrder1(index * 2 + 2);
        }
    }

}

