package web.model.dao;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import web.model.dto.BoardDto;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class BoardDao extends Dao {

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
			if (count == 1)
				return true;

		} catch (SQLException e) {
			System.out.println(e);
		}

		return false;
	}

	public ArrayList<BoardDto> findAll(int cno){
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		try {
			//String sql = "select * from board inner join member on board.mno=member.mno order by board.bno desc";
			String sql = "select * from board inner join member on board.mno=member.mno "
					+ "where cno =? order by board.bno asc ";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cno);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBno(rs.getInt("bno"));
				boardDto.setBtitle(rs.getString("btitle"));
				boardDto.setBcontent(rs.getString("bcontent"));
				boardDto.setBview(rs.getInt("bview"));
				boardDto.setBdate(rs.getString("bdate"));
				boardDto.setMno(rs.getInt("mno"));
				boardDto.setCno(rs.getInt("cno"));
				boardDto.setMid(rs.getString("mid"));
				list.add(boardDto);
			}
		}catch(SQLException e ){System.out.println(e);}
		return list;
	}// f e

    public boolean update( BoardDto boardDto ) {
            try {
                    String sql = "update board set btitle = ? , bcontent = ? where bno = ?";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString( 1 , boardDto.getBtitle() );
                    ps.setString( 2 , boardDto.getBcontent() );
                    ps.setInt( 3 , boardDto.getBno() );
                    int count = ps.executeUpdate();
                    if( count == 1 ) return true;
            }catch(Exception e ) { System.out.println( e );}
            return false;
    }
	
	public boolean delete(int bno) {
		try {
			String sql = "delete from board where bno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int count = ps.executeUpdate();
			if(count==1)
				return true;
			
		}catch( SQLException e ) {System.out.println(e);}
		return false;
	}

	public BoardDto findByBno(int bno) {
		try {
			//(1) 특정 게시물 테이블의 게시물 1개 조회
			//String sql = "select * from board where bno=?";
			//(2) 게시물 테이블과 회원 테이블 교집합 구해서 회원아이디로 조회 가능
			//String sql = "select * from board inner join member board.mno=member.mno";
			//(3) 게시물 테이블과 회원 테이블과 카테고리 테이블 교집합 구해서 회원아이디와 카테고리명 조회 가능
			String sql = "select * from board inner join member on board.mno = member.mno inner join category on board.cno = category.cno where bno = ?";
			
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setInt(1, bno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBno(rs.getInt("bno"));
				boardDto.setBtitle(rs.getString("btitle"));
				boardDto.setBcontent(rs.getString("bcontent"));
				boardDto.setBview(rs.getInt("bview"));
				boardDto.setBdate(rs.getString("bdate"));
				boardDto.setMno(rs.getInt("mno"));
				boardDto.setCno(rs.getInt("cno"));
				boardDto.setMid(rs.getString("mid"));
				boardDto.setCname(rs.getString("cname"));
				return boardDto;
				
				
			}
			
		}catch(Exception e) {System.out.println(e);}
		return null;
	}//f e

	

}// m e
