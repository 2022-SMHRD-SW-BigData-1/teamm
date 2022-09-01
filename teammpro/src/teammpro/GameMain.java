package teammpro;

import java.util.Scanner;

public class GameMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GameStart start = new GameStart();
		Loan loan = new Loan();
		MemberVO mv =null;
		
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
		DAO dao = new DAO();
		
		while (true) {
		if(mv==null) {
			System.out.println("\n원하시는 버튼을 입력해주세요");
		}else {
			System.out.println("\n원하시는 버튼을 입력해주세요\t["+mv.getNickname()+"님, 포인트 : "+mv.getPoint()+"]");
		}
		
		System.out.print("[1] 회원가입 [2] 로그인 [3] 게임 시작 [4] 랭킹 확인하기 [5] 대출하기 [6] 종료 >> ");
		int menu = sc.nextInt();
		
		if (menu == 1) {
			System.out.print("가입할 ID 입력 : ");
			String id = sc.next();
			
			System.out.print("PW 입력 : ");
			String pw = sc.next();
			
			System.out.print("닉네임 입력 : ");
			String nick = sc.next();
			
			int cnt = dao.join(id, pw, nick);
			
			if (cnt > 0) {
				System.out.println("등록 성공");
			} else {
				System.out.println("등록 실패");
			}
			
		} else if (menu == 2) {
			if(mv==null) {				
				System.out.print("로그인 ID : ");
				String id = sc.next();
				
				System.out.print("PW : ");
				String pw = sc.next();
				
				mv = dao.login(id, pw);
			}else {
				System.out.println("이미 로그인 되어있습니다.");
			}
			
			
			
		} else if (menu == 3) {
			if(mv!=null) {
				mv = start.gameStart(mv);
				
			}else {
				System.out.println("로그인후 사용해주세요");
			}
			
		} else if (menu == 4) {
			System.out.println("    '||'''|,      /.\\      '||\\   ||` '||  //' |''||''| '||\\   ||` .|'''''| \r\n"
					+ "     ||   ||     // \\\\      ||\\\\  ||   || //      ||     ||\\\\  ||  || .     \r\n"
					+ "     ||...|'    //...\\\\     || \\\\ ||   ||<<       ||     || \\\\ ||  || |''|| \r\n"
					+ "     || \\\\     //     \\\\    ||  \\\\||   || \\\\      ||     ||  \\\\||  ||    || \r\n"
					+ "    .||  \\\\. .//       \\\\. .||   \\||. .||  \\\\. |..||..| .||   \\||. `|....|' \r\n"
					+ "                                                                            \r\n"
					+ "                                                                            \r\n"
					+ "                  .|'''', '||  ||` '||''''| .|'''', '||  //' \r\n"
					+ "                  ||       ||  ||   ||   .  ||       || //   \r\n"
					+ "                  ||       ||''||   ||'''|  ||       ||<<    \r\n"
					+ "                  ||       ||  ||   ||      ||       || \\\\   \r\n"
					+ "                  `|....' .||  ||. .||....| `|....' .||  \\\\.");
			dao.select();
			
		} else if (menu == 5) {
			loan.loan(mv);
			
		} else if (menu == 6) {
			System.out.println("\n✌(‘ω’)✌ 조심히 가세요~! 다음에 또 만나요 (✌’ω’)✌");
			break;
		}
		}
	}

}
