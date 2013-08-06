import medigran.*;
import web_app_core.*;

public class WebApp {
	protected String baseUrl = "http://google.com";
	
	protected Doctor doctor = new Doctor();
	protected Reception reception = new Reception();
	protected Admin admin = new Admin();
	protected Login login = new Login();
	
	protected Root root = new Root();
	protected Registrator registrator = new Registrator();
	protected Patient patient = new Patient ();
	
	public static void main(String[] args) {
		WebApp m = new WebApp();
	}
	
	public WebApp(){
		run();
	}
	
	public void run(){
		login.openPage();
		login.autorize("root", "root");
	}
	
	
}
