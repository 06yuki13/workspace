package section4;

public class Ex_02_2_Janken_yuki {
	public static void main(String[] args) {
		
		final String HAND_G = "グー";
		final String HAND_C = "チョキ";
		final String HAND_P = "パー";
		
		//プレイヤー１の名前
				String nameP1 = args[0];
				//プレイヤー２の名前
				String nameP2 = args[1];
				//審判の名前
				String nameJ1 = args[2];
				

				//じゃんけんを行うプレイヤーを登場させる（インスタンス化）
				Ex_02_2_Player_yuki p1 = new Ex_02_2_Player_yuki(nameP1);
				Ex_02_2_Player_yuki p2 = new Ex_02_2_Player_yuki(nameP2);
				//審判を登場させる
				Ex_02_2_Judge_yuki j1 = new Ex_02_2_Judge_yuki(nameJ1);
				
				//プレイヤー１に手を握らせる
				p1.makeHandStatus();
				//プレイヤー２に手を握らせる
				p2.makeHandStatus();
				
				//じゃんけん開始の号令（審判が言う）
				j1.startJanken();
				
				System.out.println(p1.name + "さんの手" + p1.handStatus);
				System.out.println(p2.name + "さんの手" + p2.handStatus);
				
				//それぞれが出した手を審判が言う
				j1.checkHand(p1);
				j1.checkHand(p2);
				
				//勝敗の宣言を審判がする
				j1.judgeJanken(p1,p2);
				
				
		
	}
	
	
	
	

}
