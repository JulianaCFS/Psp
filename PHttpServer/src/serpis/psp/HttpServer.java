package serpis.psp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		final int port = 8080;
		ServerSocket serverSocket = new ServerSocket(port);
		//prueba multihilos
		/*for (int i=0;i<4;i++){
			Runnable runnable = new ThreadServer();
			Thread thread = new Thread(runnable);
			thread.start();
			Thread.sleep(1000);
			}*/
		while(true)
		{
			Socket socket = serverSocket.accept();
			//SimpleServer.Process(socket);
			Runnable runnable = new ThreadServer(socket);
			Thread thread = new Thread(runnable);
			thread.start();
			Thread.sleep(1000);
			
		}

	}

}
