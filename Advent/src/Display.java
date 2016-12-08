
public class Display {
	private int height=0;
	private int width=0;
	private boolean[][] display;
	Display(int newWidth, int newHeight)
	{
		height=newHeight;
		width=newWidth;
		display=new boolean[height][width];
	}
	public void draw(char off,char on)
	{
		for(boolean[] i : display)
		{
			for(boolean j : i)
			{
				if(j)System.out.print(on);
				else System.out.print(off);
			}
			System.out.println();
		}
		System.out.println(" ");
	}
	public void rect(int x,int y)
	{
		for(;x>=0;x--)
		{
			for(;y>=0;y--)
			{
				display[x][y]=true;
			}
		}
	}
	public void rotateRow(int row, int d)
	{
		
	}
	public void rotateColumn(int column, int d)
	{
		
	}
}
