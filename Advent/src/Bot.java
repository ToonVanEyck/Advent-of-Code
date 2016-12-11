import java.util.ArrayList;

public class Bot {
	private int id=0;
	private int destBotHigh=-1;
	private int destBotLow=-1;
	private int destOutHigh=-1;
	private int destOutLow=-1;
	private ArrayList<Integer> microchips=new ArrayList<>();
	Bot(String input)
	{
		String[] s=input.split(" ");
		id=Integer.parseInt(s[1]);
		if(s[5].equals("bot"))destBotLow=Integer.parseInt(s[6]);else destOutLow=Integer.parseInt(s[6]);
		if(s[10].equals("bot"))destBotHigh=Integer.parseInt(s[11]);else destOutLow=Integer.parseInt(s[11]);
	}
	
	@Override
	public String toString() {
		return "Bot [id=" + id + ", destBotHigh=" + destBotHigh + ", destBotLow=" + destBotLow + ", destOutHigh="
				+ destOutHigh + ", destOutLow=" + destOutLow + "]";
	}

	public void addValue(int value)
	{
		microchips.add(value);
		microchips.sort((a, b) -> Integer.compare(a, b));
		if(microchips.size()>2)System.err.println(microchips);
		//System.out.println(id+" + "+microchips);
	}
	public int nrOfChips()
	{
		return microchips.size();
	}
	public int getHighValue()
	{
		int value = microchips.get(microchips.size()-1);
		microchips.remove(microchips.size()-1);
		microchips.sort((a, b) -> Integer.compare(a, b));
		return value;
	}
	public int getLowValue()
	{
		int value = microchips.get(0);
		microchips.remove(0);
		microchips.sort((a, b) -> Integer.compare(a, b));
		return value;
	}
	public int getId()
	{
		return id;
	}

	public int getDestBotHigh() {
		return destBotHigh;
	}

	public void setDestBotHigh(int destBotHigh) {
		this.destBotHigh = destBotHigh;
	}

	public int getDestBotLow() {
		return destBotLow;
	}

	public void setDestBotLow(int destBotLow) {
		this.destBotLow = destBotLow;
	}

	public int getDestOutHigh() {
		return destOutHigh;
	}

	public void setDestOutHigh(int destOutHigh) {
		this.destOutHigh = destOutHigh;
	}

	public int getDestOutLow() {
		return destOutLow;
	}

	public void setDestOutLow(int destOutLow) {
		this.destOutLow = destOutLow;
	}
	
}
