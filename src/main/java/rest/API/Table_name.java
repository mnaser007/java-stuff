package rest.API;

import java.io.FileInputStream;
import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import iaas.rest.Connect_db;

@Path("/Table_name")
public class Table_name {

	// ...........reading file and creating table in database.............
	@GET
	@Path("insert_table/{id},{name}")
	@Produces(MediaType.TEXT_HTML)
	public String createTable(@PathParam("id") int id, @PathParam("name") String name) throws SQLException {
		try {
			FileInputStream in = new FileInputStream("C:\\naserworkspace\\rest\\Files-1\\" + name);
			int c = in.read();
			String s = "";
			while (c != -1) {
				if (c == 13)
					s += "<br>";
				else
					s += (char) c;
				c = in.read();
			}
			Connect_db db = new Connect_db();			
			if (db.c == null)
				return "not connected";
			else {
				db.insert(id, name);
				return "data saved";
			}
		
		}
	
		
		
	
	


