package web.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import day05.BoardDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import web.model.dto.PointDto;

@NoArgsConstructor( access = lombok.AccessLevel.PRIVATE )
public class PointDao extends Dao{
	@Getter
	 private static PointDao instance = new PointDao();

	public ArrayList<PointDto> myPoint(int loginMno) {
		ArrayList<PointDto> list = new ArrayList<PointDto>();
		try {
			String sql = "select * from point join member on mno=mno where mno =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(  1 , loginMno);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PointDto pointDto = new PointDto();
				pointDto.setPno(rs.getInt("pno"));
				pointDto.setPcontent(rs.getString("pcontent"));
				pointDto.setPcount(rs.getInt("pcount"));
				pointDto.setPdate(rs.getString("pdate"));
				pointDto.setMno(rs.getInt("mno"));
				list.add(pointDto);
			}
		} catch (Exception e) {
			System.out.println(e);}
		return list;
	}
	
}
