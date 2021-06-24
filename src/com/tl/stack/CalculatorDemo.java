package com.tl.stack;

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
			//���i�ӦrŪ�i��
			ch = formula.charAt(i);
			//�P�_Ū�i���ӬO�_���B�⤸
			if(numStack.isOper(ch)) {
				//�p�G�B�⤸��줣�O�Ū���
				if(!operStack.isEmpty()) {
					//�P�_�O�_���A��case
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
						//�P�_�u���ŧO,�p�G�n�i�Ӫ��u���ŧO�p��bstack�̭����A�h��Ʀrstack�̪���ӭȧ�X�ӹB��A�A��oper��J
						//�p�G�O�ݨ쪺�O���A���h���n�z�L
					}else if(operStack.judgeOrder(ch)<operStack.judgeOrder(operStack.peek())&&operStack.peek()!='(') {
						num2=numStack.pop();
						num1=numStack.pop();
						oper= operStack.pop();		
						numStack.push(numStack.calculate(num1, num2, oper));
						operStack.push(ch);
					
					
					
					}else {
						operStack.push(ch);
					}
					
					
				//�p�G�O�Ū���,�N¾��{�i�hoperStack
				}else {
					operStack.push(ch);
				}
			//���O�B�⤸�h���Ʀr	
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
		//��stack���B�⤸�B�z����
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
