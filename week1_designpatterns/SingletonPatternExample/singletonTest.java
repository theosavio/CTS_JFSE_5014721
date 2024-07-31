
public class singletonTest {

	public static void main(String[] args) {
		
		Logger logger1=Logger.getInstance();
		Logger logger2=Logger.getInstance();
		
		logger1.log("this is logger 1");
		logger2.log("this is logger 2");
		
		if(logger1==logger2) {
			System.out.println("both are in same intance");
			
		}
		else {
			System.out.println("both are in different intance");
		}
		
	}
}
