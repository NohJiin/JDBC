package 화면DB연결;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StartUI {
	public static void main(String[] args) {
		// 로그인 화면 만들기
		JFrame f = new JFrame();
		FlowLayout lay = new FlowLayout();
		f.setSize(400, 300);
		f.setLayout(lay);
		
		Font font = new Font("돋움", 1, 30);
		Font font_title = new Font("돋움", 1, 40);
		JLabel label_title = new JLabel("로그인을 하세요");
		JLabel label_line = new JLabel("----------------");
		JLabel label_id = new JLabel("ID");
		JLabel label_pw = new JLabel("PW");
		label_title.setFont(font_title);
		label_line.setFont(font_title);
		label_id.setFont(font);
		label_pw.setFont(font);
		
		JTextField text_id = new JTextField(10);
		JTextField text_pw = new JTextField(10);
		text_id.setFont(font);
		text_pw.setFont(font);
		
		JButton btn_login = new JButton("Log-in");
		btn_login.setFont(font);
		btn_login.setBackground(Color.LIGHT_GRAY);
		
		f.add(label_title);
		f.add(label_line);
		f.add(label_id);
		f.add(text_id);
		f.add(label_pw);
		f.add(text_pw);
		f.add(btn_login);
		
		f.setVisible(true);
	}
}