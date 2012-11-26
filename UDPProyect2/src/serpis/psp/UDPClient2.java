package serpis.psp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient2
{

	private static void fillByteArray(byte[] buf, String data)
	{
		byte[] bufData = data.getBytes();
		for(int i = 0; i<bufData.length;i++)
			buf[i] = bufData[i];
	}
	
	public static void main(String[] args)throws IOException
	{
		// TODO Auto-generated method stub
		
		try 
		{
		
		InetAddress inetAddress = InetAddress.getByName("127.1.1.0");
		int port = 10001;	
		
		DatagramSocket datagramSocket = new DatagramSocket();
		byte[] buf = new byte[2048];
		DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length, inetAddress, port);
		
		
		while(true)
		{
			
			
			String text = "Hola desde UDPClient2"+ new java.util.Date();
			StringUtilFillByteArray(buf,text);
			datagramPacket.setLength(text.getBytes().length);
			datagramSocket.send(datagramPacket);
			
			
			
			String data = new String(datagramPacket.getData(),0, datagramPacket.getLength());
			System.out.printf("Receive Data='%s'\n",data);
			
			
			
			
			Thread.sleep(5000);//miliseconds
		}
		
		
		}
	catch(Exception ex)
		{
			System.out.println("error");
		}
	
		

	}

}
