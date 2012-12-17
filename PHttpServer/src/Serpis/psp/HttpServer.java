package Serpis.psp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HttpServer
 {

	/*
		con un navegador probar la conexión http://localhost:8080/index.html
				hacer con el terminal telnet -help
				telnet www.google.es 80
				Get/index.html HTTP/1.0
				telnet www.upv.es 80
				reenvio  Get/no_exist ....
				gedit www.upv.es
				Get/index.html HTTP/1.0
				*/
	public static void main(String[] args)throws IOException
	 {
		String nextLine = "\r\n";
		int port = 8080;
	
		ServerSocket serverSocket = new SeverSocket(port);
	
		Socket socket = serverSocket.accept();
		Scanner scanner = new Scanner(socket.getInputStream());
		
		while (true)
		{
			String line = scanner.nextLine();
			System.out.println(line);
			if (line.equals(""))
				break;
		}
		PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);//autoflush true
		
		printWriter.println("HTTP/1.0 404 Not Found" + nextLine);
		printWriter.println(nextLine);
		
		
		printWriter.Close();
		
		socket.Close();
		
		serverSocket.Close();
	}

}
