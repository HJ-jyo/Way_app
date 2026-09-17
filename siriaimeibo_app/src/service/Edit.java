package service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import model.UserEntity;

public class Edit {
	static Scanner scan = new Scanner(System.in);

	public static void edit(ArrayList<String[]> allProfiles) {

		Map<String, String[]> fileSearch = new HashMap<>();
		StringBuilder builder = new StringBuilder();

		boolean isInvalid = true;

		while (isInvalid) {
			for (String[] profile : allProfiles) {

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

				fileSearch.put(fileCounter.substring(4, 8), profile);
				System.out.println(
						"No." + fileCounter.substring(4, 8) + " | 名前:" + name + " | 年齢:" + age + "歳" + " | 誕生日:"
								+ birthmonth
								+ "月" + birthday + "日" + " | 血液型:"
								+ bloodtype
								+ " | 趣味:" + hobby
								+ " | 好感度:" + likeAbility);
			}

			System.out.println("編集したいファイルをNo.に続く形で指定してください。");
			String key = scan.next();
			String[] file = (String[]) fileSearch.get(key);

			for (int i = 0; i < file.length - 1; i++) {
				builder.append(file[i]);
			}

			String choiceFile = builder.toString();

			Path filePath = Paths.get(choiceFile + ".txt");
			System.out.println("選択されたファイル:" + filePath);

			isInvalid = false;
		}
	}
}