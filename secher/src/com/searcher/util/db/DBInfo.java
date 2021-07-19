package com.searcher.util.db;

/*
 * 공용으로 사용하게될 부분이므로 수정이 필요해보이면 얘기하고 수정해주세요
 * 실습때와는 다르게 java03, java03으로 연결합니다
 * 에러 발생시 SQL Developer에 꼭 계정을 생성했는지 확인해주세요 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.searcher.main.controller.MainController;

public class DBInfo {
	// DB 정보 - 다른 클래스에서 가져가지 못하도록 정의
		private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
		private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		private static final String UID = "java03";
		private static final String UPW = "java03";
		
		// 드라이버 확인 변수
		private static boolean DriverCheck = false;
		
		// 처음에 딱 한번 실행되는 부분에 드라이버 확인을 시킨다. -> static 초기화 블록 -> main()의 처음에 적용시킨다.
		// Class.forName("com.webjjang.util.db.DBInfoDBinfo"
		static {
			//System.out.println("DBInfo static 초기화 블록 실행 - 드라이버 확인"); 7. 잘 돌아가니까 마지막으로 개발자용 출력 주석처리
			try {
				Class.forName(DRIVER);
				DriverCheck = true;
				// System.out.println("드라이버 확인 완료"); 7. 잘 돌아가니까 마지막으로 개발자용 출력 주석처리
			} catch (ClassNotFoundException e) {			
				e.printStackTrace();
				MainController.shutdown("DB 드라이버가 존재하지 않음", 1);
//				System.out.println("드라이버가 존재하지 않음");
//				System.out.println("프로그램을 종료합니다.");
//				System.exit(0);
			}
		}
		
		// Connection을 가져가는 매소드 만들기 - 다른 패키지에서 사용이 가능하도록 한다.
		// 사용 방법 - DBInfo.getConnection()
		public static Connection getConnection() throws Exception {
			// 드라이버가 있는지 확인
			if (DriverCheck = false) throw new Exception("드라이버가 존재하지 않습니다.");
			// 연결객체 가져가기 처리
			try {
				return DriverManager.getConnection(URL, UID, UPW);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();			
				throw new Exception("DB연결 실패 - " + e.getMessage());
			}		
			
		}
		
		// 사용객체를 닫는 메소드 만들기
		public static void close(Connection con, PreparedStatement pstmt) {
			try {
				if (con != null) con.close();
				if (pstmt != null) pstmt.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
			try {
				close(con, pstmt);
				if (rs != null) rs.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
}
