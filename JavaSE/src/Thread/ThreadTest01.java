package Thread;
/*
 ������һ��ִ�г����߳���һ�������е�ִ�г���/ִ�е�Ԫ��һ�����̿�����������̡߳�
 java��

	�������³����м����̣߳�
		���³���ֻ��һ���̣߳��������߳�.
		main,m1,m2,m3���ĸ�������ͬһ��ջ�ռ��С�
		û�����������κ��̡߳�

	��ͬ���̵��ڴ����������
	ͬһ���̵Ĳ�ͬ�̣߳�����ڴ�ͷ������ڴ湲��
	�������ţ��������У�----���̲߳�������߳���Ĵ���Ч��
	ʹ�ö��̣߳�main����ִ�н��������ܳ���û�н�����main����ֻ�����߳̽����ˣ���ջ���ˣ�����ջ�Դ���ѹջ��ջ�Ŀ���

	����CPU�Ƿ��ʵ�ֶ��̲߳�����
	    ����ʵ�������Ķ��̲߳����������Ը��˶��̲߳����ĸо�
	    ������CPU�����ٶȼ��죬�����ڲ�ͬ����֮��Ƶ���л�ִ�У�������ķ�Ӧ�ٶȺ��������Ի�������̲߳����ĸо�

	ʲô�������Ķ��̲߳�����
	    A�߳�ִ��A�̵߳ģ�B�߳�ִ��B�̵߳ģ������Ǹ���Ӱ��


*/
public class ThreadTest01 {
    public static void main(String[] args) {
        System.out.println("mani begin");
        m1();
        System.out.println("main over");
    }

    private static void m1() {
        System.out.println("main begin");
        m2();
        System.out.println("m2 over");
    }

    private static void m2() {
        System.out.println("m2 begin");
        m3();
        System.out.println("m3 over");
    }

    private static void m3() {
        System.out.println("m3 execute");
    }
}
