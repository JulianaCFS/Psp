package serpis.psp;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class TCPClient
{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		
		String host = "127.0.0.1"; //o null//localhost 127.0.0.1
		int port= 10001;
		Socket socket = new Socket(host, port);
		
		OutputStream outputStream = socket.getOutputStream();
		
		PrintWriter printWriter = new PrintWriter(outputStream,true);
		
		printWriter.println("HOLA MUNDO");
		
		Scanner scanner = new Scanner(socket.getInputStream());
		
		String line = scanner.nextLine();
		System.out.println("Estoy en el cliente la frase devuelta es "+line);
		
		
		printWriter.close();
		socket.close();

	}

}
