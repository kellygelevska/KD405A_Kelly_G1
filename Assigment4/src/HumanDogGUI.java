import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HumanDogGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldHuman;
	private JTextField textFieldDog;
	private JTextArea textAreaErro;
	private Human human; 
	private Dog dog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HumanDogGUI frame = new HumanDogGUI();
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
	public HumanDogGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		textFieldHuman = new JTextField();
		textFieldHuman.setBounds(50, 65, 140, 37);
		contentPane.add(textFieldHuman);
		textFieldHuman.setColumns(10);
		
		textFieldDog = new JTextField();
		textFieldDog.setBounds(50, 114, 140, 37);
		contentPane.add(textFieldDog);
		textFieldDog.setColumns(10);
		
		JTextArea textAreaGetInfo = new JTextArea();
		textAreaGetInfo.setBounds(36, 182, 294, 39);
		contentPane.add(textAreaGetInfo);
		
		JTextArea textAreaErroM = new JTextArea();
		textAreaErroM.setBounds(36, 233, 294, 39);
		contentPane.add(textAreaErroM);
		
		
		
		JButton btnHuman = new JButton("Human");
		btnHuman.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnHuman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldHuman.getText().length() < 3) {
					textAreaErroM.setText("Saknas bokstäver i human");
					textFieldHuman.setText("");
				} else {
					human = new Human(textFieldHuman.getText());
					textAreaErroM.setText("");
				}
			}
		});
		btnHuman.setBounds(219, 66, 128, 37);
		contentPane.add(btnHuman);
		
		JButton btnDog = new JButton("Buy Dog");
		btnDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldHuman.getText().length() < 3) {
					textAreaErroM.setText("Det saknas en ägare");
					textFieldDog.setText("");
				} else {
					dog = new Dog(textFieldDog.getText());
					human.buyDog(dog);
					textAreaErroM.setText("");
				}
			}
		});
		btnDog.setBounds(219, 115, 128, 37);
		contentPane.add(btnDog);
		
		JButton btnPrintInfo = new JButton("Print info");
		btnPrintInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaGetInfo.setText(human.getInfo());
			}
		});
		btnPrintInfo.setBounds(342, 177, 88, 29);
		contentPane.add(btnPrintInfo);
	
	
		
		JLabel lblPuppyLove = new JLabel("Humans and Dogs");
		lblPuppyLove.setFont(new Font("Avenir", Font.PLAIN, 21));
		lblPuppyLove.setBounds(142, 6, 175, 29);
		contentPane.add(lblPuppyLove);
	}
}