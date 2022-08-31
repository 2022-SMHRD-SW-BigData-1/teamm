package teammpro;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int result = 0;
		System.out.print("A 입력 : ");
		int A = sc.nextInt();
		System.out.print("B 입력 : ");
		int B = sc.nextInt();
		while(A<B) {
			result = B-A;
			System.out.println(result);
			break;
		}
	}

}
