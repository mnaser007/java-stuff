package rest.API;

import java.util.Scanner;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



					//.......adding alphabates...

@Path("/Sum_alpha")
public class Sum_alpha {

	/*int a=1,b=2,c=3,d=4,e=5,f=6,g=7,h=8,i=9,j=10,
		k=11,l=12,m=13,n=14,o=15,p=16,q=17,r=18,
		s=19,t=20,u=21,v=22,w=23,x=24,y=25,z=26;
	String str;
	public String getAscii() {
	    int add = 0;
	    
	    char ch[]=str.toCharArray();
	    for(int i=0;i<ch.length;i++) {
	    if(ch[i]=='a')
	        add+=a;
	    else if(ch[i]=='b')
	        add+=b;
	    else if(ch[i]=='c')
	        add+=c;
	    else if(ch[i]=='d')
	        add+=d;
	    else if(ch[i]=='e')
	        add+=e;
	    else if(ch[i]=='f')
	        add+=f;
	    else if(ch[i]=='g')
	        add+=g;
	    else if(ch[i]=='h')
	        add+=h;
	    else if(ch[i]=='i')
	        add+=i;
	    else if(ch[i]=='j')
	        add+=j;
	    else if(ch[i]=='k')
	        add+=k;
	    else if(ch[i]=='l')
	        add+=l;
	    else if(ch[i]=='m')
	        add+=m;
	    else if(ch[i]=='n')
	        add+=n;
	    else if(ch[i]=='o')
	        add+=o;
	    else if(ch[i]=='p')
	        add+=p;
	    else if(ch[i]=='q')
	        add+=q;
	    else if(ch[i]=='r')
	        add+=r;
	    else if(ch[i]=='s')
	        add+=s;
	    else if(ch[i]=='t')
	        add+=t;
	    else if(ch[i]=='u')
	        add+=u;
	    else if(ch[i]=='v')
	        add+=v;
	    else if(ch[i]=='w')
	        add+=w;
	    else if(ch[i]=='x')
	        add+=x;
	    else if(ch[i]=='y')
	        add+=y;
	    else
	        add+=z;
	    
	    }
	    return "adding all the charecter values fromgiven String: "+add;
	}	
	 @Path("sum1/{name}")	
	@Produces(MediaType.TEXT_HTML)
    @GET
    public String getAscii(@PathParam("name")String name) {
		 Sum_alpha sq=new Sum_alpha();
        sq.str=name;
        return sq.getAscii();
	 }
}
*/
	
	String str;
	@Path("sum1/{name}")	
	@Produces(MediaType.TEXT_HTML)
   	@GET
   public String getAscii(@PathParam("name")String name) {
	  Sum_alpha sq=new Sum_alpha();
	  int sum1 = 0;
	 String low=name.toLowerCase();
	for (int i = 0; i < str.length(); i++) {
		int asci = str.charAt(i) - 96;
		sum1 += asci;
	
       return sq.str=name;	 
	// sum1;
		}
	}
}



















