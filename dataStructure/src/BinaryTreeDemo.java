/**
 * @author YLPJFR
 * @date 2022��04��11�� 16:39
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        //����Ҫ����һ�Ŷ�����
        BinaryTree binaryTree = new BinaryTree();
        //������Ҫ�Ľ��
        HeroNode1 root = new HeroNode1(1, "�ν�");
        HeroNode1 node2 = new HeroNode1(2, "����");
        HeroNode1 node3 = new HeroNode1(3, "¬����");
        HeroNode1 node4 = new HeroNode1(4, "�ֳ�");
        HeroNode1 node5 = new HeroNode1(5, "��ʤ");

        //˵�����������ֶ������ö���������������ѧϰ�ݹ�ķ�ʽ����������
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);

        //����
        System.out.println("ǰ�����");
        binaryTree.preOrder();

        System.out.println("�������");
        binaryTree.infixOrder();

        System.out.println("�������");
        binaryTree.postOrder();

//        System.out.println("ǰ�������ʽ~");
//        HeroNode1 resNode = binaryTree.preOrderSearch(5);
//        if (resNode != null) {
//            System.out.printf("�ҵ��ˣ���ϢΪ no=%d name=%s", resNode.getNo(), resNode.getName());
//        } else {
//            System.out.printf("û���ҵ� no=%d ��Ӣ��", 5);
//        }

//        System.out.println("���������ʽ~");
//        HeroNode1 resNode = binaryTree.infixOrderSearch(5);
//        if (resNode != null) {
//            System.out.printf("�ҵ��ˣ���ϢΪ no=%d name=%s", resNode.getNo(), resNode.getName());
//        } else {
//            System.out.printf("û���ҵ� no=%d ��Ӣ��", 5);
//        }

//        System.out.println("���������ʽ~");
//        HeroNode1 resNode = binaryTree.postOrderSearch(5);
//        if (resNode != null) {
//            System.out.printf("�ҵ��ˣ���ϢΪ no=%d name=%s", resNode.getNo(), resNode.getName());
//        } else {
//            System.out.printf("û���ҵ� no=%d ��Ӣ��", 5);
//        }

        System.out.println("ɾ��ǰ��ǰ�����");
        binaryTree.preOrder();
        binaryTree.delNode(5);
        System.out.println("ɾ����ǰ�����");
        binaryTree.preOrder();
    }

}

//����BinaryTree ������
class BinaryTree {
    private HeroNode1 root;

    public void setRoot(HeroNode1 root) {
        this.root = root;
    }

    //ǰ�����
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("������Ϊ�գ��޷�����");
        }
    }

    //�������
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("������Ϊ�գ��޷�����");
        }
    }

    //�������
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("������Ϊ�գ��޷�����");
        }
    }

    public HeroNode1 preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    public HeroNode1 infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    public HeroNode1 postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }

    public void delNode(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            } else {
                //�ݹ�ɾ��
                root.delNode(no);
            }
        } else {
            System.out.println("����������ɾ��~");
        }
    }
}

//�ȴ���HeroNode1 ���
class HeroNode1 {
    private int no;
    private String name;
    private HeroNode1 left; //Ĭ��null
    private HeroNode1 right; //Ĭ��null

    public HeroNode1(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode1 getLeft() {
        return left;
    }

    public void setLeft(HeroNode1 left) {
        this.left = left;
    }

    public HeroNode1 getRight() {
        return right;
    }

    public void setRight(HeroNode1 right) {
        this.right = right;
    }


    @Override
    public String toString() {
        return "HeroNode1 [no=" + no + ", name=" + name + "]";
    }

    //�ݹ�ɾ�����
    //1.���ɾ���Ľڵ���Ҷ�ӽڵ㣬��ɾ���ýڵ�
    //2.���ɾ���Ľڵ��Ƿ�Ҷ�ӽڵ㣬��ɾ��������
    public void delNode(int no) {
        //˼·
		/*
		 * 	1. ��Ϊ���ǵĶ������ǵ���ģ������������жϵ�ǰ�����ӽ���Ƿ���Ҫɾ����㣬������ȥ�жϵ�ǰ�������ǲ�����Ҫɾ�����.
			2. �����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�� ����Ҫɾ����㣬�ͽ�this.left = null; ���Ҿͷ���(�����ݹ�ɾ��)
			3. �����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�� ����Ҫɾ����㣬�ͽ�this.right= null ;���Ҿͷ���(�����ݹ�ɾ��)
			4. �����2�͵�3��û��ɾ����㣬��ô���Ǿ���Ҫ�����������еݹ�ɾ��
			5.  �����4��Ҳû��ɾ����㣬��Ӧ�������������еݹ�ɾ��.
		 */
        //2. �����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�� ����Ҫɾ����㣬�ͽ�this.left = null; ���Ҿͷ���(�����ݹ�ɾ��)

        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }

        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }
    }

    //��дǰ������ķ���
    public void preOrder() {
        System.out.println(this); //����������
        //�ݹ���������ǰ�����
        if (this.left != null) {
            this.left.preOrder();
        }
        //�ݹ���������ǰ�����
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //�������
    public void infixOrder() {

        //�ݹ����������������
        if (this.left != null) {
            this.left.infixOrder();
        }
        //��������
        System.out.println(this);
        //�ݹ����������������
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //�������
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    public HeroNode1 preOrderSearch(int no) {
        System.out.println("����ǰ�����");
        if (this.no == no) {
            return this;
        }
        HeroNode1 resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    public HeroNode1 infixOrderSearch(int no) {
        HeroNode1 resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }

        System.out.println("��ʼ�������");
        if (this.no == no) {
            return this;
        }

        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        return resNode;
    }

    public HeroNode1 postOrderSearch(int no) {
        HeroNode1 resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }


        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }

        System.out.println("��ʼ�������");
        if (this.no == no) {
            return this;
        }
        return resNode;
    }
}

