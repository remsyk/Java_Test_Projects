
public class MyException extends Exception {
	
	
	public MyException() { 
		super("MyException"); 
		}
	
    public MyException(String message){
        super(message + " (MyException)");
    }

}
