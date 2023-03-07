package 자바DB연결;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class 반환값받아오기 {
	public static void main(String[] args) {
		반환값연습 re = new 반환값연습();
		re.add2();
		int result1 = re.add(200, 100);
		System.out.println("더한 값은 " + result1);
		
//		String data = JOptionPane.showInputDialog("입력");
//		String data2 = JOptionPane.showMessageDialog(null, "출력값");
		
		double result2 = re.add(22.1, 10);
		System.out.println("더한 값은 " + result2);
		
		String result3 = re.add("나는", " 천재");
		System.out.println("더한 값은 " + result3);
		
		String result4 = re.add(1, "번 천재");
		System.out.println("더한 값은 " + result4);
		
		HashSet result5 = re.getSet();
		System.out.println("중복된 값을 제외하면 " + result5);
		
		int result6 = re.getHour();
		System.out.println("지금은  " + result6 + "시");
		
		int[] result7 = re.add();
		for (int j = 0; j < result7.length; j++) {
			System.out.println("배열  " + j + "번의 값 : " + result7[j]);
		}
		
		Date result8 = re.getDate();
		// 년, 월, 일, 시, 분, 초, 요일
		System.out.println("분 : " + result8.getMinutes());
		System.out.println("초 : " + result8.getSeconds());
		// 0: 일요일, 1: 월요일, 2:화요일 ~~...
		System.out.println("요일 : " + result8.getDay());
		// => 리턴이 없는 값은 프린트 불가
		// => result8.getMinutes()는 리턴이 있어서 프린트 가능!
		
		int result9 = re.getRandom2();
		System.out.println("랜덤한 정수는 " + result9);
		
		ArrayList result10 = re.getList();
		for (int j = 0; j < result10.size(); j++) {
			System.out.println("ArrayList " + j + "번의 값 : " + result10.get(j));
		}
		result10.set(0, "양파");
		System.out.println(result10.get(0));
	}
}