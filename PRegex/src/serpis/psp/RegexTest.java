package serpis.psp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Estudiar comportamiento de las regex en java
		
		String input = "GET /index.html HTTP/1.1";
		String regex = "GET /(.*?) HTTP/1.[01]";
		
		//expresion regular
		Pattern patten = Pattern.compile(regex);
		Matcher matcher = patten.matcher(input);
		String fileName = matcher.group(1); //from 1.7 -> matcher.group("fileName");
		
		System.out.println("fileName");

	}

}
