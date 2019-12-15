package www.jcc.com;

import www.jcc.com.control.FileControl;

public class MainClass {

	public static void main(String[] args) {
		FileControl fileControl = new FileControl();
		String title = "java.txt";
		String content = "안녕하세요. 반갑습니다~^^";
		
		fileControl.writeFile(title, content);
		
		String readFile = fileControl.readFile(title);
		System.out.println(readFile);
	}

}
