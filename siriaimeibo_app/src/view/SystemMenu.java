package view;

import java.util.Scanner;

public class SystemMenu {
	Scanner scan = new Scanner(System.in);

	public void Menu() {
		int unser = 0;
		while (true) {
			try {
				System.out.println("ようこそマスター!こちらではプロフィールの閲覧や登録が可能です");
				Thread.sleep(1300);
				System.out.println("今回はどうなさいますか？");
				Thread.sleep(1300);
				System.out.println("1:新規登録" + " " + "2:一覧表記" + " " + "3:ログアウト");
				unser = scan.nextInt();
				if (unser == 1) {
					break;
				} else if (unser == 2) {
					break;
				} else if (unser == 3) {
					System.out.println("お疲れ様でした、またきてくださいね。");
					break;
				} else {
					System.out.println("打つ値を間違えてますよ...");
				}
			} catch (Exception e) {
				System.out.println("打つ値を間違えてますよ...");
				scan.next();

			}

		}

	}
}
