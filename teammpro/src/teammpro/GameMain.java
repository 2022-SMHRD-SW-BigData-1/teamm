package teammpro;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\r\n\n\n"
				+ "                       __      __       .__                             \r\n"
				+ "                      /  \\    /  \\ ____ |  |   ____  ____   _____   ____  \r\n"
				+ "                      \\   \\/\\/   // __ \\|  | _/ ___\\/  _ \\ /     \\_/ __ \\ \r\n"
				+ "                       \\        /\\  ___/|  |_\\  \\__(  <_> )  Y Y  \\  ___/ \r\n"
				+ "                        \\__/\\  /  \\___  >____/\\___  >____/|__|_|  /\\___  >\r\n"
				+ "                             \\/       \\/          \\/            \\/     \\/ ");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n\n\t\t\t???????????????! ???((?????????))??? ????????? H ???????????? ?????? ?????? ???????????????!!");
		play.play("??????????????? ?????????");
		DAO dao = new DAO();
		
		while (true) {
		if (mv == null) {
			System.out.println("\n\t\t\t\t     ???????????? ????????? ??????????????????");
			System.out.print("\t\t[1] ????????????\t[2] ?????????\t[3] ?????? ????????????\t    [4] ?????? >> ");
			int menu = sc.nextInt();
			
			play.play("?????????_?????????");
			
			if (menu == 1) {
				System.out.print("\t\t\t\t\t????????? ID ?????? : ");
				String id = sc.next();
				
				System.out.print("\t\t\t\t\tPW ?????? : ");
				String pw = sc.next();
				
				System.out.print("\t\t\t\t\t????????? ?????? : ");
				String nick = sc.next();
				
				int cnt = dao.join(id, pw, nick);
				
				if (cnt > 0) {
					System.out.println("\t\t\t\t\t?????? ?????? ????????????( ??'???'??)??? ");
				} else {
					System.out.println("\t\t\t\t\t?????? ?????? (???????????????) ");
				}
				
			} else if (menu == 2) {
				if(mv == null) {		
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t==================================================================");
					System.out.print("\n\t\t\t\t     ????????? ID : ");
					String id = sc.next();
					
					System.out.print("\n\t\t\t\t     Password : ");
					String pw = sc.next();
					System.out.println("\n\n\t\t==================================================================");
					
					mv = dao.login(id, pw);
				} 
			} else if (menu == 3) {
				play.play("?????????");
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
					System.out.println("\n\t\t\t\t???(????????)??? ????????? ?????????~! ????????? ??? ????????? (???????????)???");
					break;
			}	
			
		} else {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t???????????? ????????? ??????????????????\t[" + mv.getNickname() + "???, ????????? : " + mv.getPoint() + "]");
		
		System.out.print("\t  [1] ?????? ??????\t [2] ?????? ????????????\t    [3] ????????????\t     [4] ????????????\t   [5] ?????? >> ");
		int menu = sc.nextInt();
		
		if (menu == 1) {
			if (mv != null) {
				mv = start.gameStart(mv);
			} else {
				System.out.println("\t\t\t\t\t???????????? ??????????????????.\n");
			}
			
		} else if (menu == 2) {
			play.play("?????????");
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
			System.out.print("\t\t\t\t\t???????????? ???????????????????\n\t\t\t\t [1] ???\t\t\t[2] ????????? >> ");
			int out = sc.nextInt();
			
			if (out == 1) {
				mv = null;
				System.out.println("\t\t\t\t???????????? ???????????????! ????????? ??? ????????? (?? ??~ ???? ??????)???\n");
			} else {
				
			}
		} else if (menu == 5) {
			System.out.println("\n\t\t\t\t???(????????)??? ????????? ?????????~! ????????? ??? ????????? (???????????)???");
			break;
		} 
	}
}
	}
}
