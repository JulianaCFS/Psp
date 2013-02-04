package serpis.psp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ThreadServer implements Runnable
{
	private Socket socket;
	private static final String newLine = "\r\n";
	private final String defaultFileName = "index.html";
	private final String fileNameError404 = "fileError404.html";
	private final String response200 ="HTTP/1.0 200 OK";
	private final String response404 ="HTTP/1.0 404 Not Found";
	
	private InputStream inputStream;
	private OutputStream outputStream;
	private String fileName;
	private Boolean fileExists;
	
	public ThreadServer(Socket socket)
	{
		this.socket = socket;
		
	}

	@Override
	public void run() {
		/*for(int i=0;i<3;i++){
			System.out.println(Thread.currentThread().getName() + "paso"+i);
			try{
				Thread.sleep(1000);
			}catch(InterruptedException ex){
				
			}
		}*/
		System.out.println(Thread.currentThread().getName() + "inicio.");
		try{
		inputStream = socket.getInputStream();
		outputStream = socket.getOutputStream();
		getFileName();
	 	writeHeader();
	 	writeFile();
	 	getFileExists();
	 	getFileName();
	 	socket.close();
		}catch(IOException ex){
			
		}
		
		System.out.println(Thread.currentThread().getName() + "fin.");
		
	}
	
	
	private void getFileName()
	{
		Scanner scanner = new Scanner( inputStream);
		
		
		//String fileName = "index.html";
		String fileName = ""; 
		
		//se lee la peticion
		while (true)
		{
			String line = scanner.nextLine();
			
			if(line.startsWith("GET"))//Get /index.html HTTP/1.1
			{		//opcion1
				//fileName = line.split(" ")[1].substring(1);//->index.html
				//System.out.println("fileName=" + fileName);
					//opcion2
				//fileName = line.substring(5,line.indexOf(" ",5));
				//System.out.println("fileName=" + fileName);
					//opcion3
				/*int index = 5;
				while (line.charAt(index) != ' '){
					fileName += line.charAt(index++);
					System.out.println("fileName=" + fileName);
				}
				System.out.println("fileName=" + fileName);*/
					
					//opcion5 MiOpcion
				fileName = line.substring(line.indexOf(" ")+2, line.lastIndexOf(" "));
				System.out.println("fileName=" + fileName);
				//System.out.println("line.indexOf=" + line.indexOf(" "));
				//System.out.println("line.LastindexOf =" + line.lastIndexOf(" "));
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			System.out.println(line);
			if (line.equals(""))
				break;
		}
		//cuando se pide el raiz:localhost:8080, aparece el fichero index.
				if(fileName.equals(""))
					fileName = defaultFileName;
				System.out.println("fileName=" + fileName);
		
	}
	private void getFileExists()
	{
		File file = new File(fileName);
		fileExists = file.exists();
	}
	private  void writeHeader() throws IOException
	{	
		File file = new File(fileName);
		
		String response = file.exists() ? response200 : response404;
		String header = response + newLine + newLine;
		
		byte[] headerBuffer = header.getBytes();
		
		outputStream.write(headerBuffer );
	}
	private  void writeFile() throws IOException{
		
		
		
		File file = new File(fileName);
		String responseFileName = file.exists() ? fileName : fileNameError404;
		
		final int bufferSize = 2048;
		byte[] buffer = new byte[bufferSize];
		
		
		FileInputStream fileInputStream = new FileInputStream(responseFileName);
		
		int count;
		while((count = fileInputStream.read(buffer)) != -1){
			try {
				System.out.println(Thread.currentThread().getName()+ ".");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//retardo del proceso de lectura y escritura
			outputStream.write(buffer, 0, count);
		}
			
		
		fileInputStream.close();
	}
		
	 

}
