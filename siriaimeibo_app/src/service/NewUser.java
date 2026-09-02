package service;

import java.time.LocalDate;
import java.util.Scanner;

import view.SystemMenu;

public class NewUser extends model.UserData {

	static Scanner scan = new Scanner(System.in);

	public NewUser(String name, LocalDate birthday, String bloodType, String hobby, String memo, String likeAbility) {
		super(name, birthday, bloodType, hobby, memo, likeAbility);
	}

	public void signUp() {
		while (true) {
			try {

				System.out.println("名前を入力してください");
				String setingName = scan.next();
				String newname = setingName;
				setName(newname);
			} catch (Exception e) {
			}
			try {
				System.out.println("誕生日を入力してください" + "※注意:日付は必ず" + LocalDate.now() + "という形式で入力してください");
				String setingBirthday = scan.next();
				LocalDate date = LocalDate.parse(setingBirthday);
				setBirthday(date);
			} catch (Exception e) {
			}
			try {
				System.out.println("血液型を入力してください");
				String setingBloodType = scan.next();
				setBloodType(setingBloodType);
			} catch (Exception e) {
			}
			try {
				System.out.println("趣味を入力してください");
				String setingHobby = scan.next();
				setHobby(setingHobby);
			} catch (Exception e) {
			}
			try {
				System.out.println("一言メモを入力してください");
				String setingMemo = scan.next();
				setMemo(setingMemo);
			} catch (Exception e) {
			}
			try {
				System.out.println("好感度を入力してください");
				String setinglikeAbility = scan.next();
				setLikeAbility(setinglikeAbility);
				System.out.println("----" + "作成が完了しました" + "----");
				System.out.println("名前：" + getName());
				System.out.println("誕生日：" + getBirthday());
				System.out.println("血液型：" + getBloodType() + "型");
				System.out.println("趣味：" + getHobby());
				System.out.println("メモ：" + getMemo());
				System.out.println("好感度：" + getLikeAbility());
				System.out.println("-----------------------");
				System.out.println("メニュー選択画面に戻ります");
				SystemMenu.Menu();
				break;
			} catch (Exception e) {
			}

		}
	}
}
