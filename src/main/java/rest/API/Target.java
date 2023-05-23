package rest.API;

import java.io.FileInputStream;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import iaas.rest.Connect_db;
import iaas.rest.Stud;

@Path("Target")
public class Target {

	private String rev;

	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("studs")
	public String getStuds() {
		Students s1 = new Students();
		Students s2 = new Students();

		s1.id = 201;
		s1.name = "Mohammad Naesrer";
		s1.course = "MySQL";
		s1.age = 28;

		s2.id = 202;
		s2.name = "Muneer Ahmed";
		s2.course = "JAVA";
		s2.age = 25;

		Students.college = "IAAS";
		return s1 + "<br>" + s2;
	}
	
	
	
		/*@Produces(MediaType.TEXT_HTML)
		@GET
		@Path("sum/{str}")*/
		/*public String strnum(@PathParam("str")String s) {
			int L = s.length();
	        String str="";
	        int[] convert = new int[L];
	        for(int i=0;i<L;i++){
	            convert[i] = (int)(s.charAt(i)-'a')+1;
	            str+= ""+convert[i];
	        }
	            return str+Integer.parseInt(str);*/
	
	
		
		
		
		
		
		
