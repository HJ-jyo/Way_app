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
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import model.UserEntity;

public class Edit {

	public static void edit(ArrayList<String[]> allProfiles) {
		ArrayList<String> newFile = new ArrayList<>();
		Map<String, String[]> fileSearch = new HashMap<>();
		StringBuilder builder = new StringBuilder();
		boolean isInvalid = true;
		int allSelect = 0;

		while (isInvalid) {
			Scanner scan = new Scanner(System.in);
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
						}

						else {
							builder.append("-" + file[i]);
						}

					}

					String choiceFile = builder.toString();

					Path filePath = Paths.get(choiceFile + ".txt");

					System.out.println("選択されたファイル:" + filePath);
					System.out.println(
							"1:全て/" + "2:名前/" + "3:生年月日/" + "4:血液型/" + "5:趣味/" + "6:一言メモ/" + "7:好感度/" + "8:取り消し/"
									+ "9:保存・決定");
					int select = scan.nextInt();

					switch (select) {
					case 1:
						allSelect += 1;
					case 2:
						while (isInvalid) {
							try {
								System.out.println("名前を入力してください");
								String setingName = scan.next();
								file[0] = setingName;
								String newName = file[0];
								newFile.add(newName);
								if (setingName.contains("-")) {
									throw new IllegalArgumentException("-は使用できません");
								} else if (allSelect < 1) {
									isInvalid = false;
									break;
								}

							} catch (IllegalArgumentException e) {
								System.out.println(e.getMessage());
							}
						}
						isInvalid = true;
					case 3:
						while (isInvalid) {
							try {
								System.out.println("生年月日を入力してください");
								String setingBirthday = scan.next();
								file[1] = setingBirthday;
								String newBirthday = file[1];
								newFile.add(newBirthday);
								if (setingBirthday.contains("-")) {
									throw new IllegalArgumentException("-は使用できません");
								}
								isInvalid = false;
							} catch (IllegalArgumentException e) {
								System.out.println(e.getMessage());
							} finally {
								if (allSelect < 1) {
									break;
								}
							}
						}
						isInvalid = true;

					case 4:
						while (isInvalid) {
							try {
								System.out.println("血液型を入力してください");
								String setingBloodType = scan.next();
								file[2] = setingBloodType;
								String newBloodTyoe = file[2];
								newFile.add(newBloodTyoe);
								if (setingBloodType.contains("-")) {
									throw new IllegalArgumentException("-は使用できません");
								}
								isInvalid = false;
							} catch (IllegalArgumentException e) {
								System.out.println(e.getMessage());
							} finally {
								if (allSelect < 1) {
									break;
								}
							}
						}
						isInvalid = true;
					case 5:
						while (isInvalid) {
							try {
								System.out.println("趣味を入力してください");
								String setingHobby = scan.next();
								file[3] = setingHobby;
								String newHobby = file[3];
								newFile.add(newHobby);
								if (setingHobby.contains("-")) {
									throw new IllegalArgumentException("-は使用できません");
								}
								isInvalid = false;
							} catch (IllegalArgumentException e) {
								System.out.println(e.getMessage());
							} finally {
								if (allSelect < 1) {
									break;
								}
							}
						}
						isInvalid = true;

					case 6:
						while (isInvalid) {
							try {
								System.out.println("一言メモを入力してください");
								String setingMemo = scan.next();
								file[4] = setingMemo;
								String newMemo = file[4];
								newFile.add(newMemo);
								if (setingMemo.contains("-")) {
									throw new IllegalArgumentException("-は使用できません");
								}
								isInvalid = false;
							} catch (IllegalArgumentException e) {
								System.out.println(e.getMessage());
							} finally {
								if (allSelect < 1) {
									break;
								}
							}
						}
						isInvalid = true;

					case 7:
						while (isInvalid) {
							try {
								System.out.println("好感度を入力してください");
								String setingLiikeAbility = scan.next();
								file[5] = setingLiikeAbility;
								String newLikeAbility = file[5];
								newFile.add(newLikeAbility);
								if (setingLiikeAbility.contains("-")) {
									throw new IllegalArgumentException("-は使用できません");
								}
								isInvalid = false;
							} catch (IllegalArgumentException e) {
								System.out.println(e.getMessage());
							} finally {
								if (allSelect < 1) {
									break;
								}
							}
						}
						isInvalid = true;

						String createFileName = String.join("-", newFile) + ".txt";
						File dir = new File("UserList");
						File targetFile = new File(dir, createFileName);
						FileWriter fw = new FileWriter(targetFile);
						PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
						String fileContent = String.join("-", newFile);
						pw.println(fileContent);
						pw.close();
						Files.delete(filePath);

					case 8:
						break;
					}

				} catch (Exception e) {
					continue;
				}
				isInvalid = false;
			}
		}
	}
}
