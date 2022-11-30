package iaas.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("Trainee")
public class Trainee {

	Overload ol = new Overload();
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
	public String wish(@PathParam("user_name") String name) {
		return "Hello " + name + ", Welcome to REST";
	}

	/*
	 * @GET
	 * 
	 * @Produces(MediaType.TEXT_HTML)
	 * 
	 * @Path("add/{n1},{n2}") public String add(@PathParam("n1")String
	 * x,@PathParam("n2")String y) { try { float
	 * sum=Float.parseFloat(x)+Float.parseFloat(y); return "<h1>sum:"+sum+"<h1>"; }
	 * catch(NumberFormatException e) { return
	 * "<h1>one or more values are not numeric<br>sum:unknown</h1>"; }
	 * 
	 * }
	 */

	@GET
	@Path("add/{values}")
	@Produces(MediaType.TEXT_HTML)
	public String add(@PathParam("values") String values) {
		String[] vals = values.split(",");
		float sum = 0.0f;
		int count = values.length();
		try {
			for (int i = 0; i < vals.length; i++)
				sum += Float.parseFloat(vals[i]);
			// return "<font size=10px>"+sum+"</font>";
		} catch (Exception e) {
			return e.getMessage();
		}

		VarArgs va = new VarArgs();
		return "Adition is " + va.add("add", vals) + "<br>" + "Average is " + va.avg("avg", count, vals) + "";

	}

	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("studs")
	public String getStuds() {
		Stud s1 = new Stud();
		Stud s2 = new Stud();

		s1.id = 101;
		s1.name = "vinayak";
		s1.course = "java";
		s1.age = 25;

		s2.id = 102;
		s2.name = "aarthi";
		s2.course = "REST";
		s2.age = 23;

		Stud.college = "IAAS";

		return s1 + "<br>" + s2;
	}

	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("emp")
	public String getEmpDetails() {
		Emp e1 = new Emp(1000, "nivas", 45600);
		/*
		 * e1.id=1001; e1.name="manasa"; e1.sal=24560;
		 */
		return e1.toString();
	}

	/*
	 * @Produces(MediaType.TEXT_HTML)
	 * 
	 * @GET
	 * 
	 * @Path("emp/{sal}") public String getSal(@PathParam("sal") String sal) { Emp
	 * e1 = new Emp(); //e1.sal(Double.parseDouble(sal)); e1.sal=sal; return
	 * e1.sal+"<br>"; }
	 */
	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("array")
	public String getArray() {
		String a[] = new String[6];
		a[0] = "Naser";
		a[1] = "Irfan";
		a[2] = "vinayak";
		a[3] = "Akash";
		a[4] = "Arthi";
		a[5] = "Aamani";
		// String a[]= {"hyd","wgl","vjw","vzg","tpt","gtr"};
		String s = "";
		for (int i = 0; i < 4; i++)
			s += a[i] + "<br>";
		return s;

	}

	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("stud_arr")
	public String getStudArray() {
		Stud arr[] = new Stud[6];
		int ids[] = { 101, 102, 103, 104, 105, 106 };
		String names[] = { "Naser", "Irfan", "Akash", "Arthi", "Aamani", "Vinayak" };
		String courses[] = { "java", "sailpoint", "linux", "java", "linux", "sailpoint" };
		int ages[] = { 24, 24, 23, 22, 25, 28 };
		String s = "<table border=5><tr><th>Id</th><th>Name</th><th>Course</th><th>Age</th><th>College</th></tr>";
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Stud();
			arr[i].id = ids[i];
			arr[i].name = names[i];
			arr[i].course = courses[i];
			arr[i].age = ages[i];
			arr[i].college = "IAAS";
			s += "<tr><td>" + arr[i].id + "</td><td>" + arr[i].name + "</td><td>" + arr[i].course + "</td><td>"
					+ arr[i].age + "</td><td>" + arr[i].college + "</tr>";
		}
		s += "</table>";
		return s;

	}

	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("array/{size}")
	public String array(@PathParam("size") int size) {
		int ar[] = new int[size];
		String s = "";
		for (int i = 0; i < size; i++) {
			ar[i] = 10 * (i + 1);
			s += ar[i] + " ";
		}

		return s;
	}

	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("color/{color}")
	public String fillColor(@PathParam("color") String color) {
		String s = "<html><body bgcolor='" + color + "'></body></html>";
		return s;
	}

	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("string/{str}")
	public String stringOp(@PathParam("str") String s) {
		int length = s.length(); // number of chars
		String cap = s.toUpperCase(); // to capital letters
		String low = s.toLowerCase(); // small letters
		int ind = 7;
		char c = '*';
		if (ind < length)
			c = s.charAt(7);// to find char at given index
		String s1 = (c + "").toUpperCase() + s.substring(1);// to get a part of string from given index
		int start = 3, end = 6;
		String s2 = "";
		if (start < length && end < length)
			s2 = s.substring(start, end);// to get a part of string from start index to end index
		String last3 = s.substring(length - 3, length).toUpperCase();
		String inp = "ah";
		String inds = "";
		for (int i = 0; i < inp.length(); i++)
			inds += s.indexOf(inp.charAt(i)) + " "; // to get index of given char

		String replace = s.replace(last3.toLowerCase(), "nagar");
		String s3 = "bheem,divya,uday,bhatnagar,trisha,devi";
		String ar[] = s3.split(",");
		String split = "";
		for (int i = 0; i < ar.length; i++) {
			if (i == ar.length - 1)
				split += ar[i];
			else
				split += ar[i] + "<br>";
		}

		String res = length + "<br>" + cap + "<br>" + low + "<br>" + c + "<br>" + s1 + "<br>" + s2 + "<br>" + last3
				+ "<br>" + inds + "<br>" + replace + "<br>" + split;
		return "<font size=10px>" + res + "</font>";
	}

	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("replace/{s},{s1},{s2}")
	public String replace(@PathParam("s") String s, @PathParam("s1") String s1, @PathParam("s2") String s2) {
		return "<font size=10px>" + s.replace(s1, s2) + "</font>";
	}

	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("sum_int/{x},{y}")
	public String addNums(@PathParam("x") int x, @PathParam("y") int y) {
		return ol.add(x, y) + "";
	}

	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("sum_int_float/{x},{y}")
	public String addNums(@PathParam("x") int x, @PathParam("y") float y) {
		return ol.add(x, y) + "";
	}

	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("sum_float/{x},{y}")
	public String addNums(@PathParam("x") float x, @PathParam("y") float y) {
		return ol.add(x, y) + "";
	}

	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("load_array/{values}")
	public String loadArray(@PathParam("values") String values) {
		ar = new Array();
		ar.loadValues(values);
		return "values loaded:" + ar.readValues();
	}

	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("square/{n}")
	public String getSquare(@PathParam("n") int n) {
		Number number1 = new Number(n);
		Number number2 = new Number(n + 5);
		return number2.square() + "";

	}

	/*
	 * @Produces(MediaType.TEXT_HTML)
	 * 
	 * @GET
	 * 
	 * @Path("sin/{n}") public String getSin(@PathParam("n")double n) { trig.Number
	 * number=new trig.Number(n); return number.sin()+""; }
	 */

	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("number/{n}")
	public String getNumber(@PathParam("n") int n) {
		Number number = new Number(n);
		return number.n + "";
	}

	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("ascii/{c}")
	public String getNumber(@PathParam("c") String c) {
		char[] ar = c.toCharArray();
		String s = "";
		for (int i = 0; i < ar.length; i++) {
			int n = (int) ar[i];
			s += n + " ";
		}

		return s;
	}

	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("count_vow/{s}")
	public String countVowels(@PathParam("s") String s) {
		int count = 0;
		String vowels = "aeiouAEIOU";
		String s1 = "";
		for (int i = 0; i < s.length(); i++) {
			int vi = vowels.indexOf(s.charAt(i));
			if (vi >= 0) {
				count++;
				if (vi >= 0 && vi < 5)
					s1 += vowels.charAt(vi + 5);
			} else
				s1 += s.charAt(i);

		}
		return count + "<br>" + s1;
	}

	@GET
	@Path("first/{n1}/second/{n2}/sum")
	@Produces(MediaType.TEXT_HTML)
	public String sum(@PathParam("n1") int n1, @PathParam("n2") int n2) {
		return (n1 + n2) + "";
	}

	@GET
	@Path("inh")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Stud> getStud() {
		CurrStud cur = new CurrStud();
		cur.id = 100;
		cur.name = "vishal";
		cur.age = 23;
		cur.course = "java";
		cur.trainer = "bheem";
		cur.time = "10-12";
		cur.stipend = 10000;

		Deployed dep = new Deployed();
		dep.id = 101;
		dep.name = "vinay";
		dep.age = 26;
		dep.course = "SQL";
		dep.client = "infosys";
		dep.loc = "BLR";
		dep.salary = 36790;

		List<Stud> list = new ArrayList<Stud>();
		list.add(cur);
		list.add(dep);

		// Stud stud[]= {cur,dep};

		Stud st = new Stud();
		// st.trainer="bheem";
		return list;
	}

	@GET
	@Path("savings/{sal}")
	@Produces(MediaType.TEXT_HTML)
	public String getSavings(@PathParam("sal") double sal) {
		Child child = new Child();
		return child.getSavings(sal) + "";
	}

	// .........Topic instance..............

	@GET
	@Path("type")
	@Produces(MediaType.TEXT_HTML)
	public String type() {
		Instance<Float> inst = new Instance<Float>();
		// inst.x=0.0f;
		return inst.getType();
	}

	@GET
	@Path("t_array")
	@Produces(MediaType.TEXT_HTML)
	public String getArrayValues() {
		Instance<Float> inst = new Instance<Float>();
		inst.createArray(56.8f, 69.9f, 58.4f, 36.3f);
		String s = "";
		for (Float i : inst.readArray())
			s += i + ",";
		return s;

	}

	@GET
	@Path("t_array/{type}/{values}")
	@Produces(MediaType.TEXT_HTML)
	public String getArrayValues(@PathParam("type") String type, @PathParam("values") String values) {
		String vals[] = values.split(",");
		String s = "";
		if (type.equals("Integer")) {
			Inst<Integer> inst = new Inst<Integer>();
			inst.createArray(StringArray.toIntegerArray(vals));
			for (Integer i : inst.readArray())
				s += i + " ";
		} else if (type.equals("Float")) {
			Inst<Float> inst = new Inst<Float>();
			inst.createArray(StringArray.toFloatArray(vals));
			for (Float i : inst.readArray())
				s += i + " ";
		} else if (type.equals("String")) {
			Inst<String> inst = new Inst<String>();
			inst.createArray(vals);
			for (String i : inst.readArray())
				s += i + " ";
		}
		return s;

	}

	// Fin1 and Fin2 classes
	public String finalTest(int x) {
		Fin1 f1 = new Fin1();
		// f1.x=x;
		return x + "";
	}

	@GET
	@Path("area/{x}/{name}")
	@Produces(MediaType.TEXT_HTML)
	public String accessAbstract(@PathParam("x") float x, @PathParam("name") String name) {
		Shape circle = new Shape() {
			@Override
			public float area(float x) {
				// TODO Auto-generated method stub
				return 3.14f * x * x;
			}
		};

		Shape square = new Shape() {
			@Override
			public float area(float x) {
				// TODO Auto-generated method stub
				return x * x;
			}
		};
		String res = "circle area:" + circle.area(x) + "<br>square area:" + square.area(x) + "<br>"
				+ circle.drawnBy(name) + "<br>" + square.drawnBy(name);
		return res;
	}

	@GET
	@Path("vehicle")
	@Produces(MediaType.TEXT_HTML)
	public String getVehicleData() {
		PetrolCar car = new PetrolCar();
		// car.maxSpeed=180;
		return car.wheelCount() + "<br>" + car.fuelType() + "<br>" + car.color() + "<br>" + car.maxSpeed + "<br>"
				+ car.seatCount();
	}

	@GET
	@Path("shape/{rad}")
	@Produces(MediaType.TEXT_HTML)
	public String getShapeArea(@PathParam("rad") float x) {
		MyShape circle = (radius) -> {
			return 3.14f * radius * radius;
		};

		MyShape square = (side) -> {
			return side * side;
		};

		return circle.area(x) + "<br>" + square.area(x);
	}

	// ..............Arithmatic Operations in Inteerface...............
	@GET
	@Path("arithmatic1/{x},{y}")
	@Produces(MediaType.TEXT_HTML)
	public String doOperation(@PathParam("x") float x, @PathParam("y") float y) {
		Arithmatic add = (a, b) -> {
			return a + b;
		};
		String res = add.doOperation(x, y) + "";
		return res;

	}
	// ..........Enum...............................

	@GET
	@Path("signal/{color}")
	@Produces(MediaType.TEXT_HTML)
	public String getSignal(@PathParam("color") String color) {
		int code = 0;
		String text = "";
		String result = "";
		Signal signal = Signal.valueOf(color.toUpperCase()); // assigning to one signal type like "RED"
		try {
			for (int i = 0; i < 4; i++) {
				code += (int) color.toUpperCase().charAt(i);
			}
			switch (signal) {
			case RED:
				text = "<font color='red' size=10px>";
				break;
			case YELLOW:
				text = "<font color='yellow' size=10px>";
				break;
			case GREEN:
				text = "<font color='green' size=10px>";
				break;
			default:
				text = "<font color='green' size=10px>";
			}
			result = text + signal.toString() + ":" + signal.action + ":" + signal.time + ":" + code + "</font>";
			return result;
		} catch (IllegalArgumentException ex) {
			result = "<font color='" + color + "' size=10px>The given signal color is not valid</font>";
			return result;
		} catch (StringIndexOutOfBoundsException ex) {
			text = "<font color='" + color + "' size=10px>";
			result = text + signal.toString() + ":" + signal.action + ":" + signal.time + ":" + code + "</font>";
			return result;
		} catch (Exception ex) {
			return "";
		}
		/*
		 * finally { text="<font color='"+color+"' size=10px>";
		 * result=text+"thank u"+"</font>"; return result; }
		 */

	}

	@GET
	@Path("all_signals")
	@Produces(MediaType.TEXT_HTML)
	public String getAllSignals() {
		String allSig = "";
		for (Signal sig : Signal.values()) // singal.value type of array will be default array and from that adding and
											// returning
			allSig += sig.toString() + "<br>"; // singal are converting to String
		return allSig;
	}

	@GET
	@Path("vote/{age}")
	@Produces(MediaType.TEXT_HTML)
	public String vote(@PathParam("age") int age) {
		String votingPage = "";
		try {
			Vote vote = new Vote();
			if (vote.canVote(age))
				votingPage = "<form><input type='radio' name='party'>BJP<br><input type='radio' name='party'>TRS<br><input type='radio' name='party'>Congress<br><input type='radio' name='party'>MIM";
			else
				throw new LessAgeException("U r not eligible");
			return votingPage;
		} catch (LessAgeException e) {
			votingPage = e.getMessage();
			return votingPage;
		}
	}

	// ..............FileInputStream..............
	@GET
	@Path("read_file1/{fname}")
	@Produces(MediaType.TEXT_HTML)
	public String readFile(@PathParam("fname") String fname) {
		try {
			FileInputStream in = new FileInputStream("C:\\naserworkspace\\rest\\Files\\" + fname);
			int c = in.read();
			String s = "";
			while (c != -1) {
				if (c == 13)
					s += "<br>";
				else
					s += (char) c;
				c = in.read();
			}
			return s;
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	// ............FileOutputStream...................
	@GET
	@Path("write_file/{fname}/{data}")
	@Produces(MediaType.TEXT_HTML)
	public String writeFile(@PathParam("fname") String fname, @PathParam("data") String data) {
		try {
			FileOutputStream out = new FileOutputStream("C:\\naserworkspace\\rest\\Files\\" + fname, true);
			byte b[] = data.getBytes();
			out.write(b);
			out.write(System.lineSeparator().getBytes());
			return "data saved in file";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	// ..............LIST like integer ......................
	@GET
	@Path("list/{values}")
	@Produces(MediaType.TEXT_HTML)
	public String getlist(@PathParam("values") String values) {
		String ar[] = values.split(",");
		Integer ia[] = new Integer[ar.length];
		int i = 0;
		for (String val : ar)
			ia[i++] = new Integer(val); // i is increased by 1 after every the execution
		ListEx ex = new ListEx();
		List<Integer> list = ex.addValues(ia);// converting arrays to list
		String res = "";
		for (Integer val : list)
			res += val + "<br>";
		return res;
	}

	@GET
	@Path("list")
	@Produces(MediaType.TEXT_HTML)
	public String getList() {
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(-30);
		list.add(40);
		list.remove(1);
		list.add(2, 50);// adding in between
		List<Integer> list2 = new ArrayList<>();
		list2.add(100);
		list2.add(70);
		list2.add(90);
		list2.add(30);
		list.addAll(list2);
		list.removeAll(list2);
		list.set(2, 85);
		Collections.sort(list);// in ascending order it will sort
		Collections.reverse(list);// it will come last to first
		int x = list.get(2); // getting a value from given index
		String res = "";
		for (Integer i : list)
			res += i + "<br>";
		res += "------<br>";
		res += x + "<br>";
		// int i=list.indexOf(-30); // to check 30 is in which position
		int i = list.indexOf(100);// if the value is no there will check in
		res += i + "<br>";
		boolean b = list.contains(40); // if its is there it will give true or false
		res += b + "<br>";
		return res;
	}

	// List of objects link students,employees
	@GET
	@Path("emps_list")
	@Produces(MediaType.APPLICATION_JSON) // returning objects so use JSON Format
	public List<Emp> listOfEmps() {
		int ids[] = { 101, 102, 103 };
		String names[] = { "vishal", "vijay", "kiran" };
		int sals[] = { 23450, 24500, 35900 };
		List<Emp> emps = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Emp e = new Emp(ids[i], names[i], sals[i]);
			emps.add(e);
		}
		/*
		 * Emp e1=new Emp(100,"vishal", 23450); Emp e2=new Emp(101,"manish", 24500); Emp
		 * e3=new Emp(102,"naser", 25900);
		 * 
		 * emps.add(e1); emps.add(e2); emps.add(e3);
		 */

		return emps;
	}

	@GET
	@Path("item_list")
	@Produces(MediaType.APPLICATION_XML)
	public List<Item> getItems() {
		Item i1 = new Item(10, "briyani", 250);
		Item i2 = new Item(11, "roti", 25);
		Item i3 = new Item(12, "curry", 150);
		List<Item> items = new ArrayList<>();
		items.add(i1);
		items.add(i2);
		items.add(i3);
		Collections.sort(items);
		return items;

	}

	@GET
	@Path("set_city")
	@Produces(MediaType.TEXT_HTML)
	public String getSet() {
		// Set<String> set =new HashSet<>();
		// Set<String> set =new LinkedHashSet<>(); // if change hashet to Linkedhashet
		// then it will come in same order
		Set<String> set = new TreeSet<>(); // if we give in treeset then it will come in random or ascii value
		String ar1[] = { "hyd", "blore", "pune", "mumbai", "chennai", "blore", "pune" };
		for (String city : ar1) {
			set.add(city);
		}
		set.remove("mumbai"); // it will remove one item
		List<String> list = new ArrayList<>();
		for (String city : set)
			list.add(city);
		Collections.reverse(list);
		String s = "";
		for (String city : set)
			s += city + "<br>";
		return s;
	}

	@GET
	@Path("map")
	@Produces(MediaType.TEXT_HTML)
	public String getMap() {
		Map<Integer, String> map = new HashMap<>();
		String names[] = { "arathi", "aamani", "naser", "irfan", "vinayak", "akash" };
		for (int i = 101; i <= 100 + names.length; i++)
			map.put(i, names[i - 101]);
		String s = "";
		for (Map.Entry<Integer, String> entry : map.entrySet()) // inside the interface we have a class inside a map
			if (entry.getKey() == 104)
				s += entry.getKey() + "," + entry.getValue() + "<br>"; // entryset have one by one entry
		// s+=map.get(103);
		return s;
	}

	@GET
	@Path("map_marks")
	@Produces(MediaType.TEXT_HTML)
	public String getMarks() {
		Map<Integer, List<Integer>> map = new HashMap<>();
		List<Integer> list1 = Arrays.asList(67, 78, 98);
		List<Integer> list2 = Arrays.asList(77, 89, 88);
		List<Integer> list3 = Arrays.asList(67, 79, 98);
		map.put(101, list1);
		map.put(102, list2);
		map.put(103, list3);
		String s = "";
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet())
			s += entry.getKey() + ":" + entry.getValue() + "<br>";
		return s;
	}

	@GET
	@Path("map_family")
	@Produces(MediaType.TEXT_HTML)
	public String familyMap() {
		Map<String, Map<String, Object>> family = new LinkedHashMap<>();
		Map<String, Object> head = new LinkedHashMap<>();
		Map<String, Object> mem1 = new LinkedHashMap<>();
		Map<String, Object> mem2 = new LinkedHashMap<>();
		Map<String, Object> mem3 = new LinkedHashMap<>();
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

		String s = "";
		for (Map.Entry<String, Map<String, Object>> entry : family.entrySet())
			s += entry.getKey() + ":" + entry.getValue() + "<br>";
		return s;
	}

	@GET
	@Path("last_char_words/{text}")
	@Produces(MediaType.TEXT_HTML)
	public String lastCharOfWords(@PathParam("text") String text) {
		String ar[] = text.split(" ");
		String res = "";
		for (String s : ar)
			res += s.charAt(s.length() - 1);
		return res;
	}

	@GET
	@Path("scan_file/{fileName}")
	@Produces(MediaType.TEXT_HTML)
	public String readFileScan(@PathParam("fileName") String fileName) {
		List<String> lines = new ArrayList<>();
		try {
			Scanner sc = new Scanner(new File("C:\\ashwin\\classes\\java_iam_b3\\rest\\files\\" + fileName));
			while (sc.hasNextLine())
				lines.add(sc.nextLine());
			return lines.toString();
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	// .............database checking..................

	@GET
	@Path("connect_server")
	@Produces(MediaType.TEXT_HTML)
	public String connectToDatabase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = Connect_db.Connect();
			return "connected";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}

	
	
	@GET
	@Path("insert/{id},{name},{sal},{dep},{mgr}")
	@Produces(MediaType.TEXT_HTML)
	public String insert(@PathParam("id") int id, @PathParam("name") String name, @PathParam("sal") int sal,
			@PathParam("dep") int dep, @PathParam("mgr") int mgr) throws SQLException {
		Connect_db db = new Connect_db();
		if (db.c == null)
			return "not connected";
		else {
			db.insert(id, name, sal, dep, mgr);
			return "data saved";
		}
		/**/
	}

	@GET
	@Path("read_all_emps")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Emps> getAllEmps() {
		Connect_db db = new Connect_db();
		return db.readAllEmps();
	}

	@GET
	@Path("student_db")
	@Produces(MediaType.TEXT_HTML)
	public String getAllStudents() {
		Connect_db db = new Connect_db();
		return db.readAllStudentsList();
	}
	
	
	//......Inner classes........
	
	@GET
	@Path("inner_class")
	@Produces(MediaType.TEXT_HTML)
	public String getInnerVar() {
		Outer out= new Outer();
		Outer.Inner in=out.new Inner(); // this is for Non-static inner class
		
		Iouter.Inner iin=new Iouter.Inner(); //inner class in interface is by efault static
		Outer.Inner2 in2=new Outer.Inner2();
		return in.x+"<br>"+in2.n+"<br>"+out.getInt()+"<br>"+iin.x;
	}
	//.......Calendar..........
	
	@GET
	@Path("date")
	@Produces(MediaType.TEXT_HTML)
	public String getCurrentDate() {		
		CalEx ex= new CalEx();
		return ex.getDate();
	}
	
	//....checking different TimeZones......
	
	
	@GET
	@Path("zone")
	@Produces(MediaType.TEXT_HTML)
	public String getZones() {
		String tz[]=TimeZone.getAvailableIDs();
		String zones=";";
		for(String zone:tz)
		zones+=zone+"<br>";
		return zones;
		
	}
	// Getting area of time of the zone
	
	
	@GET
	@Path("zone_time/{zone}/{sub}")
	@Produces(MediaType.TEXT_HTML)
	public String getTime(@PathParam ("zone")String zone,@PathParam("sub")String sub){
		//TimeZone tz=TimeZone.getTimeZone("America/Mexico_City");
		TimeZone tz=TimeZone.getTimeZone(zone+"/"+sub);
		TimeZone.setDefault(tz);
		Calendar cal=Calendar.getInstance(tz);
		return cal.getTime().toString();
		
		

	}
	
	// .......String Tokenizer...... it will wherever we have .@ charecter wise
	
	
	@GET
	@Path("tokens/{string}/{delim}")
	@Produces(MediaType.TEXT_HTML)
	public String tokens(@PathParam ("string")String s,@PathParam ("delim")String delim) {
		StringTokenizer tok=new StringTokenizer(s,delim);
		String toks="";
		int n=tok.countTokens();
		while(tok.hasMoreTokens())
				toks+=tok.nextToken()+"--tokens: "+tok.countTokens()+"<br>";
		return "total number of tokens:"+n+"<br>"+toks;
	}	
	
	//HTML PAGE SETUP.....
	
	
	@GET
	@Path("bday")
	@Produces(MediaType.TEXT_HTML)
	public String bdayWish(@Context HttpServletRequest rq,@Context HttpServletRequest city) {
		String name=rq.getParameter("username");
		String name1=city.getParameter("city");
		return "Happy Birthday to: "+name+"<br>"+"and you born in :"+name1;
	}
	
	// Open the link after submitting the button....
	
	
	@GET
	@Path("website")
	@Produces(MediaType.TEXT_HTML)
		public String website(@Context HttpServletRequest fb,@Context HttpServletRequest gb,@Context HttpServletRequest lk) {
		
		String web=fb.getParameter("Facebook");	
		String web1=gb.getParameter("Google");
		String web2=lk.getParameter("Linkedin");
		String s="<a href=\"https://www.facebook.com/\">Facebook</a";
		String s1="<a href=\"https://www.google.com/\">Google</a";
		String s2="<a href=\"https://in.linkedin.com/\">Linkedin</a";
		String res="Links to Access:"+s+"<br>"+s1+"<br>"+s2;
		return res;

		}	
}


