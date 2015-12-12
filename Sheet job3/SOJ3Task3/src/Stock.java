
public class Stock {
	StringBuilder sb = new StringBuilder();
	Product[] mass = new Product[3];
	int summ = 0;
	void summ(){
		mass[0] = new Product("banana",10063);
		mass[1] = new Product("apples",3506);
		mass[2] = new Product("orange",350346);
		System.out.println("Products on stock");
		for(int i = 0; i < mass.length; i++){
			summ = summ + mass[i].getWeight();
			System.out.println(mass[i].getName() + " " + mass[i].getWeight() +"kg."  );
		}
		System.out.println("The weight of the stored goods = "+summ + "kg.");
	}
}

