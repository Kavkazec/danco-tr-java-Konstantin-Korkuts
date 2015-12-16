
public class Stock {
	void summ(Product[] mass){
		int summ = 0;
		System.out.println("Products on stock");
		for(int i = 0; i < mass.length; i++){
			summ = summ + mass[i].getWeight();
			System.out.println(mass[i].getName() + " " + mass[i].getWeight() +"kg."  );
		}
		System.out.println("The weight of the stored goods = "+summ + "kg.");
	}
}

