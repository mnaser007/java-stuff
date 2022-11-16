package iaas.rest;

public class VarArgs {

	public int add(String str,String... x) {
		int sum=0;
		for (String n:x) // for every int n in x
			sum+=Integer.parseInt(n);//n="2", after parse 2// sum = sum+2
		return sum;
	}
	
	public float addflaot(String... y) {
		float sum1=0;
		for (String m:y) // for every int n in x
			sum1+=Float.parseFloat(m);
		return sum1;
	}
	public float avg(String avg,int count,String... z) {
		VarArgs var=new VarArgs() ;
		int store= var.add("Avg", z);
		float avg1= store/count;
		
	
		return avg1;
	
}
	
}
