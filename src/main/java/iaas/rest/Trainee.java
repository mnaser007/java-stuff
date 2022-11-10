package iaas.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("Trainee")
public class Trainee {
	

		Overload ol=new Overload();
		Array ar;
		
		@GET
		@Produces(MediaType.TEXT_HTML)
		@Path("all")
		public String wish() {
			return "<center><h1>Hello trainees, Welcome to REST</h1></center>";
		}
		
		@GET
		@Produces("text/plain")
		@Path("{user_name}")
		public String wish(@PathParam("user_name")String name) {
			return "Hello "+name+", Welcome to REST";
		}
		
		/*@GET
		@Produces(MediaType.TEXT_HTML)
		@Path("add/{n1},{n2}")
		public String add(@PathParam("n1")String x,@PathParam("n2")String y) {
			try {
				float sum=Float.parseFloat(x)+Float.parseFloat(y);
				return "<h1>sum:"+sum+"<h1>";
			}
			catch(NumberFormatException e) {
				return "<h1>one or more values are not numeric<br>sum:unknown</h1>";
			}
			
		}*/
		
		
		@GET
		@Path("add/{values}")
		@Produces(MediaType.TEXT_HTML)
		public String add(@PathParam("values")String values) {
			String[] vals=values.split(",");
			float sum=0.0f;
			try {
				for(int i=0;i<vals.length;i++)
					sum+=Float.parseFloat(vals[i]);
				return "<font size=10px>"+sum+"</font>";
			}
			catch(Exception e) {
				return e.getMessage();
			}
		
		
			VarArgs va=new VarArgs();
			return va.add("add",vals)+"<br>"+va.avg("avg", vals)+"<br>"+va.perc("percentage", p, vals);
		
			}
		
		@Produces(MediaType.TEXT_HTML)
		@GET
		@Path("studs")
		public String getStuds() {
			Stud s1=new Stud();
			Stud s2=new Stud();
			
			s1.id=101;
			s1.name="vinayak";
			s1.course="java";
			s1.age=25;
			
			s2.id=102;
			s2.name="aarthi";
			s2.course="REST";
			s2.age=23;
			
			Stud.college="IAAS";
		
			
			return s1+"<br>"+s2;
		}
		
		@Produces(MediaType.TEXT_HTML)
		@GET
		@Path("emp")
		public String getEmpDetails() {
			Emp e1=new Emp(1000,"nivas",45600);
			/*e1.id=1001;
			e1.name="manasa";
			e1.sal=24560;*/
			return e1.toString();
		}
		
		@Produces(MediaType.TEXT_HTML)
		@GET
		@Path("emp/{sal}")
		public String getSal(@PathParam("sal")String sal) {
			Emp e1=new Emp();
			e1.setSal(Double.parseDouble(sal));
			return e1.getSal()+"<br>";
		}
		
		@Produces(MediaType.TEXT_HTML)
		@GET
		@Path("array")
		public String getArray() {
			String a[]=new String[6];
			a[0]="Naser";
			a[1]="Irfan";
			a[2]="vinayak";
			a[3]="Akash";
			a[4]="Arthi";
			a[5]="Aamani";
			//String a[]= {"hyd","wgl","vjw","vzg","tpt","gtr"};
			String s="";
			for(int i=0;i<4;i++)
				s+=a[i]+"<br>";
			return s;
			
		}
		
		@Produces(MediaType.TEXT_HTML)
		@GET
		@Path("stud_arr")
		public String getStudArray() {
			Stud arr[]=new Stud[6];
			int ids[]= {101,102,103,104,105,106};
			String names[]= {"Naser","Irfan","Akash","Arthi","Aamani","Vinayak"};
			String courses[]= {"java","sailpoint","linux","java","linux","sailpoint"};
			int ages[]= {24,24,23,22,25,28};
			String s="<table border=5><tr><th>Id</th><th>Name</th><th>Course</th><th>Age</th><th>College</th></tr>";
			for(int i=0;i<arr.length;i++) {
				arr[i]=new Stud();
				arr[i].id=ids[i];
				arr[i].name=names[i];
				arr[i].course=courses[i];
				arr[i].age=ages[i];
				arr[i].college="IAAS";
				s+="<tr><td>"+arr[i].id+"</td><td>"+arr[i].name+"</td><td>"+arr[i].course+"</td><td>"+arr[i].age+"</td><td>"+arr[i].college+"</tr>";
			}
			s+="</table>";
			return s;
			
		}
		
		@Produces(MediaType.TEXT_HTML)
		@GET
		@Path("array/{size}")
		public String array(@PathParam("size")int size) {
			int ar[]=new int[size];
			String s="";
			for(int i=0;i<size;i++) {
				ar[i]=10*(i+1);
				s+=ar[i]+" ";
			}
			
			return s;	
		}
		
		
		@Produces(MediaType.TEXT_HTML)
		@GET
		@Path("color/{color}")
		public String fillColor(@PathParam("color")String color) {
			String s="<html><body bgcolor='"+color+"'></body></html>";
			return s;	
		}
		
		@Produces(MediaType.TEXT_HTML)
		@GET
		@Path("string/{str}")
		public String stringOp(@PathParam("str")String s) {
			int length=s.length(); //number of chars
			String cap=s.toUpperCase(); //to capital letters
			String low=s.toLowerCase(); //small letters
			int ind=7;
			char c='*';
			if(ind<length)
				c=s.charAt(7);//to find char at given index
			String s1=(c+"").toUpperCase()+s.substring(1);//to get a part of string from given index
			int start=3,end=6;
			String s2="";
			if(start<length&&end<length)
				s2=s.substring(start,end);//to get a part of string from start index to end index 
			String last3=s.substring(length-3, length).toUpperCase();
			String inp="ah";
			String inds="";
			for(int i=0;i<inp.length();i++)
				inds+=s.indexOf(inp.charAt(i))+" "; //to get index of given char
			
			String replace=s.replace(last3.toLowerCase(), "nagar");
			String s3="bheem,divya,uday,bhatnagar,trisha,devi";
			String ar[]=s3.split(",");
			String split="";
			for(int i=0;i<ar.length;i++) {
				if(i==ar.length-1)
					split+=ar[i];
				else
					split+=ar[i]+"<br>";
			}
				
			String res=length+"<br>"+cap+"<br>"+low+"<br>"+c+"<br>"+s1+"<br>"+s2+"<br>"+last3+"<br>"+inds+"<br>"+replace+"<br>"+split;
			return "<font size=10px>"+res+"</font>";
		}
		
		@Produces(MediaType.TEXT_HTML)
		@GET
		@Path("replace/{s},{s1},{s2}")
		public String replace(@PathParam("s")String s,@PathParam("s1")String s1,@PathParam("s2")String s2) {
			return "<font size=10px>"+s.replace(s1, s2)+"</font>";
		}
		
		@Produces(MediaType.TEXT_HTML)
		@GET
		@Path("sum_int/{x},{y}")
		public String addNums(@PathParam("x")int x,@PathParam("y")int y) {
			return ol.add(x, y)+"";
		}
		
		@Produces(MediaType.TEXT_HTML)
		@GET
		@Path("sum_int_float/{x},{y}")
		public String addNums(@PathParam("x")int x,@PathParam("y")float y) {
			return ol.add(x, y)+"";
		}
		
		@Produces(MediaType.TEXT_HTML)
		@GET
		@Path("sum_float/{x},{y}")
		public String addNums(@PathParam("x")float x,@PathParam("y")float y) {
			return ol.add(x, y)+"";
		}
		
		@Produces(MediaType.TEXT_HTML)
		@GET
		@Path("load_array/{values}")
		public String loadArray(@PathParam("values")String values) {
			ar=new Array();
			ar.loadValues(values);
			return "values loaded:"+ar.readValues();
		}
		
		@Produces(MediaType.TEXT_HTML)
		@GET
		@Path("square/{n}")
		public String getSquare(@PathParam("n")int n) {
			Number number1=new Number(n);
			Number number2=new Number(n+5);
			return number2.square()+"";
			
		}
		
		/*@Produces(MediaType.TEXT_HTML)
		@GET
		@Path("sin/{n}")
		public String getSin(@PathParam("n")double n) {
			trig.Number number=new trig.Number(n);
			return number.sin()+"";
		}*/
		
		@Produces(MediaType.TEXT_HTML)
		@GET
		@Path("number/{n}")
		public String getNumber(@PathParam("n")int n) {
			Number number=new Number(n);
			return number.n+"";
		}
		
		@Produces(MediaType.TEXT_HTML)
		@GET
		@Path("ascii/{c}")
		public String getNumber(@PathParam("c")String c) {
			char[] ar=c.toCharArray();
			String s="";
			for(int i=0;i<ar.length;i++) {
				int n=(int)ar[i];
				s+=n+" ";
			}
			
			return s;
		}
		
		@Produces(MediaType.TEXT_HTML)
		@GET
		@Path("count_vow/{s}")
		public String countVowels(@PathParam("s")String s) {
			int count=0;
			String vowels="aeiouAEIOU";
			String s1="";
			for(int i=0;i<s.length();i++) {
				int vi=vowels.indexOf(s.charAt(i));
				if(vi>=0) {
					count++;
					if(vi>=0&&vi<5)
						s1+=vowels.charAt(vi+5);
				}
				else
					s1+=s.charAt(i);
					
			}
			return count+"<br>"+s1;
		}
		
		@GET
		@Path("first/{n1}/second/{n2}/sum")
		@Produces(MediaType.TEXT_HTML)
		public String sum(@PathParam("n1")int n1,@PathParam("n2")int n2) {
			return (n1+n2)+"";
		}
		
		@GET
		@Path("inh")
		@Produces(MediaType.APPLICATION_JSON)
		public List<Stud> getStud() {
			CurrStud cur=new CurrStud();
			cur.id=100;
			cur.name="vishal";
			cur.age=23;
			cur.course="java";
			cur.trainer="bheem";
			cur.time="10-12";
			cur.stipend=10000;
			
			Deployed dep=new Deployed();
			dep.id=101;
			dep.name="vinay";
			dep.age=26;
			dep.course="SQL";
			dep.client="infosys";
			dep.loc="BLR";
			dep.salary=36790;
			
			List<Stud> list=new ArrayList<Stud>();
			list.add(cur);
			list.add(dep);
			
			//Stud stud[]= {cur,dep};
			
			Stud st=new Stud();
			//st.trainer="bheem";
			return list;
		}
		
		@GET
		@Path("savings/{sal}")
		@Produces(MediaType.TEXT_HTML)
		public String getSavings(@PathParam("sal")double sal) {
			Child child=new Child();
			return child.getSavings(sal)+"";
		}
		
		//.........Topic instance..............
		
		@GET
		@Path("type")
		@Produces(MediaType.TEXT_HTML)
		public String type() {
			Instance<Float> inst=new Instance<Float>();
			//inst.x=0.0f;
			return inst.getType();
		}
		
		
		@GET
		@Path("t_array")
		@Produces(MediaType.TEXT_HTML)
		public String getArrayValues() {
			Instance<Float> inst=new Instance<Float>();
			inst.createArray(56.8f,69.9f,58.4f,36.3f);
			String s="";
			for(Float i:inst.readArray())
				s+=i+",";
			return s;
			
		}
		
		
		@GET
		@Path("t_array/{type}/{values}")
		@Produces(MediaType.TEXT_HTML)
		public String getArrayValues(@PathParam("type")String type,@PathParam("values")String values) {
			String vals[]=values.split(",");
			String s="";
			if(type.equals("Integer")) {
				Inst<Integer> inst=new Inst<Integer>();
				inst.createArray(StringArray.toIntegerArray(vals));
				for(Integer i:inst.readArray())
					s+=i+" ";
			}
			else if(type.equals("Float")) {
				Inst<Float> inst=new Inst<Float>();
				inst.createArray(StringArray.toFloatArray(vals));
				for(Float i:inst.readArray())
					s+=i+" ";
			}
			else if(type.equals("String")) {
				Inst<String> inst=new Inst<String>();
				inst.createArray(vals);
				for(String i:inst.readArray())
					s+=i+" ";
			}
			return s;
			
		}
		 //Fin1 and Fin2 classes
		public String finalTest(int x) {
			Fin1 f1=new Fin1();
			//f1.x=x;
			return x+"";
		}
		
		@GET
		@Path("area/{x}/{name}")
		@Produces(MediaType.TEXT_HTML)
		public String accessAbstract(@PathParam("x")float x,@PathParam("name")String name) {
			Shape circle=new Shape() {	
				@Override
				public float area(float x) {
					// TODO Auto-generated method stub
					return 3.14f*x*x;
				}
			};	 
			
			Shape square = new Shape() {	
				@Override
				public float area(float x) {
					// TODO Auto-generated method stub
					return x*x;
				}
			};	
			String res="circle area:"+circle.area(x)+"<br>square area:"+square.area(x)+"<br>"+circle.drawnBy(name)+"<br>"+square.drawnBy(name);
			return res;
		}
		

		@GET
		@Path("vehicle")
		@Produces(MediaType.TEXT_HTML)
		public String getVehicleData() {
			PetrolCar car=new PetrolCar();
			//car.maxSpeed=180;
			return car.wheelCount()+"<br>"+car.fuelType()+"<br>"+car.color()+"<br>"+car.maxSpeed+"<br>"+car.seatCount();
		}
		
		@GET
		@Path("shape/{rad}")
		@Produces(MediaType.TEXT_HTML)
		public String getShapeArea(@PathParam("rad")float x) {
			MyShape circle=(radius)->{
				return 3.14f*radius*radius;
			};
			
			MyShape square=(side)->{
				return side*side;
			};
			
			return circle.area(x)+"<br>"+square.area(x);
		}
	}
		
		
	
	


