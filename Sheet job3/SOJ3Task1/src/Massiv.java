import java.util.Arrays;

public class Massiv {
	String[] mass = {"Костя", "Паша", "Макс", "Саша", "Настя", "Юля", "Катя", "Захар"};
	void sort(){
		Arrays.sort(mass);
		for(int i = 0; i < mass.length; i++){
			System.out.println(mass[i]);
		}
	}
}
