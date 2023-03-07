package 자바DB연결;

import java.util.Scanner;

public class 게시판삭제하기 {
	public static void main(String[] args) {
		
		BbsDAO dao = new BbsDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("no를 입력하세요");
		int no = sc.nextInt();
		
		dao.delete(no);
	}
}