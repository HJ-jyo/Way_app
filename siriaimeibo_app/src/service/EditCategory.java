package service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import model.UserEntity;

public class EditCategory {
	public static void editCategory(ArrayList<String[]> allProfiles) {
		Map<String, String[]> fileSearch = new HashMap<>();
		boolean isInvalid = true;
		Scanner scan = new Scanner(System.in);

		while (isInvalid) {
			StringBuilder builder = new StringBuilder();
			for (String[] profile : allProfiles) {

				LocalDate today = LocalDate.now();
				String name = profile[0];
				String dateOfBirth = profile[1];
				String bloodtype = profile[2];
				String hobby = profile[3];
				String likeAbility = profile[5];
				String fileCounter = profile[profile.length - 1];

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

			isInvalid = true;
			while (isInvalid) {
				try {
					System.out.println("カテゴリを追加したいファイルをNo.に続く形で指定してください。0でメニューに戻れます");
					String key = scan.next();

					if (key.equals("0")) {
						isInvalid = false;
						break;
					}

					String[] file = (String[]) fileSearch.get(key);
					for (int i = 0; i < file.length - 1; i++) {
						if (i == 0) {
							builder.append(file[i]);
						} else {
							builder.append("-" + file[i]);
						}
					}

					String choiceFile = builder.toString();
					Path filePath = Paths.get("UserList", choiceFile + ".txt");
					String[] copyFile = Arrays.copyOf(file, file.length - 1);

					System.out.println("選択されたファイル:" + filePath);
					while (isInvalid) {
						try {
							System.out.println("カテゴリ名を入力してください");
							String setCategory = scan.next();

							if (setCategory.contains("-")) {
								throw new IllegalArgumentException("-は使用できません");
							}
							String[] newArray = Arrays.copyOf(copyFile, copyFile.length + 1);
							newArray[newArray.length - 1] = setCategory;
							copyFile = newArray;
							isInvalid = false;
						} catch (IllegalArgumentException e) {
							System.out.println(e.getMessage());
							continue;
						}
						String createFileName = String.join("-", copyFile) + ".txt";
						File dir = new File("UserList");
						File targetFile = new File(dir, createFileName);
						FileWriter fw = new FileWriter(targetFile);
						PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
						String fileContent = String.join("-", copyFile);
						pw.println(fileContent);
						pw.close();
						Files.delete(filePath);
						isInvalid = false;
						break;
					}

				} catch (Exception e) {
					continue;
				}
			}
		}
	}
}