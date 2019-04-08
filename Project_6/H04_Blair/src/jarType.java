/* File: JarType.java */
/** A program to manipulate a few jars. 
*$LastChangedRevision: $
*$LastChangedDate: $
**/
/** JarType Class */

public class jarType {

	public jarType()     // Constructor
    {
	   numUnits = 0;
     }
	
	public jarType(int units){
		numUnits =units;
	}

     /** Add to the jar. */
     public void add(int n)
     {
         numUnits = numUnits + n;
     }

     public void emptyItOut()
     {
         numUnits = 0;
     }

     /** Return how many units in the jar. */
     public int quantity()
     {
         return numUnits;
     }
     
     @Override
     public boolean equals (Object jar){
    	 numUnits = ((jarType) jar).quantity();
    	 if (numUnits == ((jarType) jar).quantity()){
    		 return true;
    	 }
		return false;
     }

     private int numUnits;  
     
     // Data member
     @Override
     public String toString() {
    	 
         return Integer.toString(numUnits);
     }
     
     public void  showDetails(){
 		System.out.printf("%s%d.%n", "Number of Units ", numUnits);
 	}

}




