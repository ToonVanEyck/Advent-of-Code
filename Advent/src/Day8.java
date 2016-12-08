import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class Day8 {
	public static void main(String[] args) throws IOException {
		String inputFile="input8";
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile)))
		{
			String line1;
			String[] input=new String[2];
			Display display= new Display(50,6);
			display.draw('_', '#');
			display.rect(3, 2);
			display.draw('_', '#');
			while ((line1 = br.readLine()) != null) 
			{
				if(line1.startsWith("rect"))
				{
					input=line1.substring(5).split("x");
					//System.out.println(input[0]+"  -  "+input[1]);
				}
				else
				{
					if(line1.substring(7).startsWith("row"))
					{
						input=line1.substring(13).split(" by ");
						//System.out.println(input[0]+"  -  "+input[1]);
					}
					else
					{
						input=line1.substring(16).split(" by ");
						//System.out.println(input[0]+"  -  "+input[1]);
					}
				}
			}
		}
	}
}
