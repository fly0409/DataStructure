package test;

public class Mytest {

	public static void main(String[] args) {
		Cat c1 = new Cat("kitty");
		Cat c2 = c1;
		
		System.out.println(c1.getCatName());
		c2.setCatName("meow");
		System.out.println(c2.getCatName());
		System.out.println(c1.getCatName());
	}

}

class Cat{
	private String catName;

	public Cat(String catName) {
		super();
		this.catName = catName;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}
	
	
	
}