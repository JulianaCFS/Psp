package serpis.psp;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		
		int port = 10001;
		System.out.println("estoy en el servidor");
		ServerSocket serverSocket = new ServerSocket(port);
		
		Socket socket = serverSocket.accept();
		
		Scanner scanner = new Scanner(socket.getInputStream());//aqui tiene el mensaje de client
		
		String line = scanner.nextLine();//aqui lee el mensaje
		String minuscula=line.toLowerCase();
		System.out.println("Line = " +minuscula);//aqui imprime el mensaje
		
		OutputStream outputStream = socket.getOutputStream();
		PrintWriter printWriter = new PrintWriter(outputStream,true);
		
		printWriter.write(minuscula);
		
		
		
		printWriter.close();
		socket.close();
		serverSocket.close();

	}

}
