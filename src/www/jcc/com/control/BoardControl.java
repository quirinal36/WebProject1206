package www.jcc.com.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import www.jcc.com.db.DBConn;
import www.jcc.com.vo.Board;

public class BoardControl {

	public int insertBoard(Board board) {
		int result = 0;
		
		DBConn db = new DBConn();
		try (Connection conn = db.getConnection()){
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT id, title, writer, pwd, content, date, favorite FROM DreamDiary ");
			sql.append("WHERE writer=? and pwd = ?");
		
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
			int i = 1;
			pstmt.setString(i++, diary.getWriter());
			pstmt.setString(i++, diary.getPwd());
			
			ResultSet rs = pstmt.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
}
