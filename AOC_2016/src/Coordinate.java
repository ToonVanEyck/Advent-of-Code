
public class Coordinate {
	private int x=0;
	private int y=0;
	Coordinate(int new_x, int new_y)
	{
		x=new_x;
		y=new_y;
	}
	Coordinate(int new_x, int new_y, int min_x, int min_y, int max_x, int max_y)
	{	
		if(new_x<=min_x)x=min_x;
		else if(new_x>=max_x)x=max_x;
		else x=new_x;
		if(new_y<=min_y)y=min_y;
		else if(new_y>=max_y)y=max_y;
		else y=new_y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public String toString()
	{
		return ("x: "+x+" y: "+y);
	}
	public int getDistanceSquare()
	{
		return Math.abs(x)+Math.abs(y);
	}
	public boolean isEqual(Coordinate c)
	{
		if((x==c.getX())&&(y==c.getY())) return true;
		else return false;
	}
}
