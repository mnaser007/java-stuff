package iaas.rest;

public class Deployed extends Stud {

		String client;
		String loc;
		int salary;
		
		@Override
		public String toString() {
			return "Deployed [client=" + client + ", loc=" + loc + ", salary=" + salary + ", id=" + id + ", name=" + name
					+ ", course=" + course + ", age=" + age + "]";
		}
	}


