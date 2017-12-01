
public class Building {
	private int nrOfFloors=0;
	private int nrOfSpots=0;
	private int elevator=1;
	private Element[][] locations;
	private int elevatorCounter=0;
	Building(Element[][] newLocations)
	{
		nrOfFloors=newLocations.length;
		nrOfSpots=newLocations[0].length;
		locations=newLocations;
	}
	public void elevate(Element[] elements)
	{
		elevatorCounter++;
	}
	public void descent(Element[] elements)
	{
		elevatorCounter++;
	}
	public int getElevatorCount()
	{
		return elevatorCounter;
	}
	@Override
	public String toString() {
		String s=nrOfFloors+" floors and "+nrOfSpots+" spots per floor. The elevator is on floor "+elevator+ ".";
		return s;
	}
	public void print()
	{
		for(int i=0;i<nrOfFloors;i++)
		{
			printFloor(nrOfFloors-i);
		}
		System.out.println("|--------------------------------------------|");
	}
	public void printFloor(int floor)
	{
		System.out.print("|F"+(floor)+"|"+((elevator==floor)?"E|":" |"));
		for(int j=0;j<nrOfSpots;j++)
		{
			if (locations[nrOfFloors-floor][j]!=null)System.out.print(locations[nrOfFloors-floor][j]+"|");
			else System.out.print("   |");
		}
		System.out.println("");
	}
	public Element[] getFloor(int floor)
	{
		return locations[nrOfFloors-floor];
	}
	public int getNrOfFloors()
	{
		return nrOfFloors;
	}
	public boolean isEmptyFloor(int floorNr)
	{
		Element[] floor=getFloor(floorNr);
		for(int i=0;i<floor.length;i++)if(floor[i]!=null)return true;
		return false;
	}
	public int elementsOnFloor(int floorNr)
	{
		Element[] floor=getFloor(floorNr);
		int c=0;
		for(int i=0;i<floor.length;i++)if(floor[i]!=null)c++;
		return c;
	}
	public int generatorsOnFloor(int floorNr)
	{
		Element[] floor=getFloor(floorNr);
		int c=0;
		for(int i=0;i<floor.length;i++)if(floor[i]!=null&&floor[i].isGenerator())c++;
		return c;
	}
	public int microchipsOnFloor(int floorNr)
	{
		Element[] floor=getFloor(floorNr);
		int c=0;
		for(int i=0;i<floor.length;i++)if(floor[i]!=null&&floor[i].isMicrochip())c++;
		return c;
	}
	public int getElevator()
	{
		return elevator;
	}
	public Element[] getCurrentFloor()
	{
		return getFloor(elevator);
	}
	public Element[] getFloorGenerators(int floorNr)
	{
		Element[] generators=new Element[generatorsOnFloor(floorNr)];
		int g=0;
		Element[] floor=getFloor(floorNr);
		for(int i=0;i<floor.length;i++)if(floor[i]!=null&&floor[i].isGenerator())generators[g++]=floor[i];
		return generators;
	}
	public Element[] getFloorMicrochips(int floorNr)
	{
		Element[] microchips=new Element[microchipsOnFloor(floorNr)];
		int m=0;
		Element[] floor=getFloor(floorNr);
		for(int i=0;i<floor.length;i++)if(floor[i]!=null&&floor[i].isMicrochip())microchips[m++]=floor[i];
		return microchips;
	}
}
