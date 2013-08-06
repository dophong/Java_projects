package medigran;

import web_app_core.Page;

public class Doctor extends Page {
	
	public Doctor(){
		super();
		System.out.println("Конструктор класса Doctor");
	}
	
	public void makeAssignment(){
		System.out.println("Вы успешно сделали назначение");
	}
}