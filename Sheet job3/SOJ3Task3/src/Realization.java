
public class Realization {
	public static void main(String[] args) {
		Product[] mass = new Product[3];
		mass[0] = new Product("banana",10063);
		mass[1] = new Product("apples",3506);
		mass[2] = new Product("orange",350346);
		Stock s = new Stock();
		s.summ(mass);

	}

}
