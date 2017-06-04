package com.bmpl.ims.users.views;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bmpl.ims.common.utils.CommonMethods;

class MyFilter implements FilenameFilter {
	private String extension;

	MyFilter(String extension) {
		this.extension = extension;
	}

	@Override
	public boolean accept(File dir, String name) {
		if (extension == null) {
			return true;
		}
		return name.endsWith(extension);
	}

}

public class SendNotice extends JFrame {

	private JPanel contentPane;
	private File selectedFile;
	private List list;
	private static JFrame frame = new JFrame();
	private String fileName;
	JButton btnUpload;
	ArrayList<String> list2;
	ArrayList<String> list1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		new SendNotice();

	}

	File[] getFiles(File file, String extension) {
		File files[] = null;
		MyFilter filter = new MyFilter(extension);
		if (extension != null) {
			files = file.listFiles(filter);
		} else
			files = file.listFiles();
		for (File f : files) {
			System.out.println(f.getAbsolutePath());
		}
		return files;

	}

	private void fileChooser() {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fileChooser.showOpenDialog(this);
		selectedFile = fileChooser.getSelectedFile();

		if (selectedFile.getAbsolutePath().endsWith(".word")) {
			System.out.println("Selected file: " + selectedFile.getAbsolutePath());
			fileName = selectedFile.getAbsolutePath();
			btnUpload.setText(selectedFile.getName());
			// CommonMethods.sendEmail(fileName);

			System.out.println("fn :" + fileName);

		} else {
			JOptionPane.showMessageDialog(null, "Choose \".word\" file only.");
			fileChooser();
		}

	}

	public SendNotice() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Send Notice");
		frame.setBounds(100, 100, 534, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		frame.setContentPane(contentPane);

		btnUpload = new JButton("Upload your \".word\" File");
		btnUpload.setBounds(179, 62, 222, 25);
		btnUpload.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fileChooser();
			}

		});

		contentPane.add(btnUpload);

		JLabel lblStep = new JLabel("Step 1.");
		lblStep.setBounds(61, 67, 70, 15);
		contentPane.add(lblStep);

		JLabel lblStep_1 = new JLabel("Step 2.");
		lblStep_1.setBounds(61, 126, 70, 15);
		contentPane.add(lblStep_1);

		JLabel lblStep_2 = new JLabel("Step 3.");
		lblStep_2.setBounds(61, 187, 70, 15);
		contentPane.add(lblStep_2);

		Vector combomodel = new Vector();

		list1 = new ArrayList<>();
		try {
			list1 = CommonMethods.getBatches();
			for (String name : list1) {
				combomodel.addElement(name);

			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JComboBox comboBox = new JComboBox(combomodel);
		comboBox.setBounds(179, 121, 162, 24);

		list2 = new ArrayList<>();
		try {
			
			System.out.println((String) comboBox.getSelectedItem());
			list2 = CommonMethods.getEmails((String) comboBox.getSelectedItem());
			
		
			System.out.println(list2.size());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		JButton btnSendEmail = new JButton("Send Email");
		btnSendEmail.addActionListener(new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent e) {
				if(fileName!=null&&list2!=null)
				new SendEmail(fileName, list2);
				else
				{	JOptionPane.showMessageDialog(null, "Empty Fields");
				frame.setVisible(false);
				}
				}
				

			
		});
		btnSendEmail.setBounds(180, 187, 117, 25);
		contentPane.add(btnSendEmail);

		contentPane.add(comboBox);

		frame.setVisible(true);

	}
}
