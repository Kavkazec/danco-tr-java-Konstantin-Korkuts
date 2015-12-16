
public class Summa {
	public static void main(String[] arh){
		int chiclo = new java.util.Random(100).nextInt(999);
		String s = "" + chiclo;
		int range = s.length();
		int[] mass = new int[range+1];
		SRandom rd = new SRandom();
		rd.summ(mass,s);
		
	}
}
