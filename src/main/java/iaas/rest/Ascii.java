package iaas.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/Ascii")
public class Ascii {
	
		@Produces(MediaType.TEXT_HTML)
		@GET
		@Path("ascii/{c}")
		public String getNumber(@PathParam("c")String c) {
			char[] ar=c.toCharArray();
			String s="";
			for(int i=0;i<ar.length;i++) {
				int n=(int)ar[i];
				s+=n+" ";
			}
			
			return s;
		}
	}


