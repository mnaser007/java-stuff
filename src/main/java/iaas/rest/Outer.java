package iaas.rest;

public class Outer {     //class cannot be static
						//inner class cannot access to outer class 
	class Inner {       // only inner class will be static
		int x=25;
	}
		static class Inner2 {       // only inner class will be static
			int n=555;
	}
		int getInt() { //method inner class
			class Inner3{
				int p=150;
			}
		Inner3 in3=new Inner3();
		return in3.p;
		}
	}

