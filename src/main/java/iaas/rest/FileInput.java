package iaas.rest;

import java.io.FileInputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("FileInput")
public class FileInput {
	
	@GET
	@Path("read_file1/{fname}")
	@Produces(MediaType.TEXT_HTML)
	public String readFile(@PathParam("fname")String fname) {
		try {
			FileInputStream in=new FileInputStream("C:\\naserworkspace\\rest\\Files\\"+fname);
			int c=in.read();
			String s="";
			while(c!=-1) {
				if(c==13)
					s+="<br>";
				else
					s+=(char)c;
				c=in.read();
			}
			return s;
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}
}
