import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day7 {
	public static void main(String[] args) throws IOException {
		String inputFile="input6";
		ArrayList<int[]> letters = new ArrayList<int[]>();

		try (BufferedReader br = new BufferedReader(new FileReader(inputFile)))
		{
			String line1;
			while ((line1 = br.readLine()) != null) 
			{
				
			}
			IPv7(line1);
			
		}
	}
}
