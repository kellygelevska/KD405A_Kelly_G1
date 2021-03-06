package uppgift1;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;

public class CalculaterGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	private Calculator myCalculator;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 try {
		    	UIManager.setLookAndFeel(new MetalLookAndFeel());
		    	
		 }
		    	
		    catch(Exception e) {}								
		 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculaterGUI frame = new CalculaterGUI();
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
	public CalculaterGUI() {
		setTitle("Min första miniräknare");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 455);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		myCalculator = new Calculator();
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 40));
		textField.setBounds(6, 12, 375, 78);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAddera = new JButton("1");
		btnAddera.setBackground(UIManager.getColor("textInactiveText"));
		btnAddera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCalculator.numberButtonPressed(1);
				textField.setText("1");
			}
		});
		btnAddera.setBounds(6, 111, 117, 29);
		contentPane.add(btnAddera);
		
		JButton btnSubtrera = new JButton("3");
		btnSubtrera.setBackground(UIManager.getColor("info"));
		btnSubtrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCalculator.numberButtonPressed(3);
				textField.setText("3");
			}
		});
		btnSubtrera.setBounds(264, 111, 117, 29);
		contentPane.add(btnSubtrera);
		
		JButton btnMultiplicera = new JButton("2");
		btnMultiplicera.setBackground(UIManager.getColor("TabbedPane.shadow"));
		btnMultiplicera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCalculator.numberButtonPressed(2);
				textField.setText("2");
			}
		});
		btnMultiplicera.setBounds(135, 111, 117, 29);
		contentPane.add(btnMultiplicera);
		
		JButton btnNewEqual = new JButton("=");
		btnNewEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCalculator.equals();
				textField.setText(String.valueOf(myCalculator.getResult()));
			}
		});
		btnNewEqual.setBounds(135, 320, 246, 67);
		contentPane.add(btnNewEqual);
		
		JButton btnClear = new JButton("4");
		btnClear.setForeground(UIManager.getColor("Table.foreground"));
		btnClear.setBackground(UIManager.getColor("inactiveCaption"));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCalculator.numberButtonPressed(4);
				textField.setText("4");
			}
		});
		btnClear.setBounds(6, 152, 117, 29);
		contentPane.add(btnClear);
		
		JButton button = new JButton("5");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCalculator.numberButtonPressed(5);
				textField.setText("5");
			}
		});
		button.setForeground(UIManager.getColor("Button.foreground"));
		button.setBackground(UIManager.getColor("textInactiveText"));
		button.setBounds(135, 152, 117, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("6");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCalculator.numberButtonPressed(6);
				textField.setText("6");
			}
		});
		button_1.setForeground(UIManager.getColor("Button.foreground"));
		button_1.setBackground(UIManager.getColor("textInactiveText"));
		button_1.setBounds(264, 152, 117, 29);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("7");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCalculator.numberButtonPressed(7);
				textField.setText("7");
			}
		});
		button_2.setForeground(UIManager.getColor("Button.foreground"));
		button_2.setBackground(UIManager.getColor("textInactiveText"));
		button_2.setBounds(6, 193, 117, 29);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("8");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCalculator.numberButtonPressed(8);
				textField.setText("8");
			}
		});
		button_3.setForeground(UIManager.getColor("Button.foreground"));
		button_3.setBackground(UIManager.getColor("textInactiveText"));
		button_3.setBounds(135, 193, 117, 29);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("9");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCalculator.numberButtonPressed(9);
				textField.setText("9");
			}
		});
		button_4.setForeground(UIManager.getColor("Button.foreground"));
		button_4.setBackground(UIManager.getColor("textInactiveText"));
		button_4.setBounds(264, 193, 117, 29);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("+");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCalculator.plus();
				textField.setText("+");
			}
		});
		button_5.setForeground(UIManager.getColor("Button.foreground"));
		button_5.setBackground(UIManager.getColor("textInactiveText"));
		button_5.setBounds(6, 259, 117, 29);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("-");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("-");
				myCalculator.minus();
			}
		});
		button_6.setForeground(UIManager.getColor("Button.foreground"));
		button_6.setBackground(UIManager.getColor("textInactiveText"));
		button_6.setBounds(135, 261, 117, 29);
		contentPane.add(button_6);
		
		JButton btnRensa = new JButton("Rensa");
		btnRensa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				myCalculator.clear();
			}
		});
		btnRensa.setForeground(UIManager.getColor("Button.foreground"));
		btnRensa.setBackground(UIManager.getColor("textInactiveText"));
		btnRensa.setBounds(264, 261, 117, 29);
		contentPane.add(btnRensa);

		

	
	}
}
