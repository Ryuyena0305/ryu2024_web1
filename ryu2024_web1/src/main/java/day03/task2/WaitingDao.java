package day03.task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WaitingDao {
	private Connection conn;
	private WaitingDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mydb0120_2",
					"root","1234");
			}catch(Exception e) {
				System.out.println(e);
			}
		
	}
	private static WaitingDao instance = new WaitingDao();
	public static WaitingDao getInstance() {
		return instance;
	}
	public boolean write(WaitingDto waitingDto) {
		try {
			String sql = "insert into waiting(phoneNum,pNum)values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, waitingDto.getPhoneNum());
			ps.setInt(2, waitingDto.getpNum());
			int count = ps.executeUpdate();
			if(count==1)return true;
			}catch(SQLException e) {System.out.println(e);}
			return false;
	}
	public boolean delete(int Num) {
		try {
			String sql = "delete from waiting where Num=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,Num);
			int count = ps.executeUpdate();
			if(count==1) return true;
			}catch(SQLException e) {System.out.println(e);}
			return false;
		}
		
	}
	
