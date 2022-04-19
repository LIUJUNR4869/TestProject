package graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author YLPJFR
 * @date 2022��04��18�� 19:07
 */

/**
 * ͼ�������������(Depth First Search) ��
 * 1) ������ȱ������ӳ�ʼ���ʽ���������ʼ���ʽ������ж���ڽӽ�㣬������ȱ����Ĳ��Ծ������ȷ���
 * ��һ���ڽӽ�㣬Ȼ��������������ʵ��ڽӽ����Ϊ��ʼ��㣬�������ĵ�һ���ڽӽ�㣬 ����������⣺
 * ÿ�ζ��ڷ����굱ǰ�������ȷ��ʵ�ǰ���ĵ�һ���ڽӽ�㡣
 * 2) ���ǿ��Կ����������ķ��ʲ����������������ھ����룬�����Ƕ�һ�����������ڽӽ����к�����ʡ�
 * 3) ��Ȼ���������������һ���ݹ�Ĺ���
 * <p>
 * ������ȱ����㷨����
 * 1) ���ʳ�ʼ��� v������ǽ�� v Ϊ�ѷ��ʡ�
 * 2) ���ҽ�� v �ĵ�һ���ڽӽ�� w��
 * 3) �� w ���ڣ������ִ�� 4����� w �����ڣ���ص��� 1 �������� v ����һ����������
 * 4) �� w δ�����ʣ��� w ����������ȱ����ݹ飨���� w ������һ�� v��Ȼ����в��� 123����
 * 5) ���ҽ�� v �� w �ڽӽ�����һ���ڽӽ�㣬ת������ 3��
 * 6) ����ͼ
 */
public class Graph {

    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numOgEdges;

    public static void main(String[] args) {

        //����һ��ͼ�Ƿ񴴽�ok
        int n = 8;  //���ĸ���
        String Vertexs[] = {"A", "B", "C", "D", "E"};

        //����ͼ����
        Graph graph = new Graph(n);

        //���ѭ���Ķ���
        for (String vertexvalue :
                Vertexs) {
            graph.insertVertex(vertexvalue);
        }

        //��ӱ�
        //A-B A-C B-C B-D B-E
        graph.insertEdge(0, 1, 1); // A-B
        graph.insertEdge(0, 2, 1); //
        graph.insertEdge(1, 2, 1); //
        graph.insertEdge(1, 3, 1); //
        graph.insertEdge(1, 4, 1); //

        graph.showGraph();
    }

    //������
    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOgEdges = 0;
    }

    //���ؽ�����
    public int getNumOgEdges() {
        return vertexList.size();
    }

    //��ʾͼ��Ӧ�ľ���
    public void showGraph() {
        for (int[] link :
                edges) {
            System.err.println(Arrays.toString(link));
        }
    }

    //������
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //���ؽڵ�i���±꣩��Ӧ������ 0-->"A" 1-->"B"
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //����v1,v2��Ȩֵ
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }


    //��ӱ�

    /**
     * @param v1     ��ʾ����±꼴ʹ�ڼ�������  "A"-"B" "A"->0 "B"->1
     * @param v2     �ڶ��������Ӧ���±�
     * @param weight ��ʾ
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOgEdges++;
    }
}
