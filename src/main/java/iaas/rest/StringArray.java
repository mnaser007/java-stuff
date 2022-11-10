package iaas.rest;

public class StringArray {

		public static Integer[] toIntegerArray(String a[]) {
			Integer ar[]=new Integer[a.length];
			for(int i=0;i<a.length;i++)
				ar[i]=Integer.parseInt(a[i]);
			return ar;
		}
		
		public static Float[] toFloatArray(String a[]) {
			Float ar[]=new Float[a.length];
			for(int i=0;i<a.length;i++)
				ar[i]=Float.parseFloat(a[i]);
			return ar;
		}
}
