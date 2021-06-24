package com.tl.dsprac.Linkedls;

public class EmpNode {
	private int num;
	private String name;
	private EmpNode next;
	public EmpNode(int num, String name) {
		this.num = num;
		this.name = name;
	}
	@Override
	public String toString() {
		return "EmpNode [num=" + num + ", name=" + name + "]";
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public EmpNode getNext() {
		return next;
	}
	public void setNext(EmpNode next) {
		this.next = next;
	}	
	 
	
}
