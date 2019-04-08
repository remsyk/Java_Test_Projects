/* File: JarType.java */

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

     private int numUnits;    // Data member

}




