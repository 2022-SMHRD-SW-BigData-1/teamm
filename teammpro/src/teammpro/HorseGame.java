package teammpro;

import java.util.concurrent.TimeUnit;

public class HorseGame {
	public RANK gamePlay() {
		RANK rk = new RANK();
		Horse ho1 = new Horse(" 1.νλΌλ°κ³ π");
		Horse ho2 = new Horse(" 2.μ¬μ₯μκ³ λπ");
		Horse ho3 = new Horse(" 3.μ²­λ΄λλΌπ");
		Horse ho4 = new Horse(" 4.κ²½λΆλλ‘π");
		Horse ho5 = new Horse(" 5.μ§κΈμ΄μκ°π");
		int count = 0;
		boolean check = false;

		while (true) {
			System.out.println("\n\n\n\n\n\n\n\n\n\n==============================================================");
			System.out.println("==============================================================");
			System.out.println("==============================================================\n\n\n\n\n\n\n\n");

			if (ho1.getCheck()) {
				count += ho1.horse(rk);
				System.out.println();
			} else {
				System.out.println("1λ²λ§(νλΌλ°κ³ ) λμ°©" + (rk.getRank(ho1.getName()) + 1) + "λ±\n");
			}
			if (ho2.getCheck()) {
				count += ho2.horse(rk);
				System.out.println();
			} else {
				System.out.println("2λ²λ§(μ¬μ₯μκ³ λ) λμ°©" + (rk.getRank(ho2.getName()) + 1) + "λ±\n");
			}
			if (ho3.getCheck()) {
				count += ho3.horse(rk);
				System.out.println();
			} else {
				System.out.println("3λ²λ§(μ²­λ΄λλΌ) λμ°©" + (rk.getRank(ho3.getName()) + 1) + "λ±\n");
			}
			if (ho4.getCheck()) {
				count += ho4.horse(rk);
				System.out.println();
			} else {
				System.out.println("4λ²λ§(κ²½λΆλλ‘) λμ°©" + (rk.getRank(ho4.getName()) + 1) + "λ±\n");
			}
			if (ho5.getCheck()) {
				count += ho5.horse(rk);
				System.out.println();
			} else {
				System.out.println("5λ²λ§(μ§κΈμ΄μκ°) λμ°©" + (rk.getRank(ho5.getName()) + 1) + "λ±\n");
			}
			System.out.println("\n\n\n\n\n\n\n\n\n\n==============================================================");
			System.out.println("==============================================================");
			System.out.println("==============================================================\n\n\n\n\n\n\n\n");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (check) {
				break;
			}
			if (count == 5) {
				check = true;
			}
		}
		System.out.println("***** μ μ κ²° κ³Ό *****");
		for (int i = 0; i < 5; i++) {

			System.out.println("  " + (i + 1) + "λ±" + rk.getHorse()[i]);
		}
		System.out.println("********************\n\n\n\n\n\n");
		return rk;
	}

}
