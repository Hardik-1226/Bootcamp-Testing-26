package gettersetter;
// write an java program using getter and setter method employee having id,name,salary

class empolyee{
	private int id;
	private String name;
	private float salary;
	
	public void steDetails(int id,String name,float salary)
	{
		this.id=id;
		this.name=name;
		this.salary=salary;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public float getSalary() {
		return salary;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
}
public class constructor {
	public static void main(String[] args) {
		empolyee e=new empolyee();
		e.steDetails(12, "abcd", 18282);
		System.out.println("Empolyee name: "+e.getName());
		System.out.println("Empolyee id: "+e.getId());
		System.out.println("empolyee salary "+e.getSalary());
		
		
	}
}
