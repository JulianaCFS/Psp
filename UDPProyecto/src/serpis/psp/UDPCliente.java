package serpis.psp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPCliente
{	//el UDPClient  envia el mensaje al servidor

	
	public static void main(String[] args)throws IOException
	{
		// TODO Auto-generated method stub
		
		String text="";
		while(text.length()<1440)
		{
			text=text + "0123456789";
		}
		//String text="Hola desde UPDClient";
		byte[]buf=text.getBytes();
		
		//envia el mensaje a mi máquina
		InetAddress inetAddress=InetAddress.getByName("127.0.0.1");
		int port=10001;
		
		DatagramPacket datagramPacket=new DatagramPacket(buf,buf.length,inetAddress,port);
		
		DatagramSocket datagramSocket=new DatagramSocket();
		
		datagramSocket.send(datagramPacket);
		System.out.println("UDPClient fin");

	}

}
