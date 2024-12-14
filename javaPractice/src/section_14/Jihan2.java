package section_14;

public class Jihan2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		int coinNum = args.length -1;		//投入されたコインの枚数 ー1　(コマンドライン引数の最後が購入された商品の値段のため)
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
				//不正な硬貨であった場合、エラーメッセージを出力
				System.out.println("警告:" + coinCheck + "は硬貨として適切な値ではありません");
			}
		}
		
		//お釣りの計算(合計金額　- 商品の値段)
		int price = Integer.parseInt(args[args.length-1]);		//購入された商品の値段（コマンドライン引数の最後）、文字列のため整数型に変換(Integer.parasInt)
		int change = coinSum - price;							//change(お釣り）　＝投入されたコインの合計-商品の値段
		
		System.out.println(coinSum + "円のお釣りです。ありがとうございました。");

	}
}
