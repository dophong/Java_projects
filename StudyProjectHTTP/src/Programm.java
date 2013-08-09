import java.io.IOException;

public class Programm {

	public HTTP request;
	public String url = "";
	
	public static void main(String[] args) throws IOException {
		Programm m = new Programm();
	}

	public Programm() throws IOException {
		request = new HTTP();
		
		//saveImage();
		//htmlParse();
		htmlValidate();
		
	}
	
	private void htmlParse() {
		try {
			String[] _htmlContent;
			_htmlContent = request.htmlParser("http://msn.com", "a");
			for (int i = 0; i < _htmlContent.length; i++){
				//print(_htmlContent[i]);
			}
			
			_htmlContent = request.htmlParser("http://msn.com", "a", "");
			for (int i = 0; i < _htmlContent.length; i++){
				print(_htmlContent[i]);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void htmlValidate() {
		try {
			String[] _htmlContent;
			_htmlContent = request.htmlParser("http://ya.ru", "a");
			for (int i = 0; i < _htmlContent.length; i++){
				print(_htmlContent[i]);
			}
			
			_htmlContent = request.htmlParser("http://ya.ru", "a", "href");
			String _str = "";
			for (int i = 0; i < _htmlContent.length; i++){
				try{
					_str = _str + "\n" + _htmlContent[i] + " - "+ request.getServerCode(_htmlContent[i]);
					//request.writeFile( a +" --"+ request.getServerCode(_htmlContent[i]),"C:/files/result.txt" );
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			request.writeFile( _str,"C:/files/result.txt" );
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void saveImage(){
		try {
			String _id;
			String _fileContent;
			String _filePath;
			
			
			System.out.println("Введите поисковый запрос: ");
			String text = request.enterText();
			_id = request.writeFile(text,"C:/files/stocks.xml" );
			_id = request.readFile("C:/files/stocks.xml");
			
			url =  _id;
			url = url.replaceAll(" ", "%20");
			
			_fileContent = request.sendRequest(url);
			System.out.println("Отправлен_запрос: " + url);
			System.out.println("Получен ответ: " + _fileContent);
			request.writeFile(_fileContent, "C:/files/index.xml");
			System.out.println("Результаты поиска сохранены.");
			
			request.xmlParser("C:/files/index.xml");
		
			//BufferedImage i = request.getImageFromUrl("http://personal.psu.edu/tao5048/JPG.jpg");
			//request.saveImgToFile(i ,"C:/files/out2.png");
			
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void print(Object _obj){
		System.out.println(_obj);
	}
	
	
	
}
