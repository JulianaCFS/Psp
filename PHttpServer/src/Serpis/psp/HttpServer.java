package Serpis.psp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import org.omg.CORBA_2_3.portable.OutputStream;

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
		final String nextLine = "\r\n";
		final int port = 8080;
		final String fileNameError404 = "fileError404.html";
		final String response200 ="HTTP/1.0 200 OK";
		final String response404 ="HTTP/1.0 404 Not Found";
		
		//buscar el archivo que se pide
		ServerSocket serverSocket = new SeverSocket(port);
	
		Socket socket = serverSocket.accept();
		Scanner scanner = new Scanner(socket.getInputStream());
		
		String fileName = "index.html";
		//se lee lo que se pide
		while (true)
		{
			String line = scanner.nextLine();
			System.out.println(line);
			if (line.equals(""))
				break;
		}
		
		File file = new File(fileName);
		// cabecera
		String responseFileName = file.exists() ? fileName : fileNameError404;
		String response = file.exists() ? response200 : response404;
		
		FileInputStream fileInputStream = new FileInputStream(responseFileName);
		
		//con esto se escribe la cabecera
		String header = response + newLine + newLine;
		byte[] headerBuffer = header.getBytes();
		
		//fin código de la cabecera
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write(buffer, 0, );
		
		//se escribe el archivo
		final int bufferSize = 2048;
		byte[] buffer = new byte[bufferSize];
		int count;
		while((count = fileInputStream.read(buffer)) != -1)
			outputStream.write(buffer, 0, count);
		
		fileInputStream.close();
		
		printWriter.Close();
		
		socket.Close();
		
		serverSocket.Close();
	}

}
