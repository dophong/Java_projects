package web_app_core;

public class Page {

	protected String url = "";
	
	public Page(){
		System.out.println("Конструктор класса Page");
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public void openPage(){	
		System.out.println("Страница открыта");
	}
	
	public String getContent(){
		return "";
	}
}
