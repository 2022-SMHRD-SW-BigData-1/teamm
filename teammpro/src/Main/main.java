package Main;

import java.io.DataOutput;
import java.util.Scanner;

import Login.Join_login;

public class main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Join_login join_login = new Join_login();
		
		while(true) {
			System.out.println("[1]회원가입 [2]로그인 [3]랭킹확인 [4]내 등수 확인 [5]종료");
			int menu = sc.nextInt();
			
			if(menu==1) {
				System.out.println("=============회원가입=============");
				System.out.print("ID를 입력하세요 : ");
				String id = sc.next();
				System.out.print("PW를 입력하세요 : ");
				String pw = sc.next();
				System.out.print("이름을 입력하세요 : ");
				String name = sc.next();
				int cnt = join_login.join(id, pw, name);
				if (cnt > 0) {
					System.out.println("등록 성공");
				} else {
					System.out.println("등록 실패");
			    }
				else if(menu==2) {
					System.out.println("ID : ");
					String id = sc.next();
					System.out.println("PW : ");
					String pw = sc.next();
					boolean res = join_login.login(id, pw);
					if (res == true) {
						System.out.println("로그인 성공");
					} else {
						System.out.println("로그인 실패");
					}
				}
			 
		}
		
		
		
		
		
		
		
		
	}

}
