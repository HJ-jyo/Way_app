package service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

import model.UserEntity;

public class Edit {
	public static void edit(ArrayList<String[]> allProfiles) {
		Scanner scan = new Scanner(System.in);
		boolean isInvalid = true;
		for (String[] profile : allProfiles) {
			UserEntity userEntity = new UserEntity();
			LocalDate today = LocalDate.now();
			String name = profile[0];
			String dateOfBirth = profile[1];
			String bloodtype = profile[2];
			String hobby = profile[3];
			String likeAbility = profile[5];
			String fileCounter = profile[6];

			LocalDate birth = UserEntity.convertToDate(profile[1]);
			int age = Period.between(birth, today).getYears();

			String birthmonth = dateOfBirth.substring(4, 6);
			String birthday = dateOfBirth.substring(6, 8);

			System.out.println(
					"No." + fileCounter.substring(4, 8) + " | 名前:" + name + " | 年齢:" + age + "歳" + " | 誕生日:"
							+ birthmonth
							+ "月" + birthday + "日" + " | 血液型:"
							+ bloodtype
							+ " | 趣味:" + hobby
							+ " | 好感度:" + likeAbility);
		}

	}
}