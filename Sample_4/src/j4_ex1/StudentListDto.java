package j4_ex1;

public class StudentListDto {
	
	/*フィールド*/
	
	//名前
	private String studentName;
	
	//性別
	private int gender;
	
	//年齢
	private int age;
	
	//職歴
	private int careerMon;
	
	//登録支店
	private String branchName;
	
	//受講講座
	private String courceName;
	
	/*getter/setter*/

	public String getName() {
		return studentName;
	}

	public void setName(String name) {
		this.studentName = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getCareerMon() {
		return careerMon;
	}

	public void setCareerMon(int careerMon) {
		this.careerMon = careerMon;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getCourceName() {
		return courceName;
	}

	public void setCourceName(String courceName) {
		this.courceName = courceName;
	}
	
	
	
	
	

}
