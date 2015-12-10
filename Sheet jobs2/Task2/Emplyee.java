public class Emplyee extends Man implements IReport{
	Emplyee(){
		System.out.println(Emplyee.class.getSimpleName());
	}
	public void getSimptleName() {
		System.out.println(IReport.class.getSimpleName());
	}
	public static void main(String[] args) {
		Emplyee emp = new Emplyee();
		Room r = new Room();
		Achievements ach = new Achievements();
		emp.getSimptleName();
	}

}
