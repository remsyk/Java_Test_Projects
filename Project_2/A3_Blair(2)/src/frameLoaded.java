
//singleton class example
public class frameLoaded {
	private static frameLoaded instance = new frameLoaded();
	
	private frameLoaded(){}
	
	public static frameLoaded getInstance(){
	      return instance;
	   }
	public void message(){
	
		System.out.println("Frame Loaded");
	   }
}


