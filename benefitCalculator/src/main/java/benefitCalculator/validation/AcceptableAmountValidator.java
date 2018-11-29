package benefitCalculator.validation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import benefitCalculator.annotation.AcceptableAmount;
import benefitCalculator.bean.RegularAmount;

public class AcceptableAmountValidator implements ConstraintValidator<AcceptableAmount, RegularAmount>{

	private String numericPattern = "^[0-9]\\d*$";
	
	@Override
	public void initialize(AcceptableAmount arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(RegularAmount regularAmount, ConstraintValidatorContext arg1) {
		boolean result = false;

		if(isValidNumericAmount(regularAmount)){
			result = true;
		}
		else return false;
		
		if(isValidFrequency(regularAmount)){
			result = true;
		}
		else return false;
		
		switch(regularAmount.getFrequency()){
		case WEEK :
			return true;
		case TWO_WEEK :
			result = isValidBiWeeklyAmount(regularAmount);
			break;
		case FOUR_WEEK :
			result = isValidFourWeeksAmount(regularAmount);
			break;
		case QUARTER : 
			result = isValidQuarterlyAmount(regularAmount);
			break;
		case YEAR : 
			result = isValidYearlyAmount(regularAmount);
			break;
		default:
			break;
		
		}
		
		return result;
	}

	private boolean isValidYearlyAmount(RegularAmount regularAmount) {
		boolean isValid = false;
		
		if(Double.parseDouble(regularAmount.getAmount()) % 52 == 0){
			return true;
		}
		return isValid;	
	}

	private boolean isValidQuarterlyAmount(RegularAmount regularAmount) {
		boolean isValid = false;
		
		if(Double.parseDouble(regularAmount.getAmount()) % 13 == 0){
			return true;
		}
		return isValid;	
	}

	private boolean isValidFrequency(RegularAmount regularAmount) {
		boolean isValid = false;
		if(regularAmount.getFrequency() != null) {
			isValid = true;
		}
		return isValid;
	}

	private boolean isValidFourWeeksAmount(RegularAmount regularAmount) {
		boolean isValid = false;
		
		if(Double.parseDouble(regularAmount.getAmount()) % 4 == 0){
			return true;
		}
		return isValid;
	}

	private boolean isValidNumericAmount(RegularAmount regularAmount) {
		boolean isValid = false;

		Pattern pattern = Pattern.compile(numericPattern);
		
		isValid = pattern.matcher(regularAmount.getAmount()).matches();
		
		return isValid;
	}

	private boolean isValidBiWeeklyAmount(RegularAmount regularAmount) {
		boolean isValid = false;
		if(Double.parseDouble(regularAmount.getAmount()) % 2 == 0)
			return true;
		return isValid;
	}

}
