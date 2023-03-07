package 화면DB연결;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BbsUI {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setTitle("나의 게시판");
		f.setSize(450, 630);
		// f.getContentPane().setBackground(Color.pink);
		FlowLayout lay = new FlowLayout();
		f.setLayout(lay);
		
		Font font_main = new Font("돋움", Font.BOLD, 50);
		Font font = new Font("돋움", Font.BOLD, 30);
		Font font_btn = new Font("돋움", 1, 25);
		
		JLabel label_join = new JLabel("나의 게시판");
		JLabel label_line = new JLabel("--------------------");
		JLabel label_id = new JLabel("아이디");
		JLabel label_pw = new JLabel("제   목");
		JLabel label_name = new JLabel("내   용");
		JLabel label_tel = new JLabel("작성자");
		JTextField text_id = new JTextField(12);
		JTextField text_pw = new JTextField(12);
		JTextField text_name = new JTextField(12);
		JTextField text_tel = new JTextField(12);
		
		// 라벨 폰트지정
		label_join.setFont(font_main);
		label_line.setFont(font);
		label_line.setForeground(Color.gray);
		label_id.setFont(font);
		label_pw.setFont(font);
		label_name.setFont(font);
		label_tel.setFont(font);
		
		// 텍스트필드 폰트지정
		text_id.setFont(font);
		text_pw.setFont(font);
		text_name.setFont(font);
		text_tel.setFont(font);
		
		// JButton btn_main = new JButton("** 나의 게시판 **");
		JButton btn_add = new JButton("[   게시물 추가   ]");
		JButton btn_del = new JButton("[   게시물 삭제   ]");
		JButton btn_find = new JButton("[   게시물 검색   ]");
		
		// 버튼 폰트 지정
		btn_add.setFont(font_btn);
		btn_del.setFont(font_btn);
		btn_find.setFont(font_btn);
		
		// 버튼 색깔 지정
		// btn_main.setBackground(Color.LIGHT_GRAY);
		btn_add.setBackground(Color.black);
		btn_del.setBackground(Color.black);
		btn_find.setBackground(Color.black);
		// btn_find.setBackground(Color.white);
		
		// btn_main.setForeground(Color.LIGHT_GRAY);
		btn_add.setForeground(Color.lightGray);
		btn_del.setForeground(Color.lightGray);
		btn_find.setForeground(Color.lightGray);
		
		f.add(label_join);
		f.add(label_line);
		f.add(label_id);
		f.add(text_id);
		f.add(label_pw);
		f.add(text_pw);
		f.add(label_name);
		f.add(text_name);
		f.add(label_tel);
		f.add(text_tel);
		f.add(btn_add);
		f.add(btn_del);
		f.add(btn_find);
		
		f.setVisible(true);
	}

}