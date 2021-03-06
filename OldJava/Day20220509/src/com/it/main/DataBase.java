package com.it.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataBase {

	private Connection con;  //mysql 연결
	private PreparedStatement psmt;  //sql 문장 전송
	
	private final String URL = "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
 
	//드라이버 등록 : 한번만 하면된다.
	public DataBase() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//연결
	public void getConnection() {
		try {
			
			con = DriverManager.getConnection(URL,"root","1234");  //경로, 아이디, 비번
			System.out.println("연결");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//연결 해재
	public void disConnection() {
		try {
			
			if(psmt != null) psmt.close();
			if(con != null) con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	//데이터 목록
	public void mydbListData() {
		try {
			
			//1. MySql 연결
			getConnection();
			
			//2. SQL 문장 작성
			String sql = "select * from member";
			
			//3. MySql로 SQL 문장 전송
			psmt=con.prepareStatement(sql);
			
			//4. 실행결과를 받아 온다.
			ResultSet rs = psmt.executeQuery();   //--> db 값을 조회 할 때
		
			//5. 결과를 출력
			while(rs.next()) {
				System.out.println(rs.getInt(1) 
						+ ", " + rs.getString(2)
						+ ", " + rs.getString(3)
						+ ", " + rs.getString(4) + " ");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
	}
	
	/*
	 * try {
	 * 
	 * 	}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();	
		}
	
	 */
	
	//추가(insert)
	public void mydbInsert(int no, String name, String sex, String content) {
		
		try {
			
			//1. 연결
			getConnection();
			
			//2. sql 문장 작성
			String sql = "insert into member(no, name, sex, content) "  //  ) "  이 사이 한칸 꼭 띄어주기
					+ "values(?,?,?,?)";
			//3. MySql로 SQL 문장 전송
			psmt = con.prepareStatement(sql);
			
			//4. ???에 값을 채운다.
			psmt.setInt(1, no);
			psmt.setString(2, name);
			psmt.setString(3, sex);
			psmt.setString(4, content);
			
			//5. 실행
			psmt.executeUpdate(); // --> db 값 변동시에는 executeUpdate
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();	
		}
	}
	
	//수정
	public void mydbUpdate(int no, String name1, String sex1, String content1) {
		 try {
			 
			 getConnection();
			 
			 String sql = "Update member set name=?, sex=?, content=? "
					 + "where no = ?";
			 
			 psmt = con.prepareStatement(sql);
			 
			 psmt.setString(1, name1);
			 psmt.setString(2, sex1);
			 psmt.setString(3, content1);
			 psmt.setInt(4, no);
			 
			 psmt.executeUpdate();
			 
			  	}catch(Exception e) {
					e.printStackTrace();
				}finally {
					disConnection();	
				}
			
	}
	
	
	public void mydbDelete(int no) {
		 try {
			 	getConnection();
			 	String sql = "delete from member where no = ? ";
			 	
			 	psmt = con.prepareStatement(sql);
			 	
			 	psmt.setInt(1, no);
			 	
			 	psmt.executeUpdate();
			 
			  	}catch(Exception e) {
					e.printStackTrace();
				}finally {
					disConnection();	
				}
		
	}
	
	//선택 출력(검색)
	public void mydbSelect(int no) {
		try {
			
			getConnection();
			String sql = "select * from member where no = ? ";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, no);
			
			ResultSet rs = psmt.executeQuery();
			
			rs.next() ;
				System.out.println(rs.getInt(1) 
						+ ", " + rs.getString(2)
						+ ", " + rs.getString(3)
						+ ", " + rs.getString(4) + " ");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
	}
	
	public static void main(String[] args) {
		DataBase db = new DataBase();
		db.getConnection();
//		db.mydbListData();
		System.out.println("-----------------------");
//		db.mydbInsert(11, "누구게", "누구냐", "하하하");
//		System.out.println("-----------------");
//		db.mydbUpdate(15, "전소연", "여자", "가수");
//		db.mydbListData();
//		db.mydbUpdate(11, "전지현", "여자", "배우");
//		db.mydbListData();
//		db.mydbDelete(15);
//		db.mydbListData();
		db.mydbListData();
//		
	}

}
