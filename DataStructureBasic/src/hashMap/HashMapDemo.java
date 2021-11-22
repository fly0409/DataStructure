package hashMap;

import java.util.ArrayList;
import java.util.List;

public class HashMapDemo {

	public static void main(String[] args) {
		MyHashMap map = new MyHashMap();
		Emp e1 = new Emp(1,"aaa");
		Emp e2 = new Emp(2,"bbb");
		Emp e3 = new Emp(3,"ccc");
		Emp e4 = new Emp(11,"ddd");
		
		map.addMap(e1);
		map.addMap(e2);
		map.addMap(e3);
		map.addMap(e4);
		
		map.showMap();
	}

}

class MyHashMap{
	private int length = 10;
	private ArrayList[] index;
	
	public MyHashMap() {
		this.index = new ArrayList[length];
		for (int i = 0 ;i<length ; i++) {
			index[i] = new ArrayList<Emp>();
		}
	}
	
	public void showMap() {
		for (int i = 0 ;i<length ; i++) {
			List<Emp> x = index[i];
			System.out.print("The"+(i+1)+"list:");
			for(Emp j :x) {				
				System.out.print(j );
			}
			System.out.println();
		}		
	}
	
	public void addMap(Emp emp) {
		int id = judge(emp.getEmpid());
		index[id].add(emp);
	}
	
	public int judge(int id) {
		return id%10;
	}
}
class Emp{
	private int empid;
	private String name;
	public Emp(int id,String name) {
		this.empid=id;
		this.name= name;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Emp [empid=" + empid + ", name=" + name + "]";
	}
	
	
}