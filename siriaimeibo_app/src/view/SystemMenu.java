package view;

import java.time.LocalDate;
import java.util.Scanner;

import model.UserData;
import service.NewUser;

public class SystemMenu extends UserData {

	public SystemMenu(String name, LocalDate birthday, String bloodType, String hobby, String memo,
			String likeAbility) {
		super(name, birthday, bloodType, hobby, memo, likeAbility);

	}

	static Scanner scan = new Scanner(System.in);
	static int coming = 0;

	public static void Menu() {
		int unser = 0;
		while (true) {
			if (coming == 0) {
				System.out.println("ようこそマスター!こちらではプロフィールの閲覧や登録が可能です");
				coming += 1;
				System.out.println("今回はどうなさいますか？");
			}
			try {
				Thread.sleep(1500);
				System.out.println("1:新規登録" + " " + "2:一覧表記" + " " + "3:ログアウト");
				unser = scan.nextInt();
				if (unser == 1) {
					NewUser newUser = new NewUser(null, null, null, null, null, null);
					newUser.signUp();
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
			}

		}

	}
}
