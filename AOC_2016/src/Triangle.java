
public class Triangle {
	int a=0;
	int b=0;
	int c=0;
	Triangle(int newA,int newB, int newC)
	{
		a=newA;
		b=newB;
		c=newC;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public boolean isLegit()
	{
		if ((a+b>c)&&(a+c>b)&&(b+c>a))return true;
		else return false;
	}
	@Override
	public String toString() {
		return "Triangle [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
	
}
