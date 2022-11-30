package iaas.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class Connect_db {
	public static Connection c;

	public static Connection Connect() {

		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/restdb?enabledTLSProtocols=TLSv1.2", "root",
					"root");
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void insert(int id, String name, int sal, int dep, int mgr) {
		int bonus = sal * 15 / 100;
		String sql = "insert into emp values(?,?,?,?,?,?)";
		java.sql.PreparedStatement ps;
		try {
			ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, sal);
			ps.setInt(4, bonus);
			ps.setInt(5, dep);
			ps.setInt(6, mgr);
			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Emps> readAllEmpsof() {
		java.sql.PreparedStatement ps;
		try {
			ps = c.prepareStatement("select * from emp");
			ResultSet rs = ps.executeQuery();
			List<Emps> emps = new ArrayList<>();
			while (rs.next()) {
				emps.add(new Emps(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6)));
			}
			return emps;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void insertinto(int id, String name, int sal, int dep, int mgr) {
		int bonus = sal * 15 / 100;
		String sql = "insert into emp values(?,?,?,?,?,?)";
		java.sql.PreparedStatement ps;
		try {
			ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, sal);
			ps.setInt(4, bonus);
			ps.setInt(5, dep);
			ps.setInt(6, mgr);
			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Emps> readAllEmps() {
		java.sql.PreparedStatement ps;
		try {
			ps = c.prepareStatement("select * from emp");
			ResultSet rs = ps.executeQuery();
			List<Emps> emps = new ArrayList<>();
			while (rs.next()) {
				emps.add(new Emps(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6)));
			}
			return emps;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public String readAllEmpsAsString() {

		return null;
	}

	
	
	  // ..........Select * from table_name............
	
	public String readAllStudentsList() {
		PreparedStatement ps;
		try {
			ps = c.prepareStatement("select * from Students");
			ResultSet rs = ps.executeQuery();
			
			List<Stud> st = new ArrayList<>();
			
			while (rs.next()) {
				st.add(new Stud(rs.getInt("id"), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
			}
			
			return st.toString();
			
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
}

