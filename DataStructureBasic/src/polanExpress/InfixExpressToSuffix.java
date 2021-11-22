package polanExpress;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InfixExpressToSuffix {
	/*演算法
	1.初始化兩個stack
	2.從左而右掃過中綴
	3.遇到數字則push進s2
	4.s1為空或為左括號時，直接把運算子放入s1
		若不是=>優先及大於頂層，直接放入
		若不是=>將s1頂的送到s2,並重複一次第4部
	5.遇到括號
		左括號=>直接進s1
		右括號=>依次彈s1直到左括號
	6.重複
	7.將s1剩餘的通通弄到s2去，在把s2反向
	*/
	
	String infixExpress;
	
	public InfixExpressToSuffix(String express) {
		this.infixExpress = express;
	}
	
	public List<String> infixStringToList(String str){
		ArrayList<String> infix = new ArrayList<String>();
		str=str.trim();
		for(int i =0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch<48||ch>57) {
				infix.add(ch+"");
			}else if (ch>=48&&ch<=57) {
				String num=ch+"";
				while(i<str.length()-1) {
					char ch2 = str.charAt(i+1);
					if(ch2>=48&&ch2<=57) {
						num+=ch2+"";
						i++;
					}else {
						break;
					}
				}
				infix.add(num);
			}else {
				System.out.println("something wrong");
			}			
		}		
		return infix;
	}
	
	public List<String> infixListToSuffix(){
		List<String> infixArray = infixStringToList(infixExpress);
		ArrayList<String> suffixArray = new ArrayList<String>();   
		Stack<String> bufferStack = new Stack<String>();
		for(String strTemp :infixArray) {
			if(strTemp.matches("\\d+")) {
				suffixArray.add(strTemp);
				
			}else {
				while(true) {
					if(bufferStack.isEmpty()||bufferStack.peek().equals("(")||strTemp.equals("(")) {
						bufferStack.push(strTemp);
						break;
					}else if(strTemp.equals(")")) {
						while(!bufferStack.peek().equals("(")) {
							suffixArray.add(bufferStack.pop());
						}
						bufferStack.pop();
						break;
					}else if(checkOrder(strTemp)<checkOrder(bufferStack.peek())) {
						suffixArray.add(bufferStack.pop());
					}else {
						bufferStack.push(strTemp);
						break;
					}
					
				}			
			}
			
			
		}
		while(!bufferStack.isEmpty()) {
			suffixArray.add(bufferStack.pop());
		}
		
		return suffixArray;
		
		
	}
	
	
	public int checkOrder(String str) {
		switch(str) {
		case "+":
			return 1;
		case "-":
			return 1;
		case "*":
			return 2;
		case "/":
			return 2;
		case "(":
			return 3;
		case ")":
			return 3;
		default:
			System.out.println("check order fail");
			return 0;
		}		
	}
	
}
