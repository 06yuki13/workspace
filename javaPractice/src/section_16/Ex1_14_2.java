package section_16;

/*-< 演習：Ex1_14_2 >---------------------------------
コマンドライン引数から1つ以上の数値を受け取り、この1つ1つの数値を購入した商品の定価としたとき、
合計金額を求め、その金額に応じた値引きを利かせ、最後に消費税（8％とする）をのせた金額を表示するプログラムを作りたい。
mainメソッドの内容は書き換えずに処理が通るようなメソッドを仕様に従って書いてください。
----------------------------------------------------*/
public class Ex1_14_2 {
	
	//！！！mainメソッドの処理は書き換えないでください！！！
	public static void main (String[] args) {
		
		int totalPrice = 0 ;                                 //購入した商品の合計金額
		
		//コマンドライン引数から購入した商品の合計金額（定価）を取得
		for(int i = 0 ; i < args.length ; i++ ){
			totalPrice += Integer.parseInt( args[i] );
		}
		
		//discountメソッドを使って値引きを適用し、値引き後の金額を取得
		int discountedPrice = discount( totalPrice );        //値引き後の金額
		
		//calcTaxPaymentメソッドを使って支払金額（税込）を取得
		int taxPayment = calcTaxPayment( discountedPrice );  //支払金額（税込）
		
		//支払金額（税込）を表示
		System.out.println("値引き後の支払金額：" + taxPayment + "円" );
		
	}
	
	
	/*
	**以下の仕様を持つメソッドcalcTaxPaymentを作成してください。
	**  - 引数として受け取った値の税込価格（消費税は8％とする）を計算して返す
	**  - 税込価格は整数（小数点以下切り捨て）で返す
	*/
	static int calcTaxPayment(int pr) {        //アンダーバーを適切な内容に書き換えてください
		final double TAX_RATE = 1.08; 			//消費税倍率
		
		int priceIncludingTax = (int)(TAX_RATE * pr);
		
		return priceIncludingTax;
		
		
	}
	
	
	/*
	**以下の仕様を持つメソッドdiscountを作成してください。
	**  - 引数として受け取った値が1000円以上5000円以下の場合、1000円より大きい分について10％割引にする
	**  - 引数として受け取った値が5000円より大きい場合、1000円より大きく5000円以下の分について10％割引、5000円より大きい分について20％割引にする
	**  - 値引き額は小数点以下切り捨てで計算する（キャストを使いましょう）
	**  - 割引金額の上限は5000円とする
	*/
	static int discount( int pr ){ //アンダーバーを適切な内容に書き換えてください
		final int DISCOUNT_BORDER1 = 1000;		//値引き発生境界線(1000円)
		final int DISCOUNT_BORDER2 = 5000;		//値引き発生境界線(5000円)
		final double DISCOUNT_RATE1 = 0.1;		//割引率(1000円以上5000円未満)
		final double DISCOUNT_RATE2 = 0.2;		//割引率(5000円以上)
		final int DISCOUNT_MAX_BORDER = 5000;	//最大割引額
		
		int priceDownTemp = 0;					//仮の値引き額
		
		//仮の値引額の計算
		if(DISCOUNT_BORDER1 <= pr && pr <= DISCOUNT_BORDER2) {
			priceDownTemp = (int)((pr - DISCOUNT_BORDER1) * DISCOUNT_RATE1);
		}else if(DISCOUNT_BORDER2 < pr) {
			priceDownTemp = (int)((DISCOUNT_BORDER2 - DISCOUNT_BORDER1) * DISCOUNT_RATE1 +(pr - DISCOUNT_BORDER2) * DISCOUNT_RATE2);
			
		}
		
		int priceDown = 0;						//最終的な値引額
		
		//値引額の上限を加味し、本当の値引額を求める
		if(DISCOUNT_MAX_BORDER < priceDownTemp ) {
			priceDown = DISCOUNT_MAX_BORDER;
		}else {
			//値引きの上限額を超えていなかったら、仮の値引額をそのまま値引額として採用する
			priceDown = priceDownTemp;
		}
		
		//値引き適応後の金額を返す
		return pr - priceDown;
		
		//discountメソッド完了
		
		
		
		
		
	}
}
