package multi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class PlayListDAO {
	// movie 전체 목록 가져오기
	public ArrayList<PlayListVO> list() {
		ResultSet rs = null; // 항목명 + 결과 데이터를 담고 있는 테이블
		
		// 가방들 넣어줄 큰 컨테이너 역할을 부품이 필요
		// ArrayList<PlayListVO>
		ArrayList<PlayListVO> list = new ArrayList<PlayListVO>();
		
		PlayListVO bag = null;
		
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
			String sql = "select * from playlist";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			System.out.println("3. SQL문 부품(객체)으로 만들어주기");

			rs = ps.executeQuery(); // select문 전송시
			System.out.println("4. SQL문 오라클로 보내기 성공");
			while(rs.next()) { // 검색결과가 있는지 여부는 res.next()
				// 1. 검색결과가 있으면
				// 2. 각 컬럼에서 값들을 꺼내오자
				// 3. 가방을 만들자
				bag = new PlayListVO();
				bag.setId(rs.getString("id"));
				bag.setTitle(rs.getString("title"));
				bag.setArtist(rs.getString("artist"));
				bag.setGenre(rs.getString("genre"));
				bag.setImg(rs.getString("img"));
				
				// 4. list에 bag을 추가
				list.add(bag);
			}

		} catch (Exception e) { // 모든 예외처리 해달라
			e.printStackTrace();
		}
		// return 뒤에는 반드시 여러 데이터를 묶어서 리턴해주어야함
		return list;
	}
	
	public ArrayList<PlayListVO> listLike(String word) {
		ResultSet rs = null; // 항목명 + 결과 데이터를 담고 있는 테이블
		
		// 가방들 넣어줄 큰 컨테이너 역할을 부품이 필요
		// ArrayList<PlayListVO>
		ArrayList<PlayListVO> list = new ArrayList<PlayListVO>();
		
		PlayListVO bag = null;
		
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
			String sql = "select * from playlist where title like ?";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setString(1, "%"+word+"%");
			System.out.println("3. SQL문 부품(객체)으로 만들어주기");

			rs = ps.executeQuery(); // select문 전송시
			System.out.println("4. SQL문 오라클로 보내기 성공");
			while(rs.next()) { // 검색결과가 있는지 여부는 res.next()
				// 1. 검색결과가 있으면
				// 2. 각 컬럼에서 값들을 꺼내오자
				// 3. 가방을 만들자
				bag = new PlayListVO();
				bag.setId(rs.getString("id"));
				bag.setTitle(rs.getString("title"));
				bag.setArtist(rs.getString("artist"));
				bag.setGenre(rs.getString("genre"));
				bag.setImg(rs.getString("img"));
				
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
	public PlayListVO one(String title) {
		// 검색결과가 null인 경우에는 입력값을 출력해보기
		System.out.println(title);
		ResultSet rs = null;
		
		PlayListVO bag = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 사용할 드라이버
			System.out.println("1. mySQL과 자바 연결할 부품 설정 성공");

			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			System.out.println("2. mySQL 연결 성공");

			String sql = "select * from playlist where title = ?";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setString(1, title);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기");

			rs = ps.executeQuery(); // select문 전송시
			System.out.println("4. SQL문 오라클로 보내기 성공");
			if (rs.next()) { // 검색결과가 있는지 여부는 res.next()
				bag = new PlayListVO();
				bag.setId(rs.getString("id"));
				bag.setTitle(rs.getString("title"));
				bag.setArtist(rs.getString("artist"));
				bag.setGenre(rs.getString("genre"));
				bag.setImg(rs.getString("img"));
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

	public int delete(String title) {
		int result = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 사용할 드라이버
			System.out.println("1. mySQL과 자바 연결할 부품 설정 성공");

			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			System.out.println("2. mySQL 연결 성공");

			String sql = "delete from playlist where title = ?";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setString(1, title);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기");

			result = ps.executeUpdate();
			System.out.println("4. SQL문 오라클로 보내기 성공");
			if (result == 1) {
				System.out.println("플레이리스트 삭제 성공");
			}

		} catch (Exception e) { // 모든 예외처리 해달라
			result = 0;
			e.printStackTrace();
		}
		return result;
	}

	// 1. 가방을 받아서 저장해두자
	// 2. 필요할 때 가방에서 값들을 하나씩 꺼내자
	public int update(PlayListVO bag) {
		int result = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 사용할 드라이버
			System.out.println("1. mySQL과 자바 연결할 부품 설정 성공");

			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			System.out.println("2. mySQL 연결 성공");

			String sql = "update playlist set genre = ? where title = ?";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setString(1, bag.getGenre());
			ps.setString(2, bag.getTitle());
			System.out.println("3. SQL문 부품(객체)으로 만들어주기");

			result = ps.executeUpdate();
			System.out.println("4. SQL문 오라클로 보내기 성공");
			if (result == 1) {
				System.out.println("회원정보 수정 성공");
			}

		} catch (Exception e) { // 모든 예외처리 해달라
			result = 0;
			e.printStackTrace();
		}
		return result;
	}

	public int insert(PlayListVO bag) {
		// 1. 가방을 받아서 변수에 넣어주세요
		int result = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 사용할 드라이버
			System.out.println("1. mySQL과 자바 연결할 부품 설정 성공");

			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			System.out.println("2. mySQL 연결 성공");

			// public void insert(String id, String pw, String name, String tel)
			String sql = "insert into playlist values (?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement

			// R빼고 인덱스 0부터 시작
			// 유일하게 DB는 인덱스가 1부터 시작

			// 2. 가방에서 값들을 하나씩 꺼내쓰세요
			ps.setString(1, bag.getId()); // ps.setInt(1, no);
			ps.setString(2, bag.getTitle());
			ps.setString(3, bag.getArtist());
			ps.setString(4, bag.getGenre());
			ps.setString(5, bag.getImg());

			System.out.println("3. SQL문 부품(객체)으로 만들어주기");

			result = ps.executeUpdate();
			System.out.println("4. SQL문 오라클로 보내기 성공");
			if (result == 1) {
				System.out.println("플레이리스트 등록 성공");
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