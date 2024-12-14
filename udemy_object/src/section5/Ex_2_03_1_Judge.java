package section5;

public class Ex_2_03_1_Judge {
	
	final String HAND_G = "グー";
	final String HAND_C = "チョキ";
	final String HAND_P = "パー";
	
	String name;
	
	

	
	Ex_2_03_1_Judge(String jname){  //jnm = Judge nameの略
		this.name = jname;
		
		
	}
	
//じゃんけ開始の掛け声
void startJanken(){
	messageJudge("じゃんけん...ぽん！！！！！");
	}

//プレイヤーの出した手を確認
void checkHand(Ex_2_03_1_Player p) {
	if((p.getHandStatus()).equals(HAND_G)) {
		messageJudge(p.getName() + "さんの手はグーでした");
	}else if((p.getHandStatus()).equals(HAND_C)) {
		messageJudge(p.getName() + "さんの手はチョキでした");
	}else if((p.getHandStatus()).equals(HAND_P)) {
		messageJudge(p.getName() + "さんの手はパーでした");
	}else {
		messageJudge("不正な値が入力されたので中止しました。");
	}
	
	
}

//勝ち負け判定
void judgeJanken(Ex_2_03_1_Player p1, Ex_2_03_1_Player p2) {
	if((p1.getHandStatus()).equals(p2.getHandStatus())) {
		messageJudge("あいこ！勝負つかず、、");
	}else if ((p1.getHandStatus().equals(HAND_G) && p2.getHandStatus().equals (HAND_C))
			||(p1.getHandStatus().equals(HAND_C) && p2.getHandStatus().equals(HAND_P))
			||(p1.getHandStatus().equals(HAND_P) && p2.getHandStatus().equals(HAND_G))) {
		messageJudge(p1.getName() + "さんの勝利！");
	}else if((p2.getHandStatus().equals(HAND_G) && p1.getHandStatus().equals(HAND_C))
			||(p2.getHandStatus().equals(HAND_C) && p1.getHandStatus().equals(HAND_P))
			||(p2.getHandStatus().equals(HAND_P) && p1.getHandStatus().equals(HAND_G))) {
		messageJudge(p2.getName() + "さんの勝利");
	}else {
		System.out.println("[ERROR]不正な値です。");
	}
	
	
}

//審判としてメッセージを表示する
//※毎回this.name~と書く必要をなくすため。
void messageJudge(String msg) {
	System.out.println(this.name + "「" + msg + "」");
}

}
