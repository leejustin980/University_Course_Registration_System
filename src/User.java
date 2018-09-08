package main;

public class User implements java.io.Serializable{
	//data fields
	String username;
	String password;
	String fname;
	String lname;
	
	// default constructor
	public User() {
		username = "default username";
		password = "default password";
		fname = "default first name";
		lname = "default last name";
	}

	// constructor
	public User(String username, String password,
				String fname, String lname) {
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
	}

	// getters and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	
}
