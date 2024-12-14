package section_14;

public class Jihan {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int coinNum = args.length;		//投入されたコインの枚数
		int coinCheck = 0;				//チェック対象の硬貨の金額
		int coinSum = 0;				//投入された硬貨の合計金額 | 使用可能な硬貨のみ
		
		for(int i = 0; i < coinNum; i++) {
			//今回のループでチェックする硬貨をセット
			coinCheck = Integer.parseInt(args[i]);  //文字列を数字に変換
			if(coinCheck == 10 || coinCheck == 50 || coinCheck == 100 || coinCheck == 500) {
			//使用可能な硬貨出会った、場合coinSumに加算
				coinSum += coinCheck;  //coinSum = coinSum + coinCheckでも可。
			}else if(coinCheck == 1 || coinCheck == 5){
				//使用不可な硬貨であった場合、エラーメッセージを出力
				System.out.println("警告:" + coinCheck + "円玉は使えません");
			}else {
				System.out.println("警告:" + coinCheck + "は硬貨として適切な値ではありません");
			}
			
		}
		
		System.out.println("現在の合計金額は" + coinSum + "円です");
		

	}

}
