package tree;

public class ArrayBinaryTree {

	/**
	 * give an Array,traversal as a tree
	 * @param args
	 */
	
	public static void main(String[] args) {
		int[]  arrTree= {1,2,3,4,5,6,7};
		ArrayBinaTree tree = new ArrayBinaTree(arrTree);
		tree.prefixTraverse(0);
		
	}
	
	
	/**			tree
	 * 			(0)
	 * 			 1
	 * 		 (1)     (2)
	 * 		  2       3
	 * 	   (3)(4)   (5) (6)
	 * 		4  5    6     7
	 * 	  8 9 10  11 12  13 14
	 * 
	 */
	// the nth node left index = 2*n+1
	// the nth node right index = 2*n+2
	// father node = (n-1)/2

}

class ArrayBinaTree {
	int[] arr;
	
	public ArrayBinaTree(int[] array) {
		this.arr = array;
	}
	
	public void prefixTraverse(int index) {
		
		System.out.println(arr[index]);
		
		if(index*2+1<arr.length) {
			prefixTraverse(index*2+1);
		}
		
		if(index*2+2<arr.length) {
			prefixTraverse(index*2+2);
		}
		
	}
	
}