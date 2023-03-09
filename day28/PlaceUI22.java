package 화면DB연결;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PlaceUI22 {

	public static void main(String[] args) {
		// 지점 UI 만들기
		JFrame f = new JFrame();
		FlowLayout lay = new FlowLayout();
		f.setSize(400, 580);
		f.setTitle("지점 정보");
		f.setLayout(lay);
		
		Font font_title = new Font("돋움", 1, 40);
		Font font = new Font("돋움", 1, 30);
		
//		JLabel label_code = new JLabel();
		JLabel label_img = new JLabel();
		JLabel label_name = new JLabel("상 호 명 : ");
		JLabel label_location = new JLabel("위치 : ");
		JLabel label_grade= new JLabel("평    점 : ");
		JLabel label_category = new JLabel("카테고리 : ");
		JLabel label_tel = new JLabel("연 락 처 : ");
//		label_code.setFont(font);
		label_name.setFont(font);
		label_location.setFont(font);
		label_grade.setFont(font);
		label_category.setFont(font);
		label_tel.setFont(font);
		
//		JLabel label_code2 = new JLabel();
		JLabel label_name2 = new JLabel("__________");
		JLabel label_location2 = new JLabel("__________");
		JLabel label_grade2 = new JLabel("__________");
		JLabel label_category2 = new JLabel("__________");
		JLabel label_tel2 = new JLabel("__________");
//		label_code2.setFont(font);
		label_name2.setFont(font);
		label_location2.setFont(font);
		label_grade2.setFont(font);
		label_category2.setFont(font);
		label_tel2.setFont(font);
		
		ImageIcon icon = new ImageIcon("lotte.png");
		label_img.setIcon(icon);
		
		JButton btn = new JButton("게시물 보기");
		btn.setFont(font);
		btn.setBackground(Color.LIGHT_GRAY);

		f.add(label_name);
		f.add(label_name2);
		f.add(label_img);
		f.add(label_category);
		f.add(label_category2);
		f.add(label_grade);
		f.add(label_grade2);
		f.add(label_tel);
		f.add(label_tel2);
		f.add(btn);
		
		f.setVisible(true);
	}

}