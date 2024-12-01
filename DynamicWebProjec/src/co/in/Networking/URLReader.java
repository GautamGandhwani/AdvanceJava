package co.in.Networking;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class URLReader {

	public static void main(String[] args) {

		URL u = null;
		try {
			u = new URL("http://localhost:8080/DynamicWebProjec/");

			System.out.println("Protocol = " + u.getProtocol());
			System.out.println("Host Name = " + u.getHost());
			System.out.println("Port Name = " + u.getPort());
			System.out.println("File Name = " + u.getFile());

			InputStream istr = u.openStream();

			Scanner in = new Scanner(istr);

			System.out.println("URL Contents ***");

			while (in.hasNext()) {
				String html = (String) in.next();
				System.out.println(html);
			}
			in.close();

		} catch (MalformedURLException e) {
			System.out.println("Invalid URL");
		} catch (IOException e) {
			System.out.println("Input Output Error");
		}

	}

}
