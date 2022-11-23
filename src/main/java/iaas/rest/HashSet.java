package iaas.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("HashSet")
public class HashSet {
	
	@GET
	@Path("set_city")
	@Produces(MediaType.TEXT_HTML)
	public String getSet() {
//	Set<String> set =new HashSet<>(); 
//	Set<String> set =new LinkedHashSet<>(); // if change hashet to Linkedhashet then it will come in same order
	Set<String> set =new TreeSet<>();	// if we give in treeset then it will come in random or ascii value								
	String ar1[]= {"hyd","blore","pune","mumbai","chennai","blore","pune"} ;
			for (String city:ar1) {
				set.add(city);				
			}
			set.remove("mumbai"); // it will remove one item
			List<String> list=new ArrayList<>();
			for (String city:set)
				list.add(city);
			Collections.reverse(list);
			String s="";
			for (String city:set)
				s+=city+"<br>";
			return s;
			}
}

