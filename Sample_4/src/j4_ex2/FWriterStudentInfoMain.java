package j4_ex2;

import j4_ex1.FWriterStudentListBL;

public class FWriterStudentInfoMain {

	public static void main(String[] args) {
		
		//ビジネスロジッククラスのインスタンス化&メソッド起動
		FWriterStudentListBL businessLogic = new FWriterStudentListBL();
		businessLogic.extractStudentList();

		//ビジネスロジッククラス(コース別受講者数書き出し）のインスタンス化&メソッド起動
		FWriterStudentsCountByCourseBL fWriteCountBusinessLogic = new FWriterStudentsCountByCourseBL();
		fWriteCountBusinessLogic.extractStudentsCountByCourse();

	}
}
