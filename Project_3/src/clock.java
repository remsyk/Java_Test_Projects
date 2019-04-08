import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
/** This program will show three different time zones on a JFrame and allow the user to stop and start the times
*$LastChangedRevision: $
*$LastChangedDate: $
*@author  Scott Blair
*@version 1.0
*@since   2017-5-5
*
**/
public class clock extends JPanel implements Runnable {
	//
	String zoneID, zoneName;
	Button suspend, resume;
	JPanel myPanel;
	JFrame frame;
	JLabel myLabel = new JLabel();
	//There should be at least three separate threads. Each thread is responsible to manage the time of a different time zone. 
	Thread thread = null;
	Calendar cal = new GregorianCalendar();
	DateFormat fmt = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.US);
	TimeZone timez;
	

	public clock(String zoneName, String zoneID) {
		this.zoneID = zoneID;
		this.zoneName = zoneName;
	}
	
	/**
	 * @param myPanel this the the main panel that will hold the updating time
	 * @param resume this button will resume the timer
	 * @param suspend this button will stop the time
	 * @param thread this is the thread for updating the time 
	 * @return myPanel is returned to be placed inside of the myFrame
	 */
	public JPanel panel() {
		myPanel = new JPanel();
		resume = new Button("Resume");
		suspend = new Button("Suspend");
		
		//otherwise, the background color should be green. 
		myPanel.setBackground(Color.GREEN);

		myPanel.add(myLabel);
		myPanel.add(resume);
		myPanel.add(suspend);
		this.start();
		//Each display must be labeled appropriately and should be individually controlled by a pair of Suspend and Resume buttons. 
		resume.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//changes panel background color
				myPanel.setBackground(Color.GREEN);
				//starts time back up
				//When the Resume button is pressed, the time begins displaying the current time in the appropriate time zone.
				start();
				
			}
		});
		//action listener for suspend button
		suspend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//changes panel background color
				//When a display is suspended, its background color should be red
				myPanel.setBackground(Color.RED);
				//stops time
				stop();
			}
		});
		return myPanel;
	}
	//start time 
	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}
	//stops time
	public void stop() {
		thread = null;
	}
	//updates time
	public void run() {
		while (thread != null) {
			try {
				//intervals update
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			//creates new date and time request for every update
			cal = new GregorianCalendar();
			timez = TimeZone.getTimeZone(this.zoneID);
			fmt.setTimeZone(timez);
			//updates  time on the JFrame
			myLabel.setText("Local Time " + this.zoneName + ": " + fmt.format(cal.getTime()));
		}
		thread = null;
	}
	
	/**
	 * Write a multithreaded, GUI based, Java application to control the display of the current time in three different U.S. time zones, EST, CST, and PST. 
	 * @param EST_clock class being created for easter time
	 * @param CST_clock class being created for central time
	 * @param PST_clock class being created for pacific time
	 * @param frame is the main frame for the project
	 * @param args
	 */
	public static void main(String[] args) {
		
		clock EST_clock = new clock("EST", "EST5EDT");
		clock CST_clock = new clock("CST", "CST6CDT");
		clock PST_clock = new clock("PST", "PST8PDT");
		JFrame frame;

		//sets specifics of frame
		frame = new JFrame("TimeZones");
		frame.setSize(500, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
		
		//adds clock panels to frame
		frame.getContentPane().add(EST_clock.panel());
		frame.getContentPane().add(CST_clock.panel());
		frame.getContentPane().add(PST_clock.panel());
		
		//sets content to visible
		frame.setVisible(true);
		
		//starts timers
		EST_clock.start();
		CST_clock.start();
		PST_clock.start();
	}
}
