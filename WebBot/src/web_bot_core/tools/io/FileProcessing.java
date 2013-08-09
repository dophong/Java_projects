package web_bot_core.tools.io;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FileProcessing {

	
	public String readFile(String _url) {
		String strLine = "";
		String _result = "";
		try {
			FileInputStream fstream = new FileInputStream(_url);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				_result = strLine;
			}
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			print("Error: " + e.getMessage());
		}
		
		return _result;
	}
	
	public String writeFile(String _text, String _path) throws IOException {
		// Создаём объект файла
		File flt = new File(_path);
		// Объект, позволяющий осуществить запись в файл
		FileWriter wrt = new FileWriter(flt);

		wrt.append(_text);
		// Собственно здесь и происходит сама запись в файл
		wrt.flush();
		wrt.close();
		return null;
	}
	
	public String enterText(){
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String _text = null;
		try {
			_text = String.valueOf(in.readLine());			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return _text;
	}
	
	public void saveImgToFile(BufferedImage _img, String _path) throws IOException{
		
		File outputfile = new File(_path);
		String ext = _path.substring(_path.lastIndexOf(".") + 1);
		ImageIO.write(_img, ext, outputfile);
	}
	
	public void xmlParser(String _path){
		try {
			File stocks = new File(_path );
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(stocks);
			doc.getDocumentElement().normalize();

			System.out.println("root of xml file " + doc.getDocumentElement().getNodeName());
			NodeList nodes = doc.getElementsByTagName("!DOCTYPE");
			System.out.println("==========================");

			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("Рецепт: " + getValue("title", element, 0));
					System.out.println("Ингридиенты: " + getValue("ingredient", element, 0));
					System.out.println("Ингридиенты: " + getValue("ingredient", element, 1));
					System.out.println("Способ приготовления: " + getValue("step", element, 0));
				}
			}
		} catch (Exception ex) {
				ex.printStackTrace();				
		}
	}
	private String getValue(String tag, Element element, int id) {
		NodeList nodes = element.getElementsByTagName(tag).item(id).getChildNodes();
		Node node = (Node) nodes.item(0);
		return node.getNodeValue();
	}
	
	public String[] htmlParser(String _url, String _tag) throws IOException{
		org.jsoup.nodes.Document doc = Jsoup.connect(_url).get();
		Elements newsHeadlines = doc.select(_tag);
		
		Object[] objArr = newsHeadlines.toArray();
		String[] objStr = new String[objArr.length];
		for (int i = 0; i < objArr.length; i++){
			objStr[i] = objArr[i].toString();
		}
		return objStr;
	}
	
	public String[] htmlParser(String _url, String _tag, String _attr) throws IOException{
		org.jsoup.nodes.Document doc = Jsoup.connect(_url).get();
		Elements newsHeadlines = doc.select(_tag);
		
		Object[] objArr = newsHeadlines.toArray();
		String[] objStr = new String[objArr.length];
		for (int i = 0; i < objArr.length; i++){
			String _tmp = objArr[i].toString();
			if(_tmp.indexOf(_attr) != -1){
				objStr[i] = _tmp.replaceAll(".*"+_attr+"=\"", "").replaceAll("\".*", "");
			}else{
				objStr[i] = "";
			}
			
		}
		
		return objStr;
	}
	public void print(Object _obj){
		System.out.println(_obj);
	}
	
	
	
	
}
