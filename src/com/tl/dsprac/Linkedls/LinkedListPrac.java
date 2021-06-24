package com.tl.dsprac.Linkedls;

public class LinkedListPrac {

	public static void main(String[] args) {
		
		
		LinkedListDemo linklist = new LinkedListDemo();
		EmpNode emp1 = new EmpNode(1, "john1");
		EmpNode emp3 = new EmpNode(3, "john3");
		EmpNode emp5 = new EmpNode(5, "john5");
		EmpNode emp7 = new EmpNode(7, "john7");
		linklist.addList(emp1);
		linklist.addList(emp3);
		linklist.addList(emp5);
		linklist.addList(emp7);
		linklist.showList();
		emp7.setName("john77");
		
		linklist.update(emp7);
		linklist.showList();
		linklist.deleteNode(5);
		linklist.showList();
		linklist.deleteNode(7);
		linklist.showList();

//		LinkedListDemo linklist2 = new LinkedListDemo();
////		EmpNode emp2 = new EmpNode(2, "john2");
//		EmpNode emp4 = new EmpNode(4, "john4");
//		EmpNode emp8 = new EmpNode(8, "john8");
//		EmpNode emp2 = new EmpNode(2, "john2");
//		EmpNode emp6 = new EmpNode(6, "john6");
//		//EmpNode emp8 = new EmpNode(8, "john8");
//		linklist2.addList(emp2);
//		linklist2.addList(emp4);
//		linklist2.addList(emp6);
//		linklist2.addList(emp8);
//	
//		linklist.showList();
//		linklist2.showList();
//		
//		linklist.mergeTwoList(linklist, linklist2);
//		linklist.showList();
	}
	
	
}