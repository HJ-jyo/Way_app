package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserEntity {
	public static LocalDate convertToDate(String dateStr) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		return LocalDate.parse(dateStr, formatter);
	}
}