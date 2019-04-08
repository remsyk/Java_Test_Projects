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
		int tyy;
		int h = 28;

		String words="";
		
		if(value>19000){
			tyy = (int)(value/1000);
			th  = tyy % 10;
			if(tyy>19){
				tyy = (int) Math.round(tyy/10);
				tyy+=18;
			}
			if (tyy==value){
				tyy=0;
			}
			if (th==value){
				th=0;
			}
			
			hu = (int) Math.round (value % 1000);
			hu=hu/100;
			if (hu == 0){
				h=0;
			}
			
					
			te = (int) Math.round(value % 1000);
			te= te % 100;
			if(te>19){
				te = (int) Math.round(te/10);
				te += 18;
			}
			if (te==value){
				te=0;
			}
			if (te>10&&te<20){
				on=0;
			}
			if(te<10){
				te=0;
			}
			
			on = (int) Math.round(value % 10);

			words= nums[tyy]+nums[th]+nums[29]+nums[hu]+ nums[h] +nums[te]+nums[on];
		}
		
			
		
		
		if(value>999 && value<20000){
			
			th  = (int)(value / 1000);
			if (th==value){
				th=0;
			}
			
			hu = (int) Math.round (value % 1000);
			hu=hu/100;			
			if (hu == 0){
				h=0;
			}
			
						
			te = (int) Math.round(value % 1000);
			te= te % 100;
			if(te>19){
				te = (int) Math.round(te/10);
				te += 18;
			}
			if (te==value){
				te=0;
			}
			if (te>10&&te<20){
				on=0;
			}
			if(te<10){
				te=0;
			}
			
			on = (int) Math.round(value % 10);

			words= nums[th]+nums[29]+nums[hu]+ nums[h] +nums[te]+nums[on];
		}
		
		
		if(value>99 && value<1000){
			hu = (int) (value / 100);
			
			te = (int) Math.round(value % 100);
			if (te==value){
				te=0;
			}
			if(te>19){
				te = (int) Math.round(te/10);
				te += 18;
			}
			if (te>10&&te<20){
				on=0;
			}
			if(te<10){
				te=0;
			}
			
			on = (int) Math.round(value % 10);

			words= nums[hu]+ nums[28] +nums[te]+nums[on];
		}
		
		
		if(value>9 & value<100){
			te = (int)(value);
			
			on = (int) Math.round(value % 10);
			if(te>19){
				te = (int) Math.round(value/10);
				te += 18;
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
			on = (int)(value);
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
			    System.out.printf("_________________________________________________________\n");
			    System.out.printf("|                                         "+"%tD %n",currentTime);
			    System.out.printf("|                                                        |\n"
			    				+ "|Pay To Order Of:__"+p+"__\n"
			    		        + "|                                               ["+aa+"]\n"
			    		        + "|Amount:__"+aaa+"_\n"
			    		        + "|                                                        |\n"
			    		        + "|For:__"+f+"__                   _________________\n"
			    		        + "|________________________________________________________|\n");
			}
						
			catch(InputMismatchException e){
				System.out.printf("Invalid Input!\n");
				continue;
			}
			break;
		}
	}
}