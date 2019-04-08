
public class labeledJar extends jarType {
	
	private String label;
	/** Builds the constructor for the class when called*
	 * 
	 * @param label this will the name of the label
	 * @param numUnits this is the number of labels
	 * 
	 */
	
	public labeledJar(int units, String input){
	   numUnits = units;
	   label=input;
     }

     /** Add to the jar. */
     /** Return how many units in the labeledJar. */

     private int numUnits;    // Data member
     
     /** Prints string that is the jarlabel*/
     public void displayLabel(){
		System.out.println(label);
     }
     
     /** Sets the string for the jar label*/
     public String setLabel(String input){
    	 return label=input;
     }

}
