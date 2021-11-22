package josepfu;

public class Soldier {
	
	private int num;
	
	private Soldier next;

	public Soldier(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Soldier getNext() {
		return next;
	}

	public void setNext(Soldier next) {
		this.next = next;
	}
	
	
}
