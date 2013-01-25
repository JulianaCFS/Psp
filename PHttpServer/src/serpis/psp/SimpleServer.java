package serpis.psp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SimpleServer
{
	private static final String newLine = "\r\n";
	public static void main(String[] args)throws IOException
	{	
		final int port = 8080;
		
		ServerSocket serverSocket = new ServerSocket(port);
		try
		{
			
		
			while(true)
		 	{	
			 	Socket socket = serverSocket.accept();
			 	
			 	String fileName = getFileName(socket.getInputStream());
			 	//escribe la cabecera en funcion del archivo
			 	writeHeader(socket.getOutputStream(),fileName);
			 	writeFile(socket.getOutputStream(),fileName);
			 	socket.close();
			 	
			 	}
			}catch(Exception e){
				System.err.println("Error:" + e.getMessage());
				e.printStackTrace();
				
			}finally{
			serverSocket.close();
			}
	 }
	//implementar correctamente
	private static String getFileName(InputStream inputStream)
	{
		Scanner scanner = new Scanner( inputStream);
		
		//String fileName = "index.html";
		String fileName = ""; 
		
		//se lee la peticion
		while (true)
		{
			String line = scanner.nextLine();
			if(line.startsWith("GET"))//Get /index.html HTTP/1.1
			{
				//fileName = line.split(" ")[1].substring(1);//->index.html
				//System.out.println("fileName=" + fileName);
				//fileName = line.substring(5,line.indexOf(" ",5));
				int index = 5;
				while (line.charAt(index) != ' ')
					fileName += line.charAt(index++);
				
				System.out.println("fileName=" + fileName);
				
			}
			System.out.println(line);
			if (line.equals(""))
				break;
		}
		return fileName;
	}
	private static void writeHeader(OutputStream outputStream, String fileName) throws IOException
	{	
		File file = new File(fileName);
		
		final String response200 ="HTTP/1.0 200 OK";
		final String response404 ="HTTP/1.0 404 Not Found";
		String response = file.exists() ? response200 : response404;
		String header = response + newLine + newLine;
		
		byte[] headerBuffer = header.getBytes();
		
		outputStream.write(headerBuffer );
	}
	private static void writeFile(OutputStream outputStream, String fileName) throws IOException{
		
		final String fileNameError404 = "fileError404.html";
		
		File file = new File(fileName);
		String responseFileName = file.exists() ? fileName : fileNameError404;
		
		final int bufferSize = 2048;
		byte[] buffer = new byte[bufferSize];
		
		
		FileInputStream fileInputStream = new FileInputStream(responseFileName);
		
		int count;
		while((count = fileInputStream.read(buffer)) != -1){
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//retardo del proceso de lectura y escritura
			outputStream.write(buffer, 0, count);
		}
			
		
		fileInputStream.close();
	}
		
	 

}
