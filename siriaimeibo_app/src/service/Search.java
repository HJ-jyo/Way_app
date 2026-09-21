package service;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Search {

	public static void search() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			try {
				ArrayList<String[]> searchProfiles = new ArrayList<>();
				System.out.println("検索したい内容を入力してください。" + "0でメニュー画面に戻ります");
				String keyWord = scan.next();
				File searchDir = new File("UserList");
				File[] files = searchDir.listFiles((dirPath, name) -> name.contains(keyWord) && name.endsWith(".txt"));
				if (keyWord.equals("0")) {
					break;
				} else if (files != null && files.length > 0) {
					for (File file : files) {
						String fileName = file.getName();
						String dataString = fileName.replace(".txt", "");
						String[] profileData = dataString.split("-");
						searchProfiles.add(profileData);
					}
					for (String[] profile : searchProfiles) {
						String name = profile[0];
						String dateOfBirth = profile[1];
						String bloodtype = profile[2];
						String hobby = profile[3];
						String likeAbility = profile[5];

						System.out.println(
								"名前:" + name + " | 生年月日:" + dateOfBirth + " | 血液型:"
										+ bloodtype
										+ " | 趣味:" + hobby
										+ " | 好感度:" + likeAbility);
					}
				} else {
					System.out.println("入力された値を持つファイルは存在しません、もう一度入力してください");
				}
			} catch (Exception e) {
				System.out.println("不正な値が入力されました");
			}

		}

	}
}
