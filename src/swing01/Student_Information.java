package swing01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Student_Information extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DefaultTableModel model;
	private int i=0;
	private JScrollPane scrollPane;
	private JPanel contentPane;
	private JTextField Stu_Name;
	private JTextField stu_subject;
	private JTextField Stu_class;
	private JTextField Stu_email;
	private JTable table;
	private JRadioButton male;
	private JRadioButton female;
	ButtonGroup group;
	private Vector<Student> list=new Vector<>();
	String column[] = {"Name","Subject","Class","Email","Gender" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_Information frame = new Student_Information();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Student_Information() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel mainHeading = new JLabel("Enter the Student Information");
		mainHeading.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblName = new JLabel("Name");
		
		Stu_Name = new JTextField();
		lblName.setLabelFor(Stu_Name);
		Stu_Name.setColumns(10);
		
		JLabel lblSubject = new JLabel("Subject");
		
		stu_subject = new JTextField();
		lblSubject.setLabelFor(stu_subject);
		stu_subject.setColumns(10);
		
		JLabel lblClass = new JLabel("Class");
		
		Stu_class = new JTextField();
		lblClass.setLabelFor(Stu_class);
		Stu_class.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		
		Stu_email = new JTextField();
		lblEmail.setLabelFor(Stu_email);
		Stu_email.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setForeground(Color.RED);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Student sObject = new Student();
				sObject.setName(Stu_Name.getText());
				sObject.setSubject(stu_subject.getText());
				sObject.setStu_class(Stu_class.getText());
				sObject.setEmail(Stu_email.getText());
				sObject.setGender( getSelectedButtonText(group));
				JOptionPane.showMessageDialog(null, sObject.getName()+" "
						+ sObject.getSubject()+" "+
						sObject.getStu_class()+" "+
						sObject.getEmail()+" ", "Student Information", 1);
				//sObject.setGender(st);
				list.add(sObject);
				Iterator<Student> itr = list.iterator();
				model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);// resets row count to 0 every time we hit submit
				while (itr.hasNext())
				{
				    Student s = itr.next();
					model.addRow(new Object[]{s.getName(),s.getSubject(),s.getStu_class(),s.getEmail(),s.getGender()});
				}
				//clear details
				Stu_Name.setText("");
				stu_subject.setText("");
				Stu_class.setText("");
				Stu_email.setText("");
				male.setSelected(false);
				female.setSelected(false);
			}
		});
		
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(Color.RED);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		male = new JRadioButton("Male");
		male.setBackground(SystemColor.controlHighlight);
		
		female = new JRadioButton("Female");
		female.setBackground(SystemColor.controlHighlight);
		
		group = new ButtonGroup();
		group.add(male);
		group.add(female);
		JLabel lblGender = new JLabel("Gender");
		
		scrollPane = new JScrollPane();
		table = new JTable();
		table.setBounds(244, 71, 474, 177);
		
	
		scrollPane.setRowHeaderView(table);
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		model.setColumnIdentifiers(column);

		table.getTableHeader().repaint();
		scrollPane.setViewportView(table);
		
		JButton btnFirst = new JButton("First");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i=0;
				//ListIterator<Student> itr = list.listIterator();
				Stu_Name.setText("");
				stu_subject.setText("");
				Stu_class.setText("");
				Stu_email.setText("");
				male.setSelected(false);
				female.setSelected(false);
			    if(!list.isEmpty())
			    {
			    	Student s= list.elementAt(0);
				System.out.println(s.getName());
				Stu_Name.setText(s.getName());
				stu_subject.setText(s.getSubject());
				Stu_class.setText(s.getStu_class());
				Stu_email.setText(s.getEmail());
				if(s.getGender().equals("Male"))
					male.setSelected(true);
				else
					female.setSelected(true);
				}
				else
					System.out.println("Record not found.");
			}
		});
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i++;
				Stu_Name.setText("");
				stu_subject.setText("");
				Stu_class.setText("");
				Stu_email.setText("");
				male.setSelected(false);
				female.setSelected(false);
			    if(!list.isEmpty())
			    {
			    	Student s= list.elementAt(i);
				System.out.println(s.getName());
				Stu_Name.setText(s.getName());
				stu_subject.setText(s.getSubject());
				Stu_class.setText(s.getStu_class());
				Stu_email.setText(s.getEmail());
				if(s.getGender().equals("Male"))
					male.setSelected(true);
				else
					female.setSelected(true);
				}
				else
					System.out.println("Record not found.");
			}
		});
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i--;
				Stu_Name.setText("");
				stu_subject.setText("");
				Stu_class.setText("");
				Stu_email.setText("");
				male.setSelected(false);
				female.setSelected(false);
			    if(!list.isEmpty())
			    {
			    	Student s= list.elementAt(i);
				System.out.println(s.getName());
				Stu_Name.setText(s.getName());
				stu_subject.setText(s.getSubject());
				Stu_class.setText(s.getStu_class());
				Stu_email.setText(s.getEmail());
				if(s.getGender().equals("Male"))
					male.setSelected(true);
				else
					female.setSelected(true);
				}
				else
					System.out.println("Record not found.");
			
			}
		});
		
		JButton btnLast = new JButton("Last");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i=list.size()-1;
				Stu_Name.setText("");
				stu_subject.setText("");
				Stu_class.setText("");
				Stu_email.setText("");
				male.setSelected(false);
				female.setSelected(false);
			    if(!list.isEmpty())
			    {
			    	Student s= list.lastElement();
				System.out.println(s.getName());
				Stu_Name.setText(s.getName());
				stu_subject.setText(s.getSubject());
				Stu_class.setText(s.getStu_class());
				Stu_email.setText(s.getEmail());
				if(s.getGender().equals("Male"))
					male.setSelected(true);
				else
					female.setSelected(true);
				}
				else
					System.out.println("Record not found.");
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(SystemColor.controlHighlight);
		panel.setForeground(Color.BLACK);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(67)
									.addComponent(Stu_Name, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
							.addGap(22)
							.addComponent(btnFirst, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addGap(82)
							.addComponent(btnPrevious, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(136))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(586)
							.addComponent(btnLast, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(41))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblSubject, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(67)
											.addComponent(stu_subject, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(67)
											.addComponent(Stu_class, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(67)
											.addComponent(male, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
											.addGap(4)
											.addComponent(female, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
											.addGap(12)
											.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)))
									.addGap(9))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addGap(154))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(Stu_email, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
									.addGap(22))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblClass, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addGap(154))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 4, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(155)
							.addComponent(mainHeading, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(173)
							.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(151)
							.addComponent(Stu_email, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(120)
							.addComponent(lblClass, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 108, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(39)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(54)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(Stu_Name, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnFirst)
								.addComponent(btnNext)
								.addComponent(btnPrevious)
								.addComponent(btnLast))
							.addGap(12)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(2)
											.addComponent(lblSubject, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
										.addComponent(stu_subject, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
									.addGap(10)
									.addComponent(Stu_class, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
									.addGap(8)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(male, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
										.addComponent(female, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnSubmit)
										.addComponent(btnExit))
									.addGap(11))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))))
					.addGap(0))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(mainHeading, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(212, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
}
