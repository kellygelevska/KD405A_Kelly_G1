import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Line;
import se.mah.k3lara.skaneAPI.model.Lines;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class SkanetrafikenGUI extends JFrame {
	
	ArrayList<Station> searchStations = new ArrayList<Station>();


	private JPanel contentPane;
	private JTextField textFieldStation;
	private JTextField textFieldFra;
	private JTextField textFieldTil;

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
		setBounds(100, 100, 667, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 46, 286, 124);
		contentPane.add(scrollPane);
		
		final JTextArea resultTextArea = new JTextArea();
		scrollPane.setViewportView(resultTextArea);
		
		textFieldStation = new JTextField();
		textFieldStation.setBounds(29, 196, 130, 26);
		contentPane.add(textFieldStation);
		textFieldStation.setColumns(10);
		
		JButton searchStation = new JButton("Søk");
		searchStation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultTextArea.setText("søker...");
				resultTextArea.setText(" ");

				searchStations.addAll(Parser.getStationsFromURL(textFieldStation.getText()));
				for (Station s: searchStations){
					
					resultTextArea.append(s.getStationName() +" number:" +s.getStationNbr() + "\n");
				}
				
			}
		});
		searchStation.setBounds(197, 196, 117, 29);
		contentPane.add(searchStation);
		
		JLabel label = new JLabel("4.");
		label.setBounds(28, 6, 61, 16);
		contentPane.add(label);
		
		textFieldFra = new JTextField();
		textFieldFra.setBounds(39, 271, 130, 26);
		contentPane.add(textFieldFra);
		textFieldFra.setColumns(10);
		
		textFieldTil = new JTextField();
		textFieldTil.setBounds(213, 271, 130, 26);
		contentPane.add(textFieldTil);
		textFieldTil.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(39, 327, 416, 140);
		contentPane.add(scrollPane_1);
		
		final JTextArea textAreaReise = new JTextArea();
		scrollPane_1.setViewportView(textAreaReise);
		
		JButton sokResaButton = new JButton("søk resa");
		sokResaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String searchURL = Constants.getURL(textFieldFra.getText(),textFieldTil.getText(),1);
				
				
				textAreaReise.append("søker.." + "\n");
				Journeys journeys = Parser.getJourneys(searchURL);
				for (Journey journey : journeys.getJourneys()) {
					textAreaReise.setText("søker...");
					String time = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)+":"+journey.getDepDateTime().get(Calendar.MINUTE);

					textAreaReise.setText(journey.getStartStation()+" - " + journey.getEndStation() + " Departs " + time +" that is in "+journey.getTimeToDeparture()+ " minutes. And it is "+journey.getDepTimeDeviation()+" min late" + "\n");
					
				
				}
			}
				
		});
		sokResaButton.setBounds(376, 271, 117, 29);
		contentPane.add(sokResaButton);
		
		JLabel label_1 = new JLabel("5.");
		label_1.setBounds(39, 237, 61, 16);
		contentPane.add(label_1);
		
		JLabel lblFra = new JLabel("fra");
		lblFra.setBounds(49, 255, 61, 16);
		contentPane.add(lblFra);
		
		JLabel lblTil = new JLabel("til");
		lblTil.setBounds(232, 255, 61, 16);
		contentPane.add(lblTil);
		
		JLabel lblNewLabel = new JLabel("Stasjon");
		lblNewLabel.setBounds(38, 178, 61, 16);
		contentPane.add(lblNewLabel);
		
		
	}
	}
