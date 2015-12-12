
public class SRandom {
	int chiclo = new java.util.Random(100).nextInt(999);
	String s = "" + chiclo;
	String ss = "";
	int range = s.length();
	int[] mass = new int[range+1];
	int summ = 0;
	void summ(){
		for(int i = 1; i <= s.length();i++){
			ss=s.substring(i-1,i);
			mass[i] = Integer.parseInt(ss);
			summ = summ + mass[i];
		}
		System.out.println(s);
		System.out.println(summ);
		
	}

	
}
