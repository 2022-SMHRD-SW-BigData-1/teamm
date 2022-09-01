package teammpro;

import java.util.Arrays;

public class RANK {
	private int rank =0;
	private String[] horse = new String[5];

	public int getRank(String name) {
		return Arrays.asList(horse).indexOf(name);
	}

	public void setRank(String name) {
		horse[rank] = name;
		this.rank++;
	}
	public String[] getHorse() {
		return horse;
	}
	
}
