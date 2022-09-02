package teammpro;

import java.util.Scanner;

public class GameStart {

	public MemberVO gameStart(MemberVO mv) {
		Scanner sc = new Scanner(System.in);
		HorseGame game = new HorseGame();
		RANK ranking = null;
		DAO dao = new DAO();

		while(true) {
			System.out.print("\n게임을 시작하시겠습니까?\n[1]네 [2]아니요 >> ");
			int start = sc.nextInt();
		
			if (start == 1) {
				System.out.println("\r\n"
						+ "                         ________    _____      _____  ___________\r\n"
						+ "                        /  _____/   /  _  \\    /     \\ \\_   _____/\r\n"
						+ "                       /   \\  ___  /  /_\\  \\  /  \\ /  \\ |    __)_ \r\n"
						+ "                       \\    \\_\\  \\/    |    \\/    Y    \\|        \\\r\n"
						+ "                        \\______  /\\____|__  /\\____|__  /_______  /\r\n"
						+ "                               \\/         \\/         \\/        \\/ \r\n"
						+ "                         _________________________ _____________________\r\n"
						+ "                        /   _____/\\__    ___/  _  \\\\______   \\__    ___/\r\n"
						+ "                        \\_____  \\   |    | /  /_\\  \\|       _/ |    |   \r\n"
						+ "                        /        \\  |    |/    |    \\    |   \\ |    |   \r\n"
						+ "                       /_______  /  |____|\\____|__  /____|_  / |____|   \r\n"
						+ "                               \\/                 \\/       \\/         ");
			System.out.println("🐎 말을 선택해주세요 🐎");
			System.out.print("[1] 1번 말 : 훌라밍고\n"
					+ "[2] 2번 말 : 심장의고동\n"
					+ "[3] 3번 말 : 청담도끼\n"
					+ "[4] 4번 말 : 경부대로\n"
					+ "[5] 5번 말 : 지금이순간\n원하는 말의 번호 : ");
			int choice = sc.nextInt();
			System.out.println(choice + "번 말 선택완료!");
			
			String horse_name = null;
			if(choice==1) {
				horse_name =" 1.훌라밍고🐎";
			}
			else if(choice ==2) {
				horse_name =" 2.심장의고동🐎";
			}
			else if(choice ==2) {
				horse_name =" 3.청담도끼🐎";
			}
			else if(choice ==2) {
				horse_name =" 4.경부대로🐎";
			}
			else if(choice ==2) {
				horse_name =" 5.지금이순간🐎";
			}
		
			System.out.print("\n💸 배팅하실 포인트를 입력해주세요 💸\n배팅 금액 : ");
			int point = sc.nextInt();
				if(mv.getPoint()<point) {				
					System.out.println(point + "p 배팅하였습니다!\n행운을 빕니다...☘");
				
						ranking = game.gamePlay();
					if(ranking.getHorse()[0].equals(horse_name)) {
					
					}else if(ranking.getHorse()[1].equals(horse_name)){
						point = (int) (point/2);
					}else if(ranking.getHorse()[2].equals(horse_name)) {
						point = 0;
					}
					else {
						point = -point;
					}
					mv = dao.minus_point(mv, point);
					System.out.println(mv.getNickname()+"님의 현재 포인트 : " + mv.getPoint());
				}else {
					System.out.println("배팅 포인트 부족");
				}
				
			} else {
				break;
			}
		}
		return mv;
	}
}
