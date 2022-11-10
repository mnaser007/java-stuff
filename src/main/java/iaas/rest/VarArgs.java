package iaas.rest;

public class VarArgs {

	public int add(String... x) {
		int sum=0;
		for (String n:x) // for every int n in x
			sum+=Integer.parseInt(n);
		return sum;
	}
	
	public float addflaot(String... y) {
		float sum1=0;
		for (String m:y) // for every int n in x
			sum1+=Float.parseFloat(m);
		return sum1;
	}
}
