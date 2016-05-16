package cn.edu.qdu.exam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Student {
    List<Integer> choice = new ArrayList<Integer>();
    String name;
    Integer score=0;
    BufferedReader in= null;
    public void readAnswer(BufferedReader in,String name) throws IOException{
    	 this.name = name.substring(0,name.indexOf(".") );
    	 int temp;
    	 while ((temp=in.read())!=-1) {
			choice.add(temp);
		}
    }
    public  void compare(List rightAnswer){
    	Iterator<Integer> stu =  this.choice.iterator(); 
    	Iterator<Integer> ans = rightAnswer.iterator();
    	while (stu.hasNext()&&ans.hasNext()) {
    		int a=stu.next();
    		int b=ans.next();
			if (a!=10&&a!=13&&b!=10&&b!=13&&a==b||a==b+32) {
				score+=4;
			}
		}
    	
    }
    public void recordResult(BufferedWriter out) throws IOException{
    	out.write(name+":");
    	out.write(score.toString()+"\r\n");
    	System.out.println(name+" : "+score);
    }
  
}
