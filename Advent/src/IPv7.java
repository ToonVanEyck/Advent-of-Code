import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IPv7 {
	private String goodPart="";
	private	String badPart="";
	IPv7(String newIP)
	{
		List<String> input = new ArrayList<String>(Arrays.asList(newIP.trim().split("\\W+")));
		for(int i=0;i<input.size()-1;i++)
		{
			if(i%2==1)
			{
				System.out.println("odd: "+input.get(i));
			}
			else
			{
				System.out.println("even: "+input.get(i));
			}
		}
	}
}
