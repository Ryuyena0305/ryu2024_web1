package web.model.dao;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import lombok.Getter;
import lombok.NoArgsConstructor;
import web.model.dto.BoardDto;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class BoardDao extends Dao{
	
	@Getter
	private static BoardDao instance = new BoardDao();
	public boolean write(BoardDto boardDto) {
		try {
			String sql = "insert into board(btitle,bcontent,mno,cno) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, boardDto.getBtitle());
			ps.setString(2, boardDto.getBcontent());
			ps.setInt(3, boardDto.getMno());
			ps.setInt(4, boardDto.getCno());
			int count = ps.executeUpdate();
			if(count==1) return true;
			
		}catch( Exception e) {System.out.println(e);}
			
		return false;
	}
	
	

}
