package model;

import java.time.LocalDate;

public class UserData {
	private String name;
	private LocalDate birthday;
	private String bloodType;
	private String hobby;
	private String memo;
	private String likeAbility;

	public UserData(String name, LocalDate birthday, String bloodType, String hobby, String memo, String likeAbility) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.bloodType = bloodType;
		this.hobby = hobby;
		this.memo = memo;
		this.likeAbility = likeAbility;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getLikeAbility() {
		return likeAbility;
	}

	public void setLikeAbility(String likeAbility) {
		this.likeAbility = likeAbility;
	}

}
