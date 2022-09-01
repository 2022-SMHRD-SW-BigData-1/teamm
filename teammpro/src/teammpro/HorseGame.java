package teammpro;

import java.util.concurrent.TimeUnit;

public class HorseGame {
		public RANK gamePlay() {
		// TODO Auto-generated method stub
		RANK rk = new RANK();
		Horse ho1 = new Horse("h1");
		Horse ho2 = new Horse("h2");
		Horse ho3 = new Horse("h3");
		Horse ho4 = new Horse("h4");
		Horse ho5 = new Horse("h5");
		int count =0;
		int rank =0;
		boolean check= false;
		while(true) {
			System.out.println("=======================================================");
			if(ho1.getCheck()) {
				count += ho1.horse(rk);
				System.out.println();				
			}
			else {
				System.out.println("1번말 도착"+(rk.getRank("h1")+1)+"등");
				
			}
			if(ho2.getCheck()) {
				count += ho2.horse(rk);
				System.out.println();				
			}else {
				System.out.println("2번말 도착"+(rk.getRank("h2")+1)+"등");
			}
			if(ho3.getCheck()) {
				count += ho3.horse(rk);
				System.out.println();				
			}else {
				System.out.println("3번말 도착"+(rk.getRank("h3")+1)+"등");
			}
			if(ho4.getCheck()) {
				count += ho4.horse(rk);
				System.out.println();				
			}else {
				System.out.println("4번말 도착"+(rk.getRank("h4")+1)+"등");
			}
			if(ho5.getCheck()) {
				count += ho5.horse(rk);
				System.out.println();				
			}else {
				System.out.println("5번말 도착"+(rk.getRank("h5")+1)+"등");
			}
			System.out.println("=======================================================");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(check) {
				break;
			}
			if(count==5) {
				check=true;
			}
		}
		for(int i =0;i<5;i++) {
			
			System.out.println((i+1)+"등"+rk.getHorse()[i]);
		}
		return rk;
	}
	
}
