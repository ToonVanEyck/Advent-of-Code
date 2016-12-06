import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day1 {
	public enum direction {North,East,West,South}
	public static void main(String[] args)
	{
		direction currentDir = direction.North;
		ArrayList<Coordinate> coordinates =  new ArrayList<Coordinate>();
		ArrayList<Coordinate> doublePoints = new ArrayList<Coordinate>();
		coordinates.add(new Coordinate(0,0));
		String input="R3, L5, R2, L1, L2, R5, L2, R2, L2, L2, L1, R2, L2, R4, R4, R1, L2, L3, R3, L1, R2, L2, L4, R4, R5, L3, R3, L3, L3, R4, R5, L3, R3, L5, L1, L2, R2, L1, R3, R1, L1, R187, L1, R2, R47, L5, L1, L2, R4, R3, L3, R3, R4, R1, R3, L1, L4, L1, R2, L1, R4, R5, L1, R77, L5, L4, R3, L2, R4, R5, R5, L2, L2, R2, R5, L2, R194, R5, L2, R4, L5, L4, L2, R5, L3, L2, L5, R5, R2, L3, R3, R1, L4, R2, L1, R5, L1, R5, L1, L1, R3, L1, R5, R2, R5, R5, L4, L5, L5, L5, R3, L2, L5, L4, R3, R1, R1, R4, L2, L4, R5, R5, R4, L2, L2, R5, R5, L5, L2, R4, R4, L4, R1, L3, R1, L1, L1, L1, L4, R5, R4, L4, L4, R5, R3, L2, L2, R3, R1, R4, L3, R1, L4, R3, L3, L2, R2, R2, R2, L1, L4, R3, R2, R2, L3, R2, L3, L2, R4, L2, R3, L4, R5, R4, R1, R5, R3";
		List<String> directions = new ArrayList<String>(Arrays.asList(input.split(", ")));
		for(String s:directions)
		{
			char d=s.charAt(0);
			int i=Integer.parseInt(s.substring(1));
			currentDir=rotate(currentDir,d);
			for(;i>0;i--)
			{
				Coordinate c=coordinates.get(coordinates.size()-1);
				switch (currentDir)
				{
					case North: 
						coordinates.add(new Coordinate(c.getX()+1,c.getY()));
					break;
					case East:
						coordinates.add(new Coordinate(c.getX(),c.getY()+1));
					break;
					case South:	
						coordinates.add(new Coordinate(c.getX()-1,c.getY()));
					break;
					case West:
						coordinates.add(new Coordinate(c.getX(),c.getY()-1));
					break;
				}
			}

		}
		System.out.println("Total distance is "+coordinates.get(coordinates.size()-1).getDistanceSquare());
		for(int i=0;i<coordinates.size()-2;i++)
		{
			Coordinate c_1=coordinates.get(i);
			for(int j=i+1;j<coordinates.size()-1;j++)
			{
				Coordinate c_2=coordinates.get(j);
				if (c_1.isEqual(c_2))
				{
					doublePoints.add(c_1);
					break;
				}
			}
		}
		System.out.println("First double point is at "+doublePoints.get(0)+" at a distance of "+doublePoints.get(0).getDistanceSquare());
	}	
	public static direction rotate(direction currentDir,char d)
	{
		if(d=='R')
		{
			switch (currentDir)
			{
				case North:
					currentDir=direction.East;
				break;
				case East:
					currentDir=direction.South;
				break;
				case South:
					currentDir=direction.West;
				break;
				case West:
					currentDir=direction.North;
				break;
			}
		}
		else
		{
			switch (currentDir)
			{
				case North:
					currentDir=direction.West;
				break;
				case East:
					currentDir=direction.North;
				break;
				case South:
					currentDir=direction.East;
				break;
				case West:
					currentDir=direction.South;
				break;
			}
		}
		return currentDir;
	}
}


