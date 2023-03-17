package multi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.ResultSet;
import java.util.ArrayList;


// 테이블 하나당 DAO 하나 ==> CUD를 완성
public class ProductDAO {
	public ArrayList<ProductVO> list() {
		ResultSet rs = null; // 항목명 + 결과 데이터를 담고 있는 테이블
		
		// 가방들 넣어줄 큰 컨테이너 역할을 부품이 필요
		// ArrayList<MemberVO>
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		
		ProductVO bag = null;
		
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
			String sql = "select * from product";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			System.out.println("3. SQL문 부품(객체)으로 만들어주기");

			rs = ps.executeQuery(); // select문 전송시
			System.out.println("4. SQL문 오라클로 보내기 성공");
			while(rs.next()) { // 검색결과가 있는지 여부는 res.next()
				// 1. 검색결과가 있으면
				// 2. 각 컬럼에서 값들을 꺼내오자
				// 컬럼명을 넣으면 이후에 손댈 필요가 줄어든다
				String id = rs.getString("id");
				String name = rs.getString("name");
				String content = rs.getString("content");
				int price = rs.getInt("price");
				String company = rs.getString("company");
				String img = rs.getString("img"); 
				
				// 3. 가방을 만들자
				bag = new ProductVO();
				bag.setId(id);
				bag.setName(name);
				bag.setContent(content);
				bag.setPrice(price);
				bag.setCompany(company);
				bag.setImg(img);
				
				// 4. list에 bag을 추가
				list.add(bag);
			}

		} catch (Exception e) { // 모든 예외처리 해달라
			e.printStackTrace();
		}
		// return 뒤에는 반드시 여러 데이터를 묶어서 리턴해주어야함
		return list;
	}
	
	public ProductVO one(String id) {
		
		ResultSet rs = null;
		
		ProductVO bag = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 사용할 드라이버
			System.out.println("1. mySQL과 자바 연결할 부품 설정 성공");

			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			System.out.println("2. mySQL 연결 성공");
			
			String sql = "select * from product where id = ?";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setString(1, id);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기");
			
			rs = ps.executeQuery();
			System.out.println("4. SQL문 오라크로 보내기 성공");
			
			if (rs.next()) {	// rs로 전달된 값(테이블..?)이 있으면
				System.out.println("검색결과 있음. 성공");
				String id2 = rs.getString("id");
				String name = rs.getString("name");
				String content = rs.getString("content");
				int price = rs.getInt("price");
				String company = rs.getString("company");
				String img = rs.getString("img"); 
				
				bag = new ProductVO();
				bag.setId(id);
				bag.setName(name);
				bag.setContent(content);
				bag.setPrice(price);
				bag.setCompany(company);
				bag.setImg(img);
				
			} else {
				System.out.println("검색 결과 없음. 성공.");
			}
			
		} catch (Exception e) {	// 모든 예외처리 해달라
			e.printStackTrace();
		}
		return bag;
	}
	
	public void delete(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 사용할 드라이버
			System.out.println("1. mySQL과 자바 연결할 부품 설정 성공");

			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			System.out.println("2. mySQL 연결 성공");
			
			String sql = "delete from product where id = ?";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setInt(1, id);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기");
			
			ps.executeUpdate();
			System.out.println("4. SQL문 오라크로 보내기 성공");
			
		} catch (Exception e) {	// 모든 예외처리 해달라
			e.printStackTrace();
		}
	}
	
	public void update(ProductVO bag) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 사용할 드라이버
			System.out.println("1. mySQL과 자바 연결할 부품 설정 성공");

			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			System.out.println("2. mySQL 연결 성공");
			
			String sql = "update bbs set content = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setString(1, bag.getContent());
			ps.setString(2, bag.getId());
			System.out.println("3. SQL문 부품(객체)으로 만들어주기");
			
			ps.executeUpdate();
			System.out.println("4. SQL문 오라크로 보내기 성공");
			
		} catch (Exception e) {	// 모든 예외처리 해달라
			e.printStackTrace();
		}
	}
	
	public void insert(ProductVO bag) {
		// ResultSet rs = null;
		
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
			String sql = "insert into product values (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			
			
			// R빼고 인덱스 0부터 시작
			// 유일하게 DB는 인덱스가 1부터 시작
			ps.setString(1, bag.getId());
			ps.setString(2, bag.getName());
			ps.setString(3, bag.getContent());
			ps.setInt(4, bag.getPrice());
			ps.setString(5, bag.getCompany());
			ps.setString(6, bag.getImg());
			// => insert into hr.MEMBWE2 values('a', 'a', 'a', 'a');
			System.out.println("3. SQL문 부품(객체)으로 만들어주기");

			ps.executeUpdate();
			System.out.println("4. SQL문 오라클로 보내기 성공");

		} catch (Exception e) { // 모든 예외처리 해달라
			e.printStackTrace();
		}
	}

}