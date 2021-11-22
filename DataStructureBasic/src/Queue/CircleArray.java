package Queue;

import java.util.Scanner;

public class CircleArray {

	public static void main(String[] args) {
		boolean goloop=true;
		CircleQueue quene = new CircleQueue(4);

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
					//scanner1.close();
					break;
				case 'g':
					try{
						int getNum = quene.getNum();
						System.out.println("取出數字："+getNum);
						break;
					}catch(Exception e) {
						e.printStackTrace();
					}

				case 'h':
					try{
						int headNum = quene.getHead();
						System.out.println("首個數字："+headNum);
						break;
					}catch(Exception e) {
						e.printStackTrace();
					}
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

class CircleQueue{
	private int maxSize;
	private int front;
	private int rear;
	private int[] arrayQueue;

	public CircleQueue(int maxSize) {
		this.maxSize = maxSize;//現在把最後一個位置預留，方便環形
		arrayQueue = new int[maxSize];
		front = 0;//指向頭部,指向頭一個數字的位置
		rear = 0;//指向尾巴的數字+1(ex如果陣列數字位置在0,1,2 的2,那rear就是2+1)
	}

	public boolean isFull() {
		if ((rear+maxSize-front)%maxSize == maxSize-1) {
			return true;
		}
		return false;
		//return rear == maxSize-1;
	}
	public boolean isEmpty() {
		return (front == rear);
	}

	public void addNum(int num) {
		if (isFull()) {
			System.out.println("queue is full");
			return;
		}else {
			arrayQueue[rear] = num;
			rear=(rear+1)%maxSize;
			return;
		}

	}

	public int getNum() {
		if(isEmpty()) {
			throw new RuntimeException("array is Empty");
		}
		int getnumber = arrayQueue[front];
		front = (front+1)%maxSize;
		return getnumber;
	}

	public void showArray() {
		if(isEmpty()) {
			System.out.println("array is Empty");
			return;
		}
		for(int i = front ;i < front+getCurrentSize();i++) {
			System.out.printf("array[%d] is %d\n",i%maxSize,arrayQueue[i%maxSize]);
		}
	}

	public int getCurrentSize() {
		return (rear-front+maxSize)%maxSize;
	}
	public int getHead() {
		if(isEmpty()) {
			throw new RuntimeException("array is Empty");
		}
		return arrayQueue[front];
	}


}
