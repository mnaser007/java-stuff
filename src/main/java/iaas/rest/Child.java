package iaas.rest;


	public class Child extends Parent {
		
		public String getSavings(double sal) {
			String ps=super.getSavings(35000);
			return ps+"<br>child's savings:"+sal*80/100;
		}

	}


