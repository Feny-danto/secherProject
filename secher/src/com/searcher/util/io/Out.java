package com.searcher.util.io;

/* 
 * 공용으로 사용하게될 부분이므로 수정이 필요해보이면 얘기하고 수정해주세요
 * title 출력은 *
 * menu 출력은 = 
 */

public class Out {	
	
	// 특수문자를 반복해서 출력해주는 프로그램
	public static void forChar(String str, int x) {
		for(int i = 1; i <= x ; i++) System.out.print(str);
	}

	// 제목을 출력하는 메서드
	public static void title(String title, String str, int x) {
		if(x == 0) x= 15; // 기본 값 셋팅
		if(str == null) str = "*"; // 기본 값 셋팅
		System.out.println("\n"); // 2줄을 건너 띈다.
		forChar(str, x);
		System.out.print("[ " + title + " ]");
		forChar(str, x); // 줄바꿈을 안한 상태
		System.out.println(); // 줄바꿈을 한다.
	}
	
	// 제목만 받아서 출력하는 메서드
	public static void title(String title) {
		title(title, "*", 15);
	}
	
	// 위아래 라인과 함께 출력되는 제목 메서드
	public static void titleWithLine(String title) {
		line("*", 30);
		System.out.println("+ " + title);
		line("*", 30);
	}
	
	// 항목을 구분하는 라인 출력
	public static void line(String str, int x) {
		System.out.print("+");
		forChar(str, x);
		System.out.print("+");
		System.out.println();
	}
	
	// 메뉴를 구분하는 라인 출력
	public static void menuLine() {
		line("=", 60);
	}
	
	// 메뉴를 출력하는 메서드
	public static void menu(String ... menus) {
		for(String menu : menus) {
			System.out.print("+ ");
			System.out.println(menu);
		}
	}
	
	// 라인과 함께 메뉴 출력하는 메서드
	public static void menuWithLine(String ... menus) {
		menuLine();
		menu(menus);
		menuLine();
	}
	
	
}
