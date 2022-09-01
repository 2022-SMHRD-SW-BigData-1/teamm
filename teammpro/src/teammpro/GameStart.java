package teammpro;

import java.util.Scanner;

public class GameStart {

	public void gameStart() {
		Scanner sc = new Scanner(System.in);
		HorseGame game = new HorseGame();
		RANK ranking = null;

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
					+ "[2] 2번 말 : 심장의 고동\n"
					+ "[3] 3번 말 : 청담도끼\n"
					+ "[4] 4번 말 : 경부대로\n"
					+ "[5] 5번 말 : 지금이순간\n원하는 번호의 말 : ");
			int choice = sc.nextInt();
			System.out.println(choice + "번 말 선택완료!");
		
			System.out.print("\n💸 배팅하실 포인트를 입력해주세요 💸\n배팅 금액 : ");
			int point = sc.nextInt();
			System.out.println(point + "p 배팅하였습니다!\n행운을 빕니다...☘");
		
			ranking = game.gamePlay();
			
		
			} else {
				break;
			}
		}
	}
}
