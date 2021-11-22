package tree;

// create Emp Beans use tree structure
public class BinaryTreeDemo {
	
	public static void main(String[] args) {
		
		
		Emp emp1 = new Emp(1,"aaa");
		Emp emp2 = new Emp(2,"bbb");
		Emp emp3 = new Emp(3,"ddd");
		Emp emp4 = new Emp(4,"eee");
		Emp emp5 = new Emp(5,"fff");
		Emp emp6 = new Emp(6,"ggg");
		//Emp emp7 = new Emp(7,"hhh");

		emp1.left=emp2;
		emp2.left=emp3;
		emp2.right= emp4;
		emp1.right= emp5;
		emp5.left = emp6;
		//emp3.right=emp7;
		//			1
		//		2		5
		//	 3     4	
		//6     7
		BinaryTree binaryTree = new BinaryTree(emp1);
//		System.out.println("=====pre======");
//		binaryTree.preOrder();
//		System.out.println("=====infix======");
//		binaryTree.infixOrder();
		System.out.println("=====post======");
		binaryTree.postOrder();
		
//		Emp emp = binaryTree.infixOderSearch(1);
//		if(emp!=null) {
//		System.out.println(emp.toString());
//		}else {
//			System.out.println("not found");
//		}
		
//		binaryTree.deleteEmp(2);
//		binaryTree.preOrder();
			
	}

}

class BinaryTree {
Emp root;
	
	public BinaryTree(Emp root) {
		super();
		this.root = root;
	}
	
	public void preOrder() {
		root.preOrder();
	}
	public void infixOrder() {
		root.infixOrder();
	}
	public void postOrder() {
		root.postOrder();
	}
	public Emp preOderSearch(int id) {
		return root.preOrderSearch(id);
	}
	public Emp infixOderSearch(int id) {
		return root.infixOrderSearch(id);
	}
	
	public void deleteEmp(int id) {
		if (root.getId()==id){
			root=null;
		}else {
			root.deleteEmp(id);
		}
		
	}
	
}

class Emp {
	private int id;
	private String name;
	public Emp left;
	public Emp right;
		
	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}	
	//traversal
	// root => left => right
	public void preOrder() {
		System.out.println(this.toString());
		
		if(this.left!=null) {
			this.left.preOrder();
		}
		if(this.right!=null) {
			this.right.preOrder();
		}		
	}
	
	//left => root => right
	public void infixOrder() {
		if(this.left!=null) {
			this.left.infixOrder();
		}
		System.out.println(this.toString());
		if(this.right!=null) {
			this.right.infixOrder();
		}		
	}
	
	public void postOrder() {
		if(this.left!=null) {
			this.left.postOrder();
		}
		
		if(this.right!=null) {
			this.right.postOrder();
		}
		
		System.out.println(this.toString());
	}
	// search root => left => right
	// need a temp Emp for judge the recursion result
	// if the result of left recursion is null => continue to run right side
	// if right side still not found => return null;
	public Emp preOrderSearch(int id) {
		System.out.println("----preOrderSearch start----");
		System.out.println(this.getId());
		Emp temp=null;
		if(this.getId()==id) {
			temp = this;
			return temp;
		}
		//
		if(this.left!=null && temp == null) {
			temp =  this.left.preOrderSearch(id);
		}
		if(this.right!=null && temp == null) {
			temp = this.right.preOrderSearch(id);
			return temp;
		}else {
			return temp;
		}		
	}
	//infix return Emp or Null
	public Emp infixOrderSearch(int id) {
		System.out.println("----infixOrderSearch start----");
		Emp temp=null;
		if(this.left!=null && temp == null) {
			temp =  this.left.infixOrderSearch(id);
		}		
		System.out.println(this.getId());
		if(this.getId()==id) {
			temp = this;
			return temp;
		}		
		if(this.right!=null && temp == null) {
			temp = this.right.infixOrderSearch(id);
			return temp;
		}else {
			return temp;
		}		
	}
	//infix
	public Emp postOrderSearch(int id) {
		System.out.println("----postOrderSearch start----");
		
		Emp temp=null;
		if(this.left!=null && temp == null) {
			temp =  this.left.postOrderSearch(id);
		}		
	
		if(this.right!=null && temp == null) {
			temp = this.right.postOrderSearch(id);
			return temp;
		}
		System.out.println(this.getId());
		if(this.getId()==id) {
			temp = this;
			return temp;
		}else {
			return temp;
		}		
	}
	
	// delete Node
	// 
	public void deleteEmp(int id) {
		
			if (this.left!=null ) {
				if(this.left.getId() == id) {
					//directly delete 
					this.left = null;
					
				}else {
					this.left.deleteEmp(id);
				}
			}
			
			if (this.right!=null ) {
				if(this.right.getId() == id) {
					this.right = null;
				}else {
					this.right.deleteEmp(id);
				}
			}
		
	}
	
	
	
	
	//getter & setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Emp getLeft() {
		return left;
	}
	public void setLeft(Emp left) {
		this.left = left;
	}
	public Emp getRight() {
		return right;
	}
	public void setRight(Emp right) {
		this.right = right;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + "]";
	}
	
	
}

