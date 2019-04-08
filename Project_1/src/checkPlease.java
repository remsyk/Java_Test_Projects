/** A program to manipulate a few jars. 
*$LastChangedRevision: $
*$LastChangedDate: $
**/

import java.util.Scanner;
import java.time.ZonedDateTime;
import java.util.InputMismatchException;
import java.text.*;

public class checkPlease {
	static double a;
	static String aa;
	static String aaa;
	static String p; 
	static String f;
	static String[] nums= {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ","Ten ","Eleven ", "Twelve ", "Thirteen ","Fourteen ",
			"Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen ","Twenty ", "Thirty ", "Fourty ","Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety ", "Hundred ", "Thousand ", "Cents "};

	static public String commaFormat(double value ) {
	      DecimalFormat form = new DecimalFormat("$###,###.###");
	      String output = form.format(value);
	      return output;
	   }
	
	static public String wordFormat (double value ) {
		int th;
		int tnn;
		int hu;
		int te;
		int on;
		String words="";
		
		
		if(value>999){
			th  = (int) Math.round(value / 1000);
			if (th==value){
				th=0;
			}
			hu = (int) Math.round (value % 1000);
			hu=hu/100;
			te = (int) Math.round(value % 1000);
			te= te % 100;
			if (te==value){
				te=0;
			}
			
			on = (int) Math.round(value % 10);
			if(th>19){
				th=th-on;
			}
			
			
			if(te>19){
				te=te-on;
			}
			if (te>10&&te<20){
				on=0;
			}
			if(te<10){
				te=0;
			}
			words= nums[th]+nums[29]+nums[hu]+ nums[28] +nums[te]+nums[on];
		}
		
		
		if(value>99 && value<1000){
			hu = (int) Math.round (value / 100);
			te = (int) Math.round(value % 100);
			if (te==value){
				te=0;
			}
			
			on = (int) Math.round(value % 10);
			if(te>19){
				te=te-on;
			}
			if (te>10&&te<20){
				on=0;
			}
			if(te<10){
				te=0;
			}
			words= nums[hu]+ nums[28] +nums[te]+nums[on];
		}
		
		
		if(value>9 & value<100){
			te = (int) Math.round(value);
			
			on = (int) Math.round(value % 10);
			if(te>19){
				te=te-on;
			}
			if (te>10&&te<20){
				on=0;
			}
			if(te<10){
				te=0;
			}
			words= nums[te]+nums[on];
		}
		if(value <10){
			on = (int) Math.round(value);
			words= nums[on];

		}
		
		return words;
	}
	
	public static void main(String[] args){
		while (true){
			try{
				
				Scanner sc = new Scanner(System.in);
				Scanner ic = new Scanner(System.in);
	
				
				System.out.printf("Pay To Order Of: ");
			    p = sc.nextLine();
			     
				System.out.printf("Amount: ");
			    a = ic.nextDouble();
			    aa=commaFormat(a);
			    aaa=wordFormat(a);
			    
			     
			    System.out.printf("For: ");
				f = sc.nextLine();
				
			    ZonedDateTime currentTime = ZonedDateTime.now();
			    System.out.printf("......Here Is Your Check......\n");
				System.out.printf("Date:[%tD]%n",currentTime);
			    System.out.printf("Pay To Order Of: ["+p+"]"
			    					+ "\nAmount: ["+aaa+"] ["+aa+"]"
			    					+"\nFor: ["+f+"]");
			}
						
			catch(InputMismatchException e){
				System.out.printf("Invalid Input!\n");
				continue;
			}
			break;
		}
	}
}