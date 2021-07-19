package com.searcher.util.db;

/**
 * DAO에 필요한 객체를 가지고 있는 부모 클래스
 * - 다른 DAO프로그램들은 이것을 반드시 상속 받아서 개발해야만 한다.
 * @author user
 *
 */

/*
 * 공용으로 사용하게될 부분이므로 수정이 필요해보이면 얘기하고 수정해주세요
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	public Connection con = null;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;
}
