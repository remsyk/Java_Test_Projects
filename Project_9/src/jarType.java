/* File: JarType.java */
/** A program to manipulate a few jars. 
*$LastChangedRevision: $
*$LastChangedDate: $
**/
/** JarType Class */


public class jarType implements Comparable<jarType> {

	public jarType()     // Constructor
    {
	   numUnits = 0;
     }
	
	public jarType(int units){
		numUnits =units;
	}

     /** Add to the jar. */
	/////////////////HW5/////////////////////////
     public void add(int n){
    	 
    	 if (n < 0) {
     	    throw new IllegalArgumentException("No Negative Input");
     	}
    	 else{
    	 
         numUnits = numUnits + n;
    	 }
        
     }
     
     public void sub(int n) {
        if (n < 0) {
        	try {
				throw new MyException("No Negative Input");
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
     	}
    	 else{
    	 
         numUnits = numUnits - n;
    	 }
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

     public int numUnits;  
     
     // Data member
     @Override
     public String toString() {
    	 
         return Integer.toString(numUnits);
     }
     
     public void  showDetails(){
    	 System.out.printf("%s%d.%n","Number of Units ",numUnits);
 	}
     
     @Override
     public int hashCode(){
     return Integer.hashCode(numUnits);
     }
     
     @Override
 	public int compareTo(jarType shelf3) {
    	 
 		return this.numUnits - shelf3.quantity();
 	}

}




