package medigran;

import web_app_core.User;

public class Registrator extends User {
	
	public Registrator(){
		super();
		System.out.println("Конструктор класса Registrator");
		login = "reg";
		pass = "reg";
	}
	
}