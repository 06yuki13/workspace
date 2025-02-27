package j4_ex2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import j4_ex1.StudentListDao;
import j4_ex1.StudentListDto;

/**
 * FWiterStudentListBusinessLogiクラス<br>
 * ユーザー情報抽出
 * */
public class FWriterStudentListBL {

	/*フィールドの設定*/

	//書き出し先ファイル（フルパス）
	private final String FILE_PATH = "/Users/nakagawayuki/Desktop/udemy_JDBC/csv/WriteCsvEx1.csv";

	//テキストデータ（共通）
	private final String CONMA = ",";

	//改行
	private final String NEW_LINE = System.getProperty("line.separator") ;  //改行;;

	//テキストデータ（受講生情報）

	//タイトル
	private final String HEADER_TITLE = "#--受講生一覧--";

	//名前
	private final String SL_HEADER_COLUMN_NAME = "受講者名";

	//性別
	private final String SL_COLUMN_GENDER = "性別";

	//年齢
	private final String SL_COLUMN_AGE = "年齢";

	//職歴
	private final String SL_COLUMN_CAREER = "職歴";

	//登録支店
	private final String SL_COLUMN_BRANCH = "登録支店";

	//受講講座
	private final String SL_COLUMN_COURSE = "受講講座";

	//男性
	private final String MALE = "男性";

	//女性
	private final String FEMALE = "女性";

	//変換文字(年)
	private final String TEXT_YEAR = "年";

	//変換文字(月)
	private final String TEXT_MONTH = "ヶ月";

	//変換文字列(職歴なし)
	private final String TEXT_NON_CARRER = "職歴なし";

	//変換文字列(受講なし)
	private final String TEXT_NON_COURSE = "受講なし";
	
	//1年の月換算
	private final int ONE_YEAR_BY_MONTH = 12;

	/**
	 * extractStudentListメソッド<br>
	 * 対象のユーザー情報を抽出し、CSVリストに書き出す
	 * */
	public void extractStudentList() {
		StudentListDao studentListDao = new StudentListDao();
		List<StudentListDto> extractDtoList = studentListDao.selectStudentInfo();

		try {

			//書き出し用ファイルを読み込みFileWriterにセット
			FileWriter fw = new FileWriter(FILE_PATH);

			//タイトルの書き出し
			writeStudentListTitle(fw);

			//ヘッダーの書き出し
			writeStudentListHeader(fw);

			//受講生データの書き出し
			writeStudentList(fw, extractDtoList);

			//FileWriterを閉じる
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void writeStudentListTitle(FileWriter fw) {
		try {
			fw.write(HEADER_TITLE);
			fw.write(NEW_LINE);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeStudentListHeader(FileWriter fw) {
		try {
			fw.write(SL_HEADER_COLUMN_NAME);
			fw.write(CONMA);
			fw.write(SL_COLUMN_GENDER);
			fw.write(CONMA);
			fw.write(SL_COLUMN_AGE);
			fw.write(CONMA);
			fw.write(SL_COLUMN_CAREER);
			fw.write(CONMA);
			fw.write(SL_COLUMN_BRANCH);
			fw.write(CONMA);
			fw.write(SL_COLUMN_COURSE);
			fw.write(NEW_LINE);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void writeStudentList(FileWriter fw, List<StudentListDto> stList) {

		try {
			for (int i = 0; i < stList.size(); i++) {
				
				StudentListDto dto = stList.get(i);
				fw.write(dto.getName());
				fw.write(CONMA);

				if (dto.getGender() == 1) {
					fw.write(MALE);
				} else if (dto.getGender() == 2) {
					fw.write(FEMALE);
				}
				fw.write(CONMA);

				fw.write(String.valueOf(dto.getAge()));
				fw.write(CONMA);

				if(dto.getCareerMon() == 0) {
					fw.write(TEXT_NON_CARRER);
				}else {
					int carrerYM_Y = dto.getCareerMon()/ONE_YEAR_BY_MONTH;
					int carrerYM_M = dto.getCareerMon()%ONE_YEAR_BY_MONTH;
					
					if(carrerYM_Y > 0) {
						 fw.write(String.valueOf(carrerYM_Y));
						 fw.write(TEXT_YEAR);
					}
					
					if(carrerYM_M > 0) {
						fw.write(String.valueOf(carrerYM_M));
						 fw.write(TEXT_MONTH);
					}
				}
				fw.write(CONMA);
				
				fw.write(dto.getBranchName());
				
				fw.write(CONMA);
				
				if(dto.getCourceName()!= null) {
					fw.write(dto.getCourceName());
				}else {
					fw.write(TEXT_NON_COURSE);
				}
				fw.write(NEW_LINE);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
