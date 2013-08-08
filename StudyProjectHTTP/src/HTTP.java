import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.w3c.dom.*;

public class HTTP {

	
	private static final String String = null;
	public static void main(String[] args) throws Exception {
		HTTP m = new HTTP();
	}

	public HTTP() {
	}

	public String sendRequest(String _url) throws Exception {
		URL yahoo = new URL(_url);
		URLConnection yc = yahoo.openConnection();

		BufferedReader in = new BufferedReader( new InputStreamReader(yc.getInputStream()) );
		String inputLine;
		String _result = "";
		while ((inputLine = in.readLine()) != null) {
			_result += inputLine;
		}
		in.close();
		return _result;
	}

	public void sendPostRequest(String _url, String _urlParameters)	throws Exception {
		URL url = new URL(_url);
		URLConnection conn = url.openConnection();

		conn.setDoOutput(true);

		OutputStreamWriter writer = new OutputStreamWriter(
				conn.getOutputStream());

		writer.write(_urlParameters);
		writer.flush();

		String line;
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		writer.close();
		reader.close();
	}

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
			System.err.println("Error: " + e.getMessage());
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
	
	public BufferedImage getImageFromUrl(String _url) throws IOException{
		
		BufferedImage img = null;
		try {
		    URL url = new URL(_url);
		    img = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}	
	public void saveImgToFile(BufferedImage _img, String _path) throws IOException{
		
		File outputfile = new File(_path);
		String ext = _path.substring(_path.lastIndexOf(".") + 1);
		ImageIO.write(_img, ext, outputfile);
	}
	
	public void xmlParser_test(){
		try {
			File stocks = new File("C:/files/stocks.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(stocks);
			doc.getDocumentElement().normalize();

			System.out.println("root of xml file " + doc.getDocumentElement().getNodeName());
			NodeList nodes = doc.getElementsByTagName("recipe");
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
	
	public String[] htmlParser() throws IOException{
		org.jsoup.nodes.Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
		Elements newsHeadlines = doc.select("a");
		
		//print( newsHeadlines.toString() );
		return (java.lang.String[]) newsHeadlines.toArray();
	}
	
	
	public void print(Object _obj){
		System.out.println(_obj);
	}
	
}
