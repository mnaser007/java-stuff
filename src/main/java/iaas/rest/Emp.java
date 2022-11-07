package iaas.rest;


public class Emp {

		int id;
		String name;
		private double sal;
		
		Emp(){
			id=0;
			name="None";
			sal=0;
		}
		
		Emp(int x,String y,int z){
			id=x;
			name=y;
			sal=z;
		}
		
		public double getSal() {
			return sal;
		}
		
		public void setSal(double sal) {
			this.sal=sal;
		}
		public String toString() {
			return id+"<br>"+name+"<br>"+sal;
		}

	}


