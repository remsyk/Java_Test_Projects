/* File: MyProg.java */

/** A program to manipulate a few jars. 
*$LastChangedRevision: $
*$LastChangedDate: $
**/
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class myProg{

	public static void main(String[] args){
        jarType jar1 = new jarType();   // Create a jar
        jarType jar2 = new jarType();   // Create another jar

        jar1.add(10);
        jar2.add(20);

        System.out.println("Jar1 contains " + jar1.quantity() + " units");
        System.out.println("Jar2 contains " + jar2.quantity() + " units");

        jar1.emptyItOut();
        System.out.println("Now Jar1 contains " + jar1.quantity() + " unit");
        
        
        jarType jar3 = new jarType(25);  // Prefill the jar
        
        labeledJar l1 = new labeledJar(0,"");
        l1.add( 30 );
        l1.displayLabel();
		labeledJar l2 = new labeledJar( 50,"" );
		System.out.println( l1.quantity() );

        labeledJar l3 = new labeledJar(0, "Pills" );
        l3.displayLabel();
        l3.setLabel ( "Nails" );
        l3.displayLabel();
        
       
        labeledJar l4 = new labeledJar( 20, "Pickles" );
        System.out.println( l4.quantity() );
        l4.displayLabel();
        
        ////////////////HW 3/////////////////////////////
        jarType[] shelf = new jarType[10];
        Random rand = new Random();

        
        for (int i = 0; i < shelf.length; i++){
        	shelf[i] = new jarType(rand.nextInt(11)+i);
        	System.out.println("jar " + i + " has " + shelf[i].quantity() + " units");
        	
    	}
        
        /////////////HW 4/////////////////////////
        labeledJar l21 = new labeledJar( 50 );
        System.out.println( l21.quantity() );
        System.out.println( jar1 );
        System.out.println( l1 );
        
        if ( jar1.equals(jar2) ) { 
        	System.out.println ("jar1 and jar2 are equal"); 
        	}

        if ( jar1.equals(jar1) ) { 
        	System.out.println ("jar1 and jar1 are equal"); 
        	}
        
        for ( int i = 0; i < shelf.length; i++ ){
        	shelf[i] = new jarType(rand.nextInt(11)+i);
            shelf[i].showDetails();
        }
        
        ////////////////HW7/////////////////////
        jarType[] shelf3 = new jarType[50];
        for ( int i = 0; i < shelf3.length; i++ ){
        	shelf3[i] = new jarType(rand.nextInt(9)+i);
        	//shelf3[i].compareTo(shelf[i]);
            shelf3[i].showDetails();
            
            //THESE ARE MY ATTEMPTS FOR HW 7///////////////////////
            //(shelf3) -> System.out.println(shelf3);
            //Arrays.stream(shelf3[i].quantity()).forEach(num -> System.out.println(shelf2[i].quantity()));
        }
        
        Arrays.sort(shelf3);

       
       jar1.sub(10);
       jar1.sub( -5 );
       
       
        
 	  myJFrame frame = new myJFrame();
 	  frame.frame();

       
    }
}
