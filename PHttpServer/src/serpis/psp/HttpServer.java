package serpis.psp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		final int port = 8080;
		ServerSocket serverSocket = new ServerSocket(port);
		while(true)
		{
			Socket socket = serverSocket.accept();
			SimpleServer.Process(socket);
		}

	}

}
