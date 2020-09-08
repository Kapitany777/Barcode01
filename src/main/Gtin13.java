package main;

import main.exceptions.Gtin13Exception;

public class Gtin13
{
	private String gtin;
	
	public Gtin13(String gtin)
	{
		if (gtin.length() < 12 || gtin.length() > 14)
		{
			throw new Gtin13Exception("Invalid GTIN: " + gtin);
		}
		
		if (!isValid(gtin))
		{
			throw new Gtin13Exception("Invalid character: " + gtin);
		}
		
		calculateCheckDigit(getCode(gtin));
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
	
	private String getCode(String gtin)
	{
		String code;
		
		if (gtin.length() == 14)
		{
			code = gtin.substring(1);
		}
		else
		{
			code = gtin;
		}
		
		return code;
	}
	
	private void calculateCheckDigit(String code)
	{
		int sum = 0;
		
		for (int i = 0; i < 12; i++)
		{
			int digit = Character.digit(code.charAt(i), 10);				
			sum += digit * (i % 2 == 0 ? 1 : 3);
		}
		
		int checkDigit = 10 - (sum % 10);
		
		if (checkDigit == 10)
		{
			checkDigit = 0;
		}
		
		this.gtin = code.substring(0, 12) + Integer.toString(checkDigit);
	}

	public String getGtin() {
		return gtin;
	}
}
