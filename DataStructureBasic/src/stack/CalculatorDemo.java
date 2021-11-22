package stack;

public class CalculatorDemo {

	public static void main(String[] args) {
		
		StackArrayCal numStack= new StackArrayCal(10);
		StackArrayCal operStack= new StackArrayCal(10);
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		String formula = "80+(3*(10-20))";
		char ch =' ';
		
		for(int i = 0 ; i< formula.length();i++) {
			//把第i個字讀進來
			ch = formula.charAt(i);
			//判斷讀進的來是否為運算元
			if(numStack.isOper(ch)) {
				//如果運算元欄位不是空的話
				if(!operStack.isEmpty()) {
					//判斷是否為括號case
					if(numStack.isRightBracket(ch)) {
						while(true) {							
							oper=operStack.pop();
							if(oper=='(') {
								break;
							}
							num2=numStack.pop();
							num1=numStack.pop();
							numStack.push(numStack.calculate(num1, num2, oper));
							System.out.println(numStack.calculate(num1, num2, oper));
						}
						//判斷優先級別,如果要進來的優先級別小於在stack裡面的，則把數字stack裡的兩個值抓出來運算，再把oper放入
						//如果是看到的是左括號則不要理他
					}else if(operStack.judgeOrder(ch)<operStack.judgeOrder(operStack.peek())&&operStack.peek()!='(') {
						num2=numStack.pop();
						num1=numStack.pop();
						oper= operStack.pop();		
						numStack.push(numStack.calculate(num1, num2, oper));
						operStack.push(ch);
					
					
					
					}else {
						operStack.push(ch);
					}


					//如果是空的話,就職街坊進去operStack
				}else {
					operStack.push(ch);
				}
				//不是運算元則為數字
			}else {
				String number="";
				number+=ch;
				while(i<formula.length()-1) {					
					char nextnum = formula.charAt(i+1);
					if(numStack.isOper(nextnum)) {
						break;				
					}else {
						number+=nextnum;
						i++;
					}
				}
				
				numStack.push(Integer.parseInt(number));
			}
		}
		numStack.viewStack();
		operStack.viewStack();
		//把stack內運算元處理完畢
		while (true) {
			if (operStack.isEmpty()){
				break;
			}
			num2=numStack.pop();
			num1=numStack.pop();
			char opr = (char) operStack.pop();
			numStack.push(numStack.calculate(num1, num2, opr));
		}
		
		System.out.println("ans is :" + numStack.pop());
		
		
		
	}	
}
