package j4_ex2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


/**----------------------------------------------------------------------*
 *■■■FWriterStudentsCountByCourseBLクラス■■■
 *概要：ビジネスロジック（コース別受講者数の書き出し）
 *----------------------------------------------------------------------**/
public class FWriterStudentsCountByCourseBL {

	//書き出し先ファイル（フルパス）
	private final String FILE_PATH = "/Users/nakagawayuki/Desktop/udemy_JDBC/csv/WriteCsvEx1.csv";

	//テキストデータ（共通）
	private final String COMMA                = ","               ;                     //コンマ
	private final String NEW_LINE             = System.getProperty("line.separator") ;  //改行

	//テキストデータ（コース別受講者数）
	private final String SC_HEADER_TITLE         = "#--集計結果--"   ;                     //タイトル
	private final String SC_HEADER_COLUMN_BRANCH = "登録支店"        ;                     //項目名（登録支店）
	private final String SC_HEADER_COLUMN_COURSE = "受講講座"        ;                     //項目名（受講講座）
	private final String SC_HEADER_COLUMN_COUNT  = "受講者数"        ;                     //項目名（受講者数）

	//その他
	private final int INTERVAL_LINE_NUMBER = 2   ;                        //追記で書き出す際の既存データとの間隔行数


	/**----------------------------------------------------------------------*
	 *■extractStudentsCountByCourseメソッド
	 *概要　：コース別受講者数を抽出し、CSVファイルに追記形式で書き出す
	 *引数　：なし
	 *戻り値：なし
	 *----------------------------------------------------------------------**/
	public void extractStudentsCountByCourse(){

		//-------------------------------------------
		//データベースへの接続を実施
		//-------------------------------------------

		//DAOクラスをインスタンス化＆コース別受講者数を抽出するよう依頼
		StudentsCountByCourseDao dao = new StudentsCountByCourseDao();
		List<StudentsCountByCourseDto> extractedDtoList = dao.selectStudentsCountByCourse();

		try{
			//書き出し用ファイルを読み込みFileWriterにセット（追記形式）
			FileWriter fw = new FileWriter( new File( FILE_PATH ) , true );

			//既存データとの間隔行を挿入する
			insertInterval( fw );

			//タイトルの書き出し
			writeStudentsCountByCourseTitle( fw );

			//ヘッダの書き出し
			writeStudentsCountByCourseHeader( fw );

			//コース別受講者数の書き出し
			writeStudentsCountByCourseRecord( fw , extractedDtoList );

			//FileWriterを閉じる
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**----------------------------------------------------------------------*
	 *■writeStudentsCountByCourseTitleメソッド
	 *概要　：受講者リストのタイトルをCSVファイルに書き出す
	 *引数1 ：FileWriter
	 *戻り値：なし
	 *----------------------------------------------------------------------**/
	private void writeStudentsCountByCourseTitle ( FileWriter fw) {

		try{
			//タイトルの書き出し
			fw.write( SC_HEADER_TITLE );
			fw.write( NEW_LINE );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**----------------------------------------------------------------------*
	 *■writeStudentsCountByCourseHeaderメソッド
	 *概要　：受講者リストのヘッダーをCSVファイルに書き出す
	 *引数1 ：FileWriter
	 *戻り値：なし
	 *----------------------------------------------------------------------**/
	private void writeStudentsCountByCourseHeader ( FileWriter fw) {

		try{
			//ヘッダの書き出し
			fw.write( SC_HEADER_COLUMN_BRANCH );
			fw.write( COMMA );
			fw.write( SC_HEADER_COLUMN_COURSE );
			fw.write( COMMA );
			fw.write( SC_HEADER_COLUMN_COUNT );
			fw.write( NEW_LINE );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**----------------------------------------------------------------------*
	 *■writeStudentsCountByCourseRecordメソッド
	 *概要　：コース別受講者数をCSVファイルに書き出す
	 *引数1 ：FileWriter
	 *引数2 ：コース別受講者数（List<StudentListDto>）
	 *戻り値：なし
	 *----------------------------------------------------------------------**/
	private void writeStudentsCountByCourseRecord ( FileWriter fw , List<StudentsCountByCourseDto> dl ) {

		try{

			//受講生データの書き出し
			for (int i = 0; i < dl.size(); i++) {

				//処理対象のレコード情報（DTO）を取得
				StudentsCountByCourseDto dto = dl.get(i);

				//書き出し（登録支店）
				fw.write( dto.getBranchName() );
				fw.write( COMMA );

				//書き出し（受講講座）
				fw.write( dto.getCourceName() );
				fw.write( COMMA );

				//書き出し（受講者数）
				fw.write( String.valueOf( dto.getStudentsCount() ) );
				fw.write( NEW_LINE );

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**----------------------------------------------------------------------*
	 *■insertIntervalメソッド
	 *概要　：既存データとの間隔行を挿入する
	 *引数1 ：FileWriter
	 *戻り値：なし
	 *----------------------------------------------------------------------**/
	private void insertInterval ( FileWriter fw ) {

		try{
			//間隔行の挿入
			for (int i = 0 ; i < INTERVAL_LINE_NUMBER ; i++) {
				fw.write( NEW_LINE );
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
