package 화면DB연결;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import 자바DB연결.MemberDAO3;

public class MemberUI4 {
	public static void main(String[] args) {
		// 프로그램 시작하자 마자 db에서 데이터를 가져와서
		// 화면을 만들어 주고싶음
		JFrame f = new JFrame();
		f.setSize(500, 700);

		MemberDAO3 dao = new MemberDAO3();
		ArrayList<MemberVO> list = dao.list(); // ArrayList<MemberVO> 타입

		String[] header = { "아이디", "패스워드", "이름", "전화번호" };
		Object[][] all = new String[list.size()][4]; // 타입이 섞인경우 String -> Object으로 변경

		if (list.size() == 0) {
			System.out.println("검색결과 없음");
		} else {
			System.out.println("검색결과는 전체  " + list.size() + "개 입니다.");

			for (int i = 0; i < all.length; i++) { // 14개의 가방, 14개의 행
				all[i][0] = list.get(i).getId();
				all[i][1] = list.get(i).getPw();
				all[i][2] = list.get(i).getName();
				all[i][3] = list.get(i).getTel();
//				for (int j = 0; j < 4; j++) {
//					all[i][j] = list.get(i).getId();
//					all[i][j] = list.get(i).getPw();
//					all[i][j] = list.get(i).getName();
//					all[i][j] = list.get(i).getTel();
//				}
			}
		}	// else
		
		JTable table = new JTable(all, header);
		JScrollPane scroll = new JScrollPane(table);
		f.setLayout(new FlowLayout());
		f.add(scroll);

		f.setVisible(true);
	}
}