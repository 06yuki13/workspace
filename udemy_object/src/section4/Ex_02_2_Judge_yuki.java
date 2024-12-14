package section4;

public class Ex_02_2_Judge_yuki {
		
		final String HAND_G = "グー";
		final String HAND_C = "チョキ";
		final String HAND_P = "パー";
		
		String name;
		
		

		
		Ex_02_2_Judge_yuki(String jname){  //jnm = Judge nameの略
			this.name = jname;
			
			
		}
		
	//じゃんけ開始の掛け声
    void startJanken(){
		messageJudge("じゃんけん...ぽん！！！！！");
		}
    
    //プレイヤーの出した手を確認
    void checkHand(Ex_02_2_Player_yuki p) {
    	if((p.handStatus).equals(HAND_G)) {
    		messageJudge(p.name + "さんの手はグーでした");
    	}else if((p.handStatus).equals(HAND_C)) {
    		messageJudge(p.name + "さんの手はチョキでした");
    	}else if((p.handStatus).equals(HAND_P)) {
    		messageJudge(p.name + "さんの手はパーでした");
    	}else {
    		messageJudge("不正な値が入力されたので中止しました。");
    	}
    	
    	
    }
    
    //勝ち負け判定
    void judgeJanken(Ex_02_2_Player_yuki p1, Ex_02_2_Player_yuki p2) {
    	if((p1.handStatus).equals(p2.handStatus)) {
    		messageJudge("あいこ！勝負つかず、、");
		}else if ((p1.handStatus.equals(HAND_G) && p2.handStatus.equals (HAND_C))
				||(p1.handStatus.equals(HAND_C) && p2.handStatus.equals(HAND_P))
				||(p1.handStatus.equals(HAND_P) && p2.handStatus.equals(HAND_G))) {
			messageJudge(p1.name + "さんの勝利！");
		}else if((p2.handStatus.equals(HAND_G) && p1.handStatus.equals(HAND_C))
				||(p2.handStatus.equals(HAND_C) && p1.handStatus.equals(HAND_P))
				||(p2.handStatus.equals(HAND_P) && p1.handStatus.equals(HAND_G))) {
			messageJudge(p2.name + "さんの勝利");
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
