package custom_exception;

@SuppressWarnings("serial")
public class InvalidInputException extends Exception{
	
	public InvalidInputException(String errorMsg) {
		super(errorMsg);
	}

}
