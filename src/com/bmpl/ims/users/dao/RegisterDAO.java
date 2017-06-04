package com.bmpl.ims.users.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bmpl.ims.common.dao.CommonDAO;
import com.bmpl.ims.common.dao.CommonSQLConstants;

public class RegisterDAO {

	public boolean register(com.bmpl.ims.users.dto.RegisterDTO registerDTO)
			throws SQLException, ClassNotFoundException {

		boolean registration = false;
		String sql = CommonSQLConstants.REGISTRATION_SQL;
		Connection con = null;
		PreparedStatement pstmt = null;
		int rs;

		try {
			con = CommonDAO.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, registerDTO.getRollno());
			pstmt.setString(2, registerDTO.getName());
			pstmt.setString(3, registerDTO.getAddress());
			pstmt.setString(4, registerDTO.getCourse());
			pstmt.setString(5, registerDTO.getPhone());
			pstmt.setString(6, registerDTO.getFname());
			pstmt.setString(7, registerDTO.getBatch());
			pstmt.setString(8, registerDTO.getFees());
			pstmt.setString(9, "0");
			pstmt.setString(10, "0");
			pstmt.setString(11, registerDTO.getPath());
			pstmt.setString(12, registerDTO.getMail());

			// `EnrollmentNumber`,`Name`,`Address`,`Course`,`Phone`,'Fname`,`Bname`,`TotalFees`,`DueAmt`,`DueDate`,`ImgPath`
			rs = pstmt.executeUpdate();

			try {

				registration = true;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Registration Failed");
			}

		} finally {
			if (con != null) {
				con.close();
			}
		}

		return registration;

	}

}
