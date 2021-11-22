package HuffManTree;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @author tailinh
 * 1)Node (data(存放數據)， weight(權值)，left 和 right)
 * 2)得到 "i like like like java do you like java"對應的byte[]
 * 3)編寫方法，將準備構建huffman 樹的Node節點放到 list形式 [Node(data = 97,weight =5)]..即a有5個
 *   show 出d:1 y:1 ...
 * 4)通過list 創建對應的huffman樹
 *
 *
 * what is huffman tree? 權值+路徑長 為最小的 樹，該樹即為huffman 樹
 * how to create
 * 1) 從小到大排列，每個數據都是結點，每個節點都是簡單的2叉樹
 * 2) 取出權值最小的兩棵樹
 * 3) 組合成新的樹，其權值為前兩棵樹之和
 * 4) 再將此樹與其他樹排序，重複處理直到只剩一個大樹
 *
 */
public class HuffmanCode {

    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
//        byte[] content = str.getBytes();
//        System.out.println(content.length);
//        List<Node> nodes = getNodes(content);
////		for(Node n:nodes) {
////			System.out.println(n+",");
////		}
//
//        Node nod = createhuffmanTree(nodes);
//        nod.preOrder();
//        //是否生成對應的huffmanCode
//        getCodes(nod,"",stringBuilder);
//        //{32=01, 97=100, 100=11000, 117=11001, 101=1110, 118=11011, 105=101, 121=11010, 106=0010, 107=1111, 108=000, 111=0011
//        System.out.println("生成的huffman code"+huffmanCode);
//
//        byte[] zips = zip(content, huffmanCode);
        byte[] zips = huffmanZip(str);
        System.out.println(Arrays.toString(zips));

        byte[] decode = decode(huffmanCode, zips);
        System.out.println(new String(decode));
    }

    /**
     * 將數據解壓縮
     * 1.huffman壓縮後的 byte[] 轉成 huffman 便編碼的二進制 字串
     * 2.將此字符串 透過map 來把二進制字串 轉換為 原始字串
     */
    /**
     * @param flag 是否不為最後一位
     * @param b     傳入的byte
     * @return      回傳binary string
     */
    private static String byteArrToStr(boolean flag,Byte b){
        //要怎麼to Binary String
        int temp = b;
        //btye是正數 => (ex 1111111...111)返回的是32 bit 的 二補數,但是一個byte是8個bit，所以要substr
        //byte是負數 => (ex 00..001)返回的只有1,所以要對此String 進行處理 用 |=，一個bit的or運算
        //最後一位不滿8位=>用flag控制
        if(flag ==true){
            if(temp>=0){
                temp|=256;//ex ..0 0000 0001=> 1 0000 0001
            }
        }

        String str =Integer.toBinaryString(temp);
        if (flag==true){
            str = str.substring(str.length()-8);
            return str;
        }
        return str;
    }

    /**
     * 傳入huffmanCode 編碼對應表 以及 壓縮過後([-88,xx,x...])huffmanByte 進行解碼
     *
     *
     * @param huffmanCode
     * @param huffmanByte
     * @return
     */
    public static byte[] decode(Map<Byte,String> huffmanCode,byte[] huffmanByte){

        //先得到huffman byte對應的字串
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < huffmanByte.length; i++) {
            boolean isLast = (i==huffmanByte.length-1);
            stringBuilder.append(byteArrToStr(!isLast,huffmanByte[i]));
        }

        //反轉huffman map
        Map<String,Byte> inverseMap = new HashMap<>();
        for(Map.Entry<Byte,String> entry:huffmanCode.entrySet()){
            inverseMap.put(entry.getValue(),entry.getKey());
        }

        ArrayList<Byte> alphaByte = new ArrayList<>();
        for (int i = 0; i <stringBuilder.length() ; ) {
            int count = 0;
            boolean flag =true;
            while (flag){
                String substring = stringBuilder.substring(i, i + count);
                Byte letterByte = inverseMap.get(substring);
                if (letterByte ==null){
                    count++;
                }else{
                    alphaByte.add(letterByte);
                    i+=count;
                    flag=false;
                }
            }

        }
        System.out.println(alphaByte.toString());
        byte[] stringByte = new byte[alphaByte.size()];
        for (int i = 0; i < alphaByte.size(); i++) {
            stringByte[i] = alphaByte.get(i);
        }

        return stringByte;
    }




    //包裝步驟 一口氣取的huffmanByte[]
    private static byte[] huffmanZip(String str){
        byte[] content = str.getBytes();
        //建立 字母以及其權重 的 Node陣列
        List<Node> nodes = getNodes(content);
        //通過list取的huffman樹，返回樹的根結點
        Node nod = createhuffmanTree(nodes);
        //從根結點 利用路徑 取得各個字母對應的huffman編碼 (map方式)
        getCodes(nod,"",stringBuilder);
        //利用map表遍歷 byte陣列，取得壓縮後的結果
        byte[] zips = zip(content, huffmanCode);
        return zips;
    }


    //遍歷byte陣列，把對應的Node 建立出來並放在一個arrayList裡面
    private static List<Node> getNodes(byte[] bytes){
        ArrayList<Node> nodes = new ArrayList<Node>();
        HashMap<Byte, Integer> counts = new HashMap<Byte,Integer>();

        //利用hashmap 來建立各byte對應到的count，把每個byte[] 的值都抓出來，並用值當做key,value則為用該key去抓值得到的
        for(byte b : bytes) {
            Integer count = counts.get(b);
            if (count ==null) {
                counts.put(b, 1);
            }else {
                counts.put(b,count+1);
            }
        }

        //將map轉成node list
        //遍歷map的方法
        for (Map.Entry<Byte, Integer> entry :counts.entrySet()) {
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }


    //通過list創建huffman樹
    private static Node createhuffmanTree(List<Node> nodes) {

        while(nodes.size()>1) {
            //排序 從小到大
            Collections.sort(nodes);
            //取出最小的二叉樹
            Node leftNode = nodes.get(0);
            //取出次小的
            Node rightNode = nodes.get(1);
            //建立一個新的二叉小樹，新的只有權值 ，沒有data，因為字母都放在葉子節點
            Node parent = new Node(null,leftNode.weight+rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;

            //移除舊的node
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);

        }
        // node最後的節點 為2叉樹的根結點
        return nodes.get(0);
    }
    /**
     *  生成對應的huffman編碼
     *  1.將huffmanCode放在map結構 <Byte String>
     *    32->01,97->100, 100->11000
     *  2.在生成huffman code需要串接路徑，利用String builder 儲存路徑
     */

    static Map<Byte,String> huffmanCode = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();

    /**
     * 將傳入的node節點，拿到所有葉子節點的huffmanCode, 傳到sb
     *
     * @param node 傳入節點
     * @param code 路徑 =>左子節點 0,右子節點 =>1
     * @param stringBuilder =>串接路徑
     */
    private static void getCodes(Node node, String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        //字串串接
        stringBuilder2.append(code);
        //如果node不是葉子node
        if(node.data ==null){
            getCodes(node.left,"0",stringBuilder2);
            getCodes(node.right,"1",stringBuilder2);
        }else{
            huffmanCode.put(node.data,stringBuilder2.toString());
        }

    }
    /**
     * 透過一個方法，將字串對應的byte[]，通過生成的huffmanCode，回一個被壓縮後的byte[]
     * bytes 原始字串的byte[]
     * huffmancode 生成的huffmanCode
     * 舉例進入的某某字串"XXX"返回為"10101000..."
     * 此返回視為byte[]，huffmanCodeBytes,8位一個byte[]
     * huffman[0] = "10101000"(二補數的值) 求出他對應的數字 1.先-1,2.在對第二個開始的每個進行not操作
     * 10100111=>11011000; => -88
     *
     */
    private static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes){
        //1.利用編碼表 把傳進的byte[]轉成 huffman編碼後的String
        StringBuilder stringBuilder1 = new StringBuilder();
        //遍歷byte[]
        for(byte b :bytes) {
            stringBuilder1.append(huffmanCodes.get(b));
        }
        //將對應的字串轉成byte[]
        // System.out.println("huffmanString"+stringBuilder1.toString());
        int len = stringBuilder1.length()%8==0? stringBuilder1.length()/8:stringBuilder1.length()/8+1;
        //建立存儲壓縮後的byte[]
        byte[] huffByte = new byte[len];
        int index=0;
        for (int i = 0; i < stringBuilder1.length(); i+=8) {
            String tempStr;
            if(i+8>stringBuilder1.length()){
                tempStr = stringBuilder1.substring(i);
            }else{
                tempStr = stringBuilder1.substring(i,i+8);
            }
            //轉成二進制在轉成byte
            huffByte[index] = (byte)Integer.parseInt(tempStr,2);
            index++;
        }
        return huffByte;
    }

}

class Node implements Comparable<Node>{
    Byte data; //存放數據本身
    int weight;  //權值 表示字母出現次數
    Node right;
    Node left;
    public Node(Byte data, int weight) {
        super();
        this.data = data;
        this.weight = weight;
    }
    @Override
    public int compareTo(Node o) {
        //從小到大排序
        return this.weight - o.weight;
    }
    @Override
    public String toString() {
        return "Node [data=" + data + ", weight=" + weight + "]";
    }

    public void preOrder() {
        System.out.println(this);

        if (this.left!=null) {
            this.left.preOrder();
        }

        if (this.right!=null) {
            this.right.preOrder();
        }
    }
}

