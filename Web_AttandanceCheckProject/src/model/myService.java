package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServlet;

public class myService extends HttpServlet {
	
	
	public ArrayList<StudentDTO>[] getlist(String input){
		ArrayList<StudentDTO>[] list = new ArrayList[4];
		for(int i=0; i<4; i++) list[i] = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(input, "[");
		StringTokenizer st2 = null, st3 = null;
		while(st.hasMoreTokens()) {
			String cur = st.nextToken();
			if(cur.length() < 10 || !cur.contains("출석") || !cur.contains("]")) continue;
			
			st2 = new StringTokenizer(cur, "]");
			String frontInfo = st2.nextToken();
			
			if(!st2.hasMoreTokens()) continue;
			String backInfo = st2.nextToken();
			if(!backInfo.contains("출석")) continue;
			
			if(!frontInfo.contains("_")) continue;
			st3 = new StringTokenizer(frontInfo,"_");
			
			//지역_반_이름
			String local = st3.nextToken();
			if(!st3.hasMoreTokens()) continue;
			String ban = st3.nextToken();
			int banint = 0;
			if(ban.length() < 2 || ban.length() > 3) continue;
			if(ban.length() == 2) {
				if(!Character.isDigit(ban.charAt(0)) || Character.isDigit(ban.charAt(1))) continue;
				banint = ban.charAt(0)-48;
			}else {
				if(!Character.isDigit(ban.charAt(0)) || !Character.isDigit(ban.charAt(1)) || Character.isDigit(ban.charAt(2))) continue;
				banint += ban.charAt(0)-48;
				banint = banint*10 + (ban.charAt(1)-48);
			}
			
			if(!st3.hasMoreTokens()) continue;
			String name = st3.nextToken();
			
			StudentDTO student = new StudentDTO();
			student.setLocation(local);
			student.setBan(banint);
			student.setName(name);
			
			int size=0;
			boolean isNotDuplicated = true;
			if(local.equals("서울")) {
				size = list[0].size();
				for(int k=0; k<size; k++) {
					StudentDTO instudent = list[0].get(k);
					if(instudent.ban == student.ban && instudent.name.equals(student.name)) {
						isNotDuplicated = false;
						break;
					}
				}
				if(isNotDuplicated) list[0].add(student);
			}else if(local.equals("대전")) {
				size = list[1].size();
				for(int k=0; k<size; k++) {
					StudentDTO instudent = list[1].get(k);
					if(instudent.ban == student.ban && instudent.name.equals(student.name)) {
						isNotDuplicated = false;
						break;
					}
				}
				if(isNotDuplicated) list[1].add(student);
			}else if(local.equals("구미")) {
				size = list[2].size();
				for(int k=0; k<size; k++) {
					StudentDTO instudent = list[2].get(k);
					if(instudent.ban == student.ban && instudent.name.equals(student.name)) {
						isNotDuplicated = false;
						break;
					}
				}
				if(isNotDuplicated) list[2].add(student);
			}else if(local.equals("광주")) {
				size = list[3].size();
				for(int k=0; k<size; k++) {
					StudentDTO instudent = list[3].get(k);
					if(instudent.ban == student.ban && instudent.name.equals(student.name)) {
						isNotDuplicated = false;
						break;
					}
				}
				if(isNotDuplicated) list[3].add(student);
			}
		}
		return list;
	}
}
