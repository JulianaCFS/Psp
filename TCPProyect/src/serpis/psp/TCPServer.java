package serpis.psp;
import java.io.IOException;
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
		
		ServerSocket serverSocket = new ServerSocket(port);
		
		Socket socket = serverSocket.accept();
		
		Scanner scanner = new Scanner(socket.getInputStream());//aqui tiene el mensaje de client
		
		String line = scanner.nextLine();//aqui lee el mensaje
		System.out.println("Line = " + line);//aqui imprime el mensaje
		
		String line2 = scanner.nextLine();//aqui lee el mensaje
		System.out.println("Line2 = " + line2);//aqui imprime el mensaje
		
		socket.close();
		serverSocket.close();

	}

}
