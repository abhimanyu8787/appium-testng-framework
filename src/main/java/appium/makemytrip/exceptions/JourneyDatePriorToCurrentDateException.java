package appium.makemytrip.exceptions;

public class JourneyDatePriorToCurrentDateException extends Exception{
	
private static final long serialVersionUID = 1L;
	
	public JourneyDatePriorToCurrentDateException(String message) {
        super(message);
    }

}
