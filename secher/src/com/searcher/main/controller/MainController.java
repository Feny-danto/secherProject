package com.searcher.main.controller;

import com.seacher.company.controller.CompanyController;

/*
 * 공용으로 사용하게될 부분이므로 수정이 필요해보이면 얘기하고 수정해주세요
 * 제일 첫 화면이 나올 메인 컨트롤러
 * 각각 메뉴의 ~~ 처리는 동작 확인용, 다 만들면 지우거나 주석처리 해주시면 감사하겠습니다. * 
 */

import com.searcher.util.io.In;
import com.searcher.util.io.Out;



public class MainController {
	public static void main(String[] args) {
		while(true) {
		
			Out.title("함께 찾아주는 도우미 Searcher 메인 홈입니다.");
			Out.menuWithLine("1. 공지사항", "2. 회사관리", "3. 회원관리","4. 공고관리", "5. 이력서관리", "6. 지원관리", "7. 로그인", "0. 종료" );		 
			String menu = In.getString("메뉴 선택");
			
			switch (menu) {		
				case "1":
					System.out.println("선택 : "+menu);
					System.out.println("공지사항 처리");			
					break;
				case "2":
					System.out.println("선택 : "+menu);
					System.out.println("회사관리 처리");
					(new CompanyController()).execute();
					break;
				case "3":				
					System.out.println("선택 : "+menu);		
					System.out.println("회원관리 처리");
					break;
				case "4":				
					System.out.println("선택 : "+menu);
					System.out.println("공고관리 처리");
					break;
				case "5":				
					System.out.println("선택 : "+menu);
					System.out.println("이력서관리 처리");
					break;
				case "6":				
					System.out.println("선택 : "+menu);
					System.out.println("지원관리 처리");
					break;
				case "7":				
					System.out.println("선택 : "+menu);
					System.out.println("로그인 처리");
					break;
				case "0":				
					System.out.println("선택 : "+menu);
					System.out.println("프로램을 종료합니다.");
					System.exit(0);				
				default:
					System.out.println("선택 : "+menu);
					System.out.println("잘못된 입력입니다. 원하시는 기능의 번호를 선택해주세요.");
					break;
			} // switch 끝
		} // while 끝
	} // main 끝	
		
	
	public static void shutdown(String msg, int x) {
		System.out.println(msg);
		System.out.println("프로그램을 종료합니다.");
		System.exit(x);
		
	}
}