package service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import model.UserEntity;

public class ShowList {
	public static void showList(ArrayList<String[]> allProfiles) {
		LocalDate today = LocalDate.now();

		for (String[] profile : allProfiles) {
			String name = profile[0];
			LocalDate birthday = UserEntity.convertToDate(profile[1]);
			int age = Period.between(birthday, today).getYears();
			String memo = profile[4];
			String likeAbility = profile[5];

			System.out.println("名前:" + name + " | 年齢:" + age + "歳" + " | 一言メモ:" + memo + " | 好感度:" + likeAbility);
		}
	}

}
