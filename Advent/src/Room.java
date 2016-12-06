import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Room {
	private int[] alphabet=new int[26];
	private int roomNumber;
	private String checkSum;
	private String computedCheckSum;
	private String encrypted="";
	private String decrypted="";
	Room(String input)
	{
		List<String> s = new ArrayList<String>(Arrays.asList(input.split("\\W+")));
		for(int i=0;i<=s.size()-1;i++)
		{
			if(i<=s.size()-3)
			{
				encrypted=encrypted+s.get(i)+" ";
				for(char c:s.get(i).toCharArray())
				{
					alphabet[(int)c-97]=alphabet[(int)c-97]+1;
				}
			}
			if(i==s.size()-2)
			{
				roomNumber = Integer.parseInt(s.get(i));
			}
			if(i==s.size()-1)
			{
				checkSum=s.get(i);
			}
			
		}
		encrypted=encrypted.trim();
		decrypted=decrypt();
		computedCheckSum=this.computeCheckSum();
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public String getCheckSum() {
		return checkSum;
	}
	private String computeCheckSum()
	{
		int temp=0;
		int index=-1;
		int i=0;
		String cs = "";
		while(i<5)
		{
			if(i==0)
			{
				for(int check=0;check<=25;check++)
				{
					if(alphabet[check]>temp)
						{
							temp=alphabet[check];
							//index=check;
						}
				}
			//	cs=cs+((char)(index+97));
			//	i++;
			}
			for(int check=0;check<=25;check++)
			{
				if((alphabet[check]==temp)&&(i<5))
					{
					cs=cs+((char)(check+97));
					i++;
					}
			}
			temp--;
		}
		return cs;
	}
	public boolean isRoom()
	{
		if(computedCheckSum.equals(checkSum))return true;
		return false;
	}
	private String decrypt()
	{
		String decrypted="";
		for(char c:encrypted.toCharArray())
		{
			if(c>='a' && c<='z')
			{
				c+=roomNumber;
				while(c>'z')c-=26;
				decrypted+=c;
			}
			else
			decrypted+=" ";
		}
		return decrypted;
	}
	public String getEncrypted() {
		return encrypted;
	}
	public String getDecrypted() {
		return decrypted;
	}
	
}
