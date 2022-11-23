package iaas.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




@Path("ListObj")
public class ListObj {
	
	@GET
	@Path("list/{values}")
	@Produces(MediaType.TEXT_HTML)
	public String getlist(@PathParam("values")String values) {
		String ar[]=values.split(",");
		Integer ia[]=new Integer[ar.length];
		int i=0;
		for (String val:ar)
			ia[i++]=new Integer(val); //i is increased by 1 after every the execution
		ListEx ex=new ListEx();
		List<Integer> list=ex.addValues(ia);// converting arrays to list
		String res="";
		for (Integer val:list)
			res+=val+"<br>";
		return res;			
	}
	@GET
	@Path("list")
	@Produces(MediaType.TEXT_HTML)
	public String getList() {
		List<Integer> list=new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(-30);
		list.add(40);
		list.remove(1);
		list.add(2,50);//adding in between
		List<Integer> list2=new ArrayList<>();
		list2.add(100);
		list2.add(70);
		list2.add(90);
		list2.add(30);
		list.addAll(list2);
		list.removeAll(list2);
		list.set(2, 85);
		Collections.sort(list);// in ascending order it will sort
		Collections.reverse(list);// it will come last to first
		int x=list.get(2); // getting a value from given index
		String res="";
		for (Integer i:list)
			res+=i+"<br>";
		res+="------<br>";
		res+=x+"<br>";
		// int i=list.indexOf(-30); // to check 30 is in which position
		int i=list.indexOf(100);// if the value is no there will check in 
		res+=i+"<br>";
		boolean b=list.contains(40); // if its is there it will give true or false
		res+=b+"<br>";
		return res;
	}
	
	// List of objects link students,employees
	@GET
	@Path("employees")
	@Produces(MediaType.APPLICATION_JSON)// returning objects so use JSON Format
	public List<Emp> listOfEmps() {
		int ids[]= {101,102,103};
		String names[]= {"vishal","vijay","kiran"};
		int sals[]= {23450,24500,35900};
		List<Emp> emps=new ArrayList<>();
		for (int i=0;i<3; i++) {
			Emp e=new Emp(ids[i], names[i], sals[i]);
			emps.add(e);
		}					
	/*Emp e1=new Emp(100,"vishal", 23450);
	Emp e2=new Emp(101,"manish", 24500);
	Emp e3=new Emp(102,"naser", 25900);

	emps.add(e1);
	emps.add(e2);
	emps.add(e3);*/
	return emps;	
	}
	
	@GET
	@Path("item_list")
	@Produces(MediaType.APPLICATION_XML)
	public List<Item> getItems() {
		Item i1=new Item (10,"briyani",250);
		Item i2=new Item (11,"roti",25);
		Item i3=new Item (12,"curry",150);
		List<Item> items=new ArrayList<>();
		items.add(i1);
		items.add(i2);
		items.add(i3);
		Collections.sort(items);
		return items;	
	}
	
	
	// Finding common vlues in it 
	@GET
	@Path("common_list")
	@Produces(MediaType.TEXT_HTML)
	public String commonList() {
		List<Integer> list4=new ArrayList<> ();
		list4.add(100);
		list4.add(200);
		list4.add(300);
		list4.add(400);	
		list4.add(400);
		List<Integer> list5 =new ArrayList<> ();
		list5.add(400);
		list5.add(500);
		list5.add(600);
		list5.add(700);
		
		
		
		//Remove duplicates from a list
		for(Integer o:list4)
            if(!list5.contains(o))
                list5.add(o);
        
		String res1=""+list4;
		String res2=""+list5;
		list4.retainAll(list5);
		return "List4 is:"+res1+"<br>"+"List5 is:"+res2+"<br>"+"Common value is:"+list4+"<br>"+"duplicate value removed:"+list5;
		//Collections.sort(list4);
		//Collections.sort(list5);

		// take a String and sort the characters in alphabetical order.
	}
		@GET
	    @Path("String_sort/{s}")
	    @Produces(MediaType.TEXT_HTML)
	        public String getString_sort(@PathParam("s")String s) {
	        String st="";
	        st+=s;
	        char CharArray[]=st.toCharArray();
	        Arrays.sort(CharArray);
	        String str=new String(CharArray);
	        return str;
	    }

		
		public String empList() {
			List<Integer> emp=new ArrayList<> ();
			
			
			
		}
	}
	

