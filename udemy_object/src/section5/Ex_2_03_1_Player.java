package section5;

public class Ex_2_03_1_Player {
	
	private final String HAND_G = "グー";
	private String HAND_C = "チョキ";
	private final String HAND_P = "パー";
	
	private String name;
	private String handStatus;
	
	Ex_2_03_1_Player(String nm){
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


	public String getName() {
		return this.name;
	}


	public String getHandStatus() {
		return this.handStatus;
	}
	
	

}
