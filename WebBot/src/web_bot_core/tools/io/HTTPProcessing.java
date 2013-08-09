package web_bot_core.tools.io;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;

public class HTTPProcessing {
	
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
	
	public int getServerCode(String _url) throws IOException{
		URL url = new URL(_url);
		HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
		openConnection.connect();
		return openConnection.getResponseCode();
	}
	
	public void print(Object _obj){
		System.out.println(_obj);
	}

}
