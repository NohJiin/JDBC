package 화면DB연결;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

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