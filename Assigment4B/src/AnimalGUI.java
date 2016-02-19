import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;

public class AnimalGUI extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnimalGUI frame = new AnimalGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AnimalGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setForeground(new Color(169, 169, 169));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAnimals = new JLabel("Animallist");
		lblAnimals.setFont(new Font("Avenir", Font.PLAIN, 15));
		lblAnimals.setForeground(new Color(0, 0, 0));
		lblAnimals.setBounds(180, 6, 89, 12);
		contentPane.add(lblAnimals);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 30, 438, 242);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		ArrayList <Animal> myAnimals = new ArrayList<Animal>();
		myAnimals.add(new Dog("Dogus", 4, false, "maja"));
		myAnimals.add(new Cat("kaktus", 5, 10));
		myAnimals.add(new Snake("Lynx Lynx", true));
		myAnimals.add(new Dog("Pumbus", 3, true, "Frigo"));
		myAnimals.add(new Cat("kaktus the cat", 5, 35));
		myAnimals.add(new Snake("snikus", false));
		
		
		for(Animal anAnimal : myAnimals) {
			textArea.setText(textArea.getText() + anAnimal.getInfo() + "\n");
		}	
	}
}