package com.bmpl.ims.users.views;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.bmpl.ims.common.utils.CommonMethods;
import com.bmpl.ims.users.dao.CoursesDAO;
import com.bmpl.ims.users.dao.RegisterDAO;
import com.bmpl.ims.users.dto.RegisterDTO;
import com.bmpl.ims.users.dto.StudentDTO;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

/*
* @author  Ojaswi Wadhwa
* @version 0.1
* @since   2016-07-015
* This is a Registration Page Design 
*/

public class RegistrationView extends JFrame {

	private JPanel contentPane;
	private static JTextField txtName;
	private static JTextField txtAddress;
	private static JTextField txtPhone;
	private static JTextField txtEmail;
	private static JTextField txtFather;
	/*
	 * private static JTextField txtCourse; private static JTextField txtBatch;
	 */
	private static JList<String> list1;

	private static JList<String> list_1;
	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	private static ArrayList<String> list;
	private JButton btnUpload;
	JLabel lblEnrollmentNumber;
	JScrollPane scrollPane1;
	private DefaultListModel<String> listModel1 = new DefaultListModel<String>();

	private static ArrayList<String> batchList;
	private ImageIcon image;
	private String ImagePath = null;
	private byte[] userimage;
	private JFrame frame = new JFrame();
	private JTextField textField;
	protected String id;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		new RegistrationView();

	}

	public RegistrationView() {

		list = new ArrayList<>();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 622, 499);
		contentPane = new JPanel();

		contentPane.setLayout(null);
		frame.setContentPane(contentPane);

		JLabel lblName = new JLabel("Name : ");
		lblName.setBounds(10, 38, 63, 14);
		contentPane.add(lblName);

		txtName = new JTextField();
		txtName.setBounds(91, 36, 173, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);

		JLabel lblPhoto = new JLabel("Photo :");
		lblPhoto.setBounds(296, 28, 112, 124);

		JLabel lblAddress = new JLabel("Address : ");
		lblAddress.setBounds(10, 96, 63, 14);
		contentPane.add(lblAddress);

		txtAddress = new JTextField();
		txtAddress.setBounds(91, 94, 173, 20);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);

		JLabel lblPhoneNumber = new JLabel("Phone :");
		lblPhoneNumber.setBounds(10, 166, 63, 14);
		contentPane.add(lblPhoneNumber);

		txtPhone = new JTextField();
		txtPhone.setBounds(91, 164, 173, 20);
		contentPane.add(txtPhone);
		txtPhone.setColumns(10);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(10, 238, 63, 14);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(91, 236, 173, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblCourse = new JLabel("Course :");
		lblCourse.setBounds(10, 316, 63, 14);
		contentPane.add(lblCourse);

		btnUpload = new JButton("Upload");
		btnUpload.setBounds(425, 128, 89, 23);
		contentPane.add(btnUpload);
		JLabel lblPicture = new JLabel("Picture : ");
		lblPicture.setBounds(418, 38, 75, 14);
		contentPane.add(lblPicture);

		btnUpload.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Image", "jpg", "png");
				fileChooser.addChoosableFileFilter(filter);
				int result = fileChooser.showSaveDialog(null);

				if (result == JFileChooser.APPROVE_OPTION) {
					contentPane.add(lblPhoto);
					File selectedFile = fileChooser.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					ImagePath = path;
					lblPhoto.setIcon(ResizeImage(path));
					lblPicture.setVisible(false);

				} else if (result == JFileChooser.CANCEL_OPTION) {
					System.out.println("No File Selected");
				}

			}

			private Icon ResizeImage(String ImagePath) {
				ImageIcon MyImage = new ImageIcon(ImagePath);
				Image img = MyImage.getImage();
				Image newImg = img.getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
				image = new ImageIcon(newImg);

				File imgfile = new File(ImagePath);

				try {
					FileInputStream fin = new FileInputStream(imgfile);
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					byte[] buff = new byte[1024];
					for (int readNum; (readNum = fin.read(buff)) != -1;) {
						baos.write(buff, 0, readNum);
					}
					userimage = baos.toByteArray();

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}

				return image;

			}
		});

		JLabel lblFathersName = new JLabel("Father's name :");
		lblFathersName.setBounds(296, 166, 111, 14);
		contentPane.add(lblFathersName);

		txtFather = new JTextField();
		txtFather.setBounds(425, 163, 153, 20);
		contentPane.add(txtFather);
		txtFather.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doSubmit();
			}
		});
		btnSubmit.setBounds(137, 380, 89, 23);
		contentPane.add(btnSubmit);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doExit();
			}
		});
		btnExit.setBounds(418, 380, 89, 23);
		contentPane.add(btnExit);

		JLabel lblBatch = new JLabel("Batch :");
		lblBatch.setBounds(296, 238, 89, 14);
		contentPane.add(lblBatch);

		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblRegistration.setBounds(238, -1, 126, 25);
		contentPane.add(lblRegistration);

		listModel = new DefaultListModel<String>();

		try {
			list = CommonMethods.getCourse();
			for (String courses : list) {
				listModel.addElement(courses);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		textField_1 = new JTextField();
		textField_1.setText("");
		textField_1.setBounds(425, 202, 153, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(91, 283, 173, 86);
		contentPane.add(scrollPane1);
		list1 = new JList<String>(listModel);
		list1.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {

				ArrayList list = null;
				try {
					list = CoursesDAO.showCourse(list1.getSelectedValue());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textField_1.setText((String) list.get(2));

			}
		});
		scrollPane1.setViewportView(list1);
		list1.setValueIsAdjusting(true);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(425, 238, 153, 92);
		contentPane.add(scrollPane);

		JButton btnEnroll = new JButton("Roll No.");
		btnEnroll.setBounds(296, 348, 111, 20);
		contentPane.add(btnEnroll);

		listModel1 = new DefaultListModel<String>();

		try {
			batchList = CommonMethods.getBatches();
			for (String batches : batchList) {
				listModel1.addElement(batches);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		list_1 = new JList(listModel1);
		scrollPane.setViewportView(list_1);

		btnEnroll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (txtName.getText() != null && list_1.getSelectedValue() != null
						&& list1.getSelectedValue() != null) {
					if (txtName.getText().length() < 4) {
						JOptionPane.showMessageDialog(null, "Name too short. ");
					} else {
						id = generateEnrollment(txtName.getText(), list_1.getSelectedValue(), list1.getSelectedValue());
						textField.setText(id);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Name, Course and Batch should be entered. ");
				}
			}
		});

		textField = new JTextField();
		textField.setBounds(425, 342, 153, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblFees = new JLabel("Fees :");
		lblFees.setBounds(296, 204, 70, 15);
		contentPane.add(lblFees);

		frame.setVisible(true);

	}

	private void doSubmit() {

		RegisterDAO registerDAO = new RegisterDAO();
		RegisterDTO registerDTO = new RegisterDTO();

		String rollno = textField.getText();
		String name = txtName.getText();
		String fname = txtFather.getText();
		String address = txtAddress.getText();
		String contactnumber = txtPhone.getText();
		String email = txtEmail.getText();
		String fees = textField_1.getText();
		String course = list_1.getSelectedValue();
		String batch = list1.getSelectedValue();

		if (name != null && fname != null && address != null && contactnumber != null && email != null
				&& ImagePath != null && course != null && batch != null && fees != null) {

			registerDTO.setName(name);
			registerDTO.setFname(fname);
			registerDTO.setAddress(address);
			registerDTO.setRollno(rollno);
			registerDTO.setFees(fees);
			registerDTO.setPhone(contactnumber);
			registerDTO.setMail(email);
			registerDTO.setPath(ImagePath);
			registerDTO.setCourse(course);
			registerDTO.setBatch(batch);

		} else
			JOptionPane.showMessageDialog(null, "Empty Fields!");

		try {
			registerDAO.register(registerDTO);
			System.out.println(registerDTO);
			JOptionPane.showMessageDialog(null, "Student added...");
			frame.setVisible(false);
			frame.dispose();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

	private void doExit() {

		System.exit(0);

	}

	public static String viewStudent(StudentDTO studentDTO) {

		txtName.setText(studentDTO.getName());
		txtAddress.setText(studentDTO.getAddress());
		txtFather.setText(studentDTO.getFname());
		txtEmail.setText(studentDTO.getMail());
		txtPhone.setText(studentDTO.getPhone());
		/*
		 * list_1.setSelectedValue(trainerDTO.getPhone());
		 * list.setText(trainerDTO.getPhone());
		 */
		String info = "Name :" + studentDTO.getName() + "\nFather :" + studentDTO.getFname() + "\nPhone :"
				+ studentDTO.getPhone() + "\nAddress :" + studentDTO.getAddress() + "\nMail :" + studentDTO.getMail();

		return info;

	}

	private String generateEnrollment(String string, String string2, String string3) {
		String id = string.substring(0, 3) + string2 + string3 + Calendar.getInstance().get(Calendar.YEAR);
		return id;
	}
}
