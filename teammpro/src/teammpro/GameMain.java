package teammpro;

import java.util.ArrayList;
import java.util.Scanner;

import javazoom.jl.player.MP3Player;

public class GameMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GameStart start = new GameStart();
		Loan loan = new Loan();
		MemberVO mv = null;
		BGM play = new BGM();
		
		MusicVO m1 = play.p1();
		MusicVO m2 = play.p2();
		
		System.out.println("\n"
				+ "                                                           |\\    /|\r\n"
				+ "                                                        ___| \\,,/_/\r\n"
				+ "                                                     ---__/ \\/    \\\r\n"
				+ "                                                    __--/     (D)  \\\r\n"
				+ "                                                    _ -/    (_      \\\r\n"
				+ "                                                   // /       \\_ / ==\\\r\n"
				+ "                             __-------_____--___--/           / \\_ O o)\r\n"
				+ "                            /                                 /   \\==/`\r\n"
				+ "                           /                                 /\r\n"
				+ "                          ||          )                   \\_/\\\r\n"
				+ "                          ||         /              _      /  |\r\n"
				+ "                          | |      /--______      ___\\    /\\  :\r\n"
				+ "                          | /   __-  - _/   ------    |  |   \\ \\\r\n"
				+ "                           |   -  -   /                | |     \\ )\r\n"
				+ "                           |  |   -  |                 | )     | |\r\n"
				+ "                            | |    | |                 | |    | |\r\n"
				+ "                            | |    | |                 | |   |_/\r\n"
				+ "                            | |    /__\\               |  \\\r\n"
				+ "                            /__\\                       /___\\");
		
		System.out.println("\r\n\n\n"
				+ "                       __      __       .__                             \r\n"
				+ "                      /  \\    /  \\ ____ |  |   ____  ____   _____   ____  \r\n"
				+ "                      \\   \\/\\/   // __ \\|  | _/ ___\\/  _ \\ /     \\_/ __ \\ \r\n"
				+ "                       \\        /\\  ___/|  |_\\  \\__(  <_> )  Y Y  \\  ___/ \r\n"
				+ "                        \\__/\\  /  \\___  >____/\\___  >____/|__|_|  /\\___  >\r\n"
				+ "                             \\/       \\/          \\/            \\/     \\/ ");
		
		System.out.println("\n\n\t\t\t반갑습니다! ⊂((・▽・))⊃ 스마트 H 경마장에 오신 것을 환영합니다!!");
		DAO dao = new DAO();
		
		while (true) {
		if (mv == null) {
			play.play("반갑습니다 에이치");
			System.out.println("\n\t\t\t\t     원하시는 버튼을 입력해주세요");
			System.out.print("\t\t[1] 회원가입\t[2] 로그인\t[3] 랭킹 확인하기\t    [4] 종료 >> ");
			int menu = sc.nextInt();
			
			play.play("스포츠_타이틀");
			
			if (menu == 1) {
				System.out.print("\t\t\t\t\t가입할 ID 입력 : ");
				String id = sc.next();
				
				System.out.print("\t\t\t\t\tPW 입력 : ");
				String pw = sc.next();
				
				System.out.print("\t\t\t\t\t닉네임 입력 : ");
				String nick = sc.next();
				
				int cnt = dao.join(id, pw, nick);
				
				if (cnt > 0) {
					System.out.println("\t\t\t\t\t등록 성공 ෆ⸒⸒⸜( ˶'ᵕ'˶)⸝ ");
				} else {
					System.out.println("\t\t\t\t\t등록 실패 (╯•﹏•╰) ");
				}
				
			} else if (menu == 2) {
				if(mv == null) {		
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t==================================================================");
					System.out.print("\n\t\t\t\t     로그인 ID : ");
					String id = sc.next();
					
					System.out.print("\n\t\t\t\t     Password : ");
					String pw = sc.next();
					System.out.println("\n\n\t\t==================================================================");
					
					mv = dao.login(id, pw);
				} 
			} else if (menu == 3) {
				play.play("1등등장");
				System.out.println("\n\n\n\n\n\n\r\n"
						+ "              '||'''|,      /.\\      '||\\   ||` '||  //' |''||''| '||\\   ||` .|'''''| \r\n"
						+ "               ||   ||     // \\\\      ||\\\\  ||   || //      ||     ||\\\\  ||  || .     \r\n"
						+ "               ||...|'    //...\\\\     || \\\\ ||   ||<<       ||     || \\\\ ||  || |''|| \r\n"
						+ "               || \\\\     //     \\\\    ||  \\\\||   || \\\\      ||     ||  \\\\||  ||    || \r\n"
						+ "              .||  \\\\. .//       \\\\. .||   \\||. .||  \\\\. |..||..| .||   \\||. `|....|' \r\n"
						+ "                                                                                      \r\n"
						+ "                                                                                      \r\n"
						+ "                            .|'''', '||  ||` '||''''| .|'''', '||  //' \r\n"
						+ "                            ||       ||  ||   ||   .  ||       || //   \r\n"
						+ "                            ||       ||''||   ||'''|  ||       ||<<    \r\n"
						+ "                            ||       ||  ||   ||      ||       || \\\\   \r\n"
						+ "                            `|....' .||  ||. .||....| `|....' .||  \\\\. \n");
				dao.select();
				
			} else if (menu == 4) {
					System.out.println("\n\t\t\t\t✌(‘ω’)✌ 조심히 가세요~! 다음에 또 만나요 (✌’ω’)✌");
					break;
			}	
			
		} else {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t원하시는 버튼을 입력해주세요\t[" + mv.getNickname() + "님, 포인트 : " + mv.getPoint() + "]");
		
		System.out.print("\t  [1] 게임 시작\t [2] 랭킹 확인하기\t    [3] 대출하기\t     [4] 로그아웃\t   [5] 종료 >> ");
		int menu = sc.nextInt();
		
		if (menu == 1) {
			if (mv != null) {
				mv = start.gameStart(mv);
				
			} else {
				System.out.println("\t\t\t\t\t로그인후 사용해주세요.\n");
			}
			
		} else if (menu == 2) {
			play.play("1등등장");
			System.out.println("\n\n\n\n\n\n\r\n"
					+ "              '||'''|,      /.\\      '||\\   ||` '||  //' |''||''| '||\\   ||` .|'''''| \r\n"
					+ "               ||   ||     // \\\\      ||\\\\  ||   || //      ||     ||\\\\  ||  || .     \r\n"
					+ "               ||...|'    //...\\\\     || \\\\ ||   ||<<       ||     || \\\\ ||  || |''|| \r\n"
					+ "               || \\\\     //     \\\\    ||  \\\\||   || \\\\      ||     ||  \\\\||  ||    || \r\n"
					+ "              .||  \\\\. .//       \\\\. .||   \\||. .||  \\\\. |..||..| .||   \\||. `|....|' \r\n"
					+ "                                                                                      \r\n"
					+ "                                                                                      \r\n"
					+ "                            .|'''', '||  ||` '||''''| .|'''', '||  //' \r\n"
					+ "                            ||       ||  ||   ||   .  ||       || //   \r\n"
					+ "                            ||       ||''||   ||'''|  ||       ||<<    \r\n"
					+ "                            ||       ||  ||   ||      ||       || \\\\   \r\n"
					+ "                            `|....' .||  ||. .||....| `|....' .||  \\\\. \n");
			dao.select();
			
		} else if (menu == 3) {
			loan.loan(mv);
			
		} else if (menu == 4) {
			System.out.print("\t\t\t\t\t로그아웃 하시겠습니까?\n\t\t\t\t [1] 네\t\t\t[2] 아니요 >> ");
			int out = sc.nextInt();
			
			if (out == 1) {
				mv = null;
				System.out.println("\t\t\t\t로그아웃 되었습니다! 다음에 또 만나요 (˵ ͡~ ͜ʖ ͡°˵)ﾉ\n");
			} else {
				
			}
		} else if (menu == 5) {
			System.out.println("\n\t\t\t\t✌(‘ω’)✌ 조심히 가세요~! 다음에 또 만나요 (✌’ω’)✌");
			break;
		} 
	}
}
	}
}
