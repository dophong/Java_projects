package medigran;

import web_app_core.User;

public class Root extends User {
	
	public Root(){
		super();
		System.out.println("����������� ������ Root");
		login = "admin";
		pass = "admin";
	}

}