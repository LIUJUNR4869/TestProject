package graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author YLPJFR
 * @date 2022年04月18日 19:07
 */

/**
 * 图的深度优先搜索(Depth First Search) 。
 * 1) 深度优先遍历，从初始访问结点出发，初始访问结点可能有多个邻接结点，深度优先遍历的策略就是首先访问
 * 第一个邻接结点，然后再以这个被访问的邻接结点作为初始结点，访问它的第一个邻接结点， 可以这样理解：
 * 每次都在访问完当前结点后首先访问当前结点的第一个邻接结点。
 * 2) 我们可以看到，这样的访问策略是优先往纵向挖掘深入，而不是对一个结点的所有邻接结点进行横向访问。
 * 3) 显然，深度优先搜索是一个递归的过程
 * <p>
 * 深度优先遍历算法步骤
 * 1) 访问初始结点 v，并标记结点 v 为已访问。
 * 2) 查找结点 v 的第一个邻接结点 w。
 * 3) 若 w 存在，则继续执行 4，如果 w 不存在，则回到第 1 步，将从 v 的下一个结点继续。
 * 4) 若 w 未被访问，对 w 进行深度优先遍历递归（即把 w 当做另一个 v，然后进行步骤 123）。
 * 5) 查找结点 v 的 w 邻接结点的下一个邻接结点，转到步骤 3。
 * 6) 分析图
 */
public class Graph {

    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numOgEdges;

    public static void main(String[] args) {

        //测试一把图是否创建ok
        int n = 8;  //结点的个数
        String Vertexs[] = {"A", "B", "C", "D", "E"};

        //创建图对象
        Graph graph = new Graph(n);

        //添加循环的顶点
        for (String vertexvalue :
                Vertexs) {
            graph.insertVertex(vertexvalue);
        }

        //添加边
        //A-B A-C B-C B-D B-E
        graph.insertEdge(0, 1, 1); // A-B
        graph.insertEdge(0, 2, 1); //
        graph.insertEdge(1, 2, 1); //
        graph.insertEdge(1, 3, 1); //
        graph.insertEdge(1, 4, 1); //

        graph.showGraph();
    }

    //构造器
    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOgEdges = 0;
    }

    //返回结点个数
    public int getNumOgEdges() {
        return vertexList.size();
    }

    //显示图对应的矩阵
    public void showGraph() {
        for (int[] link :
                edges) {
            System.err.println(Arrays.toString(link));
        }
    }

    //插入结点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //返回节点i（下标）对应的数据 0-->"A" 1-->"B"
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回v1,v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }


    //添加边

    /**
     * @param v1     表示点的下标即使第几个顶点  "A"-"B" "A"->0 "B"->1
     * @param v2     第二个顶点对应的下标
     * @param weight 表示
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOgEdges++;
    }
}
