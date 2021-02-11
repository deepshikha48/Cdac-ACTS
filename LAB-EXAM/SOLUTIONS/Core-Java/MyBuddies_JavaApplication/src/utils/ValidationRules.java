package utils;

import static java.sql.Date.valueOf;
import java.sql.Date;
import custom_exception.InvalidInputException;

public class ValidationRules {
	
	public static Date BEFORE_DATE;
	// Static initializer block
	static {
		BEFORE_DATE = valueOf("2000-01-01");
	}

	// validate email
	public static String validateEmail(String email) throws InvalidInputException {
		if (!email.contains("@") || (!email.endsWith(".com")))
			throw new InvalidInputException("Invalid email");
		return email;

	}

	// validate phone numbers
	public static String validatePhoneNumber(String phoneno) throws InvalidInputException {
		if (phoneno.length() == 10) {
			return phoneno;
		}
		throw new InvalidInputException("Invalid phone no.");

	}
	
	// Buddies's birth date validation
		public static Date validateDateOfBirth(String dateOfBirth) throws InvalidInputException{
			Date dob = Date.valueOf(dateOfBirth);
			if (dob.before(BEFORE_DATE))
				return dob;
			throw new InvalidInputException("Date of birth must be before  1st Jan 2000. ");
		}
}
