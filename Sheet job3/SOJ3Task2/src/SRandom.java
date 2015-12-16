
public class SRandom {
	void summ(int[] mass, String s){
		String ss = "";
		int summ = 0;
		for(int i = 1; i <= s.length();i++){
			ss=s.substring(i-1,i);
			mass[i] = Integer.parseInt(ss);
			summ = summ + mass[i];
		}
		System.out.println(s);
		System.out.println(summ);
		
	}

	
}
