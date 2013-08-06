package medigran;

import web_app_core.Page;


public class Login extends Page {
	private String log = "";
	private String pass = "";
	private Root root = new Root(); 
	private Registrator reg = new Registrator ();
	private Patient patient = new Patient ();
	public Login(){
		super();
		System.out.println("Конструктор класса Login");
	}
	
	public void autorize(String login, String password){
		log = login;
		pass = password;
		if (log.equals(root.getLogin()) && pass.equals(root.getPass())){
			System.out.println("Введены верные логин и пароль" );	
			System.out.println("Вы успешно вошли в систему как " + log);	
		}
		else if (log.equals(reg.getLogin()) && pass.equals(reg.getPass())){
			System.out.println("Введены верные логин и пароль" );	
			System.out.println("Вы успешно вошли в систему как " + log);
		}
		else if (log.equals(patient.getLogin()) && pass.equals(patient.getPass())){
			System.out.println("Введены верные логин и пароль" );	
			System.out.println("Вы успешно вошли в систему как " + log);
		} else {
			System.out.println("Введен неверный логин или пароль");	
		}
		
			
	}
}