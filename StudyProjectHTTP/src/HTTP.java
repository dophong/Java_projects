import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;

public class HTTP {

	
	public static void main(String[] args) throws Exception {
		HTTP m = new HTTP();
	}

	public HTTP() throws Exception {
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
		// —оздаЄм объект файла
		File flt = new File(_path);
		// ќбъект, позвол€ющий осуществить запись в файл
		FileWriter wrt = new FileWriter(flt);

		wrt.append(_text);
		// —обственно здесь и происходит сама запись в файл
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
	
	
}
