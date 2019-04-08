import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.Serializable;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JFileChooser;


///////////////HW6////////////////////////
public class myJFrame extends JFrame  implements ActionListener, Serializable{
	int jarNum,jarNum1,jarNum2,requesting;
	String jarName,jarName1,jarName2,fileNam;
	Button b,r,c;
	JFrame frame;
	labeledJar jar,jar1,jar2;
	TextField label,label1,label2,num0,num1,num2,request,fileName;
	labeledJar[] shelf2 = new labeledJar[3];
	labeledJar[] result;
	JLabel requestedJar = new JLabel("Requested Jar");
	private static final long serialVersionUID = 1L;
	
	
	public void frame(){
		try {
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	    } catch (Exception evt) {}
		
		fileName = new TextField("File_Name");
		label = new TextField("Label[0]");
		label1 = new TextField("Labe[1]");
		label2 = new TextField("Label[2]");
		num0 = new TextField("###");
		num1 = new TextField("###");
		num2 = new TextField("###");
	   frame = new JFrame("Jars");
       frame.setSize(100,100);
       frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       frame.getContentPane().setLayout(new GridLayout(7,2,3,3));     
       frame.getContentPane().add(label);
       frame.getContentPane().add(num0);
       frame.getContentPane().add(label1);
       frame.getContentPane().add(num1);
       frame.getContentPane().add(label2);
       frame.getContentPane().add(num2);
       
       
       b = new Button("Save File");
       b.addActionListener(this);
       frame.add(b);       
       
       c = new Button("Load File");
       c.addActionListener(this);
       frame.add(c);

       r = new Button("Request Jar");
       r.addActionListener(this);
       frame.add(r);
       
       frame.getContentPane().add(fileName);
       
	   request = new TextField("Jar # Request");
       frame.getContentPane().add(request);
       frame.add(requestedJar);
               
       frame.pack();
       frame.setVisible(true);
    
       frame.addWindowListener(new java.awt.event.WindowAdapter() {
           @Override
           public void windowClosing(java.awt.event.WindowEvent windowEvent) {
               if (JOptionPane.showConfirmDialog(frame, 
                   "Exit?", "Exit?", 
                   JOptionPane.YES_NO_OPTION,
                   JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
               	frame.dispose();
               }
           }
       });  
       
       
     	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
	

		if (arg0.getActionCommand().equals("Save File")) {
			
			//if(pattern.matcher(num0.getText()) != null && pattern.matcher(num0.getText()) != null && pattern.matcher(num0.getText()) != null){
		
		   if(num0.getText().matches("\\D+")&&num1.getText().matches("\\D+")&&num2.getText().matches("\\D+")){
		    	
				try {
					requestedJar.setText("Invalid Assignment");
					throw new MyException("Need Number Input");
				} catch (MyException e) {
					e.printStackTrace();
				}
			}
		    else{
		    	jarNum = Integer.parseInt(num0.getText());
			    jarNum1 = Integer.parseInt(num1.getText());
			    jarNum2 = Integer.parseInt(num2.getText());
		    }
			
		   if(label.getText().matches("\\W+")&&label1.getText().matches("\\W+")&&label2.getText().matches("\\W+")){
				
				try {
					requestedJar.setText("Invalid Assignment");
					throw new MyException("No Special Characters");
				} catch (MyException e) {
					e.printStackTrace();
				}
			}
			
			else{
				
				fileNam = fileName.getText();
				jarName = label.getText();
			    jarName1 = label1.getText();
			    jarName2 = label2.getText();
				shelf2[0] = new labeledJar( jarNum, jarName);
				shelf2[1]= new labeledJar( jarNum1, jarName1);
				shelf2[2] = new labeledJar( jarNum2, jarName2); 
				
				try{
					FileOutputStream fout = new FileOutputStream(fileNam+".ser");
				    ObjectOutputStream oos = new ObjectOutputStream(fout);
					oos.writeObject(shelf2);
					oos.close();
					File f = new File("C:\\Desktop\\"+fileNam+".ser");
					if(f.exists() && !f.isDirectory()) { 
						if (JOptionPane.showConfirmDialog(frame, 
				                   "Repalace File?", "Replace File?", 
				                   JOptionPane.YES_NO_OPTION,
				                   JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
									requestedJar.setText("Rename File");
				               }
					}

				} catch (FileNotFoundException e) {
					
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		}
		
		if (arg0.getActionCommand().equals("Load File")) {
			
			fileNam = fileName.getText();
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			 int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		          File selectedFile = fileChooser.getSelectedFile();
		        
		         
			try{
				
				FileInputStream fis = new FileInputStream(selectedFile.getAbsolutePath());
				ObjectInputStream ois = new ObjectInputStream(fis);
				result = (labeledJar[]) ois.readObject();
				requestedJar.setText("File Loaded");
				ois.close();
			}
		 catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		   
		}
		}
		}
			
			if (arg0.getActionCommand().equals("Request Jar")) {
		    if (requesting >result.length){
				try {
					requestedJar.setText("Invalid Request");
					throw new MyException("Out of Bounds");

				} catch (MyException e) {
					e.printStackTrace();
				}
		    }
		    
		    else{
			requestedJar.setText("Jar["+requesting+"]: "+result[requesting].toString()+" has "+result[requesting].quantity()+" Units");
		    }
		}
    }	
}

