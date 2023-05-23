package iaas.rest;


public class Emp {

	public	int id;
	public	String name;
	public double sal;
		//This is constructor
		Emp(){
			id=0;
			name="None";
			sal=0;
		}
		
	public 	Emp(int id,String name,double sal){
			this.id=id;
			this.name=name;
			this.sal=sal;
		}
		
	/*	public double getSal() {
			return sal;
		}
		
		public void setSal(double sal) {
			this.sal=sal;
		}*/
		public String toString() {
			return id+"<br>"+name+"<br>"+sal;
		}

	}


