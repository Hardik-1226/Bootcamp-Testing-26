package overloadingconstructor.com;
class overloading_constructor{
	public overloading_constructor(int a,int b) {
		int c=a+b;
		System.out.println("int type constructor "+c);
	}
	public overloading_constructor(double a,double b) {
		double c=a+b;
		System.out.println("Double constructor "+c);
	}
}
public class const_overloading {
	public static void main(String[] args) {
		overloading_constructor i=new overloading_constructor(1,2);
		overloading_constructor d=new overloading_constructor(1.22,1.22);
	}
}
