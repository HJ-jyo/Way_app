package service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class NewUser extends model.UserData {

	static Scanner scan = new Scanner(System.in);

	public NewUser(String name, String birthday, String bloodType, String hobby, String memo, String likeAbility) {
		super(name, birthday, bloodType, hobby, memo, likeAbility);
	}

	public void signUp() {
		boolean isInvalid = true;
		while (isInvalid) {
			ArrayList<String> profileList = new ArrayList<>();
			isInvalid = true;
			while (isInvalid) {
				try {
					System.out.println("名前を入力してください");
					String setingName = scan.next();
					String newname = setingName;
					if (setingName.contains("-")) {
						throw new IllegalArgumentException("-は使用できません");
					}
					setName(newname);
					profileList.add(newname);
					isInvalid = false;
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			}
			isInvalid = true;
			while (isInvalid) {
				try {
					System.out.println("誕生日を入力してください" + "※注意:日付は必ず" + 20000123 + "(記号なしの年月日８桁で入力してください");
					String setingBirthday = scan.next();
					if (setingBirthday.contains("-")) {
						throw new IllegalArgumentException("-は使用できません");
					}
					setBirthday(setingBirthday);
					profileList.add(setingBirthday);
					isInvalid = false;
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			}
			isInvalid = true;
			while (isInvalid) {
				try {
					System.out.println("血液型を入力してください");
					String setingBloodType = scan.next();
					if (setingBloodType.contains("-")) {
						throw new IllegalArgumentException("-は使用できません");
					}
					setBloodType(setingBloodType);
					profileList.add(setingBloodType);
					isInvalid = false;
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			}
			isInvalid = true;
			while (isInvalid) {
				try {
					System.out.println("趣味を入力してください" + "注意※複数書く場合は、で区切ってください");
					String setingHobby = scan.next();
					if (setingHobby.contains("-")) {
						throw new IllegalArgumentException("-は使用できません");
					}
					setHobby(setingHobby);
					profileList.add(setingHobby);
					isInvalid = false;
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			}
			isInvalid = true;
			while (isInvalid) {
				try {
					System.out.println("一言メモを入力してください");
					String setingMemo = scan.next();
					if (setingMemo.contains("-")) {
						throw new IllegalArgumentException("-は使用できません");
					}
					setMemo(setingMemo);
					profileList.add(setingMemo);
					isInvalid = false;
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			}
			isInvalid = true;
			while (isInvalid) {
				try {
					System.out.println("好感度を入力してください");
					String setinglikeAbility = scan.next();
					if (setinglikeAbility.contains("-")) {
						throw new IllegalArgumentException("-は使用できません");
					}
					setLikeAbility(setinglikeAbility);
					profileList.add(setinglikeAbility);
					String createFileName = String.join("-", profileList) + ".txt";
					File dir = new File("UserList");
					File targetFile = new File(dir, createFileName);
					FileWriter fw = new FileWriter(targetFile);
					PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
					String fileContent = String.join("-", profileList);
					pw.println(fileContent);
					pw.close();
					System.out.println("----" + "作成が完了しました" + "----");
					System.out.println("名前：" + getName());
					System.out.println("誕生日：" + getBirthday());
					System.out.println("血液型：" + getBloodType() + "型");
					System.out.println("趣味：" + getHobby());
					System.out.println("メモ：" + getMemo());
					System.out.println("好感度：" + getLikeAbility());
					System.out.println("-----------------------");
					System.out.println("メニュー選択画面に戻ります");
					isInvalid = false;
					break;
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				} catch (java.io.IOException e) {
					System.out.println("ファイルの保存中にエラーが発生しました: " + e.getMessage());
				}
			}

		}
	}
}
