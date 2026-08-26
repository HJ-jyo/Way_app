package service;

import java.time.LocalDate;
import java.util.Scanner;

public class NewUser extends model.UserData {

	Scanner scan = new Scanner(System.in);

	public NewUser(String name, LocalDate birthday, String bloodType, String hobby, String memo) {
		super(name, birthday, bloodType, hobby, memo);
	}
}
