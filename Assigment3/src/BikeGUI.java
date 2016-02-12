import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BikeGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldColor;
	private JTextField textFieldSize;
	private JTextField textFieldPrice;
	
	BikeStore bikeStore = new BikeStore();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BikeGUI frame = new BikeGUI();
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
	public BikeGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(26, 68, 218, 167);
		contentPane.add(textArea);
		
		textFieldColor = new JTextField();
		textFieldColor.setBounds(289, 53, 130, 26);
		contentPane.add(textFieldColor);
		textFieldColor.setColumns(10);
		
		textFieldSize = new JTextField();
		textFieldSize.setBounds(289, 108, 130, 26);
		contentPane.add(textFieldSize);
		textFieldSize.setColumns(10);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(289, 166, 130, 26);
		contentPane.add(textFieldPrice);
		textFieldPrice.setColumns(10);
		
		JButton btnAddBike = new JButton("Add Bike");
		btnAddBike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int size;
				int price;
				try{
				size = Integer.parseInt(textFieldSize.getText());
				price = Integer.parseInt(textFieldPrice.getText());
				bikeStore.addBike(textFieldColor.getText(), size, price);
				textArea.setText(bikeStore.getAllBikes());
				} catch (NumberFormatException e2) {
					System.out.println(e2);
				}
			}
		});
		btnAddBike.setBounds(302, 221, 117, 29);
		contentPane.add(btnAddBike);
		
		JLabel lblBikeStore = new JLabel("Bike Store");
		lblBikeStore.setBounds(30, 40, 80, 16);
		contentPane.add(lblBikeStore);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(289, 40, 61, 16);
		contentPane.add(lblColor);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setBounds(289, 91, 61, 16);
		contentPane.add(lblSize);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(289, 149, 61, 16);
		contentPane.add(lblPrice);
	}
}
