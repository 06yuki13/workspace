package personal.development;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("ようこそ占いの館へ");
		
		System.out.println("あなたの名前を入力してください");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		
		System.out.println(name);
		
		System.out.println("あなたの年齢を入力してください");
		String ageString =sc.nextLine();
		int age = Integer.parseInt(ageString);
		System.out.println(age + "歳");
		
		int fortune = new java.util.Random().nextInt(4);
		fortune ++;
		
		System.out.println("占いの結果が出ました！");
		
		System.out.println(age + "歳の" + name + "さん、あなたの運気番号は" + fortune + "です");
		
		System.out.println("1 : 大吉 2 : 中吉 3 : 吉 4 : 凶");
		


	}

}
