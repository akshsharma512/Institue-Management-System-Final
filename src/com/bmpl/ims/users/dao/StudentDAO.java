package com.bmpl.ims.users.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bmpl.ims.common.dao.CommonDAO;
import com.bmpl.ims.common.dao.CommonSQLConstants;
import com.bmpl.ims.users.dto.StudentDTO;
import com.bmpl.ims.users.views.RegistrationView;

public class StudentDAO {
	StudentDTO studentDTO;

	public boolean addCourse(StudentDTO studentDTO) throws ClassNotFoundException, SQLException {
		boolean courseAdded = false;
		String sql = CommonSQLConstants.VIEWCOURSE_SQL;
		Connection con = null;
		PreparedStatement pstmt = null;
		int rs;
		try {
			con = CommonDAO.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, studentDTO.getName());
			pstmt.setString(2, studentDTO.getFname());
			pstmt.setString(3, studentDTO.getMail());
			pstmt.setString(4, studentDTO.getPhone());
			pstmt.setString(5, studentDTO.getAddress());
			rs = pstmt.executeUpdate();
			try {

				courseAdded = true;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("can't execiute");

			}
		} finally {
			// logger.debug("Resource Close Inside Finally");
			con.close();
		}
		return courseAdded;

	}

	public String getCourseInfo(String info) {
		return RegistrationView.viewStudent(studentDTO);

	}

	public String updateCourse(String item) throws SQLException {
		boolean isUpdated = false;
		String sql = CommonSQLConstants.VIEWSTUDENT_SQL;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs;
		String info = null;
		studentDTO = new StudentDTO();
		RegistrationView cv = null;
		try {

			con = CommonDAO.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, item);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				studentDTO.setName(rs.getString(2));
				studentDTO.setFname(rs.getString(6));
				studentDTO.setPhone(rs.getString(5));
				studentDTO.setAddress(rs.getString(3));
				studentDTO.setMail(rs.getString(12));

				cv = new RegistrationView();
				info = RegistrationView.viewStudent(studentDTO);

				System.out.println("course viewed to update");

			}

			isUpdated = true;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to delete course");
		} finally {
			con.close();
		}
		return info;

	}

	public static boolean deleteCourse(String itemString) throws SQLException {
		boolean isDeleted = false;
		String sql = CommonSQLConstants.DELETECOURSE_SQL;

		Connection con = null;
		PreparedStatement pstmt = null;
		int rs;
		try {
			con = CommonDAO.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, itemString);
			rs = pstmt.executeUpdate();

			isDeleted = true;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to delete student");
		} finally {
			con.close();
		}
		return isDeleted;

	}

	public static ArrayList<String> showCourse(String item) throws SQLException {
		boolean coursesShown = false;
		String sql = CommonSQLConstants.VIEWSTUDENT_SQL;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs;
		ArrayList<String> list = new ArrayList<String>();
		try {
			con = CommonDAO.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, item);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				list.add(rs.getString(1));

				list.add(rs.getString(2));

				list.add(rs.getString(3));

				list.add(rs.getString(4));

				list.add(rs.getString(5));

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

}
