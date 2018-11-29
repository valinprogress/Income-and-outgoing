package benefitCalculator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

import benefitCalculator.bean.Frequency;
import benefitCalculator.bean.RegularAmount;
import junit.framework.Assert;

public class CalculatorTest {

	RegularAmount income =  new RegularAmount();
	
	@Test
	public void testWeeklyValid() {
		income.setAmount("10");
		income.setFrequency(Frequency.WEEK);
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    Validator validator = factory.getValidator();

	    Set<ConstraintViolation<RegularAmount>> constraintViolations = validator.validate(income);
		
		Assert.assertTrue(constraintViolations.isEmpty());
	}
	
	@Test
	public void testBiWeeklyValid(){
		income.setAmount("10");
		income.setFrequency(Frequency.TWO_WEEK);
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    Validator validator = factory.getValidator();

	    Set<ConstraintViolation<RegularAmount>> constraintViolations = validator.validate(income);
	    Assert.assertTrue(constraintViolations.isEmpty());
	    
	}
	
	@Test
	public void testBiWeeklyInvalid(){income.setAmount("10");
		income.setAmount("11");
		income.setFrequency(Frequency.TWO_WEEK);
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    Validator validator = factory.getValidator();
	
	    Set<ConstraintViolation<RegularAmount>> constraintViolations = validator.validate(income);
	    
	    Assert.assertTrue(!constraintViolations.isEmpty());
	}
	
	@Test
	public void testNotNumericInvalidAmount(){
		income.setAmount("abc");
		income.setFrequency(Frequency.WEEK);
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    Validator validator = factory.getValidator();
	
	    Set<ConstraintViolation<RegularAmount>> constraintViolations = validator.validate(income);
	    
	    Assert.assertTrue(!constraintViolations.isEmpty());
		
	}

	@Test
	public void testBlankInvalidAmount(){
		income.setAmount("");
		income.setFrequency(Frequency.WEEK);
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    Validator validator = factory.getValidator();
	
	    Set<ConstraintViolation<RegularAmount>> constraintViolations = validator.validate(income);
	    
	    Assert.assertTrue(!constraintViolations.isEmpty());
		
	}
	
	@Test
	public void testValidNumericAmount(){
		income.setAmount("12");
		income.setFrequency(Frequency.TWO_WEEK);
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    Validator validator = factory.getValidator();
	
	    Set<ConstraintViolation<RegularAmount>> constraintViolations = validator.validate(income);
	
	    Assert.assertTrue(constraintViolations.isEmpty());
	}
	
	@Test
	public void testFourWeeksNotValid(){
		income.setAmount("13");
		income.setFrequency(Frequency.FOUR_WEEK);
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    Validator validator = factory.getValidator();
	
	    Set<ConstraintViolation<RegularAmount>> constraintViolations = validator.validate(income);
	
	    Assert.assertTrue(!constraintViolations.isEmpty());
	}

	@Test
	public void testFourWeeksValid(){
		income.setAmount("12");
		income.setFrequency(Frequency.FOUR_WEEK);
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    Validator validator = factory.getValidator();
	
	    Set<ConstraintViolation<RegularAmount>> constraintViolations = validator.validate(income);
	
	    Assert.assertTrue(constraintViolations.isEmpty());
	}
	
	@Test
	public void testNullFrequencyNotValid(){
		income.setAmount("10");
		income.setFrequency(null);
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    Validator validator = factory.getValidator();
	
	    Set<ConstraintViolation<RegularAmount>> constraintViolations = validator.validate(income);
	
	    Assert.assertTrue(!constraintViolations.isEmpty());
	}

	@Test
	public void testMonthlyValid(){
		income.setAmount("9");
		income.setFrequency(Frequency.MONTH);
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    Validator validator = factory.getValidator();
	
	    Set<ConstraintViolation<RegularAmount>> constraintViolations = validator.validate(income);
	
	    Assert.assertTrue(constraintViolations.isEmpty());
	}
	
	@Test
	public void testQuarterlyNotValid(){
		income.setAmount("25");
		income.setFrequency(Frequency.QUARTER);
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    Validator validator = factory.getValidator();
	
	    Set<ConstraintViolation<RegularAmount>> constraintViolations = validator.validate(income);
	
	    Assert.assertTrue(!constraintViolations.isEmpty());
	}

	@Test
	public void testQuarterlyValid(){
		income.setAmount("26");
		income.setFrequency(Frequency.QUARTER);
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    Validator validator = factory.getValidator();
	
	    Set<ConstraintViolation<RegularAmount>> constraintViolations = validator.validate(income);
	
	    Assert.assertTrue(constraintViolations.isEmpty());
	}
	
	@Test
	public void testYearlyNotValid(){
		income.setAmount("103");
		income.setFrequency(Frequency.YEAR);
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    Validator validator = factory.getValidator();
	
	    Set<ConstraintViolation<RegularAmount>> constraintViolations = validator.validate(income);
	
	    Assert.assertTrue(!constraintViolations.isEmpty());
	}
	
	@Test
	public void testYearlyValid(){
		income.setAmount("52");
		income.setFrequency(Frequency.YEAR);
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    Validator validator = factory.getValidator();
	
	    Set<ConstraintViolation<RegularAmount>> constraintViolations = validator.validate(income);
	
	    Assert.assertTrue(constraintViolations.isEmpty());
	}
	
	@Test
	public void testMinimalAmountValid(){
		income.setAmount("0");
		income.setFrequency(Frequency.WEEK);
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    Validator validator = factory.getValidator();
	
	    Set<ConstraintViolation<RegularAmount>> constraintViolations = validator.validate(income);
	
	    Assert.assertTrue(constraintViolations.isEmpty());
	}

	@Test
	public void testNegativeAmountNotValid(){
		income.setAmount("-1");
		income.setFrequency(Frequency.TWO_WEEK);
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    Validator validator = factory.getValidator();
	
	    Set<ConstraintViolation<RegularAmount>> constraintViolations = validator.validate(income);
	
	    Assert.assertTrue(!constraintViolations.isEmpty());
	}
}