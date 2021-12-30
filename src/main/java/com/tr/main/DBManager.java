package com.tr.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DB���� �۾��� �� �� �Ź� �����ڵ带 �� ���� �۾� �ؿ�

// �װ� AOP ���ڴ°�

public class DBManager {
	// db�۾��ÿ� ��¶�� ���� �ؾ���
	public static Connection connect() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		return DriverManager.getConnection(url,"c##hn","hn");
		
	}
	
	// ������ ������ �ѹ��� �ݱ�
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs !=null)
			rs.close();
		} catch (SQLException e) {
		}
		try {
			pstmt.close();
		} catch (SQLException e) {
		}
		try {
			con.close();
		} catch (SQLException e) {
		}
	}
	
	
	
}
