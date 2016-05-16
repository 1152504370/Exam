package cn.edu.qdu.exam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Teacher {
	public static void main(String[] args) throws IOException {
		File students = new File("C:\\Users\\NIIT\\students");
		File answer = new File("C:\\Users\\NIIT\\answer.txt");
		File result = new File("C:\\Users\\NIIT\\result.txt");
		if (!result.exists()) {
			result.createNewFile();
		}
		File[] menu = students.listFiles();
		Student[] student = new Student[menu.length];
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			Answer answer1 = new Answer();
			in = new BufferedReader(new FileReader(answer));
			answer1.readAnswer(in);
			for (int i = 0; i < menu.length; i++) {
				student[i] = new Student();
				in = new BufferedReader(new FileReader(menu[i]));
				student[i].setName(menu[i].getName().substring(0, menu[i].getName().indexOf(".")));
				student[i].readAnswer(in);
				student[i].compare(answer1.rightAnswer);
				out = new BufferedWriter(new FileWriter(result, true));
				student[i].recordResult(out);
				in.close();
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}

		}
	}

}
