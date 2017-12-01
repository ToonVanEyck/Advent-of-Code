import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day7 {
	public static void main(String[] args) throws IOException {
		String inputFile="input7";

		try (BufferedReader br = new BufferedReader(new FileReader(inputFile)))
		{
			String line1;
			int counterTLS=0;
			int counterSSL=0;
			while ((line1 = br.readLine()) != null) 
			{
				IPv7 ip= new IPv7(line1);
				if (ip.hasTLS())counterTLS++;
				if (ip.hasSSL())counterSSL++;
			}
			System.out.println("TLS: "+counterTLS);
			System.out.println("SSL: "+counterSSL);
		}
	}
}
