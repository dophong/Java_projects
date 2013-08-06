import java.io.*;

public class ReadWriteFile {

	public static void main(String args[]) {
		{
			try {
				//File file = new File("C:/robots.txt");
				//FileInputStream fis = null;
				FileInputStream fstream = new FileInputStream("C:/files/textfile.txt.txt");
				// Get the object of DataInputStream
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				
				String strLine;
				// Read File Line By Line
				while ((strLine = br.readLine()) != null) {
					// Print the content on the console
					System.out.println(strLine);
				}
				// Close the input stream
				in.close();
			} catch (Exception e) {// Catch exception if any
				System.err.println("Error: " + e.getMessage());
			}
		}
	}

}
