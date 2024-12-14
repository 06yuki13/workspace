package personal.development;

	import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

	public class Blackjack {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // カードのデッキを作成
	        List<String> deck = createDeck();
	        Collections.shuffle(deck);

	        // プレイヤーとディーラーの手札を初期化
	        List<String> playerHand = new ArrayList<>();
	        List<String> dealerHand = new ArrayList<>();

	        // プレイヤーとディーラーに2枚ずつカードを配る
	        playerHand.add(deck.remove(0));
	        playerHand.add(deck.remove(0));
	        dealerHand.add(deck.remove(0));
	        dealerHand.add(deck.remove(0));

	        System.out.println("=== ブラックジャックへようこそ！ ===");
	        System.out.println("ディーラーの見えているカード: " + dealerHand.get(0));
	        System.out.println("あなたのカード: " + playerHand + " (合計: " + calculateHandValue(playerHand) + ")");

	        // プレイヤーのターン
	        while (true) {
	            System.out.print("カードを引きますか？ (y/n): ");
	            String choice = scanner.nextLine();
	            if (choice.equalsIgnoreCase("y")) {
	                playerHand.add(deck.remove(0));
	                int playerTotal = calculateHandValue(playerHand);
	                System.out.println("あなたのカード: " + playerHand + " (合計: " + playerTotal + ")");
	                if (playerTotal > 21) {
	                    System.out.println("バーストしました！あなたの負けです。");
	                    return;
	                }
	            } else {
	                break;
	            }
	        }

	        // ディーラーのターン
	        while (calculateHandValue(dealerHand) < 17) {
	            dealerHand.add(deck.remove(0));
	        }

	        // 結果を表示
	        int playerTotal = calculateHandValue(playerHand);
	        int dealerTotal = calculateHandValue(dealerHand);

	        System.out.println("ディーラーのカード: " + dealerHand + " (合計: " + dealerTotal + ")");
	        if (dealerTotal > 21 || playerTotal > dealerTotal) {
	            System.out.println("あなたの勝ちです！");
	        } else if (playerTotal < dealerTotal) {
	            System.out.println("あなたの負けです！");
	        } else {
	            System.out.println("引き分けです！");
	        }
	    }

	    // デッキを作成するメソッド
	    private static List<String> createDeck() {
	        String[] suits = {"♠", "♥", "♦", "♣"};
	        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
	        List<String> deck = new ArrayList<>();
	        for (String suit : suits) {
	            for (String rank : ranks) {
	                deck.add(rank + suit);
	            }
	        }
	        return deck;
	    }

	    // 手札の合計を計算するメソッド
	    private static int calculateHandValue(List<String> hand) {
	        int total = 0;
	        int aceCount = 0;

	        for (String card : hand) {
	            String rank = card.substring(0, card.length() - 1);
	            if ("JQK".contains(rank)) {
	                total += 10;
	            } else if (rank.equals("A")) {
	                aceCount++;
	                total += 11; // エースは最初に11として計算
	            } else {
	                total += Integer.parseInt(rank);
	            }
	        }

	        // エースの調整 (合計が21を超える場合、エースを1として数える)
	        while (total > 21 && aceCount > 0) {
	            total -= 10;
	            aceCount--;
	        }

	        return total;
	    }
	}

