import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class SkanetrafikenGUI extends JFrame {
	
	

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JTextField textFieldFrom;
	private JTextField textFieldTo;
	private JTextArea textAreaResult;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SkanetrafikenGUI frame = new SkanetrafikenGUI();
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
	public SkanetrafikenGUI() {
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(6, 32, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(281, 18, 412, 167);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEnabled(false);
		scrollPane.setViewportView(textArea);
		
		JButton btnSk = new JButton("Sök");
		btnSk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new getStations().start();
	
				
			}
		});
		btnSk.setBounds(152, 32, 117, 29);
		contentPane.add(btnSk);
		
		textFieldFrom = new JTextField();
		textFieldFrom.setBounds(6, 222, 130, 26);
		contentPane.add(textFieldFrom);
		textFieldFrom.setColumns(10);
		
		textFieldTo = new JTextField();
		textFieldTo.setBounds(6, 280, 130, 26);
		contentPane.add(textFieldTo);
		textFieldTo.setColumns(10);
		
		JLabel lblFrn = new JLabel("Från:");
		lblFrn.setBounds(6, 204, 61, 16);
		contentPane.add(lblFrn);
		
		JLabel lblTill = new JLabel("Till:");
		lblTill.setBounds(6, 260, 61, 16);
		contentPane.add(lblTill);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(281, 204, 414, 121);
		contentPane.add(scrollPane_1);
		
		textAreaResult = new JTextArea();
		scrollPane_1.setViewportView(textAreaResult);
		textAreaResult.setEditable(false);
		
		JButton btnSkResa = new JButton("Sök resa");
		btnSkResa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new getJourney().start();
				
				
			}
		});
		btnSkResa.setBounds(152, 247, 117, 29);
		contentPane.add(btnSkResa);
		
	
	}
	
	public class getStations extends Thread {
		@Override
		public void run(){
			
			textArea.setText("");
			
			
			ArrayList<Station> searchStations = new ArrayList<Station>();
			
			
			// lägger till stationer i arraylistan som innehåller ordet "malm"
			searchStations.addAll(Parser.getStationsFromURL(textField.getText()));
			for (Station s: searchStations){
				System.out.println(s.getStationName() +" number:" +s.getStationNbr());
				textArea.append(s.getStationName() +" number:" +s.getStationNbr() + "\n");
				
				
			}
			
			
			
			
			
			
		}
		
		
		
	}
	
	public class getJourney extends Thread{
		@Override
		public void run(){
			
			textAreaResult.setText("searching...");
			
			String searchURL = Constants.getURL(textFieldFrom.getText(),textFieldTo.getText(),1);
			
			Journeys journeys = Parser.getJourneys(searchURL);
			
			textAreaResult.setText("");
			for (Journey journey : journeys.getJourneys()) {
				System.out.print(journey.getStartStation()+" - ");
				System.out.print(journey.getEndStation());
				String time = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)+":"+journey.getDepDateTime().get(Calendar.MINUTE);
				System.out.println(" Departs " + time +" that is in "+journey.getTimeToDeparture()+ " minutes. And it is "+journey.getDepTimeDeviation()+" min late");
				textAreaResult.append(" Departs " + journey.getStartStation() + " to go to " + journey.getEndStation() + " at " + time +", that is in "+journey.getTimeToDeparture()+ " minutes. And it is "+journey.getDepTimeDeviation()+" min late" + "\n");
			} 
			
			
			
			
		}
	}
}