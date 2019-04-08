/** A program to manipulate a few jars. 
*$LastChangedRevision: $
*$LastChangedDate: $
**/
public class labeledJar extends jarType {
	
	private String label;
	/** Builds the constructor for the class when called*
	 * 
	 * @param label this will the name of the label
	 * @param numUnits this is the number of labels
	 * 
	 */
	
	public labeledJar(int units, String input){
	   label=input;
     }
     
     public void displayLabel(){
		System.out.println(label);
     }
     
     /** Sets the string for the jar label*/
     public String setLabel(String input){
    	 return label=input;
     }

}
