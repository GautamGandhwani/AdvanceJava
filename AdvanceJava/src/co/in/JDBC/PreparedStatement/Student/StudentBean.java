package co.in.JDBC.PreparedStatement.Student;

import java.util.Date;

public class StudentBean {

	private int Id;
	
	private String FirstName;
	
	private String LastName;
	
	private String CollageName;
	
	private String Email;
	
	private String MobileNo;
	
	private Date DOB;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		 Id = id;
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
		this.LastName = lastName;
	}

	public String getCollageName() {
		return CollageName;
	}

	public void setCollageName(String collageName) {
		this.CollageName = collageName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getMobileNo() {
		return MobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.MobileNo = mobileNo;
	}

	public Date getDob() {
		return DOB;
	}

	public void setDob(Date dob) {
		this.DOB = dob;
	}
	
}
