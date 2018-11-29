package benefitCalculator.bean;

import javax.validation.constraints.Pattern;

import benefitCalculator.annotation.AcceptableAmount;

@AcceptableAmount
public class RegularAmount {

	private Frequency frequency;
    
	private String amount;
    
	public Frequency getFrequency() {
        return frequency;
    }
    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }
    
    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }
}

