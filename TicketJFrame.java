import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TicketJFrame extends JFrame {
	
	private JPanel ticketPanel;
	private JPanel ticketTopPanel;
	private JPanel ticketButtonPanel;
	private JPanel ticketBottomPanel;
	private JTextField adultTicketTF;
	private JTextField childTicketTF;
	private JTextField totalPriceTF;
	private JButton calcTotal;
	
	public TicketJFrame() {
		initComponentGUI();
		initEventHandler();
	}
	
	private void initComponentGUI() {
		initTicketPanel();
		add(ticketPanel);
	}
	
	public void initTicketPanel() {
		ticketPanel = new JPanel();

		BorderLayout layout = new BorderLayout();
		ticketPanel.setLayout(layout);
		
		initTicketTopPanel();
		initTicketButtonPanel();
		initTicketBottomPanel();
		
		ticketPanel.add(ticketTopPanel, BorderLayout.NORTH);
		ticketPanel.add(ticketButtonPanel, BorderLayout.CENTER);
		ticketPanel.add(ticketBottomPanel, BorderLayout.SOUTH);
		
	}
	
	private void initTicketTopPanel() {
		ticketTopPanel = new JPanel();
		
		GridLayout layout = new GridLayout(0, 2);
		ticketTopPanel.setLayout(layout);
		
		initAdultTicketGUI();
		initChildTicketGUI();
		
	}
	
	private void initAdultTicketGUI() {
		ticketTopPanel.add(new JLabel("Enter the number of adult tickets: "));
		
		adultTicketTF = new JTextField(20);
		ticketTopPanel.add(adultTicketTF);
	}
	
	private void initChildTicketGUI() {
		ticketTopPanel.add(new JLabel("Enter the number of child tickets: "));
		
		childTicketTF = new JTextField(20);
		ticketTopPanel.add(childTicketTF);
	}
	
	
	private void initTicketButtonPanel() {
		ticketButtonPanel = new JPanel();
		
		FlowLayout layout = new FlowLayout();
		ticketButtonPanel.setLayout(layout);
		
		calcTotal = new JButton("Calculate Total Cost");
		ticketButtonPanel.add(calcTotal);
	}
	
	private void initTicketBottomPanel() {
		ticketBottomPanel = new JPanel();
		
		FlowLayout layout = new FlowLayout();
		ticketBottomPanel.setLayout(layout);
		
		ticketBottomPanel.add(new JLabel("Total price: "));
		
		totalPriceTF = new JTextField(20);
		ticketBottomPanel.add(totalPriceTF);
	}
	
	private void initEventHandler() {
		initCalcButtonHandler();
	}
	
	private void initCalcButtonHandler() {
		calcTotal.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int adultTicket = Integer.parseInt(adultTicketTF.getText()) * 50;
						int childTicket = Integer.parseInt(childTicketTF.getText()) * 25;
						
						if((childTicketTF.getText().equals(null) || adultTicketTF.getText().equals(null)) || (childTicketTF.getText().equals(null) && adultTicketTF.getText().equals(null))) {
							adultTicket = 0;
							childTicket = 0;
						}
						
						int total = adultTicket + childTicket; 
						totalPriceTF.setText(Integer.toString(total));
						
					}
				});
	}
}
