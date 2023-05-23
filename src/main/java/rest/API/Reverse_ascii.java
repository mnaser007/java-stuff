package rest.API;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

				//.........Reverse of ascii.......
@Path("/Reverse_ascii")
public class Reverse_ascii {

	String str;
	int a;
	String sum = "";
	String i1 = "";

	public String getValues() {
		char ar[] = str.toCharArray();
		String c = "";
		for (int i = 0; i < ar.length; i++) {
			a = (int) (ar[i]);
			for (int j = 0; j <= a; j++) {
				i1 += a % 10;
				a = a / 10;
			}
		}
		return "Reverse acii of a given string: " + i1;
	}

	@Path("string2/{str}")
	@Produces(MediaType.TEXT_HTML)
	@GET
	public String getvalue(@PathParam("str") String string) {
		Reverse_ascii f = new Reverse_ascii();
		f.str = string;
		return f.getValues();
	}

}
