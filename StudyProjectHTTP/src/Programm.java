import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Programm {

	public HTTP request;
	public String url = "";
	
	public static void main(String[] args) throws IOException {
		Programm m = new Programm();
	}

	public Programm() throws IOException {

		try {
			String _id;
			String _fileContent;
			
			request = new HTTP();
			System.out.println("Введите поисковый запрос: ");
			String text = request.enterText();
			_id = request.writeFile(text,"C:/files/textfile.txt.txt" );
			_id = request.readFile("C:/files/textfile.txt.txt");
			
			url = "http://www.bing.com/search?q=" + _id;
			url = url.replaceAll(" ", "%20");
			_fileContent = request.sendRequest(url);
			System.out.println("Отправлен_запрос: " + url);
			System.out.println("Получен ответ: " + _fileContent);
			request.writeFile(_fileContent, "C:/files/index.html");
			System.out.println("Результаты поиска сохранены.");
			
			
			//BufferedImage i = request.getImageFromUrl("http://personal.psu.edu/tao5048/JPG.jpg");
			//request.saveImgToFile(i ,"C:/files/out2.png");
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
		
	}
	
	
}
