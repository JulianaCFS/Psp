package serpis.psp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer
{

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException
	{
		
		
		//el servidor recibe el paquete,enviado por el UDPClient
		
		byte[]buf=new byte[2048];
		int port=10001;
		
		DatagramPacket datagramPacket=new DatagramPacket(buf,buf.length);
		
		InetAddress inetAddress=InetAddress.getByName("127.0.0.1");
		
		DatagramSocket datagramSocket=new DatagramSocket(port);
		
		datagramSocket.receive(datagramPacket);
		
		String data=new String(datagramPacket.getData(),0,datagramPacket.getLength());
		
		System.out.printf("Data=%s,InetAddress=%s;Port=%s/n",
		data,datagramPacket.getAddress(),datagramPacket.getPort());
		System.out.printf("longitud=%s/n", datagramPacket.getLength());
		datagramSocket.close();
		
		
		
		
		

	}

}
