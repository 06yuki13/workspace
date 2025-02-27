package j4_02;

/**----------------------------------------------------------------------*
 *■■■Sample4_02_1_Upd_BusinessLogicクラス■■■
 *概要：ビジネスロジック（ユーザーの情報更新）
 *----------------------------------------------------------------------**/
public class Sample4_02_1_Upd_BusinessLogic {

	/**----------------------------------------------------------------------*
	 *■updateメソッド
	 *概要　：対象のユーザー情報を更新する
	 *引数　：対象のユーザーデータ（Sample4_02_1_Common_DTO型）
	 *戻り値：なし
	 *----------------------------------------------------------------------**/
	public void update(Sample4_02_1_Common_DTO targetUserDto) {

		//-------------------------------------------
		//データベースへの接続を実施
		//-------------------------------------------

		//DAOクラスをインスタンス化＆対象のユーザーデータを更新するよう依頼
		Sample4_02_1_Common_DAO dao = new Sample4_02_1_Common_DAO();
		boolean result = dao.updateMemberInfo(targetUserDto);

		//終了メッセージを表示
		if(result){
			System.out.println("[INFO]更新処理が正常終了しました" ) ;
		}else{
			System.out.println("[INFO]更新処理に失敗しました" ) ;
		}

	}
}