package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class MemberDao {
	private Connection conn;
	private MemberDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrd", "root", "1234");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	private static MemberDao instance = new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}
	
	public boolean write(MemberDto memberDto) {
		try {
			String sql = "insert into member_tbl_02(CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE, CITY ) values(?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, memberDto.getMno());
			ps.setString(2, memberDto.getMname());
			ps.setString(3, memberDto.getMphone());
			ps.setString(4, memberDto.getMaddress());
			ps.setString(5, memberDto.getMdate());
			ps.setString(6, memberDto.getMgrade());
			ps.setInt(7, memberDto.getMcode());
			int count = ps.executeUpdate();
			if (count == 1)
				return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public ArrayList<MemberDto> findAll() {
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		try {
			String sql = "SELECT * FROM MEMBER_TBL_02;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MemberDto memberDto = new MemberDto();
				memberDto.setMno(rs.getInt("CUSTNO"));
				memberDto.setMname(rs.getString("CUSTNAME"));
				memberDto.setMphone(rs.getString("PHONE"));
				memberDto.setMaddress(rs.getString("ADDRESS"));
				memberDto.setMdate(rs.getString("JOINDATE"));
				memberDto.setMgrade(rs.getString("GRADE"));
				memberDto.setMcode(rs.getInt("CITY"));
				list.add(memberDto);
			}
		} catch (Exception e) {
			System.out.println(e);}
		return list;
	}
	public ArrayList<SalesDto> findAll2() {
		ArrayList<SalesDto> list = new ArrayList<SalesDto>();
		try {
			String sql = "SELECT * FROM MONEY_TBL_02;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SalesDto salesDto = new SalesDto();
				salesDto.setMno(rs.getInt("CUSTNO"));
				salesDto.setSno(rs.getInt("SALENOL"));
				salesDto.setPrice(rs.getInt("PCOST"));
				salesDto.setQuenti(rs.getInt("AMOUNT"));
				salesDto.setTprice(rs.getInt("PRICE"));
				salesDto.setPnum(rs.getString("PCODE"));
				salesDto.setSdate(rs.getString("SDATE"));
				list.add(salesDto);
			}
		} catch (Exception e) {
			System.out.println(e);}
		return list;
	}
	
	public MemberDto findById(int mno) {
		try {
			String sql = "select * from member_tbl_02 where CUSTNO =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mno);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				MemberDto memberDto = new MemberDto();
				memberDto.setMno(rs.getInt("CUSTNO"));
				memberDto.setMname(rs.getString("CUSTNAME"));
				memberDto.setMphone(rs.getString("PHONE"));
				memberDto.setMaddress(rs.getString("ADDRESS"));
				memberDto.setMdate(rs.getString("JOINDATE"));
				memberDto.setMgrade(rs.getString("GRADE"));
				memberDto.setMcode(rs.getInt("CITY"));
				return memberDto;
			}

		} catch (Exception e) {System.out.println(e);}
		return null;
	}
	public boolean update(MemberDto memberDto) {
		try {
			String sql = "update member_tbl_02 set CUSTNO=?, CUSTNAME=?, PHONE=?, ADDRESS=?, JOINDATE=?, GRADE=?,CITY=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, memberDto.getMno());
			ps.setString(2,memberDto.getMname());
			ps.setString(3,memberDto.getMphone());
			ps.setString(4, memberDto.getMaddress());
			ps.setString(5, memberDto.getMdate());
			ps.setString(6, memberDto.getMgrade());
			ps.setInt(7, memberDto.getMcode());
			int count = ps.executeUpdate();
			if (count == 1) {
				return true;
			}
		}catch(Exception e) {System.out.println(e);}
		return false;
	}

}
