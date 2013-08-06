package medigran;

import web_app_core.User;

public class Patient extends User {
	
	public Patient(){
		super();
		System.out.println("Конструктор класса Patient");
		login = "reg";
		pass = "reg";
	}
	
}