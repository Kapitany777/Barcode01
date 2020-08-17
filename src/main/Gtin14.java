package main;

import main.exceptions.Gtin13Exception;

public class Gtin14
{
	private String gtin14;
	
	public Gtin14(String gtin)
	{
		if (gtin.length() != 14)
		{
			throw new Gtin13Exception("Invalid GTIN: " + gtin);
		}
		
		if (!isValid(gtin))
		{
			throw new Gtin13Exception("Invalid character: " + gtin);
		}
		
		//calculateCheckDigit(getCode(gtin));
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

	public String getGtin14() {
		return gtin14;
	}
}
