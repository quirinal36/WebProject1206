package www.jcc.com.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import www.jcc.com.db.DBConn;
import www.jcc.com.vo.Board;

public class BoardControl {
	private final Logger logger = Logger.getLogger(getClass().getSimpleName());
	
	/**
	 * 게시글을 선택 해서 들어왔을 때 화면을 구성하기위한 메소드
	 * 
	 * @param board : id 값만 갖고있다.
	 * @return result : id, title, content 등등 모든 정보를 데이터베이스로부터 얻어온다.
	 */
	public Board selectOne(Board board) {
		Board result = new Board();
		
		DBConn db = new DBConn();
		
		try (Connection conn = db.getConnection()){
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM Board WHERE id=?");
			
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, board.getId());
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result.setId(rs.getInt("id"));
				result.setTitle(rs.getString("title"));
				result.setContent(rs.getString("content"));
				result.setWriter(rs.getString("writer"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 게시판을 데이터베이스에 입력하는 메소드
	 * 
	 * @param board : 제목, 내용, 작성자 정보가 전달된다.
	 * @return : 입력성공 (1) / 입력실패(0)
	 */
	public int insertBoard(Board board) {
		int result = 0;
		
		DBConn db = new DBConn();
		
		try (Connection conn = db.getConnection()){
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO Board (title, writer, content) VALUES (?, ?, ?)");
			
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			
			logger.info(pstmt.toString());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<Board> selectBoardList(Board board) {
		List<Board> result = new ArrayList<Board>();
		
		DBConn db = new DBConn();
		try (Connection conn = db.getConnection()){
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT id, title, writer, content, wdate FROM Board ");
		
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
			int i = 1;
			
			ResultSet rs = pstmt.executeQuery(); // 쿼리문 실행
			while(rs.next()) {
				Board item = new Board();
				item.setId(rs.getInt("id"));
				item.setTitle(rs.getString("title"));
				item.setWriter(rs.getString("writer"));
				item.setContent(rs.getString("content"));
				item.setWdate(rs.getString("wdate"));
				
				result.add(item);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateBoard(Board board) {
		int result = 0;
		
		return result;
	}
	
	public int deleteBoard(Board board) {
		int result = 0;
		
		return result;
	}
}