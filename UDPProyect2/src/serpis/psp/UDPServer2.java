package serpis.psp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		try
		{
			//DatagramSocket datagramSocket = new DatagramSocket(10001);
			byte[] buf = new byte[2048];
			int port = 10001;
			
			DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
			
			InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
			
			DatagramSocket datagramSocket = new DatagramSocket(port);
			
			while(true)
			{
				//datagramPacket.setData(buf);
				//datagramPacket.setLength(buf.length);
				
				datagramSocket.receive(datagramPacket);//espera hasta recibir un paquete.
				
				String data = new String(datagramPacket.getData(),0,datagramPacket.getLength());
				System.out.printf("Data=%s, InetAddress=%s; Port=%s\n",
						data, datagramPacket.getAddress(),datagramPacket.getPort());			
				System.out.printf("longitud=%s\n", datagramPacket.getLength());
				
				data = data + data.toLowerCase();
				
				StringUtil.FillByteArray(buf, data);
				datagramPacket.setLength(data.getBytes().length);
				
				datagramSocket.send(datagramPacket);
				
				//datagramPacket.setData(data.getBytes());
				//datagramPacket.setLength(data.length());
				byte[] bufData = data.getBytes();
				for(int i = 0; i<data.length(); i++)
					buf[i] = bufData[i];
				datagramPacket.setLength(bufData.length);
				
				
				
			}	
				
			
			
			
		}
		catch(Exception ex)
		{
			System.out.println("fallo en la transmisión");
		}

		
		
		
		
		
		
		
		
		
		
	}

}
