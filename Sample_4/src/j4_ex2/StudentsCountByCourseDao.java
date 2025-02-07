package j4_ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**----------------------------------------------------------------------*
 *■■■StudentsCountByCourseDaoクラス■■■
 *概要：DAO（ uzuz_studentテーブル / courseテーブル / branchテーブル ）
 *----------------------------------------------------------------------**/
public class StudentsCountByCourseDao {

	//-------------------------------------------
	//データベースへの接続情報
	//-------------------------------------------

	//JDBCドライバの相対パス
	//※バージョンによって変わる可能性があります（MySQL5系の場合は「com.mysql.jdbc.Driver」）
	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

	//接続先のデータベース
	//※データベース名が「test_db」でない場合は該当の箇所を変更してください
	String JDBC_URL    = "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8&serverTimezone=Asia/Tokyo";

	//接続するユーザー名
	//※ユーザー名が「test_user」でない場合は該当の箇所を変更してください
	String USER_ID     = "test_user";

	//接続するユーザーのパスワード
	//※パスワードが「test_pass」でない場合は該当の箇所を変更してください
	String USER_PASS   = "test_pass";


	//----------------------------------------------------------------
	//メソッド
	//----------------------------------------------------------------

	/**----------------------------------------------------------------------*
	 *■selectStudentsCountByCourseメソッド
	 *概要　：「uzuz_studentテーブル」「courseテーブル」「branchテーブル」からコース別受講者数を抽出する
	 *引数　：なし
	 *戻り値：抽出データ（List<StudentsCountByCourseDto>型）
	 *----------------------------------------------------------------------**/
	public List<StudentsCountByCourseDto> selectStudentsCountByCourse(){

		//-------------------------------------------
		//JDBCドライバのロード
		//-------------------------------------------
		try {
			Class.forName( DRIVER_NAME );       //JDBCドライバをロード＆接続先として指定
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}

		//-------------------------------------------
		//SQL発行
		//-------------------------------------------

		//JDBCの接続に使用するオブジェクトを宣言
		Connection        con = null ;   // Connection（DB接続情報）格納用変数
		PreparedStatement ps  = null ;   // PreparedStatement（SQL発行用オブジェクト）格納用変数
		ResultSet         rs  = null ;   // ResultSet（SQL抽出結果）格納用変数

		//抽出データ（List型）格納用変数
		//※最終的にreturnするため、tryブロック内で宣言してはいけないことに注意
		List<StudentsCountByCourseDto> dtoList = new ArrayList<StudentsCountByCourseDto>();

		try {

			//-------------------------------------------
			//接続の確立（Connectionオブジェクトの取得）
			//-------------------------------------------
			con = DriverManager.getConnection( JDBC_URL, USER_ID, USER_PASS );

			//-------------------------------------------
			//SQL文の送信 ＆ 結果の取得
			//-------------------------------------------

			//発行するSQL文の生成（SELECT）
			StringBuffer buf = new StringBuffer();

			buf.append(" SELECT                                      ");
			buf.append("     b.BRANCH_NAME       AS BRANCH_NAME    , ");
			buf.append("     c.COURSE_NAME       AS COURSE_NAME    , ");
			buf.append("     COUNT(a.STUDENT_ID) AS STUDENTS_COUNT   ");
			buf.append(" FROM                                        ");
			buf.append("     UZUZ_STUDENT a                          ");
			buf.append("     INNER JOIN BRANCH b                     ");
			buf.append("       ON  a.BRANCH_ID = b.BRANCH_ID         ");
			buf.append("     INNER JOIN COURSE c                     ");
			buf.append("       ON  a.COURSE_ID = c.COURSE_ID         ");
			buf.append(" GROUP BY                                    ");
			buf.append("     b.BRANCH_ID,c.COURSE_ID                 ");
			buf.append(" ORDER BY                                    ");
			buf.append("     b.BRANCH_ID,c.COURSE_ID  ;              ");

			//PreparedStatement（SQL発行用オブジェクト）を生成＆発行するSQLをセット
			ps = con.prepareStatement( buf.toString() );

			//SQL文の送信＆戻り値としてResultSet（SQL抽出結果）を取得
			rs = ps.executeQuery();

			//ResultSetオブジェクトから1レコード分のデータをDTOに格納
			while( rs.next() ){
				StudentsCountByCourseDto dto = new StudentsCountByCourseDto();
				dto.setBranchName(    rs.getString( "branch_name"    ));
				dto.setCourceName(    rs.getString( "course_name"    ));
				dto.setStudentsCount(rs.getInt("students_count"));
				dtoList.add(dto);
			}

		}catch ( SQLException e ){
			e.printStackTrace();

		}finally{
			//-------------------------------------------
			//接続の解除
			//-------------------------------------------

			//ResultSetオブジェクトの接続解除
			if (rs != null) {    //接続が確認できている場合のみ実施
				try {
					rs.close();  //接続の解除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			//PreparedStatementオブジェクトの接続解除
			if (ps != null) {    //接続が確認できている場合のみ実施
				try {
					ps.close();  //接続の解除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			//Connectionオブジェクトの接続解除
			if (con != null) {    //接続が確認できている場合のみ実施
				try {
					con.close();  //接続の解除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		//抽出データを戻す
		return dtoList;
	}
}