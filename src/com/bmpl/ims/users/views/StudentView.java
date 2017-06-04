package com.bmpl.ims.users.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.bmpl.ims.common.utils.CommonMethods;
import com.bmpl.ims.users.dao.StudentDAO;

public class StudentView extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	static JTextArea textUpdateArea;
	static JLabel lblCou;
	static DefaultListModel<String> listModel;
	static JFrame frame = new JFrame();

	public static void main(String[] args) {

		new StudentView();

	}

	public StudentView() {
		frame.setTitle("Update Students");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 700, 350);
		contentPane = new JPanel();

		contentPane.setLayout(null);
		frame.setContentPane(contentPane);

		listModel = new DefaultListModel<String>();
		JList<String> courseList = new JList<String>(listModel);
		courseList.setValueIsAdjusting(true);
		courseList.setBounds(22, 57, 138, 177);
		courseList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				System.out.println("selected name :" + courseList.getSelectedValue());
				textUpdateArea.setVisible(true);
				lblCou.setVisible(true);
				textUpdateArea.setText("");
				try {
					if (courseList.getSelectedValue() == null) {
						textUpdateArea.setVisible(false);
						lblCou.setVisible(false);
					}
					textUpdateArea.setText(StudentDAO.showCourse(courseList.getSelectedValue()).toString());

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

		JButton btnCourses = new JButton("View Students");
		btnCourses.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				listModel.clear();
				bringCourses();

			}
		});
		btnCourses.setBounds(31, 23, 140, 15);
		contentPane.add(btnCourses);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 50, 150, 250);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(courseList);

		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String item = courseList.getSelectedValue();

				if (item != null) {
					System.out.println("item is :" + item);
					update(item);

					bringCourses();
					listModel.clear();
					lblCou.setVisible(false);
					textUpdateArea.setVisible(false);

				} else {
					JOptionPane.showMessageDialog(null, "No student Selected");
				}

			}
		});
		btnNewButton.setBounds(229, 275, 117, 25);
		contentPane.add(btnNewButton);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String item = courseList.getSelectedValue();
				if (item != null) {

					int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (response == JOptionPane.NO_OPTION) {
						System.out.println("No button clicked");
					} else if (response == JOptionPane.YES_OPTION) {
						System.out.println("Yes button clicked");

						deleteItem(item);
						bringCourses();
						listModel.clear();
						lblCou.setVisible(false);
						textUpdateArea.setVisible(false);

					} else if (response == JOptionPane.CLOSED_OPTION) {
						System.out.println("JOptionPane closed");
					}
				} else {
					JOptionPane.showMessageDialog(null, "No student Selected");
				}

			}
		});
		btnDelete.setBounds(397, 275, 117, 25);
		contentPane.add(btnDelete);

		lblCou = new JLabel("Student Selected :");
		lblCou.setBounds(276, 27, 238, 40);
		contentPane.add(lblCou);
		lblCou.setVisible(false);

		textUpdateArea = new JTextArea();
		textUpdateArea.setBounds(276, 81, 238, 160);
		contentPane.add(textUpdateArea);

		textUpdateArea.setVisible(false);

		frame.setVisible(true);
	}

	protected void update(String item) {

		StudentDAO studentDAO = new StudentDAO();
		RegistrationView cv = null;
		try {

			textUpdateArea.setText(studentDAO.updateCourse(item));
			lblCou.setVisible(true);
			textUpdateArea.setVisible(true);
			System.out.println(StudentDAO.showCourse(item));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Cant update..");
		}

	}

	protected void deleteItem(String item) {
		StudentDAO studentDAO = new StudentDAO();
		System.out.println(item);
		try {
			if (item != null) {

				if (StudentDAO.deleteCourse(item)) {
					String info = studentDAO.updateCourse(item);
					textUpdateArea.setText(info);
					textUpdateArea.setVisible(true);
					lblCou.setVisible(true);
					JOptionPane.showMessageDialog(this, "Student Deleted " + item);
					System.out.println("Student deleted :" + item);
					textUpdateArea.setVisible(false);
					lblCou.setVisible(false);

				}
			} else {
				JOptionPane.showMessageDialog(this, "No student to delete");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void bringCourses() {

		try {
			ArrayList<String> list = CommonMethods.getStudents();
			if (!list.isEmpty()) {
				for (String name : list) {
					listModel.addElement(name);
					System.out.println(name);
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub

	}

}
