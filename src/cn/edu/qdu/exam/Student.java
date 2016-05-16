package cn.edu.qdu.exam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Student {
	List<Integer> choice = new ArrayList<Integer>();
	private String name;
	private Integer score = 0;
	BufferedReader in = null;

	public void readAnswer(BufferedReader in) throws IOException {
		int temp;
		while ((temp = in.read()) != -1) {
			if (temp != 10 && temp != 13)
				choice.add(temp);
		}
	}

	public void compare(List<Integer> rightAnswer) {
		Iterator<Integer> stu = this.choice.iterator();
		Iterator<Integer> ans = rightAnswer.iterator();
		while (stu.hasNext() && ans.hasNext()) {
			int a = stu.next();
			int b = ans.next();
			if (a == b || a == b + 32) {
				score += 4;
			}
		}

	}

	public void recordResult(BufferedWriter out) throws IOException {
		out.write(name + ":");
		out.write(score.toString() + "\r\n");
		System.out.println(name + " : " + score);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}
