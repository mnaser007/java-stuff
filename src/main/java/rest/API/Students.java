	package rest.API;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import iaas.rest.Stud;


public class Students {

	public int id;
	public String name;
	public String course;
	public int age;
	public static String college;

	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", course=" + course + ", age=" + age + "]";
	}
	
	
}



