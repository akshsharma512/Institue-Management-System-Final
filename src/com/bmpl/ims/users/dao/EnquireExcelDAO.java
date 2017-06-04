package com.bmpl.ims.users.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bmpl.ims.common.dao.CommonDAO;
import com.bmpl.ims.common.dao.CommonSQLConstants;
import com.bmpl.ims.users.dto.EnquireExcelDTO;

public class EnquireExcelDAO {
	

	public EnquireExcelDAO(){}
	
	public Date currentDate(){
		Date CurrentDate = new Date();
		java.sql.Date sqlDate = new java.sql.Date(CurrentDate.getTime());
		return sqlDate;
		
	}
	
	public List<EnquireExcelDTO> getEnquire() throws ClassNotFoundException, SQLException {
		String sql = CommonSQLConstants.getExcelEnquire(currentDate());
		Connection con = null;
		Statement stm = null;
		con = CommonDAO.getConnection();
		stm = con.createStatement();
		List<EnquireExcelDTO> list = new ArrayList<EnquireExcelDTO>();
		ResultSet rs = stm.executeQuery(sql);
		while(rs.next()){
			EnquireExcelDTO enquireExcelDTO = new EnquireExcelDTO();
			
			enquireExcelDTO.setEnquireID(rs.getString("EnquireID"));
			enquireExcelDTO.setFirstName(rs.getString("firstName"));
			enquireExcelDTO.setSecondName(rs.getString("secondName"));
			enquireExcelDTO.setAddress1(rs.getString("address1"));
			enquireExcelDTO.setAddress2(rs.getString("address2"));
			enquireExcelDTO.setMobileContact(rs.getString("mobileContact"));
			enquireExcelDTO.setOtherContact(rs.getString("otherContact"));
			enquireExcelDTO.setEmail(rs.getString("email"));
			enquireExcelDTO.setFatherFirstName(rs.getString("fatherFirstName"));
			enquireExcelDTO.setFatherSecondName(rs.getString("fatherSecondName"));
			enquireExcelDTO.setFatherMobileContact(rs.getString("fatherMobileContact"));
			enquireExcelDTO.setFatherOtherContact(rs.getString("fatherOtherContact"));
			enquireExcelDTO.setQualification(rs.getString("qualification"));
			enquireExcelDTO.setUniversity(rs.getString("university"));
			enquireExcelDTO.setReference(rs.getString("reference"));
			enquireExcelDTO.setEnquireDate(rs.getDate("EnquireDate"));
			enquireExcelDTO.setEnquireContactDate(rs.getDate("enquireContactDate"));
			enquireExcelDTO.setSlot1(rs.getString("slot1"));
			enquireExcelDTO.setSlot2(rs.getString("slot2"));
			enquireExcelDTO.setCoursename(rs.getString("Coursename"));
			list.add(enquireExcelDTO);
			
		}
		stm.close();
		return list;
	}
}
