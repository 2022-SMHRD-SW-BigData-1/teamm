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
		System.out.print("[1] 포인트 빌리기 [2] 빌린 포인트 반납 [3] 나가기 >> ");
		int menu = sc.nextInt();
		int p0 = 0;
		
		while (true) {
			if (menu == 1) {
				System.out.print("앗!! 포인트가 얼마나 필요하신가요? >> ");
				int p1 = sc.nextInt();
				System.out.println(p1 + "p 지급 완료!\n현재 잔여 포인트 : " + (p0 + p1) + "p");
			} else if (menu == 2) {
				System.out.print("가져오신 포인트를 입력해주세요 >> ");
				int p2 = sc.nextInt();
				System.out.println(p2 + "p 반납 완료!\n현재 잔여 포인트 : " + (p0 - p2) + "p");
			} else if (menu == 3) {
				break;
			}
		}
		
	}
}
