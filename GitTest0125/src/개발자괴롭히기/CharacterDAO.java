package 개발자괴롭히기;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CharacterDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs =null;
	int cnt = 0;

	// 이름, 스탯 입력 getName, getStats

	public int inputName(CharacterDTO cdto) {
		String name = cdto.getName();
		connection();
		try {
			String sql = "INSERT INTO character VALUES (?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	public int inputStats(CharacterDTO cdto) {
		int hp = cdto.getHp();
		int intell = cdto.getIntell();
		int fp = cdto.getFp();
		int mp = cdto.getMp();
		int ment = cdto.getMent();
		int cnt = 0;

		connection();
		try {
			String sql = "INSERT INTO character VALUES (?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, hp);
			psmt.setInt(2, intell);
			psmt.setInt(3, fp);
			psmt.setInt(4, mp);
			psmt.setInt(5, ment);
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	
	private void close() {
		
		try {
			if(rs != null) {
			rs.close();
			
		}
		if(psmt != null) {
			psmt.close();
		}
		if(conn != null) {
			conn.close();
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void connection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String db_url = "jdbc:oracle:thin@project-db-campus.smhrd.com:1524:xe";
			String db_id = "campus_23K_AI18_p1_4";
			String db_pw = "smhrd4";
			
			try {
				conn = DriverManager.getConnection(db_url, db_id, db_pw);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
