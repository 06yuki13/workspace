package j4_ex2;

public class StudentsCountByCourseDto {
	
	/*フィールド*/
	
	   //登録支店
		private String branchName;
		
		//受講講座
		private String courceName;
		
		//受講者数
		private int studentsCount;

		public int getStudentsCount() {
			return studentsCount;
		}

		public void setStudentsCount(int studentsCount) {
			this.studentsCount = studentsCount;
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
