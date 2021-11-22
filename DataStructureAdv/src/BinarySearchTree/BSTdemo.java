package BinarySearchTree;

/**
 * 新增節點的邏輯
 * 1.如果當前樹沒有根結點，就把加入的Node設為根結點
 * 2.Node本身有一個addNode方法，對node進行addNode時
 *      若想add的Node的值 < 當前node 且node.left不為空, 則往左遞迴呼叫，
 *      直到當前left為空並把node給他的left
 * 3.右邊也一樣
 *
 * 刪除節點的邏輯
 * 1.要先找到要刪除的結點
 * 2.找到要刪除節的的父節點
 * 3.當前結點的三種條件
 *      -1 當前結點為葉子結點
 *         找到他的父親，直接刪掉即可
 *      -2 當前結點只有一顆子樹
 *         找到他的父親，把指向當前結點的pointer指到他的子樹
 *      -3 當前結點有完整的左右子樹(兩種解法)
 *         記錄一個值，值為要刪掉的右子樹的往左遞迴的節點的值(右子樹最小值)
 *         刪除右子樹最小值，並把本來要刪除的節點的值改成剛剛紀錄的值
 */
public class BSTdemo {
    public static void main(String[] args) {

        int[] originArr = {7,4,2,3,10,9,11};
        BinarySearchTree bst = new BinarySearchTree();
        for (int i = 0; i < originArr.length; i++) {
            bst.addNode(new Node(originArr[i]));
        }

        bst.root.infixOrder();

        System.out.println(bst.root.getParentNode(3));

        bst.deleteNode(10);
        System.out.println("====delete 2");
        bst.root.infixOrder();
        System.out.println(bst.root);
        System.out.println(bst.root.right);
        System.out.println(bst.root.right.right);
    }
}


class BinarySearchTree{
    Node root;
    //創建BST
    public void addNode(Node node){
        if(root==null){
            root = node;
            return;
        }
       root.addNode(node);
    }

    public Node searchNode(Integer value){
        if(root==null){
            return null;
        }else{
            return root.searchNode(value);
        }
    }

    public Node getParentNode(Integer value){
        if (root ==null){
            return null;
        }else {
            return  root.getParentNode(value);
        }

    }

    public void deleteNode(Integer nodeValue) {

        /* 當前結點的三種條件
         *      -1 當前結點為葉子結點
         *         找到他的父親，直接刪掉即可
         *      -2 當前結點只有一顆子樹
         *         找到他的父親，把指向當前結點的pointer指到他的子樹
         *      -3 當前結點有完整的左右子樹(兩種解法)
         *         記錄一個值，值為要刪掉的右子樹的往左遞迴的節點的值(右子樹最小值)
         *         刪除右子樹最小值，並把本來要刪除的節點的值改成剛剛紀錄的值*/
        if(root ==null){
            return;
        }else{
            Node targetNode = searchNode(nodeValue);
            //查無結點
            if(targetNode==null){
                return;
            }
            //考慮到只有一個跟結點的情況
            if(root.right==null && root.left==null){
                root=null;
                return;
            }
            //找targetNode的父結點
            Node parentNode = getParentNode(nodeValue);
            //狀況1 當前結點為葉子結點
            if (targetNode.left==null&&targetNode.right==null){
                if(parentNode.left!=null && parentNode.left==targetNode){
                    parentNode.left=null;
                }else if(parentNode.right!=null && parentNode.right==targetNode){
                    parentNode.right=null;
                }
            }else if (targetNode.right!=null && targetNode.left!=null){
                //狀況3 有兩個子樹 要刪掉的值改為左子樹的最大值，再把左子樹最大值刪掉
                Node leftTreeMaxNode = targetNode.left.getLeftTreeMaxNode();
                System.out.println("左子樹最大值結點= "+leftTreeMaxNode);
                System.out.println("左子樹最大值的父結點= "+getParentNode(leftTreeMaxNode.value) );
                Node parentMax = getParentNode(leftTreeMaxNode.value);

                //要刪掉的值改成左子樹最大值
                targetNode.value = leftTreeMaxNode.value;
                //將要刪除結點的左右子樹位置指定好，若其右子樹為空就指定為左子樹(也可以為空)
                Node tempRight = leftTreeMaxNode.right;
                Node tempLeft = leftTreeMaxNode.left;
                //看看最大值是他父親的左邊還是右邊
                if(parentMax.right == leftTreeMaxNode){
                    parentMax.right=(tempRight==null? tempLeft:tempRight);
                }else{
                    parentMax.left=(tempRight==null? tempLeft:tempRight);;
                }


            }else{//狀況2 當前結點只有一顆子樹,如果不是葉子結點或是含有左右兩顆子樹的情況下
                  //不用判斷是否有左子樹或右子樹
                //條件1 如果要刪除target的有左子樹
                if(targetNode.left!=null){
                    if(parentNode.left==targetNode){
                        parentNode.left=targetNode.left;
                    }else{
                        parentNode.right=targetNode.left;
                    }
                }else{//要刪除的target有右子樹
                    if(parentNode.left==targetNode){
                        parentNode.left=targetNode.right;
                    }else {
                        parentNode.right=targetNode.right;
                    }
                }

            }



        }


    }

}





class Node{
    Integer value;
    Node left;
    Node right;

    public Node(Integer value) {
        this.value = value;
    }

    //若新增的節點小於當前的，則往左遞迴擺
    //若新增的節點大於當前的，則往右遞迴擺
    public void addNode(Node node){
        if(this.value >node.value){
            if(this.left==null){
                this.left = node;
            }else{
                this.left.addNode(node);
            }
        }else{
            if(this.right==null){
                this.right = node;
            }else{
                this.right.addNode(node);
            }
        }
    }
    //中序遍歷
    public void infixOrder(){
        if(this==null){
            return;
        }
        if(this.left!=null){
           this.left.infixOrder();
        }
        System.out.println(this.value);
        if (this.right!=null){
            this.right.infixOrder();
        }

    }


    //查詢結點
    public Node searchNode(Integer nodeValue){
        if(this.value ==nodeValue){

            return this;
        }else if(this.value >nodeValue &&this.left !=null){
            return this.left.searchNode(nodeValue);
        }else if(this.value <nodeValue && this.right !=null){
            return this.right.searchNode(nodeValue);
        }else{
            System.out.println("查無此結點值為 "+ nodeValue);
            return null;
        }

    }
    //查詢要刪除結點的父結點
    public Node getParentNode(Integer nodeValue){
        if (this.left!=null && this.left.value ==nodeValue || this.right !=null && this.right.value == nodeValue){
            return this ;
        }else{
            if (this.value >nodeValue &&this.left !=null){
                return this.left.getParentNode(nodeValue);
            }else if (this.value <nodeValue && this.right !=null){
                return this.right.getParentNode(nodeValue);
            }else{
                System.out.println("查無父結點 ");
                return null;
            }

        }
    }

    //往右查詢最大的結點
    public Node getLeftTreeMaxNode(){
        if(this.right!=null){
            return this.right.getLeftTreeMaxNode();
        }else{
            return this;
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
