package AbstractTestDemo;

abstract class bank{
	public void deposit() {
		System.out.println("Money Deposteed");
	}
	public void withdraw() {
		System.out.println("Money withdrawn");
	}
	abstract void calaculateInterest();
}

class sbi extends bank{
	@Override
	void calaculateInterest() {
		System.out.println("sbi interest rate is 6.8%");
	}
}
class hdfc extends bank{
	@Override 
	void calaculateInterest() {
		System.out.println("hdfc interest rate is 7%");
	}
}
public class BankTestDemo {
	public static void main(String[] args) {
		sbi s=new sbi();
		s.deposit();
		s.withdraw();
		s.calaculateInterest();
		hdfc h= new hdfc();
		h.calaculateInterest();
	}
}
