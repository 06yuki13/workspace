package section4;

public class Ex_02_2_Player_yuki {
	

	
	final String HAND_G = "グー";
	final String HAND_C = "チョキ";
	final String HAND_P = "パー";
	
	String name;
	String handStatus;
	
	Ex_02_2_Player_yuki(String nm){
		this.name = nm;
	}
	
	void makeHandStatus() {
		int randomHand = 1 + (int)(Math.random() * 3);
		
		switch(randomHand) {
		case 1:
			this.handStatus = HAND_G;
			break;
			
		case 2:
			this.handStatus = HAND_C;
			break;
			
		case 3:
			this.handStatus = HAND_P;
			break;
		}
	}
}
