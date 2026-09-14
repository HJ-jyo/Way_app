package view;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import model.UserData;
import service.Edit;
import service.NewUser;
import service.ShowList;

public class SystemMenu extends UserData {

	public SystemMenu(String name, String birthday, String bloodType, String hobby, String memo,
			String likeAbility) {
		super(name, birthday, bloodType, hobby, memo, likeAbility);
	}

	static Scanner scan = new Scanner(System.in);
	static int coming = 0;

	static String fileCounter;

	public static void Menu() {
		int anser;
		while (true) {
			ArrayList<String[]> allProfiles = new ArrayList<>();
			File dir = new File("UserList");
			File[] files = dir.listFiles((dirPath, name) -> name.endsWith(".txt"));
			int counter = 99990000; //誕生日などの数列に引っかかってしまうエラー防止装置
			if (files != null) {
				for (File file : files) {
					counter += 1;
					String fileName = file.getName();
					String dataString = fileName.replace(".txt", "");
					String[] profileData = dataString.split("-");
					fileCounter = String.valueOf(counter);
					String newElement = fileCounter;
					String[] newArray = Arrays.copyOf(profileData, profileData.length + 1);
					newArray[newArray.length - 1] = newElement;
					allProfiles.add(newArray);
				}

			}
			if (coming == 0) {
				System.out.println("ようこそマスター!こちらではお知り合いのプロフィール閲覧や登録が可能です");
				coming += 1;
				System.out.println("今回はどうなさいますか？");
			}
			try {
				anser = 0;
				Thread.sleep(1500);
				System.out.println("ファイルを読み込んでいます・・・");
				Thread.sleep(1500);
				System.out.println(
						"1:新規登録/" + "2:一覧表記/" + "3:編集・更新/" + "4:削除/" + "5:検索/" + "6:新規カテゴリ作成/" + "7:終了");
				anser = scan.nextInt();
				if (anser == 1) {
					NewUser newUser = new NewUser(null, null, null, null, null, null);
					newUser.signUp();
					continue;
				} else if (anser == 2) {
					ShowList.showList(allProfiles);
					continue;
				} else if (anser == 3) {
					Edit.edit(allProfiles);
					continue;
				} else if (anser == 4) {
					continue;
				} else if (anser == 5) {
					continue;
				} else if (anser == 6) {
					continue;
				} else if (anser == 7) {
					System.out.println("お疲れ様でした、また来てくださいね。");
					break;
				}
			} catch (Exception e) {
				System.out.println("打つ値を間違えてますよ...");
			}
			break;
		}

	}

}
