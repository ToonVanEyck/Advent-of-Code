import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day10 {
	
	public static void main(String[] args) throws IOException 
	{
		String inputFile="input10";
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile)))
		{
			ArrayList<String> values=new ArrayList<String>();
			ArrayList<Bot> bots = new ArrayList<>();
			String line1;
			while ((line1 = br.readLine()) != null) 
			{
				if(line1.startsWith("bot"))
				{
					Bot b=new Bot(line1);
					bots.add(b);
				}
				else
				{
					values.add(line1);
				}
			}
			for(String line:values)
			{
				String[] s=line.split("\\D+");
				Bot b=getBotWithId(Integer.parseInt(s[2]),bots);
				b.addValue(Integer.parseInt(s[1]));
			}
			//getBotWithId(92, bots).addValue(10);
			boolean go=true;
			while(go)
			{
				go=false;
				for(Bot b:bots)
				{
					if(b.nrOfChips()>=2)
					{
						go=true;
						//System.out.println("2 chips in bot: "+b.getId());
						if(b.getDestBotHigh()<0) System.out.println("output "+b.getDestOutHigh()+" = "+b.getHighValue());
						else getBotWithId(b.getDestBotHigh(), bots).addValue(b.getHighValue());
						//else System.out.println("output "+b.getDestOutHigh()+" = "+b.getHighValue());
						if(b.getDestBotLow()<0)  System.out.println("output "+b.getDestOutLow()+" = "+b.getLowValue());
						else getBotWithId(b.getDestBotLow(), bots).addValue(b.getLowValue());
					//	else System.out.println("output "+b.getDestOutLow()+" = "+b.getLowValue());
					}		
				}
			}
		}
	}
	public static Bot getBotWithId(int id, ArrayList<Bot> bots)
	{
		for(Bot b :bots)
		{
			if(b.getId()==id)return b;
		}
		return null;
	}

}
