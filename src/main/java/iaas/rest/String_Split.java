package iaas.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("/String_Split")
public class String_Split {

		@Produces(MediaType.TEXT_HTML)
	    @GET
	    @Path("str/{values}")
	    public String str(@PathParam("values")String s) {
	        String[] split=s.split(",");
	        //String s = "";
	        int sum = 0;
	        for(int i=0;i<split.length;i++) {
	            sum+=Integer.parseInt(split[i]);
	            
	        }
	        return sum+"";
	    }
	}


