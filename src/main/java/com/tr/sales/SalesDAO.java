package com.tr.sales;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tr.main.DBManager;


public class SalesDAO {

	public void sales_select(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sales";
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			sales s = null;
			ArrayList<sales> sales = new ArrayList<sales>();
			while (rs.next()) {
				
				String name = rs.getString("s_name");
				String salesort = rs.getString("s_salesort");
				double size = rs.getDouble("s_size");
				String condition = rs.getString("s_condition");
				String price = rs.getString("s_price");
				Date date = rs.getDate("s_date");
				String etc = rs.getString("s_etc");
				String img1 = rs.getString("s_img1");
				String img2 = rs.getString("s_img2");
				String img3 = rs.getString("s_img3");
				String contact = rs.getString("s_contact");
				
				s = new sales(name, salesort, size, condition, price, date, etc, img1, img2, img3, contact);
				sales.add(s);
			}
			request.setAttribute("sales", sales);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
	}
	
	public void sales_select_one(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sales where s_no=?";
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,Integer.parseInt(request.getParameter("?")));
			rs = pstmt.executeQuery();
			sales s = null;
			ArrayList<sales> sales = new ArrayList<sales>();
			while (rs.next()) {
				
				String name = rs.getString("s_name");
				String salesort = rs.getString("s_salesort");
				double size = rs.getDouble("s_size");
				String condition = rs.getString("s_condition");
				String price = rs.getString("s_price");
				Date date = rs.getDate("s_date");
				String etc = rs.getString("s_etc");
				String img1 = rs.getString("s_img1");
				String img2 = rs.getString("s_img2");
				String img3 = rs.getString("s_img3");
				String contact = rs.getString("s_contact");
				
				s = new sales(name, salesort, size, condition, price, date, etc, img1, img2, img3, contact);
				sales.add(s);
			}
			request.setAttribute("sales", sales);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
	}
	
	public void sales_update(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update sales set s_name=?,s_salesort=?,s_size=?,s_condition=?,s_price=?,"
				+ "s_date=?,s_etc=?,s_img1=?,s_img2=?,s_img3=?,s_contact=? where s_no=?";
		try {
			DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
			String path = request.getSession().getServletContext().getRealPath("img");
		MultipartRequest mr;
		mr = new MultipartRequest(
						request,
						path,
						5*1024*1024,
						"utf-8",
						policy);
		String file1 = mr.getFilesystemName("img1");
		String file2 = mr.getFilesystemName("img2");
		String file3 = mr.getFilesystemName("img3");
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mr.getParameter(""));
			pstmt.setString(2, mr.getParameter(""));
			pstmt.setString(3, mr.getParameter(""));
			pstmt.setString(4, mr.getParameter(""));
			pstmt.setString(5, mr.getParameter(""));
			pstmt.setString(6, mr.getParameter(""));
			pstmt.setString(7, mr.getParameter(""));
			pstmt.setString(8, file1);
			pstmt.setString(9, file2);
			pstmt.setString(10, file3);
			pstmt.setString(11, mr.getParameter(""));
			pstmt.setString(12, mr.getParameter(""));
			
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "수정 성공!");
				}else {		
					request.setAttribute("r", "수정 실패!");
				}
			
		} catch (Exception e) {
			request.setAttribute("r", "DB서버 오류!");
			e.printStackTrace();
			
		}finally {
			DBManager.close(con, pstmt, null);
		}
	}
	
	public void sales_delete(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "delete sales where s_no=?";
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			int no = Integer.parseInt(request.getParameter("?"));
			pstmt.setInt(1,no);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "삭제 성공!");
				}else {		
					request.setAttribute("r", "삭제 실패!");
				}
			
		} catch (Exception e) {
			request.setAttribute("r", "DB서버 오류!");
			e.printStackTrace();
			
		}finally {
			DBManager.close(con, pstmt, null);
		}
		
		
		
	}
	
	public void sales_insert(HttpServletRequest request) {
		try {
			DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
			String path = request.getSession().getServletContext().getRealPath("img");
		MultipartRequest mr;
		mr = new MultipartRequest(
						request,
						path,
						5*1024*1024,
						"utf-8",
						policy);
		String file1 = mr.getFilesystemName("img1");
		String file2 = mr.getFilesystemName("img2");
		String file3 = mr.getFilesystemName("img3");
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into sales values (sales_seq.nextval,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,mr.getParameter(""));
			pstmt.setString(2,mr.getParameter(""));
			pstmt.setString(3,mr.getParameter(""));
			pstmt.setString(4,mr.getParameter(""));
			pstmt.setString(5,mr.getParameter(""));
			pstmt.setString(6,mr.getParameter(""));
			pstmt.setString(7,mr.getParameter(""));
			pstmt.setString(8,mr.getParameter(""));
			pstmt.setString(9,file1);
			pstmt.setString(10,file2);
			pstmt.setString(11,file3);
			pstmt.setString(12,mr.getParameter(""));
			
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("등록 성공");
				
				}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			DBManager.close(con, pstmt, null);
		}
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
}
