package j4_ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentListDao {

	//フィールド
	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

	String JDBC_URL = "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8&serverTimezone=Asia/Tokyo";

	String USER_ID = "test_user";

	String USER_PASS = "test_pass";

	/*メソッド*/

	public List<StudentListDto> selectStudentInfo() {

		StudentListDto dto = new StudentListDto();
		List<StudentListDto> studentDtoList = new ArrayList<>();

		//-------------------------------------------
		//JDBCドライバのロード
		//-------------------------------------------
		try {
			Class.forName(DRIVER_NAME); //JDBCドライバをロード＆接続先として指定
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		//-------------------------------------------
		//SQL発行
		//-------------------------------------------

		//JDBCの接続に使用するオブジェクトを宣言
		//※finallyブロックでも扱うためtryブロック内で宣言してはいけないことに注意
		Connection con = null; // Connection（DB接続情報）格納用変数
		PreparedStatement ps = null; // PreparedStatement（SQL発行用オブジェクト）格納用変数
		ResultSet rs = null; // ResultSet（SQL抽出結果）格納用変数

		try {

			//-------------------------------------------
			//接続の確立（Connectionオブジェクトの取得）
			//-------------------------------------------
			con = DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS);

			//-------------------------------------------
			//SQL文の送信 ＆ 結果の取得
			//-------------------------------------------

			//発行するSQL文の生成（SELECT）
			StringBuffer buf = new StringBuffer();
			buf.append(" SELECT                            ");
			buf.append("   a.student_name ,                ");
			buf.append("   a.gender       ,                ");
			buf.append("   a.age          ,                ");
			buf.append("   a.career_mon   ,                ");
			buf.append("   b.branch_name  ,                ");
			buf.append("   c.course_name                   ");
			buf.append(" FROM                              ");
			buf.append("   uzuz_student a                  ");
			buf.append("   LEFT OUTER JOIN branch b        ");
			buf.append("     ON a.branch_id = b.branch_id  ");
			buf.append("   LEFT OUTER JOIN course c        ");
			buf.append("     ON a.course_id = c.course_id  ");
			buf.append(" ORDER BY                          ");
			buf.append("   a.student_id ;                  ");

			//PreparedStatement（SQL発行用オブジェクト）を生成＆発行するSQLをセット
			ps = con.prepareStatement(buf.toString());
			;

			//SQL文の送信＆戻り値としてResultSet（SQL抽出結果）を取得
			rs = ps.executeQuery();

			//ResultSetオブジェクトから1レコード分のデータをDTOに格納
			//リストの件数分Dtoに格納に変更

			while (rs.next()) {
				dto = new StudentListDto();
				dto.setName(rs.getString("student_name"));
				dto.setGender(rs.getInt("gender"));
				dto.setAge(rs.getInt("age"));
				dto.setCareerMon(rs.getInt("career_mon"));
				dto.setBranchName(rs.getString("branch_name"));
				dto.setCourceName(rs.getString("course_name"));
				studentDtoList.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			
			//ResultSetオブジェクトの接続解除
			if (rs != null) {    //接続が確認できている場合のみ実施
				try {
					rs.close();  //接続の解除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			//PreparedStatementオブジェクトの接続解除
			if (ps != null) { //接続が確認できている場合のみ実施
				try {
					ps.close(); //接続の解除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			//Connectionオブジェクトの接続解除
			if (con != null) { //接続が確認できている場合のみ実施
				try {
					con.close(); //接続の解除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return studentDtoList;

	}
}
