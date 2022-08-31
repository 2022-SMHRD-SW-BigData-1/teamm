package teammpro;

import java.util.Scanner;

public class EKtest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("A 입력 : ");
		int a = sc.nextInt();

		System.out.print("B 입력 : ");
		int b = sc.nextInt();
		
		System.out.print("연산자 입력 : ");
		String c = sc.next();
		
		int result = 0;
		switch (c) {
		case "+":
			result = a+b;
			break;
		case "-":
			result = a-b;
			break;
		case "*":
			result = a*b;
			break;
		case "/":
			result = a/b;
			break;
		default:
			break;
		}
		System.out.println(a + c + b + "=" + result);
	}

}
