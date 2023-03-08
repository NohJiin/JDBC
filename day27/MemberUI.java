package 화면DB연결;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import 자바DB연결.MemberDAO2;

public class MemberUI {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setTitle("나의 회원가입 화면");
		f.setSize(450, 540);
		// f.getContentPane().setBackground(Color.pink);
		FlowLayout lay = new FlowLayout();
		f.setLayout(lay);
		
		Font font_main = new Font("돋움", Font.BOLD, 50);
		Font font = new Font("돋움", Font.BOLD, 30);
		Font font_btn = new Font("돋움", Font.BOLD, 20);
		
		//JLabel label_join = new JLabel();
		JLabel label_id = new JLabel("아이디");
		JLabel label_pw = new JLabel("패스워드");
		JLabel label_name = new JLabel("이   름");
		JLabel label_tel = new JLabel("전화번호");
		JTextField text_id = new JTextField(12);
		JTextField text_pw = new JTextField(12);
		JTextField text_name = new JTextField(12);
		JTextField text_tel = new JTextField(12);
		
		// 라벨 폰트지정
		label_id.setFont(font);
		label_pw.setFont(font);
		label_name.setFont(font);
		label_tel.setFont(font);
		
		// 텍스트필드 폰트지정
		text_id.setFont(font);
		text_pw.setFont(font);
		text_name.setFont(font);
		text_tel.setFont(font);
		
		JButton btn_main = new JButton("** 회원가입 **");
		JButton btn_join = new JButton("회원가입 처리");
		JButton btn_out = new JButton("회원탈퇴 처리");
		JButton btn_update = new JButton("정보수정 처리");
		JButton btn_find = new JButton("회원정보 검색");
		
		// 버튼 폰트 지정
		btn_main.setFont(font_main);
		btn_join.setFont(font_btn);
		btn_out.setFont(font_btn);
		btn_update.setFont(font_btn);
		btn_find.setFont(font_btn);
		
		// 버튼 색깔 지정
		btn_main.setBackground(Color.LIGHT_GRAY);
		btn_join.setBackground(Color.white);
		btn_out.setBackground(Color.white);
		btn_update.setBackground(Color.white);
		btn_find.setBackground(Color.white);
		
		// btn_main.setForeground(Color.LIGHT_GRAY);
		btn_join.setForeground(Color.red);
		btn_out.setForeground(Color.red);
		btn_update.setForeground(Color.red);
		btn_find.setForeground(Color.red);
		
		// 회원가입 버튼 함수 지정
		btn_join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = text_id.getText();
				String pw = text_pw.getText();
				String name = text_name.getText();
				String tel = text_tel.getText();
				
				if (id.equals("")) {
					JOptionPane.showMessageDialog(f, "id는 필수입력항목입니다.");
				}
				
				System.out.println("회원가입 처리");
				MemberDAO2 dao = new MemberDAO2();
				int result = dao.insert(id, pw, name, tel);
				if (!id.equals("")) {
					if (result == 1) {
						JOptionPane.showMessageDialog(f, "회원가입 성공");
					} else {
						JOptionPane.showMessageDialog(f, "회원가입 실패, 재입력해주세요");
					} 
				}
				
			}	// action implement
		});	// btn 함수 선언 끝
		
		// 회원탈퇴 버튼 함수 지정
		btn_out.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = text_id.getText();
				
				if (id.equals("")) {
					JOptionPane.showMessageDialog(f, "id는 필수입력항목입니다.");
				}
				
				System.out.println("회원탈퇴 처리");
				MemberDAO2 dao = new MemberDAO2();
				int result = dao.delete(id);
				if (!id.equals("")) {
					if (result == 1) {
						JOptionPane.showMessageDialog(f, "회원탈퇴 성공");
					} else {
						JOptionPane.showMessageDialog(f, "회원탈퇴 실패, 재입력해주세요");
					}
				}
				
			}	// action implement
		});	// btn 함수 선언 끝
		
		// 회원정보 수정 버튼 함수 지정
		btn_update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = text_id.getText();
				String tel = text_tel.getText();
				
				if (id.equals("") || tel.equals("")) {
					JOptionPane.showMessageDialog(f, "id와 전화번호는 필수입력항목입니다.");
				}
				
				System.out.println("회원정보 수정 처리");
				MemberDAO2 dao = new MemberDAO2();
				int result = dao.update(id, tel);
				if (!id.equals("") && !tel.equals("")) {
					if (result == 1) {
						JOptionPane.showMessageDialog(f, "회원정보 수정 성공");
					} else {
						JOptionPane.showMessageDialog(f, "회원정보 수정 실패, 재입력해주세요");
					} 
				}
				
			}	// action implement
		});	// btn 함수 선언 끝

		//f.add(label_join);
		f.add(btn_main);
		f.add(label_id);
		f.add(text_id);
		f.add(label_pw);
		f.add(text_pw);
		f.add(label_name);
		f.add(text_name);
		f.add(label_tel);
		f.add(text_tel);
		f.add(btn_join);
		f.add(btn_out);
		f.add(btn_update);
		f.add(btn_find);
		
		f.setVisible(true);
	}

}