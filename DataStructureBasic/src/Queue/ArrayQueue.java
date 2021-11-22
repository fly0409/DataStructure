package Queue;

import java.util.Scanner;
/*實作Quene
 * 利用Array 建立兩個指標 rear 和front
 */


public class ArrayQueue {

	public static void main(String[] args) {
		boolean goloop=true;
		Queue quene = new Queue(3);
		
		while(goloop) {
			char s;
			System.out.println("選擇以下動作");
			System.out.println("a(add):新增數字");
			System.out.println("g(get):取得數字");
			System.out.println("h(head):觀看首位");
			System.out.println("s(show):觀看陣列");
			System.out.println("e(exit):離開");
			Scanner scanner = new Scanner(System.in);
			s=scanner.next().charAt(0);
			switch(s) {
			case 'a':
				System.out.println("輸入數字");
				Scanner scanner1 = new Scanner(System.in);
				int addNum = scanner1.nextInt();
				quene.addNum(addNum);
				break;
			case 'g':
				int getNum = quene.getNum();
				System.out.println("取出數字："+getNum);
				break;
			case 'h':
				int headNum = quene.getHead();
				System.out.println("首個數字："+headNum);
				break;
			case 's':
				quene.showArray();
				break;
			case 'e':
				goloop=false;
				scanner.close();
				break;
			default:
				break;
			}
			
			
		}
		System.out.println("確認離開");
		
		
	}
	

	

}
class Queue{
	private int maxSize;
	private int front;
	private int rear;
	private int[] arrayQueue;
	
	public Queue(int maxSize) {
		this.maxSize = maxSize;
		arrayQueue = new int[maxSize];
		front = -1;//指向頭部,指向前一個位置
		rear = -1;//指向尾巴,就是array最後一個
	}
	
	public boolean isFull() {
		if (rear == maxSize-1) {
			return true;
		}
		return false;
		//return rear == maxSize-1;
	}
	
	public boolean isEmpty() {
		if (front == rear) {
			return true;
		}
		return false;
	}
	
	public void addNum(int num) {
		if (isFull()) {
			System.out.println("queue is full");
			return;
		}else {
			rear++;
			arrayQueue[rear] = num;
			return;
		}		
	
	}
	
	public int getNum() {
		if(isEmpty()) {
			throw new RuntimeException("array is Empty");
		}
		front++;
		int getnumber = arrayQueue[front];
		return getnumber;
	}
	
	public void showArray() {
		if(isEmpty()) {
			System.out.println("array is Empty");
			return;
		}
		for(int i = front+1 ;i <maxSize;i++) {
			System.out.printf("array[%d] is %d\n",i,arrayQueue[i]);
		}
	}
	public int getHead() {
		if(isEmpty()) {
			throw new RuntimeException("array is Empty");
		}
		return arrayQueue[front+1];
	}
	
	
	
	
}

