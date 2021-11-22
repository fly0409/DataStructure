package Graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  演算法步驟
 *     1.訪問初始結點v,並標記初始結點v已經訪問
 *     2.尋找該結點v的鄰近結點w
 *     3.若w存在,則繼續執行4,
 *       若w不存在,則回到第一步,從下一個v結點繼續
 *     4.若w未被訪問,對w進行DFS,(即把w當成v進行步驟123)
 *     5.查找該結點的下一個鄰接結點,轉到步驟3
 */
public class DFSgraph {

    Integer vertexNum;//頂點數量
    Integer edge=0;//邊
    ArrayList<String> elements = new ArrayList<>();
    int[][] graph;
    boolean[] isVisited;

    public DFSgraph(Integer size){
        this.vertexNum = size;
        this.graph = new int[vertexNum][vertexNum];
        isVisited = new boolean[vertexNum];
        //給list加A B C..
        for (int i = 0; i < vertexNum; i++) {
            elements.add(Character.toString((char) i+65));
        }
    }

    public void setEdge(Integer v1, Integer v2){
        graph[v1][v2] = 1;
        graph[v2][v1] = 1;
        edge++;
    }
    public void showGraph(){
        for (int[]list:graph) {
            System.out.println(Arrays.toString(list));
        }
    }
    //DFS用的function
    //取的該vertex的鄰近頂點的index，如果存在返回對應的index or -1
    public int getFirstNeighbor(int index){
        for (int i = 0; i < vertexNum; i++) {
            if(graph[index][i]>0){
                return i;
            }
        }
        return -1;
    }
    //根據前一個鄰接結點index，獲取該index對應到的下一個index
    public int getNextNeighbor(int index,int v2Index){
        for (int i = v2Index; i <vertexNum ; i++) {
            if(graph[index][i]>0){
                return i;
            }
        }
        return -1;
    }
    //深度優先
    //index 要訪問的結點，i第一次是0
    public void DFS(boolean[] isVisited,int index){
        //訪問該結點
        System.out.print(elements.get(index)+"=>");
        //將此結點設置為已訪問
        isVisited[index]=true;
        //對應第二步,查找下一個結點的鄰接結點
        int w =getFirstNeighbor(index);
        while (w!=-1){//有下一個鄰接結點
            if(isVisited[w]){//沒有被訪問過
                DFS(isVisited,w);
            }
            //如果被訪問過
                w=getNextNeighbor(index,w);

        }
    }

    //對DFS重載,走訪所有結點
    public void DFS(){
        for (int i = 0; i < vertexNum; i++) {
            if(!isVisited[i]){//如果沒被訪問過
                DFS(isVisited,i);
            }
        }
    }


    public static void main(String[] args) {
        DFSgraph graph = new DFSgraph(5);
        graph.setEdge(0,1);
        graph.setEdge(0,2);
        graph.setEdge(1,2);
        graph.setEdge(1,3);
        graph.setEdge(1,4);

        graph.showGraph();
        graph.DFS();
    }

}
