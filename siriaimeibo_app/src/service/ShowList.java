package service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import model.UserEntity;

public class ShowList extends UserEntity {
	@SuppressWarnings("static-access")
	public static void showList(ArrayList<String[]> allProfiles) {
		UserEntity userEntity = new UserEntity();
		LocalDate today = LocalDate.now();
		for (String[] profile : allProfiles) {
			String name = profile[0];
			LocalDate birthday = userEntity.convertToDate(profile[1]);
			int age = Period.between(birthday, today).getYears();
			String likeAbility = profile[5];
			System.out.println("名前:" + name + " | 年齢:" + age + "歳" + " | 好感度:" + likeAbility);
		}
	}

}
