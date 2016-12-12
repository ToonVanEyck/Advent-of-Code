import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day9 {

	public static void main(String[] args) throws IOException 
	{
		String inputFile="input9";
		ArrayList<int[]> letters = new ArrayList<int[]>();
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile)))
		{
			boolean b=false;
			String line1  = br.readLine();
			//line1="A(1x5)BC";
			//line1="(121x3)UOBCTWD(24x1)KBBJJRCFNOTNFFCKJOFGWJZT(12x6)(7x3)CKJUMES(47x12)(2x3)IY(4x12)JSFP(12x13)FDTYFDWLHWXE(5x11)XLPGL(2x7)EK(7x7)(2x3)LA";
			int length=line1.length();
			int plus=0;
			int minus=0;
			for(int i = 0;i<length;i++)
			{
				if(b)System.out.println(line1.charAt(i));
				if(line1.charAt(i)=='(')
				{ 
					if(b)System.out.println(i);
					int begin=i;
					String[] numbers = line1.substring(i+1).split("\\W+")[0].split("x");
					while(line1.charAt(i++)!=')');
					int end=i;
					line1=line1.substring(0,begin)+line1.substring(end,length);
					if(b)System.out.println(i);
					i=i-end+begin;
					if(b)System.out.println(i);
					length=length-end+begin;
					String copy=line1.substring(i,i+Integer.parseInt(numbers[0]));
					i=i+copy.length();
					for(int j=1;j<Integer.parseInt(numbers[1]);j++)
					{
						line1=line1.substring(0, i)+copy+line1.substring(i,length);
						if(b)System.out.println(line1);
						length+=copy.length();
						i+=copy.length();
						System.out.println(" --> "+i);
						if(j==Integer.parseInt(numbers[1])-1)i--;
					}
					
				}
			}
			System.out.println(line1);
			System.out.println(length);
//			System.out.println(line1.length());
		}
	}
}
