import java.math.BigInteger;
import java.security.*;

public class Day5 {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String input="uqwqemis";
	//	String input="abc";
		boolean b=true;
		int i=0;
		int charCount=0;
		char[] passchars={0,0,0,0,0,0,0,0};
		String password="";
		while(b)
		{
			String hashed=hashMD5(input+i);
			if(hashed.startsWith("00000"))
			{
				System.out.println(i+" -> "+hashed);
				char c=hashed.substring(5,6).charAt(0);
				if(c<='7')
				{
					int pos=(int)c-48;
					if(passchars[pos]==0)
						{
							passchars[pos]=hashed.substring(6, 7).charAt(0);
							charCount++;
							for(char pc:passchars)System.out.print(pc);System.out.println();
						}
				}
				password+=hashed.substring(5, 6);
			}
			i++;
			//if(password.length()==8)b=false;
			if(charCount==8)b=false;
			
		}
		System.out.println("First Password: "+password.substring(0,8));
		System.out.print("Second Password: ");
		for(char pc:passchars)System.out.print(pc);System.out.println();

	}
	public static String hashMD5 (String input) throws NoSuchAlgorithmException
	{
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.reset();
		m.update(input.getBytes());
		byte[] digest = m.digest();
		BigInteger bigInt = new BigInteger(1,digest);
		String hashtext = bigInt.toString(16);
		while(hashtext.length() < 32 ){
		  hashtext = "0"+hashtext;
		}
		return hashtext;
	}

}
