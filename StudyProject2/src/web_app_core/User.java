package web_app_core;

public class User {
	protected String login = "";
	protected String pass = "";
	protected String [] role = {"registrator", "root", "patient"};
	
	public User(){
		System.out.println("Конструктор класса User");
	}
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String[] getRole() {
		return role;
	}
	
	public void setRole(String[] role) {
		this.role = role;
	}
	
}
