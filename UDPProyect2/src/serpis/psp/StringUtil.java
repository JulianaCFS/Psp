package serpis.psp;

public class StringUtil {

	/**
	 * @param args
	 */
	
	public static void FillByteArray(byte[] buf, String data) 
	{
		// TODO Auto-generated method stub
		
		byte[] bufData = data.getBytes();
		for(int i = 0; i<bufData.length;i++)
			buf[i] = bufData[i];
		
	}

}
