package main;

public class Gs1Barcode {

	private String barcode;
	private char separator;
	private ApplicationIdentifiers identifiers;
	
	private String gtin;
	
	public Gs1Barcode(String barcode, char separator, ApplicationIdentifiers identifiers)
	{
		this.barcode = barcode;
		this.separator = separator;
		this.identifiers = identifiers;
		
		parseBarcode();
	}

	private void parseBarcode()
	{
		StringBuilder sbAi = new StringBuilder();
		StringBuilder sbData = new StringBuilder();
		
		for (char c : this.barcode.toCharArray())
		{
			sbAi.append(c);
			
			if (identifiers.contains(sbAi.toString()))
			{
				ApplicationIdentifier id = identifiers.getIdentifier(sbAi.toString());
				
				
			}
			
			sbAi.setLength(0);
		}
	}
	
	public String getBarcode() {
		return barcode;
	}

	public char getSeparator() {
		return separator;
	}

	public String getGtin() {
		return gtin;
	}
}
