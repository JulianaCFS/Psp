package serpis.psp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PruebaStream {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws FileNotFoundException
	{
		// TODO Auto-generated method stub
		if(args.length !=2){
			System.out.println("uso: PruebaStream source dest");
			return;
		}
		String inputFileName = args[0];
		String outputFileName = args[1];
		
		System.out.println("Copiando...");
		System.out.println("inputFileName=" + inputFileName);
		System.out.println("outputFileName=" + outputFileName);
		
		FileInputStream fileInputStream = new FileInputStream(inputFileName);
		FileOutputStream fileOutputStream = new FileOutputStream(outputFileName);
		
		final int bufferSize = 2048;
		

	}

}
