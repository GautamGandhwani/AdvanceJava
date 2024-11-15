package co.in.Bean;

import java.util.Date;

public class UserBean {
	
	private int Id;
	
	private String FirstName;
	
	private String LastName;
	
	private String LoginId;
	
	private String PassWord;
	
	private String Address;
	
	private Date Dob;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getLoginId() {
		return LoginId;
	}

	public void setLoginId(String loginId) {
		this.LoginId = loginId;
	}

	public String getPassWord() {
		return PassWord;
	}

	public void setPassWord(String passWord) {
		PassWord = passWord;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		this.Address = address;
	}

	public Date getDob() {
		return Dob;
	}

	public void setDob(Date dob) {
		this.Dob = dob;
	}
	
}
