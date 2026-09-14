package service;

import java.util.ArrayList;
import java.util.Scanner;

public class Edit {
	public static void edit(ArrayList<String[]> allProfiles) {
		Scanner scan = new Scanner(System.in);
		boolean isInvalid = true;
		int fileCounter = 0;
		for (String[] profile : allProfiles) {
			fileCounter += 1;
			String name = profile[0];
			String birthday = profile[1];
			String bloodtype = profile[2];
			String hobby = profile[3];
			String likeAbility = profile[5];
			System.out.println(
					"No." + fileCounter + " | 名前:" + name + " | 生年月日:" + birthday + " | 血液型:" + bloodtype
							+ " | 趣味:" + hobby
							+ " | 好感度:" + likeAbility);
		}
	}
}