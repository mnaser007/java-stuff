package iaas.rest;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Emps {
	public int eid;
	public String ename;
	public int sal;
	public int bonus;
	public int depId;
	public int manId;
	public Emps(int eid, String ename, int sal, int bonus, int depId, int manId) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.sal = sal;
		this.bonus = bonus;
		this.depId = depId;
		this.manId = manId;
	}
	public Emps() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Emps [eid=" + eid + ", ename=" + ename + ", sal=" + sal + ", bonus=" + bonus + ", depId=" + depId
				+ ", manId=" + manId + "]<br>";
	}

}


