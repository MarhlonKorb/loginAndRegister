package Vo;

public class DataUser {
	int id;
	protected String email;
	protected String password;
	
	public DataUser(){}
	
	public DataUser(String email, String password){
		this.email = email;
		this.password = password;
	}
	
	public DataUser(int id, String email, String password){
		this.id = id;
		this.email = email;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
