package churimon;

public class Hitokake extends Monster3 {
	
	Hitokake(){
		super.setCharacter("ヒトカケ");
	}
	
	Hitokake(String tr,String nm){
		super(tr,nm);
		super.setCharacter("ヒトカケ");
	}
	
	Hitokake(String tr,String nm,int lev){
		super(tr,nm,lev);
		super.setCharacter("ヒトカケ");
	}
	
	public void levelUp(int up) {
		setLv(getLv() + 1 * up);
		setHpMax(getHpMax() + 29 * up);
		setAtk(getAtk() + 8 * up);
		setDef(getDef() + 5 * up);
		setSpd(getSpd() + 9 * up);
		setHpMax(getHpMax());
	}

}
