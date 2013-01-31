package serpis.psp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import org.omg.CORBA_2_3.portable.OutputStream;

public class HttpServerMio
 {	//Servidor monoHilo y sin está legible.
	

	
	public static void main(String[] args)throws IOException
	 {
		final String newLine = "\r\n";
		final int port = 8080;
		final String fileNameError404 = "fileError404.html";
		final String response200 ="HTTP/1.0 200 OK";
		final String response404 ="HTTP/1.0 404 Not Found";
		
		//buscar el archivo que se pide
		ServerSocket serverSocket = new ServerSocket(port);
		try{
			while(true){
			
		Socket socket = serverSocket.accept();
		Scanner scanner = new Scanner(socket.getInputStream());
		
		String fileName = "index.html";
		//se lee la peticion
		while (true)
		{
			String line = scanner.nextLine();
			if(line.startsWith("GET")){
				
			}
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
		java.io.OutputStream outputStream = socket.getOutputStream();
		outputStream.write(headerBuffer );
		
		//se escribe el archivo
		final int bufferSize = 2048;
		byte[] buffer = new byte[bufferSize];
		int count;
		
		while((count = fileInputStream.read(buffer)) != -1){
			Thread.sleep(3000);//retardo del proceso de lectura y escritura
			outputStream.write(buffer, 0, count);
		}
			
		
		fileInputStream.close();
		
		
		socket.close();
		}
		}catch(Exception e){
			System.err.println("Error:" + e.getMessage());
			e.printStackTrace();
			
		}finally{
		serverSocket.close();
		}
	}

}
