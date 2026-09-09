package model;

public class UserData {
	private String name;
	private String birthday;
	private String bloodType;
	private String hobby;
	private String memo;
	private String likeAbility;

	public UserData(String name, String birthday, String bloodType, String hobby, String memo, String likeAbility) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.bloodType = bloodType;
		this.hobby = hobby;
		this.memo = memo;
		this.likeAbility = likeAbility;
	}

	public UserData(String birthday) {
		super();
		this.name = "未設定";
		this.birthday = "未設定";
		this.bloodType = "未設定";
		this.hobby = "未設定";
		this.memo = "未設定";
		this.likeAbility = "未設定";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
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
