import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IPv7 {
	private String goodPart="";
	private	String badPart="";
	private Boolean TLS=false;
	private Boolean SSL=false;
	IPv7(String newIP)
	{
		List<String> input = new ArrayList<String>(Arrays.asList(newIP.trim().split("\\W+")));
		for(int i=0;i<input.size();i++)
		{
			if(i%2==1)
			{
				badPart+=input.get(i)+",,,";
			}
			else
			{
				goodPart+=input.get(i)+",,,";
			}
		}
		if (hasABBA(goodPart))TLS=true;
		if (hasABBA(badPart))TLS=false;
		if (hasABA())SSL=true;
	}
	public boolean hasABBA(String part)
	{
		char[] str =part.toCharArray();
		for(int i=3;i<str.length;i++)
		{
			if(str[i-3]==str[i]&&str[i-2]==str[i-1]&&str[i-3]!=str[i-2]) return true;
		}
		return false;
	}
	public boolean hasABA()
	{
		char[] strGood =goodPart.toCharArray();
		char[] strBad =badPart.toCharArray();
		for(int i=2;i<strGood.length;i++)
		{
			if(strGood[i-2]==strGood[i]&&strGood[i-2]!=strGood[i-1])
			{
				for(int j=2;j<strBad.length;j++)
				{
					if(strGood[i-2]==strBad[j-1]&&strGood[i-1]==strBad[j-2]&&strGood[i-1]==strBad[j])return true;
				}
			}
		}
		return false;
	}
	public String getGoodPart() {
		return goodPart;
	}
	public void setGoodPart(String goodPart) {
		this.goodPart = goodPart;
	}
	public String getBadPart() {
		return badPart;
	}
	public void setBadPart(String badPart) {
		this.badPart = badPart;
	}
	public Boolean hasTLS() {
		return TLS;
	}
	public void setTLS(Boolean legit) {
		this.TLS = legit;
	}
	public Boolean hasSSL() {
		return SSL;
	}
	public void setSSL(Boolean legit) {
		this.SSL = legit;
	}
}
