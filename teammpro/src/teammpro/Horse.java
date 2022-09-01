package teammpro;

import java.util.Random;

public class Horse {
	private String name;
	private int range =1;
	private boolean check = true;
	Random rd = new Random();
	public Horse(String name) {
		this.name = name;
	}
	public int horse(RANK rk) {
		int s=0;
		for(int i =0  ; i<=range; i++) {
			System.out.print("*");
		}
		System.out.println(name);
		range+=rd.nextInt(3);
		if(range>=20) {
			check = false;
			rk.setRank(name);
			s=1;
		}
		return s;
	}
	public boolean getCheck() {
		return check;
	}
	public String getName() {
		return name;
	}
	
	
}
