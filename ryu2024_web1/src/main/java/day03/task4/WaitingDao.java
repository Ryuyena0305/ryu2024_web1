package day03.task4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public ArrayList<WaitingDto> findAll() {
		ArrayList<WaitingDto> list = new ArrayList<WaitingDto>();
		try {
			String sql = "select * from waiting";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				WaitingDto waitingDto = new WaitingDto();
				waitingDto.setNum( rs.getInt("num") );
				waitingDto.setPhoneNum(rs.getString("phoneNum"));
				waitingDto.setpNum(rs.getInt("pNum"));
				list.add(waitingDto);
			}
		}catch( SQLException e) { System.out.println(e);}
		return list;
	}
	
	public boolean update(WaitingDto waitingDto) {
		try {
			String sql = "update waiting set phoneNum =? , pNum=? where num = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, waitingDto.getPhoneNum());
			ps.setInt(2,waitingDto.getpNum());
			ps.setInt(3, waitingDto.getNum());
			int count = ps.executeUpdate();
			if(count==1) {
				return true;
			}
		}catch(SQLException e) {System.out.println(e);}
		return false;
	}
	
	
	public boolean delete(int num) {
		try {
			String sql = "delete from waiting where num=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,num);
			int count = ps.executeUpdate();
			if(count==1) return true;
			}catch(SQLException e) {System.out.println(e);}
			return false;
		}
	

		
	}
	
