/*
The first floor contains a thulium generator, a thulium-compatible microchip, a plutonium generator, and a strontium generator.
The second floor contains a plutonium-compatible microchip and a strontium-compatible microchip.
The third floor contains a promethium generator, a promethium-compatible microchip, a ruthenium generator, and a ruthenium-compatible microchip.
The fourth floor contains nothing relevant.
 */

public class Day11 {
	public static void main(String[] args) 
	{
		Element TmG = new Element("Tm",true);//thulium
		Element TmM = new Element("Tm",false);
		Element PuG = new Element("Pu",true);//Plutonium
		Element PuM = new Element("Pu",false);
		Element SrG = new Element("Sr",true);//Strontium
		Element SrM = new Element("Sr",false);
		Element PmG = new Element("Pm",true);//Promethium
		Element PmM = new Element("Pm",false);
		Element RuG = new Element("Ru",true);//Ruthenium
		Element RuM = new Element("Ru",false);
		Element [][] planning=
			{
					{null,	null,	null,	null,	null,	null,	null,	null,	null,	null},
					{null,	null,	null,	null,	null,	null,	PmG,	PmM,	RuG,	RuM	},
					{null,	null,	null,	PuM,	null,	SrM,	null,	null,	null,	null},
					{TmG,	TmM,	PuG,	PuM,	SrG,	null,	null,	null,	null,	null} //REMOVE PuG
			};
		Building building = new Building(planning);
		building.print();
		
		for(int floorToDo=1;floorToDo<building.getNrOfFloors();floorToDo++)
		{
			//while(building.isEmptyFloor(floorToDo))
			{
				int e = building.getElevator();
				Element[] fg=building.getFloorGenerators(e);
				Element[] fm=building.getFloorMicrochips(e);
				
				//printFloor(fg);
				//printFloor(fm);
				unpairedGenerators(fg,fm);
				if(e==floorToDo)						//elevate
				{
					
				}
				else if (e==building.getNrOfFloors())	//descent
				{
					
				}
				else									//depends
				{
					
				}
			}
		}
		/*ACCEPTABLE CASES
		 * nr of generators >= nr of microchips
		 * nr of generators = 0
		 * nr of microchips = 0
		 * 
		 * UNACEPTABLE CASES
		 * nr of microchips > nr of generators
		 */
	}
	public static void printFloor(Element[] floor)
	{
		for(Element el:floor)System.out.print(el+", ");System.out.println();
	}
	public static Element[] unpairedGenerators(Element[] generators, Element[] microchips)
	{
		Element[] upGen=new Element[generators.length-microchips.length];
		int ng=0;
		for(int g=0;g<generators.length;g++)
		{
			for(int m=0;m<microchips.length;m++)
			{
				if(generators[g]!=null&&microchips[m]!=null)
				{
					System.out.println("comparing "+generators[g]+" and "+microchips[m]);
					if(!generators[g].getType().equals(microchips[m].getType()))
					{
						upGen[ng++]=generators[g];
					}/*
					if(floor[i].isMicrochip()&&floor[j].isGenerator()&&!floor[i].getType().equals(floor[j].getType()))
					{
						upGen[ng++]=floor[j];
					}*/
				}
			}
		}
		printFloor(upGen);
		return upGen;
	}

}
