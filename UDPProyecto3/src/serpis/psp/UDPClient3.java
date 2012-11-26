package serpis.psp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient3
{

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException
	{
		// TODO Auto-generated method stub
		
		try
		{
			InetAddress inetAddress=InetAddress.getByName("127.1.1.0");
			int port = 10001;
			
			DatagramSocket datagramSocket=new DatagramSocket();
			byte []buf1=new byte[2048];
			byte []buf2=new byte[1024];
			DatagramPacket datagramPacket1= new DatagramPacket(buf1,buf1.length,inetAddress,port);
			DatagramPacket datagramPacket2= new DatagramPacket(buf2,buf2.length,inetAddress,port);
			
		}
		
		

	}

}
