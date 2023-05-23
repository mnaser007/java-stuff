package iaas.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Addition")
public class Addition {

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("add/{n1},{n2}")
	public String add(@PathParam("n1") String x, @PathParam("n2") String y) {
		try {
			float sum = Float.parseFloat(x) + Float.parseFloat(y);
			return "<h1>sum:" + sum + "<h1>";
		} catch (NumberFormatException e) {
			return "<h1>one or more values are not numeric<br>sum:unknown</h1>";
		}
	}

	@GET
	@Path("add/{values}")
	@Produces(MediaType.TEXT_HTML)
	public String add(@PathParam("values") String values) {
		String[] vals = values.split(",");
		float sum = 0.0f;
		try {
			for (int i = 0; i < vals.length; i++)
				sum += Float.parseFloat(vals[i]);
			return "<font size=10px>" + sum + "</font>";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
