package 자바DB연결;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BbsDAO {
	// 테이블 하나당 DAO 하나 ==> CUD를 완성
	public void delete(int no) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	// 사용할 드라이버
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);	// Connection
			System.out.println("2. 오라클 연결 성공");
			
			String sql = "delete from hr.BBS4 where NO = ?";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setInt(1, no);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기");
			
			ps.executeUpdate();
			System.out.println("4. SQL문 오라크로 보내기 성공");
			
		} catch (Exception e) {	// 모든 예외처리 해달라
			e.printStackTrace();
		}
	}
	
	public void update(int no, String content) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	// 사용할 드라이버
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);	// Connection
			System.out.println("2. 오라클 연결 성공");
			
			String sql = "update hr.BBS4 set content = ? where NO = ?";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setString(1, content);
			ps.setInt(2, no);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기");
			
			ps.executeUpdate();
			System.out.println("4. SQL문 오라크로 보내기 성공");
			
		} catch (Exception e) {	// 모든 예외처리 해달라
			e.printStackTrace();
		}
	}
	
	public void insert(int no, String title, String content, String writer) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 사용할 드라이버
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			System.out.println("2. 오라클 연결 성공");
			
			// public void insert(String id, String pw, String name, String tel)
			String sql = "insert into hr.BBS4 values (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			
			// R빼고 인덱스 0부터 시작
			// 유일하게 DB는 인덱스가 1부터 시작
			ps.setInt(1, no);	// ps.setInt(1, no);
			ps.setString(2, title);
			ps.setString(3, content);
			ps.setString(4, writer);
			// => insert into hr.MEMBWE2 values('a', 'a', 'a', 'a');
			
			System.out.println("3. SQL문 부품(객체)으로 만들어주기");

			ps.executeUpdate();
			System.out.println("4. SQL문 오라클로 보내기 성공");

		} catch (Exception e) { // 모든 예외처리 해달라
			e.printStackTrace();
		}
	}

}