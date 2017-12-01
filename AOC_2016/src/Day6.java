import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day6 {

	public static void main(String[] args) throws IOException {
		String inputFile="input6";
		ArrayList<int[]> letters = new ArrayList<int[]>();
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile)))
		{
			String line1  = br.readLine();
			for(char c :line1.toCharArray())
			{
				int[] alphabet=new int[26];
				alphabet[(int)c-97]=alphabet[(int)c-97]+1;
				letters.add(alphabet);
			}
		    while ((line1 = br.readLine()) != null) 
		    {
		    	int i=0;
		    	for(char c :line1.toCharArray())
				{
					int[] alphabet=letters.get(i);
					alphabet[(int)c-97]=alphabet[(int)c-97]+1;
					letters.set(i++,alphabet);
				}
		    }
		    String message="";
		    for(int[] alphabet : letters)
		    {
		    	for(int i:alphabet)System.out.print(i+", ");System.out.println("");
		    	/*
		    	int temp=0;
		    	int index=0;
		    	for(int check=0;check<=25;check++)
				{
					if(alphabet[check]>temp)
						{
							temp=alphabet[check];
							index=check;
						}
				}*/
		    	int temp=alphabet[0];
		    	int index=0;
		    	for(int check=1;check<=25;check++)
				{
					if(alphabet[check]<temp)
						{
							temp=alphabet[check];
							index=check;
						}
				}
		    	message+=((char)(index+97));
		    }
		    System.out.println("The message is :"+message);
		}
	}
}
