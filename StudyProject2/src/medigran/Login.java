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
		System.out.println("����������� ������ Login");
	}
	
	public void autorize(String login, String password){
		log = login;
		pass = password;
		if (log.equals(root.getLogin()) && pass.equals(root.getPass())){
			System.out.println("������� ������ ����� � ������" );	
			System.out.println("�� ������� ����� � ������� ��� " + log);	
		}
		else if (log.equals(reg.getLogin()) && pass.equals(reg.getPass())){
			System.out.println("������� ������ ����� � ������" );	
			System.out.println("�� ������� ����� � ������� ��� " + log);
		}
		else if (log.equals(patient.getLogin()) && pass.equals(patient.getPass())){
			System.out.println("������� ������ ����� � ������" );	
			System.out.println("�� ������� ����� � ������� ��� " + log);
		} else {
			System.out.println("������ �������� ����� ��� ������");	
		}
		
			
	}
}