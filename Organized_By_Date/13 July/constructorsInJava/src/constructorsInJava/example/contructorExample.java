package constructorsInJava.example;

class student{
	
	public student() {
		System.out.println("Default constructor");
	}
	public void meth()
	{
		System.out.println("Method block");
	}
	
}
public class contructorExample {
	public static void main(String[] args) {
		student s=new student();
		s.meth();
	}
}
