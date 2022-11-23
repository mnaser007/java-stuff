package iaas.rest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("Hashmap")
public class Maps {

	
	@GET
	@Path("map")
	@Produces(MediaType.TEXT_HTML)
	public String getMap() {
		Map<Integer,String> map=new HashMap<>();
		String names[]= {"arathi","aamani","naser","irfan","vinayak","akash"};
		for (int i=101;i<=100+names.length;i++)
			map.put(i, names[i-101]);
		String s="";
		for(Map.Entry<Integer, String> entry:map.entrySet()) //inside the interface we have a class inside a map
			if(entry.getKey()==104)
			s+=entry.getKey()+","+entry.getValue()+"<br>"; //entryset have one by one entry
		//s+=map.get(103);
		return s;
	}
	
	@GET
	@Path("map_marks")
	@Produces(MediaType.TEXT_HTML)
	public String getMarks() {
		Map<Integer,List<Integer>> map=new HashMap<>();
		List<Integer> list1=Arrays.asList(67,78,98);
		List<Integer> list2=Arrays.asList(77,89,88);
		List<Integer> list3=Arrays.asList(67,79,98);
		map.put(101, list1);
		map.put(102, list2);
		map.put(103, list3);
		String s="";
		 for(Map.Entry<Integer, List<Integer>> entry:map.entrySet())
	            s+=entry.getKey()+":"+entry.getValue()+"<br>";
		return s;
	}
	
	@GET
	@Path("map_family")
	@Produces(MediaType.TEXT_HTML)
	public String familyMap() {
		Map<String,Map<String,Object>> family=new LinkedHashMap<>();
		Map<String,Object> head=new LinkedHashMap<>();
		Map<String,Object> mem1=new LinkedHashMap<>();
		Map<String,Object> mem2=new LinkedHashMap<>();
		Map<String,Object> mem3=new LinkedHashMap<>();
		head.put("name", "Abdul Rahaman");
		head.put("age", 65);
		head.put("rel", "self");
		
		mem1.put("name", "kousar");
		mem1.put("age", 40);
		mem1.put("rel", "wife");
		
		mem2.put("name", "naser");
		mem2.put("age", 24);
		mem2.put("rel", "son");
		
		mem3.put("name", "amer");
		mem3.put("age", 30);
		mem3.put("rel", "son2");
				
		family.put("head", head);
		family.put("mem1", mem1);
		family.put("mem2", mem2);
		family.put("mem3", mem3);
		
		String s="";
		for(Map.Entry<String, Map<String,Object>> entry:family.entrySet())
		s+=entry.getKey()+":"+entry.getValue()+"<br>";
		return s;
		
		// output will come in flower bracket in HashMap
	}
}
