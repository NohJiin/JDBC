package 자바DB연결;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MemberDAO2 {

	public int delete(String id) {
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	// 사용할 드라이버
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);	// Connection
			System.out.println("2. 오라클 연결 성공");
			
			String sql = "delete from hr.MEMBER2 where id = ?";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setString(1, id);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기");
			
			result = ps.executeUpdate();
			System.out.println("4. SQL문 오라클로 보내기 성공");
			if (result == 1) {
				System.out.println("회원가입 성공");
			}
			
		} catch (Exception e) {	// 모든 예외처리 해달라
			result = 0;
			e.printStackTrace();
		}
		return result;
	}
	
	public int update(String id, String tel) {
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	// 사용할 드라이버
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);	// Connection
			System.out.println("2. 오라클 연결 성공");
			
			String sql = "update hr.MEMBER2 set tel = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setString(1, tel);
			ps.setString(2, id);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기");
			
			result = ps.executeUpdate();
			System.out.println("4. SQL문 오라클로 보내기 성공");
			if (result == 1) {
				System.out.println("회원가입 성공");
			}
			
		} catch (Exception e) {	// 모든 예외처리 해달라
			result = 0;
			e.printStackTrace();
		}
		return result;
	}
	
	public int insert(String id, String pw, String name, String tel) {
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 사용할 드라이버
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			System.out.println("2. 오라클 연결 성공");
			
			// public void insert(String id, String pw, String name, String tel)
			String sql = "insert into hr.MEMBER2 values (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			
			// R빼고 인덱스 0부터 시작
			// 유일하게 DB는 인덱스가 1부터 시작
			ps.setString(1, id);	// ps.setInt(1, no);
			ps.setString(2, pw);
			ps.setString(3, name);
			ps.setString(4, tel);
			// => insert into hr.MEMBWE2 values('a', 'a', 'a', 'a');
			
			System.out.println("3. SQL문 부품(객체)으로 만들어주기");

			result = ps.executeUpdate();
			System.out.println("4. SQL문 오라클로 보내기 성공");
			if (result == 1) {
				System.out.println("회원가입 성공");
			}
			// System.out.println(result);
		} catch (Exception e) { // 모든 예외처리 해달라
			// insert가 제대로 안된 경우, 위험한 상황이라고 판단
			// catch가 실행
			// 실행된 row수가 없으므로 result에 0을 넣어주자
			// result = 0;
			e.printStackTrace();
		}
		
		System.out.println(result);
		return result;
	}

}