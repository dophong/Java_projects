package medigran;

import web_app_core.User;

public class Patient extends User {
	
	public Patient(){
		super();
		System.out.println("����������� ������ Patient");
		login = "reg";
		pass = "reg";
	}
	
}