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

import 자바DB연결.BbsDAO;

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
		JLabel label_no = new JLabel("아이디");
		JLabel label_title = new JLabel("제   목");
		JLabel label_content = new JLabel("내   용");
		JLabel label_writer = new JLabel("작성자");
		JTextField text_no = new JTextField(12);
		JTextField text_title = new JTextField(12);
		JTextField text_content = new JTextField(12);
		JTextField text_writer = new JTextField(12);
		
		// 라벨 폰트지정
		label_join.setFont(font_main);
		label_line.setFont(font);
		label_line.setForeground(Color.gray);
		label_no.setFont(font);
		label_title.setFont(font);
		label_content.setFont(font);
		label_writer.setFont(font);
		
		// 텍스트필드 폰트지정
		text_no.setFont(font);
		text_title.setFont(font);
		text_content.setFont(font);
		text_writer.setFont(font);
		
		JButton btn_add = new JButton("[   게시물 추가   ]");
		JButton btn_del = new JButton("[   게시물 삭제   ]");
		JButton btn_find = new JButton("[   게시물 검색   ]");
		
		// 버튼 폰트 지정
		btn_add.setFont(font_btn);
		btn_del.setFont(font_btn);
		btn_find.setFont(font_btn);
		
		// 버튼 색깔 지정
		btn_add.setBackground(Color.black);
		btn_del.setBackground(Color.black);
		btn_find.setBackground(Color.black);
		
		btn_add.setForeground(Color.lightGray);
		btn_del.setForeground(Color.lightGray);
		btn_find.setForeground(Color.lightGray);
		
		// insert, delete, find
		// part_insert
		// part_delete

		
		// part_find
		btn_find.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String no = text_no.getText();
				int no2 = Integer.parseInt(no);
				
				BbsDAO dao = new BbsDAO();
				BbsVO bag = dao.one(no2);
				if (bag != null) {
					text_title.setText(bag.getTitle());
					text_content.setText(bag.getContent());
					text_writer.setText(bag.getWriter());
					text_title.setBackground(Color.yellow);
					text_content.setBackground(Color.yellow);
					text_writer.setBackground(Color.yellow);
				} else {
					JOptionPane.showMessageDialog(f, "검색결과 없음");
					text_title.setText("");
					text_content.setText("");
					text_writer.setText("");
				}
				
			}
		});
		
		f.add(label_join);
		f.add(label_line);
		f.add(label_no);
		f.add(text_no);
		f.add(label_title);
		f.add(text_title);
		f.add(label_content);
		f.add(text_content);
		f.add(label_writer);
		f.add(text_writer);
		f.add(btn_add);
		f.add(btn_del);
		f.add(btn_find);
		
		f.setVisible(true);
	}

}