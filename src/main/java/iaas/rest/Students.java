package iaas.rest;

public class Students {

	public int id;
	public String name;
	public String course;
	public int age;
	public static String college;

	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", course=" + course + ", age=" + age + "]";
	}
}
