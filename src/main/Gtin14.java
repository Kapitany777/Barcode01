package main;

import main.exceptions.Gtin14Exception;

public class Gtin14
{
	private String gtin;
	
	public Gtin14(String gtin)
	{
		if (gtin.length() != 14)
		{
			throw new Gtin14Exception("Invalid GTIN: " + gtin);
		}
		
		if (!isValid(gtin))
		{
			throw new Gtin14Exception("Invalid character: " + gtin);
		}
		
		if (!isCheckDigitCorrect(gtin))
		{
			throw new Gtin14Exception("Invalid check digit: " + gtin);
		}
		
		setGtin(gtin);
	}
	
	private boolean isValid(String gtin)
	{
		for (int i = 0; i < gtin.length(); i++)
		{
			if (!Character.isDigit(gtin.charAt(i)))
			{
				return false;
			}
		}
		
		return true;
	}
	
	private boolean isCheckDigitCorrect(String code)
	{
		int sum = 0;
		
		for (int i = 0; i < 13; i++)
		{
			int digit = Character.digit(code.charAt(i), 10);				
			sum += digit * (i % 2 == 0 ? 3 : 1);
		}
		
		int checkDigit = 10 - (sum % 10);
		
		if (checkDigit == 10)
		{
			checkDigit = 0;
		}
		
		if (code.charAt(13) != '0' + checkDigit)
		{
			return false;
		}
		
		return true;
	}

	private void setGtin(String gtin) {
		this.gtin = gtin;
	}
	
	public String getGtin() {
		return gtin;
	}
}
