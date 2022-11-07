package iaas.rest;

import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Wrapper")
public class Wrapper {

 
	@GET
	@Path("wrap/{string}")
	@Produces(MediaType.TEXT_HTML)
	public String wrap(@PathParam("string")int x) {       //int is a premitive type datatype
		Integer myint=new Integer (x); //This is called boxing
		return myint.toString()+10;  //.toString will convert any object to String will get(string+number) 2510
		}

	@GET
	@Path("wrap1/{float}")
	@Produces(MediaType.TEXT_HTML)
	public String wrap1(@PathParam("float") int x) {     
		Integer myint=new Integer (x);	
		String res= "Your String value is :"+myint.toString()+
				   "<br>"+"Your String binary is :" +Integer.toBinaryString(x)+		
				   "<br>"+"Your hexa String is :" +Integer.toHexString(x)+	
				   "<br>"+"Your float vlaue is:"+myint.floatValue()+"";  //float value is not a string conver (float to String)
		   																//method name start with small letter
		return res;
	}								   					
	}










