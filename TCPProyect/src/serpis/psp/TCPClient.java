package serpis.psp;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

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
		
		printWriter.println("Hola desde TCP Client a las "+new Date());
		printWriter.println("Hola desde TCP Client2 a las "+new Date());
		
		printWriter.close();
		socket.close();

	}

}
