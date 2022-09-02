package teammpro;
import java.util.ArrayList;

import javazoom.jl.player.MP3Player;

public class BGM {
	MP3Player bgm = new MP3Player();
	ArrayList<MusicVO> playList = new ArrayList<MusicVO>();
	
	public BGM() {
		playList.add(new MusicVO("1등 말 소개하면서 나오는 효과음", "C://music/1등 말 소개하면서 나오는 효과음.mp3"));
		playList.add(new MusicVO("각 말 등장하기전에 효과음", "C://music/각 말 등장하기전에 효과음.mp3"));
		playList.add(new MusicVO("권총소리2", "C://music/권총소리2.mp3"));
		playList.add(new MusicVO("등수 나오기전에 나오는 효과음", "C://music/등수 나오기전에 나오는 효과음.mp3"));
		playList.add(new MusicVO("말 달리는 소리2", "C://music/말 달리는 소리2.mp3"));
		playList.add(new MusicVO("소리 내면서 달리는 말", "C://music/소리 내면서 달리는 말.mp3"));
		playList.add(new MusicVO("함성박수1", "C://music/함성박수1.mp3"));
		playList.add(new MusicVO("홈페이지 들어갓을때 효과음", "C://music/홈페이지 들어갓을때 효과음.mp3"));
		playList.add(new MusicVO("환호하는관중", "C://music/환호하는관중.mp3"));
		playList.add(new MusicVO("휘파람박수", "C://music/휘파람박수.mp3"));
		playList.add(new MusicVO("말 소개", "C://music/말 소개.mp3"));
	}
	
	public MusicVO play() {
	
		MusicVO m = playList.get(0);
	
		if (bgm.isPlaying()) {
			bgm.stop();
		} 
	
		bgm.play(m.getPath());
		
		return m;
	}

}
