package web_app_core;

public class Page {

	protected String url = "";
	
	public Page(){
		System.out.println("����������� ������ Page");
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public void openPage(){	
		System.out.println("�������� �������");
	}
	
	public String getContent(){
		return "";
	}
}
