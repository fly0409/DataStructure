package com.tl.polanExpress;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolanExpress {

	public static void main(String[] args) {
		
		//後綴(逆波蘭)表達式
		//等於(3+5)*5-6
		String suffixExpression = "3 4 + 5 * 6 -";		
		List<String> expression = strToList(suffixExpression);		
		System.out.println(expression);	
		int res = calculate(expression);
		System.out.println("result is:"+res);
		
		//用中綴轉後墜並算出答案
	
		String infix = "20-((8+7)*6)/2";
		InfixExpressToSuffix infixTrans = new InfixExpressToSuffix(infix);
		List<String> arr = infixTrans.infixListToSuffix();
		System.out.println(arr);
		int res2 = calculate(arr);
		System.out.println("result is:"+res2);
	}
	
	
	public static List<String> strToList(String str){		
		String[] strSplit = str.split(" ");
		List<String> expression = new ArrayList<String>();
		for(String strs:strSplit) {
			expression.add(strs);
		}
		return expression;
	}

	
	public static int calculate(List<String> expression) {
		Stack<String> buffer = new Stack<>();
		for(String str:expression) {
			if(str.matches("\\d+")) {
				buffer.push(str);
			}else {
				int res=0;
				String operator = str;
				int num2 = Integer.parseInt(buffer.pop()) ;
				int num1 = Integer.parseInt(buffer.pop()) ;
				switch(operator) {
				case "+":
					res=num1+num2;
					break;
				case "-":
					res=num1-num2;
					break;
				case "*":
					res=num1*num2;
					break;
				case "/":
					res=num1/num2;
					break;
				default:
					throw new RuntimeException("operator error");
				}
				buffer.push(""+res);
			}
		}
		
		int result = Integer.parseInt(buffer.pop()) ;
		
		return result;
	}
}
