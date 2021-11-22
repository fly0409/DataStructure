package Linkedls;

public class LinkedListDemo {	
	private Emp header;
	
	public LinkedListDemo() {
		this.header = new Emp(0,"");
		header.setNext(null);
	}
	
	
	public Emp getHeader() {
		return header;
	}
	

	public void setHeader(Emp header) {
		this.header = header;
	}


	public void showList() {
		int count = 0;
		Emp tempNode = header.getNext();
		while(tempNode!=null) {
			System.out.println(tempNode.toString());
			count++;
			if(tempNode.getNext()==null) {
				break;
			}
			tempNode = tempNode.getNext();
			
		}
		System.out.println("this list have total "+count+" item(s)");
	}
	
	public void addList(Emp emp) {
		Emp tempNode = header;
		while(tempNode.getNext()!=null) {
			tempNode = tempNode.getNext();
		}
		tempNode.setNext(emp);
		
	}
	public void addListByOrder(Emp emp) {
		Emp tempNode = header;
		while(tempNode.getNext()!=null && emp.getNum() >tempNode.getNext().getNum()) {
			tempNode = tempNode.getNext();
		}
		emp.setNext(tempNode.getNext());
		tempNode.setNext(emp);
		
	}
	public boolean update(Emp emp) {
		Emp tempNode = header;
		boolean flag = false;
		while(tempNode.getNext()!=null) {			
			tempNode = tempNode.getNext();
			if(tempNode.getNum()==emp.getNum()) {
				flag = true;
				tempNode.setName(emp.getName());
			}
			
		}
		return flag;
	}
	
	public boolean deleteNode(int num) {
		Emp tempNode = header;
		Emp temp =null;
		boolean flag = false;
		while(tempNode.getNext()!=null) {			
			
			if(tempNode.getNext().getNum()==num) {
				flag = true;
				temp = tempNode.getNext();
				if(temp.getNext()==null) {
					tempNode.setNext(null);
					break;
				}else {
					tempNode.setNext(temp.getNext());
				}
				
			}
		tempNode = tempNode.getNext();
			
		}
		return flag;
	}
	
	public void reverseList() {
		Emp tempNode = header;
		Emp reverseHead = new Emp(0,"");
		Emp current = tempNode.getNext();
		Emp next = null;
		//開始反轉
		if (tempNode.getNext()==null || tempNode.getNext().getNext()==null) {
			return;
		}
		while(current != null) {
			//先把現在的下一個記著
			next = current.getNext();
			//把current的下一個改成reversehead的下一個
			current.setNext(reverseHead.getNext());
			//再把current放進去reversehead第一個
			reverseHead.setNext(current);
			//第一個current完成，把current跳到下個，也就是預先保留的next
			current = next;
			
		}
		header.setNext(reverseHead.getNext());
	
		return;
		
	}
	
	//merge two linkedlist
	public void mergeTwoList(LinkedListDemo list1,LinkedListDemo list2) {
//		if(list1.getHeader().getNext()==null || list2.getHeader().getNext()==null) {
//			return;
//		}
		
		Emp mergeNode = new Emp(0,"");
		Emp temp = null;
		Emp cur = null;
		Emp list1Head = list1.getHeader().getNext();
		while((list1Head)!=null) {			
			temp = mergeNode;
			cur = list1Head;
			list1Head= list1Head.getNext();
			while(temp.getNext()!=null && cur.getNum() >temp.getNext().getNum()) {
				temp=temp.getNext();				
			}
			
			cur.setNext(temp.getNext());
			temp.setNext(cur);
			
		}
		cur = null;
		Emp list2Head = list2.getHeader().getNext();
		while((list2Head)!=null) {		
			temp = mergeNode;
			cur = list2Head;
			list2Head= list2Head.getNext();
			while(temp.getNext()!=null && cur.getNum() >temp.getNext().getNum()) {
				temp=temp.getNext();
			}			
			cur.setNext(temp.getNext());
			temp.setNext(cur);			
		}
		
		
		
		list1.setHeader(mergeNode);
		
	}
	
	
	
}
