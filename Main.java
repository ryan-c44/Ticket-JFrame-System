import javax.swing.JFrame;


public class Main {
	
	public static void main(String[] args) {
		TicketJFrame ticketJFrame = new TicketJFrame();
		ticketJFrame.setTitle("Ticket Management System");
		ticketJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		ticketJFrame.pack();
		ticketJFrame.setVisible(true);
	}
}
