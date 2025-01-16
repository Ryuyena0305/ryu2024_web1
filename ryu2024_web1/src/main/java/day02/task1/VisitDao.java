package day02.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VisitDao {
	
	private Connection conn;
	
	private VisitDao() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/mydb0116",
				"root","1234");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	private static VisitDao instance = new VisitDao();
	public static VisitDao getInstance() {
		return instance;
	}
	public boolean write(String content, int age) {
		try {
		String sql = "insert into visit(content,age)values(?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, content);
		ps.setInt(2, age);
		int count = ps.executeUpdate();
		if(count==1)return true;
		}catch(SQLException e) {System.out.println(e);}
		return false;
	}
	
	public boolean delete(int num) {
		try {
		String sql = "delete from visit where num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, num);
		int count = ps.executeUpdate();
		if(count==1) return true;
		}catch(SQLException e) {System.out.println(e);}
		return false;
	}
	
}
