package test.subject;

import java.util.Scanner;

/**
 * 【程序4】
 * 题目：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
 */

public class Subject4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        decompose(a);
    }

    public static void decompose(int num) {

        int tmp = num / 2;
        for (int i = 2; i <= tmp; i++) {
            if (num % i == 0) {
                num = num / i;
                System.out.println("质因数为" + i);
                i = 1;
                continue;
            }
        }
    }

}
