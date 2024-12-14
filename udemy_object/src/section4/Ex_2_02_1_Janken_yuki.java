package section4;

public class Ex_2_02_1_Janken_yuki {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		final String HAND_G = "グー";
		final String HAND_C = "チョキ";
		final String HAND_P = "パー";
		
		//プレイヤー１の名前
		String nameP1 = args[0];
		//プレイヤー２の名前
		String nameP2 = args[1];
		
		//じゃんけんを行うプレイヤーを登場させる（インスタンス化）
		Ex_02_1_Player_yuki p1 = new Ex_02_1_Player_yuki(nameP1);
		Ex_02_1_Player_yuki p2 = new Ex_02_1_Player_yuki(nameP2);
		
		p1.makeHandStatus();
		p2.makeHandStatus();
		
		System.out.println(p1.name + "さんの手" + p1.handStatus);
		System.out.println(p2.name + "さんの手" + p2.handStatus);
		
		
		System.out.println("じゃんけん・・・ぽん！！！！！");
		
		if((p1.handStatus).equals(p2.handStatus)) {
			System.out.println("あいこ！勝負つかず、、");
		}else if ((p1.handStatus.equals(HAND_G) && p2.handStatus.equals (HAND_C))
				||(p1.handStatus.equals(HAND_C) && p2.handStatus.equals(HAND_P))
				||(p1.handStatus.equals(HAND_P) && p2.handStatus.equals(HAND_G))) {
			System.out.println(p1.name + "さんの勝利！");
		}else if((p2.handStatus.equals(HAND_G) && p1.handStatus.equals(HAND_C))
				||(p2.handStatus.equals(HAND_C) && p1.handStatus.equals(HAND_P))
				||(p2.handStatus.equals(HAND_P) && p1.handStatus.equals(HAND_G))) {
			System.out.println(p2.name + "さんの勝利");
		}else {
			System.out.println("[ERROR]不正な値です。");
		}

	}

}
