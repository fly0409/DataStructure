package com.tl.polanExpress;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InfixExpressToSuffix {
	//�t��k
	/*
	1.��l�ƨ��stack
	2.�q���ӥk���L����
	3.�J��Ʀr�hpush�is2
	4.s1���ũά����A���ɡA������B��l��Js1
		�Y���O=>�u���Τj�󳻼h�A������J
		�Y���O=>�Ns1�����e��s2,�í��Ƥ@����4��
	5.�J��A��
		���A��=>�����is1
		�k�A��=>�̦��us1���쥪�A��
	6.����
	7.�Ns1�Ѿl���q�q�˨�s2�h�A�b��s2�ϦV
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
