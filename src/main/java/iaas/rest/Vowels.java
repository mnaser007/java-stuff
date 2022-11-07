package iaas.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/Vowels")
public class Vowels {
	
	
	@Produces(MediaType.TEXT_HTML)
    @GET
    @Path("vow/{str}")
    public String stringOp(@PathParam("str")String s) {
        int lengt = s.length();
        String store="";
        String inds_temp="";
        int len_store = 0;
        for(int i=0;i<lengt;i++) {
            if(s.charAt(i) == 'a'|| s.charAt(i) == 'e'||s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                store+=s.charAt(i)+" at the index " + i+"<br>";
                inds_temp+=Character.toUpperCase(s.charAt(i));
                len_store=len_store+1;
            }
            else {
                inds_temp+=s.charAt(i);
        }
        }
        return store + "<br>"+"Number of vowels is "+ len_store + "<br>"+ inds_temp + "<br>";
      }
	
	
	@Produces(MediaType.TEXT_HTML)
    @GET
    @Path("vow1/{str}")
	public String amani(@PathParam("str") String s) {
        String res = s.substring(s.length() - 3, s.length()).toUpperCase();        
        int count = 0;
        String m="";
        int index_a = -1, index_e = -1, index_i = -1, index_o = -1, index_u = -1; // default values.



       for (int i = 0; i < s.length(); i++) {
            
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
                    || s.charAt(i) == 'u') {
                
                m=m+(s.charAt(i)+"").toUpperCase();
     
                if (s.charAt(i) == 'a') {
                    count++;
                    index_a = s.indexOf(s.charAt(i));
                    
                }
                else if (s.charAt(i) == 'e') {
                    count++;
                    index_e = s.indexOf(s.charAt(i));
                }
                else if (s.charAt(i) == 'i') {
                    count++;
                    index_i = s.indexOf(s.charAt(i));
                }
                else if (s.charAt(i) == 'o') {
                    count++;
                    index_o = s.indexOf(s.charAt(i));
                }
                else if (s.charAt(i) == 'u') {
                    count++;
                    index_u = s.indexOf(s.charAt(i));
                }
                
            }
            else {
                m=m+(s.charAt(i));
            
        }
        }
        return m + "<br>" + "---------------------------------" + "<br>" + "count of vowels: " + "<b>" + count
                + "</b><br>" + "index_a: " + "<b>" + index_a + "</b>" + "<br>" + "index_e:" + "<b>" + index_e
                + "</b><br>" + "index_i: " + "<b>" + index_i + "</b><br>" + "index_o: " + "<b>" + index_o + "</b><br>"
                + "index_u: " + "<b>" + index_u + "</b><br>";
    }
	}



