

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JColorChooser;
/** This program will take what you are feeling to a limited extent and return a color based off that feeling
*$LastChangedRevision: $
*$LastChangedDate: $
*@author  Scott Blair
*@version 1.0
*@since   2017-4-11
*
**/
public class src extends JFrame implements ActionListener, Serializable {
	public static void main(String[] args) {
		src src = new src();
		src.frame1();
		
		//singleton class example
		 frameLoaded object = frameLoaded.getInstance();
	     object.message();

	}

	String usersName, userEntry, colorF, logS, line;
	Button save, clear;
	JFrame frame;
	JPanel colorChange, colorPane, colorPane2, enter, set;
	JTextField userName;
	JTextArea entry, entry2;
	JRadioButton backgroundColor, colorPaneColor, foreground;
	ColorPatch colorPatch;
	BufferedReader br;
	BufferedWriter bw;
	List<String[]> logOut = new ArrayList<String[]>();
	List<String[]> logIn2 = new ArrayList<String[]>();
	Action saveAction;
	Feel2Color feel2Color;
	private static final long serialVersionUID = 1L;
	JLabel info = new JLabel("New or Existing Username & Press Enter (Optional)");
	JScrollPane scroll;
	File file = new File("log.csv");
	String[] logIn, p;
	int[] ind;
/**
 *  frame1 first instance of the JFrame
 * @param enter is JPanel for user to enter username
 * @param userName JtextField where user inputs username
 * @param frame main JFrame
 * @param colorPane the color tile array that represents user generate colors
 * @param entry2 JTextAre where user types what they are feeling
 * @param br reads in log file
 * @param line buffered file in stream as string
 * @param logIn conversion of input stream to array
 * @param bw writes data to log
 * @param logS temp String that contains each index of logIn[] so it can be split 
 * @param p temp string[] that contains split of logS
 * @param logIn2 ArrayList that will contain all of the log data
 * @exception NullPointerException thrown when there is no existing file or user data 			 
 * @param userEntry this will be the journal entry user puts
 * @param feel2Color class that handles converting words to colors
 * @param usersName this is entered username
 * @param logOut ArrayList of string[] that is output to file
 * @return returns nothing
 */
	
	
	
	public void frame1() {

		try {
			
			br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {
				logIn = line.split("(\\|)");
			}

			if (br.readLine() == null) {
				br.close();
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e3) {
			e3.printStackTrace();
		}

		try {
			
			bw = new BufferedWriter(new FileWriter(file, true));

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e3) {
			e3.printStackTrace();
		}
		try {

			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception evt) {
		}

		
		enter = new JPanel();
		userName = new JTextField("Username");
		frame = new JFrame("Diary in Color");
		colorPane = new JPanel();
		entry2 = new JTextArea("Type Here (Press CTRL+ W to Save)");
		scroll = new JScrollPane(entry2);

		entry2.setWrapStyleWord(true);

		colorPane.setBorder(BorderFactory.createTitledBorder(""));
		colorPane.setLayout(new WrapLayout());

		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

		enter.add(userName);
		enter.add(info);
		enter.setLayout(new WrapLayout());

		frame.add(colorPane);
		frame.getContentPane().add(scroll);
		frame.getContentPane().add(enter);
		frame.setVisible(true);
		
		try {
			
			for (int i = 0; i < logIn.length; i++) {

				logS = logIn[i];
				p = logS.split(",");
				logIn2.add(new String[] { p[0], p[1], p[2], p[3] });
				colorPane.add(new ColorPatch(logIn2.get(i)[0]));

			}
			
		} catch (NullPointerException  e) {
			 System.out.println("Lazy Exception: Entries in Log");	
		}

		
		userName.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e13) {
				String date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
				userEntry = entry2.getText();
				feel2Color = new Feel2Color();
				usersName = userName.getText();

				if (userEntry.contains("Saved") || userEntry.contains("Type Here (Press CTRL+ W to Save)")
						|| userEntry.equals("")) {
					entry2.remove(rootPane);
					frame2();
				} else {
					
					logOut.add(new String[] { feel2Color.wordColor(userEntry), ",", date, ",", userEntry, ",",
							usersName, "|" });
					
					colorPane.add(new ColorPatch(logOut.get(logOut.size() - 1)[0]));


					try {
			
						for (int i = 0; i < 8; i++) {

							bw.append(logOut.get(logOut.size() - 1)[i]);
						}
						bw.close();
						frame2();

					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e3) {
						e3.printStackTrace();
					}

				}
			}
		});

		saveAction = new AbstractAction("Save") {
			@Override
			public void actionPerformed(ActionEvent e13) {
				String date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
				userEntry = entry2.getText();
				feel2Color = new Feel2Color();

				if (userEntry.contains("Saved") || userEntry.contains("Type Here (Press CTRL+ W to Save)")
						|| userEntry.equals("")) {
					info.setText("No Valid Input");
				} else {

					entry2.setText("Saved");
					

					logOut.add(new String[] {feel2Color.wordColor(userEntry), ",", date, ",", userEntry, ",",
							usersName, "|" });

					colorPane.add(new ColorPatch(logOut.get(logOut.size() - 1)[0]));

					try {

						for (int i = 0; i < 8; i++) {
							bw.append(logOut.get(logOut.size() - 1)[i]);

						}
						colorPane.revalidate();
						colorPane.repaint();

					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e3) {
						e3.printStackTrace();
					}

				}
			}
		};

		entry2.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK), "doSomething");
		entry2.getActionMap().put("doSomething", saveAction);

		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				if (JOptionPane.showConfirmDialog(frame, "Exit?", "Exit?", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					frame.dispose();

					try {
						bw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		});

	}
	/**
	 * frame2 this is the second instance of the frame but is the same frame no new frame is drawn panels are simply made invisible 
	 * @param entry JTextArea where user will input their feelings
	 * @param white button that changes background to white
	 * @param gray button that changes background to gray
	 * @param prink button that changes background to pink
	 * @param clear button that clears text area
	 * @param save button that saves users entry
	 * @param set JPanel that contain all the buttons
	 * @colorPane2 JPanel that contains all user generated colors
	 * @returns nothing
	 */
	public void frame2() {
		
		entry = new JTextArea("Type Here");
		backgroundColor = new JRadioButton("BackgroundColor");
		colorPaneColor = new JRadioButton("ColorPaneColor");
		foreground = new JRadioButton("TextAreaColor");
		colorChange = new JPanel();
		save = new Button("Save");
		clear = new Button("Clear");
		set = new JPanel();
		colorPane2 = new JPanel();

		try {
			bw = new BufferedWriter(new FileWriter(file, true));

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e3) {
			e3.printStackTrace();
		}

		entry.setWrapStyleWord(true);

		set.setOpaque(false);

		colorPane2.setOpaque(false);
		colorPane2.setBorder(BorderFactory.createTitledBorder(""));
		colorPane2.setLayout(new WrapLayout());

		entry2.setVisible(false);
		scroll.setVisible(false);
		enter.setVisible(false);

		save = new Button("Save");

		ButtonGroup group = new ButtonGroup();
		group.add(backgroundColor);
		group.add(colorPaneColor);
		group.add(foreground);

		set.add(save);
		set.add(clear);
		set.add(backgroundColor);
		set.add(colorPaneColor);
		set.add(foreground);

		frame.add(colorPane2);
		frame.getContentPane().add(new JScrollPane(entry));
		frame.getContentPane().add(set);
		
		try {
			for(int i=0; i<logIn2.size();i++){
				
				if(logIn2.get(i)[3].equals(usersName)){
					colorPane2.add(new ColorPatch(logIn2.get(i)[0]));

				}
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			 System.out.println("Lazy Exception");	
		}

		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e10) {
				entry.setText("Type Here");
			}
		});

		backgroundColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e11) {
				Color initialcolor=Color.white;    
				Color c = JColorChooser.showDialog(null, "Choose a Color", initialcolor);
				frame.getContentPane().setBackground(c);

			}
		});

		colorPaneColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e12) {	
				Color initialcolor=Color.white;    
				Color c = JColorChooser.showDialog(null, "Choose a Color", initialcolor);
				colorPane.setBackground(c);

			}
		});

		foreground.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e13) {
				Color initialcolor=Color.white;    
				Color c = JColorChooser.showDialog(null, "Choose a Color", initialcolor);
				entry.setBackground(c);
				
			}
		});

		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e13) {
				String date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
				userEntry = entry.getText();
				feel2Color = new Feel2Color();
				

				if (userEntry.contains("Saved") || userEntry.contains("Type Here") || userEntry.equals("")) {

				} else {
					entry.setText("Saved");

					

					logOut.add(new String[] { feel2Color.wordColor(userEntry), ",", date, ",", userEntry, ",",
							usersName, "|" });
					
					colorPane2.add(new ColorPatch(logOut.get(logOut.size() - 1)[0]));
					colorPane.add(new ColorPatch(logOut.get(logOut.size() - 1)[0]));

					try {

						for (int i = 0; i < 8; i++) {
							bw.append(logOut.get(logOut.size() - 1)[i]);

						}
						colorPane2.revalidate();
						colorPane2.repaint();

					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e3) {
						e3.printStackTrace();
					}

				}
			}
		});
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}


