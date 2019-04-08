import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ColorPatch  extends JPanel{
	
	JApplet applet;
	Color selectedColor;
	/**
	 * this class was supposed to handle users clicking on colored tiles but i never got around to
	 * finishing it 
	 * 
	 * @param color input color form feel2Color class
	 * @param color2 decodes hex string to color type
	 */
	public ColorPatch(String color){
		setBorder(BorderFactory.createEtchedBorder());
		Color color2 = Color.decode(color);
		setBackground(color2);
		
		addMouseListener(new MouseAdapter(){
			public void MousePressed(MouseEvent e){
				selectedColor = JColorChooser.showDialog(
						ColorPatch.this,"Pick A Color", getBackground());
				System.out.println("Color Selected!");
				
				if(selectedColor == null){
					JOptionPane.showMessageDialog(ColorPatch.this, "ColorChooser Canceled");
				}
				
				else{
					setBackground(selectedColor);
					repaint();
					
					JOptionPane.showMessageDialog(ColorPatch.this, "Color Selected:"+selectedColor);
				}
													
			}
		});
	}
	  
}
