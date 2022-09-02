package teammpro;

import java.util.Scanner;

public class Loan {
	Scanner sc = new Scanner(System.in);
	LoanDAO ldao = new LoanDAO();
	LoanVO lv = null;
	
	public void loan(MemberVO mv) {
		lv = ldao.Loancheck(mv ,lv);
		System.out.println("\r\n"
				+ "                         '||\\   /||` .|''''|, '||\\   ||` '||''''| '\\\\  //` \r\n"
				+ "                          ||\\\\.//||  ||    ||  ||\\\\  ||   ||   .    \\\\//   \r\n"
				+ "                          ||     ||  ||    ||  || \\\\ ||   ||'''|     ||    \r\n"
				+ "                          ||     ||  ||    ||  ||  \\\\||   ||         ||    \r\n"
				+ "                         .||     ||. `|....|' .||   \\||. .||....|   .||.   \r\n"
				+ "                                                                           ");
		System.out.println("안녕하세요 ๑╹ワ╹๑ ~ 무슨 일로 오셨나요?");
		
		while (true) {
		System.out.println(mv.getNickname()+"님의 현재 포인트 : "+mv.getPoint()+"체납 포인트 : "+(lv==null?0:lv.getPoint()));
		System.out.print("[1] 포인트 빌리기 [2] 빌린 포인트 반납 [3] 나가기 >> ");
		
		int menu = sc.nextInt();
		
			if (menu == 1) {
				if(mv.getPoint()==0) {
					System.out.print("앗!! 포인트가 얼마나 필요하신가요? 최대 10p >> ");
					int p1 = sc.nextInt();
					if(p1<=10) {
						ldao.outShare(mv, p1,lv);
						System.out.println(p1 + "p 지급 완료!\n현재 잔여 포인트 : " + mv.getPoint()  + "p");
						mv.setPoint(mv.getPoint());					
					}else {
						System.out.println("10포인트 이상 삽입금지");
					}
				}else {
					System.out.println("0 포인트 때만 빌릴수 있습니다.");
				}
				
			} else if (menu == 2) {
				System.out.print("가져오신 포인트를 입력해주세요 >> ");
				int p2 = sc.nextInt();
				if(p2<=mv.getPoint()) {
					ldao.getShare(mv, p2, lv);
					System.out.println(p2 + "p 반납 완료!\n현재 잔여 포인트 : " + mv.getPoint()  + "p");
					mv.setPoint(mv.getPoint());
				}
			} else if (menu == 3) {
				break;
			}
		}
	}
}
