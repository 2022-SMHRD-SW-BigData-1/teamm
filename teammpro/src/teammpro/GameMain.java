package teammpro;

import java.util.Scanner;

public class GameMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GameStart start = new GameStart();
		
		System.out.println("                                                        |\\    /|\r\n"
				+ "                                                     ___| \\,,/_/\r\n"
				+ "                                                  ---__/ \\/    \\\r\n"
				+ "                                                 __--/     (D)  \\\r\n"
				+ "                                                 _ -/    (_      \\\r\n"
				+ "                                                // /       \\_ / ==\\\r\n"
				+ "                          __-------_____--___--/           / \\_ O o)\r\n"
				+ "                         /                                 /   \\==/`\r\n"
				+ "                        /                                 /\r\n"
				+ "                       ||          )                   \\_/\\\r\n"
				+ "                       ||         /              _      /  |\r\n"
				+ "                       | |      /--______      ___\\    /\\  :\r\n"
				+ "                       | /   __-  - _/   ------    |  |   \\ \\\r\n"
				+ "                        |   -  -   /                | |     \\ )\r\n"
				+ "                        |  |   -  |                 | )     | |\r\n"
				+ "                         | |    | |                 | |    | |\r\n"
				+ "                         | |    | |                 | |   |_/\r\n"
				+ "                         | |    /__\\               |  \\\r\n"
				+ "                         /__\\                       /___\\");
		
		System.out.println("\r\n"
				+ "                         __      __       .__                               \r\n"
				+ "                        /  \\    /  \\ ____ |  |   ____  ____   _____   ____  \r\n"
				+ "                        \\   \\/\\/   // __ \\|  | _/ ___\\/  _ \\ /     \\_/ __ \\ \r\n"
				+ "                         \\        /\\  ___/|  |_\\  \\__(  <_> )  Y Y  \\  ___/ \r\n"
				+ "                          \\__/\\  /  \\___  >____/\\___  >____/|__|_|  /\\___  >\r\n"
				+ "                               \\/       \\/          \\/            \\/     \\/ ");
		
		System.out.println("\n반갑습니다! ⊂((・▽・))⊃ 스마트 H 경마장에 오신 것을 환영합니다!!");
		
		while (true) {
			
		System.out.print("\n원하시는 버튼을 입력해주세요\n[1] 회원가입 [2] 로그인 [3] 게임 시작 [4] 랭킹 확인하기 [5] 대출하기 [6] 종료 >> ");
		int menu = sc.nextInt();
		
		if (menu == 1) {
			
		} else if (menu == 2) {
			
		} else if (menu == 3) {
			start.gameStart();
			
		} else if (menu == 4) {
			
		} else if (menu == 5) {
			
		} else if (menu == 6) {
			System.out.println("\n✌(‘ω’)✌ 조심히 가세요~! 다음에 또 만나요 (✌’ω’)✌");
			break;
		}
		}
	}

}
