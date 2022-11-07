package iaas.rest;

public class Array {

		int array[];
			
		public void loadValues(String values) {
			String[] vals=values.split(",");
			array=new int[vals.length];
			for(int i=0;i<vals.length;i++) {
				array[i]=Integer.parseInt(vals[i]);
			}
		}
		
		public String readValues() {
			String res="";
			for(int i=0;i<array.length;i++) {
				if(i==array.length-1)
					res+=array[i];
				else
					res+=array[i]+",";
			}
			return res;
		}

	}
