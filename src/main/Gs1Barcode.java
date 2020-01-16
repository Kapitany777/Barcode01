package main;

import main.enums.AiDataLengthType;

public class Gs1Barcode {

	private String barcode;
	private char separator;
	private ApplicationIdentifiers identifiers;
	
	private Gtin13 gtin13;
	
	public Gs1Barcode(String barcode, char separator, ApplicationIdentifiers identifiers)
	{
		this.barcode = barcode;
		this.separator = separator;
		this.identifiers = identifiers;
		
		parseBarcode();
	}

	private void checkBarcodeData(ApplicationIdentifier identifier, String data, boolean containsSeparator)
	{
		if (identifier.getDataLengthType() == AiDataLengthType.FIXED &&
			data.length() != identifier.getMaxLength())
		{
			throw new RuntimeException("Length is bad!");
		}
	}
	
	private void parseBarcode()
	{
		StringBuilder sbAi = new StringBuilder();
		StringBuilder sbData = new StringBuilder();
		
		int i = 0;
		
		while (i < this.barcode.length())
		{
			sbAi.append(barcode.charAt(i));
			
			if (identifiers.contains(sbAi.toString()))
			{
				ApplicationIdentifier identifier = identifiers.getIdentifier(sbAi.toString());
				System.out.println(sbAi.toString());
				
				i++;
				
				sbData.setLength(0);
				boolean containsSeparator = false;
				
				while (i < barcode.length() && sbData.length() < identifier.getMaxLength())
				{
					if (barcode.charAt(i) != separator)
					{
						sbData.append(barcode.charAt(i));
						i++;
					}
					else
					{
						containsSeparator = true;
						i++;
						break;
					}
				}

				System.out.println(sbData.toString());
				checkBarcodeData(identifier, sbData.toString(), containsSeparator);
				
				sbAi.setLength(0);
			}
			else
			{		
				i++;
			}
		}
	}
	
	public String getBarcode() {
		return barcode;
	}

	public char getSeparator() {
		return separator;
	}

	public Gtin13 getGtin13() {
		return gtin13;
	}
}
