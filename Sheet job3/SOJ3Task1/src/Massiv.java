import java.util.Arrays;

public class Massiv {
	String[] mass = {"Kostya", "Pasha", "Max", "Sasha", "Nastya", "Julya", "Katya", "Zahar"};
	void sort(){
		Arrays.sort(mass);
		for(int i = 0; i < mass.length; i++){
			System.out.println(mass[i]);
		}
	}
}
