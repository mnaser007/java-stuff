package iaas.rest;

import java.io.FileOutputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("FileOutput")
public class FileOutput {

	@GET
	@Path("write_file/{fname}/{data}")
	@Produces(MediaType.TEXT_HTML)
	public String writeFile(@PathParam("fname")String fname,@PathParam("data")String data) {
		try {
			FileOutputStream out=new FileOutputStream("C:\\naserworkspace\\rest\\Files\\"+fname,true);
			byte b[]=data.getBytes();
			out.write(b);
			out.write(System.lineSeparator().getBytes());
			return "data saved in file";
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}
	
	
	
	
	//if user give input like 2,2 then it should add these two number and give output in file like 4
	
	@GET
	@Path("write_addition/{fname}/{x},{y}")
	@Produces(MediaType.TEXT_HTML)
	public String AdditionFile(@PathParam("fname")String fname,@PathParam("x")int x,@PathParam("y")int y) {
		try {	
			FileOutputStream out=new FileOutputStream("C:\\naserworkspace\\rest\\Files\\"+fname,true);
			String empty="";
			empty=(x+y)+"";
			byte b[]=empty.getBytes();
			out.write(b);
			out.write(System.lineSeparator().getBytes());
			return "your sum is:"+empty;
		}
		catch(Exception e) {
			return e.getMessage();
		}
	} 
}
	
	










