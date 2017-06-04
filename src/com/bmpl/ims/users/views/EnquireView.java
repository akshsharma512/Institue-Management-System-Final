package com.bmpl.ims.users.views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.bmpl.ims.common.utils.CommonMethods;
import com.bmpl.ims.users.dao.EnquireDAO;
import com.bmpl.ims.users.dto.EnquireDTO;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class EnquireView extends JFrame {

	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtAddress;
	private JTextField txtAddress_1;
	private JTextField txtMobile;
	private JTextField txtHome;
	private JTextField txtTimeSlot;
	private JTextField txtTimeSlotii;
	private JTextField txtFirstName_1;
	private JTextField txtLastName_1;
	private JTextField txtMobile_1;
	private JTextField txtOther;
	private JTextField txtEnterUniversityName;
	private JTextField txtEnterYourQualifications;
	private JTextField txtFriendOrOther;
	private JTextField txtEnterEmail;
	private UtilDateModel model;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;
	private java.sql.Date sqlDate;
	private ArrayList<String> list1;
	private String list2;
	private JList<String> courseList;
	EnquireView frame;
	public static void main(String[] args) {
		
					  new EnquireView();
					
				}

	public EnquireView()  {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setSize(736,639);
		
		
		JLabel lblEnquiry = new JLabel("ENQUIRY");
		lblEnquiry.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 15));
		lblEnquiry.setBounds(322, 17, 80, 24);
		getContentPane().add(lblEnquiry);
		
		JLabel label = new JLabel("1.");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(38, 55, 21, 14);
		getContentPane().add(label);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(81, 55, 227, 14);
		getContentPane().add(lblName);
		
		JLabel label_1 = new JLabel("2.");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(40, 88, 21, 14);
		getContentPane().add(label_1);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(79, 88, 229, 14);
		getContentPane().add(lblAddress);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(365, 52, 125, 20);
		getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
				
		txtLastName = new JTextField();
		txtLastName.setBounds(517, 52, 125, 20);
		getContentPane().add(txtLastName);
		txtLastName.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(365, 85, 277, 20);
		getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		txtAddress_1 = new JTextField();
		txtAddress_1.setBounds(365, 116, 277, 20);
		getContentPane().add(txtAddress_1);
		txtAddress_1.setColumns(10);
		
		JLabel label_2 = new JLabel("3.");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(38, 150, 21, 14);
		getContentPane().add(label_2);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContact.setBounds(79, 150, 249, 14);
		getContentPane().add(lblContact);
		
		txtMobile = new JTextField();
		txtMobile.setBounds(365, 147, 125, 20);
		getContentPane().add(txtMobile);
		txtMobile.setColumns(10);
		
		txtHome = new JTextField();
		txtHome.setBounds(517, 147, 125, 20);
		getContentPane().add(txtHome);
		txtHome.setColumns(10);
		
		JLabel label_3 = new JLabel("5.");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(38, 232, 21, 14);
		getContentPane().add(label_3);
		
		JLabel lblCourses = new JLabel("Courses");
		lblCourses.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourses.setBounds(79, 232, 229, 14);
		getContentPane().add(lblCourses);
		
		JLabel label_4 = new JLabel("6.");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(38, 295, 21, 14);
		getContentPane().add(label_4);
		
		JLabel lblPreferredTime = new JLabel("Preferred \r\nTime");
		lblPreferredTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPreferredTime.setBounds(79, 295, 229, 14);
		getContentPane().add(lblPreferredTime);
		
		txtTimeSlot = new JTextField();
		txtTimeSlot.setBounds(365, 292, 125, 20);
		getContentPane().add(txtTimeSlot);
		txtTimeSlot.setColumns(10);
		
		txtTimeSlotii = new JTextField();
		txtTimeSlotii.setBounds(517, 292, 125, 20);
		getContentPane().add(txtTimeSlotii);
		txtTimeSlotii.setColumns(10);
		
		JLabel label_5 = new JLabel("7.");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(38, 326, 21, 14);
		getContentPane().add(label_5);
		
		JLabel lblFname = new JLabel("F'name");
		lblFname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFname.setBounds(79, 326, 229, 14);
		getContentPane().add(lblFname);
		
		txtFirstName_1 = new JTextField();
		txtFirstName_1.setBounds(365, 323, 125, 20);
		getContentPane().add(txtFirstName_1);
		txtFirstName_1.setColumns(10);
		
		txtLastName_1 = new JTextField();
		txtLastName_1.setBounds(517, 323, 125, 20);
		getContentPane().add(txtLastName_1);
		txtLastName_1.setColumns(10);
		
		JLabel label_6 = new JLabel("8.");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(38, 356, 21, 14);
		getContentPane().add(label_6);
		
		JLabel lblFcontact = new JLabel("F'contact");
		lblFcontact.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFcontact.setBounds(79, 356, 229, 14);
		getContentPane().add(lblFcontact);
		
		txtMobile_1 = new JTextField();
		txtMobile_1.setBounds(365, 353, 125, 20);
		getContentPane().add(txtMobile_1);
		txtMobile_1.setColumns(10);
		
		txtOther = new JTextField();
		txtOther.setBounds(517, 353, 125, 20);
		getContentPane().add(txtOther);
		txtOther.setColumns(10);
		
		JLabel label_7 = new JLabel("9.");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_7.setBounds(38, 388, 21, 14);
		getContentPane().add(label_7);
		
		JLabel lblUniversity = new JLabel("University");
		lblUniversity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUniversity.setBounds(79, 421, 229, 14);
		getContentPane().add(lblUniversity);
		
		txtEnterUniversityName = new JTextField();
		txtEnterUniversityName.setBounds(365, 418, 277, 20);
		getContentPane().add(txtEnterUniversityName);
		txtEnterUniversityName.setColumns(10);
		
		JLabel label_8 = new JLabel("10.");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_8.setBounds(33, 421, 26, 14);
		getContentPane().add(label_8);
		
		JLabel lblQualifications = new JLabel("Qualifications");
		lblQualifications.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQualifications.setBounds(79, 388, 229, 14);
		getContentPane().add(lblQualifications);
		
		txtEnterYourQualifications = new JTextField();
		txtEnterYourQualifications.setBounds(366, 385, 276, 20);
		getContentPane().add(txtEnterYourQualifications);
		txtEnterYourQualifications.setColumns(10);
		
		JLabel label_9 = new JLabel("11.");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_9.setBounds(33, 455, 26, 14);
		getContentPane().add(label_9);
		
		JLabel lblReferredBy = new JLabel("Referred By.");
		lblReferredBy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReferredBy.setBounds(79, 455, 229, 14);
		getContentPane().add(lblReferredBy);
		
		txtFriendOrOther = new JTextField();
		txtFriendOrOther.setBounds(366, 452, 276, 20);
		getContentPane().add(txtFriendOrOther);
		txtFriendOrOther.setColumns(10);
		
		JLabel label_10 = new JLabel("4.");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_10.setBounds(38, 184, 21, 14);
		getContentPane().add(label_10);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(79, 184, 229, 14);
		getContentPane().add(lblEmail);
		
		txtEnterEmail = new JTextField();
		txtEnterEmail.setBounds(366, 178, 276, 20);
		getContentPane().add(txtEnterEmail);
		txtEnterEmail.setColumns(10);
		
		JButton btnAddEnquiry = new JButton("Add Enquiry");
		btnAddEnquiry.setBounds(322, 544, 101, 23);
		getContentPane().add(btnAddEnquiry);
		
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		datePicker.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		datePicker.setBounds(366, 483, 276, 20);
		getContentPane().add(datePicker);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(365, 212, 277, 69);
		getContentPane().add(scrollPane);
		
		DefaultListModel<String> listmodel = new DefaultListModel<String>();
		list1 = new ArrayList<>();
		try {
			list1=CommonMethods.getCourse();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(String listitem: list1){
			 listmodel.addElement(listitem);
		}
		courseList = new JList(listmodel);
		courseList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setViewportView(courseList);
		courseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		courseList.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				list2 = courseList.getSelectedValue();
			}
			
		});
		
		JLabel label_11 = new JLabel("12.");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_11.setBounds(33, 491, 26, 14);
		getContentPane().add(label_11);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(79, 489, 229, 14);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setText("When would you like \r\nus to call you?");
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(152, 544, 101, 23);
		getContentPane().add(btnReset);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(500, 544, 101, 23);
		getContentPane().add(btnCancel);
		
		btnAddEnquiry.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				addEnquiry();
				EnquireView.this.setVisible(false);
				EnquireView.this.dispose();
				JOptionPane.showMessageDialog(null, "Enquire Completed");
			}
			
		});
		
		btnReset.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				reset();
			}
			
		});
		
		btnCancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
			
		});
		this.setVisible(true);
	}
		
	private void reset(){
		txtFirstName.setText("");
		txtLastName.setText("");
		txtAddress.setText("");
		txtAddress_1.setText("");
		txtEnterEmail.setText("");
		txtMobile.setText("");
		txtHome.setText("");
		txtTimeSlot.setText("");
		txtTimeSlotii.setText("");
		txtFirstName_1.setText("");
		txtLastName_1.setText("");
		txtMobile_1.setText("");
		txtOther.setText("");
		txtEnterUniversityName.setText("");
		txtEnterYourQualifications.setText("");
		txtFriendOrOther.setText("");
		model.setSelected(false);
	}
	
	private void addEnquiry(){
		EnquireDAO enquireDAO = new EnquireDAO();
		EnquireDTO enquireDTO = new EnquireDTO();
		enquireDTO.setFirstName(txtFirstName.getText());
		enquireDTO.setSecondName(txtLastName.getText());
		enquireDTO.setAddress1(txtAddress.getText());
		enquireDTO.setAddress2(txtAddress_1.getText());
		enquireDTO.setEmail(txtEnterEmail.getText());
		enquireDTO.setMobileContact(txtMobile.getText());
		enquireDTO.setOtherContact(txtHome.getText());
		enquireDTO.setSlot1(txtTimeSlot.getText());
		enquireDTO.setSlot2(txtTimeSlotii.getText());
		enquireDTO.setFatherFirstName(txtFirstName_1.getText());
		enquireDTO.setFatherSecondName(txtLastName_1.getText());
		enquireDTO.setFatherMobileContact(txtMobile_1.getText());
		enquireDTO.setFatherOtherContact(txtOther.getText());
		enquireDTO.setUniversity(txtEnterUniversityName.getText());
		enquireDTO.setQualification(txtEnterYourQualifications.getText());
		enquireDTO.setReference(txtFriendOrOther.getText());
		
		Date enquireContactDate = (Date) datePicker.getModel().getValue();
		sqlDate = new java.sql.Date(enquireContactDate.getTime());
		enquireDTO.setEnquireContactDate(sqlDate);
		
		enquireDTO.setCoursename(list2);
		
		try {
			enquireDAO.addEnquire(enquireDTO);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
}
	
	private void cancel(){
		EnquireView.this.setVisible(false);
		EnquireView.this.dispose();
	}
}