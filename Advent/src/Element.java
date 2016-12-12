
public class Element {
	private String element;
	private boolean generatorOrChip;
	Element(String newElement, boolean b)
	{
		element=newElement;
		generatorOrChip=b;
	}
	@Override
	public String toString() {
		return element+(generatorOrChip?"G":"M");
	}
	public boolean isGenerator()
	{
		return generatorOrChip;
	}
	public boolean isMicrochip()
	{
		return !generatorOrChip;
	}
	public String getType()
	{
		return element;
	}
}
