package 자바DB연결;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DB연결테스트 {

	public static void main(String[] args) {
		// 1. 오라클 11g와 연결할 부품 설정
		// 외부파일 연결 -> try/catch
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	// 사용할 드라이버
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공");
			
			// 2. 오라클 11g에 연결해보자 (java --- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);	// Connection
			System.out.println("2. 오라클 연결 성공");
			
			// 자바는 부품조립식이어서, String에 넣은 문자열을 특정한 부품으로 인식하지 못함
			// 특정한 부품으로 인식하려면 그 부품으로 만들어주어야 한다
			// SQL부품으로 만들어주어야 함
			// PreparedStatement가 SQL부품
			
			String sql = "insert into hr.MEMBER2 values ('win4', 'win4','win4','win4')";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			// con부품으로 sql스트링에 있는 것 SQL 부품으로 만들어주기
			System.out.println("3. SQL문 부품(객체)으로 만들어주기");
			
			ps.executeUpdate();
			System.out.println("4. SQL문 오라크로 보내기 성공");
			
		} catch (Exception e) {	// 모든 예외처리 해달라
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}