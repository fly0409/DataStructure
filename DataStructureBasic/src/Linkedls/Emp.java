package Linkedls;

public class Emp {
	private int num;
	private String name;
	private Emp next;
	public Emp(int num, String name) {
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
	public Emp getNext() {
		return next;
	}
	public void setNext(Emp next) {
		this.next = next;
	}	
	 
	
}
