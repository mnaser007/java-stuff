package iaas.rest;

import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("Substring")
public class SubString {
	
	
	@Produces("text/plain")
	@GET
	@Path("sub/{string}")
	public String getsubstring(@PathParam("string") String name) {
		String str=name.substring(name.length()-3);
	return str+"";

	}
	
	@Produces(MediaType.TEXT_HTML)
    @GET
    @Path("sub2/{values}")
    public String str(@PathParam("values")String values) {
        String[] vals=values.split(",");
        //String s = "";
        int sum = 0;
        for(int i=0;i<vals.length;i++) {
            sum+=Integer.parseInt(vals[i]);
            
        }
        return sum+"";
         
	}
}