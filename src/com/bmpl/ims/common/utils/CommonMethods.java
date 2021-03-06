package com.bmpl.ims.common.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bmpl.ims.common.dao.CommonDAO;
import com.bmpl.ims.common.dao.CommonSQLConstants;
import com.bmpl.ims.users.dto.BatchDTO;
import com.bmpl.ims.users.dto.StudentDTO;

public class CommonMethods {

	public static ArrayList<String> getStudents() throws SQLException {

		String sql = CommonSQLConstants.VIEWSTUDENTS_SQL;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs;
		ArrayList<String> list = new ArrayList<String>();
		try {
			con = CommonDAO.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				list.add(rs.getString("Name"));// change acc to db.!!
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			con.close();
		}
		return list;

	}

	public static ArrayList<String> getCourse() throws SQLException {
		boolean coursesShown = false;
		String sql = CommonSQLConstants.VIEWCOURSE_SQL;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs;
		ArrayList<String> list = new ArrayList<String>();
		try {
			con = CommonDAO.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				list.add(rs.getString("course_name"));

				coursesShown = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			coursesShown = false;

		} finally {
			con.close();
		}
		return list;
	}

	public static ArrayList<String> getBatches() throws SQLException {

		String sql = CommonSQLConstants.VIEWBATCHES_SQL;
		Connection con = null;
		java.sql.Statement stmt = null;
		ResultSet rs;
		ArrayList<String> list = new ArrayList<String>();
		try {
			con = CommonDAO.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				BatchDTO batchdto = new BatchDTO();
				batchdto.setBatchname(rs.getString("batchname"));
				System.out.println(rs.getString("batchname"));
				list.add(batchdto.getBatchname());
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			con.close();
		}
		return list;
	}

	public static ArrayList<String> getStudents(String batchName) throws SQLException {

		String sql = CommonSQLConstants.GETSTUDENTLIST(batchName);
		;
		Connection con = null;
		java.sql.Statement stmt = null;
		ResultSet rs;
		ArrayList<String> list = new ArrayList<String>();
		try {
			con = CommonDAO.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				StudentDTO studentdto = new StudentDTO();
				studentdto.setName(rs.getString("Name"));
				list.add(studentdto.getName());
			}
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return list;

	}
	
	public static ArrayList<String> getEmails(String batchName) throws SQLException {

		String sql = CommonSQLConstants.GETSTUDENTMAIL(batchName);
		;
		Connection con = null;
		java.sql.Statement stmt = null;
		ResultSet rs;
		ArrayList<String> list = new ArrayList<String>();
		try {
			con = CommonDAO.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				StudentDTO studentdto = new StudentDTO();
				System.out.println(rs.getString("email"));
				studentdto.setMail(rs.getString("email"));
				list.add(studentdto.getMail());
			}
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return list;

	}
}
