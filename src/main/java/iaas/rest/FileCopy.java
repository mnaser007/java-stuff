package iaas.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.*;
import java.util.Scanner;



@Path("FileCopy")
public class FileCopy {
	// copy data from one file to other  file but from two different folders
	@GET
	@Path("copyfrom/{file1},{file2}")
	@Produces(MediaType.TEXT_HTML)
	public String copyFile(@PathParam("file1") String f1,@PathParam("file2") String f2) {
			try {
				String p1="C:\\naserworkspace\\rest\\Files-1\\";
	            String p2="C:\\naserworkspace\\rest\\Files-1\\Files-2\\";
	            
				FileInputStream in= new FileInputStream(p1+f1);	//C:\\naserworkspace\\rest\\Files-1\\demo1.txt
				FileOutputStream out=new FileOutputStream(p2+f2); //C:\\naserworkspace\\rest\\Files-1\\Files-2\\demo2.txt       
			            int c=in.read();
			            while(c!=-1) {
			                out.write(c);
			                c=in.read();
			            }
			            return "data copied";
			}
			catch (Exception e) {
				return e.getMessage();
			}
	}
			
			// ...........reading a  files ..................
			@GET
			@Path("scan_file/{fileName}")
			@Produces(MediaType.TEXT_HTML)
			public String readFile(@PathParam("fileName")String  fileName) {
				String op="";			
				try {
					Scanner sc=new Scanner(new File("C:\\naserworkspace\\rest\\Files-1\\"+fileName));
					while (sc.hasNextLine())
						op+=sc.nextLine();
					return op;			
				}
				catch (Exception e) {
					return e.getMessage();
				}	
			}
			}
