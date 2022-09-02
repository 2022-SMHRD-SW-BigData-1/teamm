package teammpro;
import java.util.ArrayList;

import javazoom.jl.player.MP3Player;

public class BGM {
	MP3Player bgm = new MP3Player();
	ArrayList<MusicVO> playList = new ArrayList<MusicVO>();
	
	public BGM() {
		playList.add(new MusicVO("첫화면", "src//music//첫화면.mp3"));
		playList.add(new MusicVO("함성박수1", "src//music//함성박수1.mp3"));
		playList.add(new MusicVO("반갑습니다 에이치", "src//music//반갑습니다 에이치.mp3"));
		playList.add(new MusicVO("스포츠_타이틀", "src//music//스포츠_타이틀.mp3"));
		playList.add(new MusicVO("1등등장", "src//music//1등등장.mp3"));
		playList.add(new MusicVO("말 달리는 소리2", "src//music//말 달리는 소리2.mp3"));
		playList.add(new MusicVO("말 등장", "src//music//말 등장.mp3"));
		playList.add(new MusicVO("빵빠레", "src//music//빵빠레.mp3"));
		playList.add(new MusicVO("선수소개", "src//music//선수소개.mp3"));
		playList.add(new MusicVO("소리 내면서 달리는 말", "src//music//소리 내면서 달리는 말.mp3"));
		playList.add(new MusicVO("환호하는관중", "src//music//환호하는관중.mp3"));
		playList.add(new MusicVO("휘파람박수", "src//music//휘파람박수.mp3"));
		playList.add(new MusicVO("말 소개", "src//music//말 소개.mp3"));
	}
	
	public MusicVO p1() {
		MusicVO m = playList.get(0);
		bgm.play(m.getPath());
		
		return m;
	}
	
	public MusicVO p2() {
		MusicVO m = playList.get(1);
		
		bgm.play(m.getPath());
		return m;
	}
	
	public void play (String s) {
		for (int i = 0;  i < playList.size(); i++) {
			MusicVO m = playList.get(i);
			String a = m.getTitle();
			
			if (m.getTitle().equals(s)) {
				if(bgm.isPlaying()) {
					bgm.stop();
				}
				bgm.play(m.getPath());
			}
		}
	}

}
