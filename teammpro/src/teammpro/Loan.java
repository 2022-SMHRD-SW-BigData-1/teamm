package teammpro;

import java.util.Scanner;

public class Loan {
	
	public void loan() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\r\n"
				+ "                         '||\\   /||` .|''''|, '||\\   ||` '||''''| '\\\\  //` \r\n"
				+ "                          ||\\\\.//||  ||    ||  ||\\\\  ||   ||   .    \\\\//   \r\n"
				+ "                          ||     ||  ||    ||  || \\\\ ||   ||'''|     ||    \r\n"
				+ "                          ||     ||  ||    ||  ||  \\\\||   ||         ||    \r\n"
				+ "                         .||     ||. `|....|' .||   \\||. .||....|   .||.   \r\n"
				+ "                                                                           ");
		System.out.println("안녕하세요 ๑╹ワ╹๑ ~ 무슨 일로 오셨나요?");
		System.out.println("[1] 포인트 빌리기 [2] 빌린 포인트 반납 [3] 나가기 >> ");
		int menu = sc.nextInt();
		
		while (true) {
			if (menu == 1) {
				System.out.print("몇 포인트 필요하세요? >> ");
				int d = sc.nextInt();
			} else if (menu == 2) {
				System.out.println("");
			} else if (menu == 3) {
				break;
			}
		}
		
	}
}
