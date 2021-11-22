package polanExpress;

import java.util.List;

public class SuffixMain {

	public static void main(String[] args) {
		String infix = "3+(20-5)*8";
		InfixExpressToSuffix infixTrans = new InfixExpressToSuffix(infix);
		List<String> arr = infixTrans.infixListToSuffix();
		System.out.println(arr);
	}

}
