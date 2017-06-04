package com.bmpl.ims.users.views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.bmpl.ims.users.dao.EnquireExcelDAO;
import com.bmpl.ims.users.dto.EnquireExcelDTO;

public class ExcelEnquire extends JFrame {

	ExcelEnquire frame;
	public static void main(String[] args) {
		
					 new ExcelEnquire();
				
	}

	/**
	 * Create the frame.
	 */
	public ExcelEnquire() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setSize(428,271);
		
		JButton btnGetExcel = new JButton("Get Excel");
		btnGetExcel.setBounds(73, 108, 96, 41);
		getContentPane().add(btnGetExcel);
		
		JLabel lblMakeExcelTo = new JLabel("Make Excel To Get Today's Enquiry Contact List");
		lblMakeExcelTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMakeExcelTo.setBounds(47, 61, 301, 36);
		getContentPane().add(lblMakeExcelTo);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(214, 108, 96, 41);
		getContentPane().add(btnCancel);
		
		btnCancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ExcelEnquire.this.setVisible(false);
				ExcelEnquire.this.dispose();
			}
			
		});
		
		btnGetExcel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				getExcel();
				ExcelEnquire.this.setVisible(false);
				ExcelEnquire.this.dispose();
				JOptionPane.showMessageDialog(null, "Enquire Contact Excel file is successfully written on disk.");
	            
			}
			
		});
		this.setVisible(true);
	}
	
	private void getExcel(){
		HSSFWorkbook workbook = new HSSFWorkbook(); 
        
        HSSFSheet sheet = workbook.createSheet("Enquiry Data");
        
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        
       
          EnquireExcelDAO enquireExcelDAO = new EnquireExcelDAO();
    		List<EnquireExcelDTO> enquireExcelDTO;
    		int i=2;
    		try {
    			enquireExcelDTO = enquireExcelDAO.getEnquire();
    			SimpleDateFormat format = new SimpleDateFormat();

    			for(EnquireExcelDTO enquireExcelDTO1 : enquireExcelDTO){
    				
    				
        			String ContactDate = format.format(enquireExcelDTO1.getEnquireContactDate());
        			String EnquireDate = format.format(enquireExcelDTO1.getEnquireDate());
    				
        			data.put((String.valueOf(i++)), new Object[] {
    						enquireExcelDTO1.getEnquireID(), enquireExcelDTO1.getFirstName(), 
    						enquireExcelDTO1.getSecondName(), enquireExcelDTO1.getMobileContact(), 
    						enquireExcelDTO1.getOtherContact(), enquireExcelDTO1.getAddress1(), enquireExcelDTO1.getAddress2(), 
    						enquireExcelDTO1.getSlot1(), enquireExcelDTO1.getSlot2(), enquireExcelDTO1.getEmail(), 
    						enquireExcelDTO1.getFatherFirstName(), enquireExcelDTO1.getFatherSecondName(), 
    						enquireExcelDTO1.getFatherMobileContact(), enquireExcelDTO1.getFatherOtherContact(), 
    						enquireExcelDTO1.getQualification(), enquireExcelDTO1.getUniversity(), 
    						enquireExcelDTO1.getReference(), EnquireDate, ContactDate, enquireExcelDTO1.getCoursename()});
    			}
    		} catch (ClassNotFoundException | SQLException e) {
    			e.printStackTrace();
    		}
    		          
        Set<String> keyset = data.keySet();
        int rownum = 1;
        
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Enquire ID");
        header.createCell(1).setCellValue("First Name");
        header.createCell(2).setCellValue("Second Name");
        header.createCell(3).setCellValue("Mobile");
        header.createCell(4).setCellValue("Other Contact");
        header.createCell(5).setCellValue("Address1");
        header.createCell(6).setCellValue("Address2");
        header.createCell(7).setCellValue("Time Slot 1");
        header.createCell(8).setCellValue("Time Slot 2");
        header.createCell(9).setCellValue("Email ID");
        header.createCell(10).setCellValue("F'first Name");
        header.createCell(11).setCellValue("F'second Name");
        header.createCell(12).setCellValue("F'mobile");
        header.createCell(13).setCellValue("F'other Contact");
        header.createCell(14).setCellValue("Qualification");
        header.createCell(15).setCellValue("University");
        header.createCell(16).setCellValue("Referred By");
        header.createCell(17).setCellValue("Enquired On");
        header.createCell(18).setCellValue("Contact On");
        header.createCell(19).setCellValue("Course Selected");
                
        for (String key : keyset)
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
               Cell cell = row.createCell(cellnum++);
               if(obj instanceof String)
                    {
            	   cell.setCellValue((String)obj);
                   sheet.autoSizeColumn(cellnum); 
                   }
                else if(obj instanceof Integer)
                    {
                	cell.setCellValue((Integer)obj);
                    sheet.autoSizeColumn(cellnum);
            }
        }}
        try
        {
            FileOutputStream out = new FileOutputStream(new File("EnquireExcel.xls"));
            workbook.write(out);
            out.close();
            workbook.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}