package teammpro;

import java.util.concurrent.TimeUnit;

public class HorseGame {
		public RANK gamePlay() {
			
		RANK rk = new RANK();
		Horse ho1 = new Horse(" 1.훌라밍고🐎");
		Horse ho2 = new Horse(" 2.심장의고동🐎");
		Horse ho3 = new Horse(" 3.청담도끼🐎");
		Horse ho4 = new Horse(" 4.경부대로🐎");
		Horse ho5 = new Horse(" 5.지금이순간🐎");
		int count =0;
		int rank =0;
		boolean check= false;
		
		while(true) {
			System.out.println("====================================");
			System.out.println("====================================");
			System.out.println("====================================");
			if(ho1.getCheck()) {
				count += ho1.horse(rk);
				System.out.println();				
			}
			else {
				System.out.println("1번말(훌라밍고) 도착"+(rk.getRank(ho1.getName())+1)+"등");
				
			}
			if(ho2.getCheck()) {
				count += ho2.horse(rk);
				System.out.println();				
			}else {
				System.out.println("2번말(심장의고동) 도착"+(rk.getRank(ho2.getName())+1)+"등");
			}
			if(ho3.getCheck()) {
				count += ho3.horse(rk);
				System.out.println();				
			}else {
				System.out.println("3번말(청담도끼) 도착"+(rk.getRank(ho3.getName())+1)+"등");
			}
			if(ho4.getCheck()) {
				count += ho4.horse(rk);
				System.out.println();				
			}else {
				System.out.println("4번말(경부대로) 도착"+(rk.getRank(ho4.getName())+1)+"등");
			}
			if(ho5.getCheck()) {
				count += ho5.horse(rk);
				System.out.println();				
			}else {
				System.out.println("5번말(지금이순간) 도착"+(rk.getRank(ho5.getName())+1)+"등");
			}
			System.out.println("====================================");
			System.out.println("====================================");
			System.out.println("====================================");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(check) {
				break;
			}
			if(count==5) {
				check=true;
			}
		}
		for (int i =0;i<5;i++) {
			System.out.println((i+1)+"등"+rk.getHorse()[i]);
		}
		return rk;
	}
	
}
