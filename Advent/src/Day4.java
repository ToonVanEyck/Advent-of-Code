import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day4 {

	public static void main(String[] args) throws FileNotFoundException, IOException 
	{
		String inputFile="input4";
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile)))
		{
			String line1;
			int counter=0;
		    while ((line1 = br.readLine()) != null) {
		    	Room r = new Room(line1);
		    	if(r.isRoom())counter=counter+r.getRoomNumber();
		    	//System.out.println(r.getDecrypted());
		    	if(r.getDecrypted().equals("northpole object storage"))System.out.println("the North Pole objects are stored in room with ID: "+r.getRoomNumber());
		    }
		    System.out.println(counter);
		}
	}
}
