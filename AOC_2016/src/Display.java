
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
		for(int dX=0;dX<x;dX++)
		{
			for(int dY=0;dY<y;dY++)
			{
				display[dY][dX]=true;
			}
		}
	}
	public void rotateRow(int row, int d)
	{
		boolean[] shiftX=new boolean[width];
		for(int dX=0;dX<width;dX++)
		{
			shiftX[dX]=display[row][dX];
		}	
		shiftX=shift(shiftX,d);
		for(int dX=0;dX<width;dX++)
		{
			display[row][dX]=shiftX[dX];
		}

	}
	public void rotateColumn(int column, int d)
	{
		boolean[] shiftY=new boolean[height];
		for(int dY=0;dY<height;dY++)
		{
			shiftY[dY]=display[dY][column];
		}	
		shiftY=shift(shiftY,d);
		for(int dY=0;dY<height;dY++)
		{
			display[dY][column]=shiftY[dY];
		}	
	}
	private boolean[] shift(boolean[] shiftArray,int d)
	{
		boolean[] newArray=new boolean[shiftArray.length];
		for(int i=0;i<shiftArray.length;i++)
		{
			int newI=i+d;
			if(newI>=shiftArray.length)newI-=shiftArray.length;
			newArray[newI]=shiftArray[i];
		}
		return newArray;
	}
	public int getNrOfLitPixels()
	{
		int counter=0;
		for(int dX=0;dX<width;dX++)
		{
			for(int dY=0;dY<height;dY++)
			{
				if(display[dY][dX])counter++;
			}
		}
		return counter;
	}
}
