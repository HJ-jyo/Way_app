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
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import model.UserData;
import model.UserEntity;

public class Edit extends UserData {

	public Edit(String name, String birthday, String bloodType, String hobby, String memo, String likeAbility) {
		super(name, birthday, bloodType, hobby, memo, likeAbility);
	}

	public static void edit(ArrayList<String[]> allProfiles) {
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
					System.out.println("編集したいファイルをNo.に続く形で指定してください。0でメニューに戻れます");
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
					System.out.println(
							"1:全て/" + "2:名前/" + "3:生年月日/" + "4:血液型/" + "5:趣味/" + "6:一言メモ/" + "7:好感度/" + "8:戻る");
					int select = scan.nextInt();
					if (select == 1) {
						Files.delete(filePath);
						NewUser newUser = new NewUser("未設定", "未設定", "未設定", "未設定", "未設定", "未設定");
						newUser.Create();
					} else if (select == 2) {
						while (isInvalid) {
							try {
								System.out.println("名前を入力してください");
								String setingName = scan.next();
								if (setingName.contains("-")) {
									throw new IllegalArgumentException("-は使用できません");
								}
								copyFile[0] = setingName;
								isInvalid = false;
							} catch (IllegalArgumentException e) {
								System.out.println(e.getMessage());
							}
						}
					} else if (select == 3) {
						while (isInvalid) {
							try {
								System.out.println("生年月日を入力してください");
								String setingBirthday = scan.next();
								try {
									DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuuMMdd")
											.withResolverStyle(ResolverStyle.STRICT);
									LocalDate.parse(setingBirthday, formatter);
								} catch (DateTimeParseException e) {
									throw new IllegalArgumentException("正しい生年月日を入力してください。");
								}
								copyFile[1] = setingBirthday;
								isInvalid = false;
							} catch (IllegalArgumentException e) {
								System.out.println(e.getMessage());
							}
						}
					} else if (select == 4) {
						while (isInvalid) {
							try {
								System.out.println("血液型を入力してください");
								String setingBloodType = scan.next();
								if (setingBloodType.contains("-")) {
									throw new IllegalArgumentException("-は使用できません");
								}
								copyFile[2] = setingBloodType;
								isInvalid = false;
							} catch (IllegalArgumentException e) {
								System.out.println(e.getMessage());
							}
						}
					} else if (select == 5) {
						while (isInvalid) {
							try {
								System.out.println("趣味を入力してください");
								String setingHobby = scan.next();
								if (setingHobby.contains("-")) {
									throw new IllegalArgumentException("-は使用できません");
								}
								copyFile[3] = setingHobby;
								isInvalid = false;
							} catch (IllegalArgumentException e) {
								System.out.println(e.getMessage());
							}
						}
					} else if (select == 6) {
						while (isInvalid) {
							try {
								System.out.println("一言メモを入力してください");
								String setingMemo = scan.next();
								if (setingMemo.contains("-")) {
									throw new IllegalArgumentException("-は使用できません");
								}
								copyFile[4] = setingMemo;
								isInvalid = false;
							} catch (IllegalArgumentException e) {
								System.out.println(e.getMessage());
							}
						}
					} else if (select == 7) {
						while (isInvalid) {
							try {
								System.out.println("好感度を入力してください");
								String setingLiikeAbility = scan.next();
								if (setingLiikeAbility.contains("-")) {
									throw new IllegalArgumentException("-は使用できません");
								}
								copyFile[5] = setingLiikeAbility;
								isInvalid = false;
							} catch (IllegalArgumentException e) {
								System.out.println(e.getMessage());
							}
						}
					} else if (select == 8) {
						break;
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
				} catch (Exception e) {
					continue;
				}

			}
		}
	}
}
