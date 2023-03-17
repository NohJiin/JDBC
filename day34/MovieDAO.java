package multi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class MovieDAO {
	// movie 전체 목록 가져오기
	public ArrayList<MovieVO> list() {
		ResultSet rs = null; // 항목명 + 결과 데이터를 담고 있는 테이블
		
		// 가방들 넣어줄 큰 컨테이너 역할을 부품이 필요
		// ArrayList<MovieVO>
		ArrayList<MovieVO> list = new ArrayList<MovieVO>();
		
		MovieVO bag = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 사용할 드라이버
			System.out.println("1. mySQL과 자바 연결할 부품 설정 성공");

			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			System.out.println("2. mySQL 연결 성공");

			// 조건없이 모두 가져온다
			String sql = "select * from movie";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			System.out.println("3. SQL문 부품(객체)으로 만들어주기");

			rs = ps.executeQuery(); // select문 전송시
			System.out.println("4. SQL문 오라클로 보내기 성공");
			while(rs.next()) { // 검색결과가 있는지 여부는 res.next()
				// 1. 검색결과가 있으면
				// 2. 각 컬럼에서 값들을 꺼내오자
				// 3. 가방을 만들자
				bag = new MovieVO();
				bag.setId(rs.getString("id"));
				bag.setTitle(rs.getString("title"));
				bag.setContent(rs.getString("content"));
				bag.setLocation(rs.getString("location"));
				bag.setDirector(rs.getString("director"));
				
				// 4. list에 bag을 추가
				list.add(bag);
			}

		} catch (Exception e) { // 모든 예외처리 해달라
			e.printStackTrace();
		}
		// return 뒤에는 반드시 여러 데이터를 묶어서 리턴해주어야함
		return list;
	}

	// id로 검색결과 가져오기
	public MovieVO one(String id) {
		// 검색결과가 null인 경우에는 입력값을 출력해보기
		System.out.println(id);
		ResultSet rs = null;
		
		MovieVO bag = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 사용할 드라이버
			System.out.println("1. mySQL과 자바 연결할 부품 설정 성공");

			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			System.out.println("2. mySQL 연결 성공");

			String sql = "select * from movie where id = ?";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setString(1, id);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기");

			rs = ps.executeQuery(); // select문 전송시
			System.out.println("4. SQL문 오라클로 보내기 성공");
			if (rs.next()) { // 검색결과가 있는지 여부는 res.next()
				String id2 = rs.getString(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String location = rs.getString(4);
				String director = rs.getString(5);
				
				// 3. 가방을 만들자
				bag = new MovieVO();
				bag.setId(id);
				bag.setTitle(title);
				bag.setContent(content);
				bag.setLocation(location);
				bag.setDirector(director);
			} else {
				System.out.println("검색결과 없음. 성공.");
			}

		} catch (Exception e) { // 모든 예외처리 해달라
			e.printStackTrace();
		}
		// return 뒤에는 반드시 여러 데이터를 묶어서 리턴해주어야함
		// 출력값을 출력해보기
		System.out.println(bag);
		return bag;
	}

//	public int delete(String id) {
//		int result = 0;
//
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver"); // 사용할 드라이버
//			System.out.println("1. mySQL과 자바 연결할 부품 설정 성공");
//
//			// String url = "jdbc:mysql://localhost:3306/multi";
//			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
//			String user = "root";
//			String password = "1234";
//			Connection con = DriverManager.getConnection(url, user, password); // Connection
//			System.out.println("2. mySQL 연결 성공");
//
//			String sql = "delete from member where id = ?";
//			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
//			ps.setString(1, id);
//			System.out.println("3. SQL문 부품(객체)으로 만들어주기");
//
//			result = ps.executeUpdate();
//			System.out.println("4. SQL문 오라클로 보내기 성공");
//			if (result == 1) {
//				System.out.println("회원탈퇴 성공");
//			}
//
//		} catch (Exception e) { // 모든 예외처리 해달라
//			result = 0;
//			e.printStackTrace();
//		}
//		return result;
//	}
//
//	// 1. 가방을 받아서 저장해두자
//	// 2. 필요할 때 가방에서 값들을 하나씩 꺼내자
//	public int update(MovieVO bag) {
//		int result = 0;
//
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver"); // 사용할 드라이버
//			System.out.println("1. mySQL과 자바 연결할 부품 설정 성공");
//
//			// String url = "jdbc:mysql://localhost:3306/multi";
//			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
//			String user = "root";
//			String password = "1234";
//			Connection con = DriverManager.getConnection(url, user, password); // Connection
//			System.out.println("2. mySQL 연결 성공");
//
//			String sql = "update movie set title = ? where id = ?";
//			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
//			ps.setString(1, bag.getTitle());
//			ps.setString(2, bag.getId());
//			System.out.println("3. SQL문 부품(객체)으로 만들어주기");
//
//			result = ps.executeUpdate();
//			System.out.println("4. SQL문 오라클로 보내기 성공");
//			if (result == 1) {
//				System.out.println("회원정보 수정 성공");
//			}
//
//		} catch (Exception e) { // 모든 예외처리 해달라
//			result = 0;
//			e.printStackTrace();
//		}
//		return result;
//	}
//
//	public int insert(MovieVO bag) {
//		// 1. 가방을 받아서 변수에 넣어주세요
//		int result = 0;
//
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver"); // 사용할 드라이버
//			System.out.println("1. mySQL과 자바 연결할 부품 설정 성공");
//
//			// String url = "jdbc:mysql://localhost:3306/multi";
//			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
//			String user = "root";
//			String password = "1234";
//			Connection con = DriverManager.getConnection(url, user, password); // Connection
//			System.out.println("2. mySQL 연결 성공");
//
//			// public void insert(String id, String pw, String name, String tel)
//			String sql = "insert into movie values (?, ?, ?, ?, ?)";
//			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
//
//			// R빼고 인덱스 0부터 시작
//			// 유일하게 DB는 인덱스가 1부터 시작
//
//			// 2. 가방에서 값들을 하나씩 꺼내쓰세요
//			ps.setString(1, bag.getId()); // ps.setInt(1, no);
//			ps.setString(2, bag.getTitle());
//			ps.setString(3, bag.getContent());
//			ps.setString(4, bag.getLocation());
//			ps.setString(5, bag.getDirector());
//			// => insert into hr.MEMBWE2 values('a', 'a', 'a', 'a');
//
//			System.out.println("3. SQL문 부품(객체)으로 만들어주기");
//
//			result = ps.executeUpdate();
//			System.out.println("4. SQL문 오라클로 보내기 성공");
//			if (result == 1) {
//				System.out.println("영화등록 성공");
//			}
//			// System.out.println(result);
//		} catch (Exception e) { // 모든 예외처리 해달라
//			// insert가 제대로 안된 경우, 위험한 상황이라고 판단
//			// catch가 실행
//			// 실행된 row수가 없으므로 result에 0을 넣어주자
//			// result = 0;
//			e.printStackTrace();
//		}
//
//		System.out.println(result);
//		return result;
//	}

}