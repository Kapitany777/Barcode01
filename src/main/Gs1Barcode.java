package main;

import main.enums.AiDataLengthType;
import main.enums.BarcodeType;

public class Gs1Barcode {

	private String barcode;
	private char separator;
	private ApplicationIdentifiers identifiers;
	
	private BarcodeType barcodeType;
	private Gtin13 gtin13;
	
	private String lot;
	private String bestBefore;
	private String expiry;
	private int count;
	
	public Gs1Barcode(String barcode, char separator, ApplicationIdentifiers identifiers)
	{
		this.barcode = barcode;
		this.separator = separator;
		this.identifiers = identifiers;
		
		this.setBarcodeType(BarcodeType.UNKNOWN);
		this.setLot(null);
		this.setBestBefore(null);
		this.setExpiry(null);
		this.setCount(0);
		
		parseBarcode();
	}

	private void tryToSetBarcodeType(ApplicationIdentifier identifier)
	{
		BarcodeType tmpBarcodeType = BarcodeType.UNKNOWN;
		
		switch (identifier.getAi())
		{
		case "00":
			tmpBarcodeType = BarcodeType.SSCC;
			break;
			
		case "01":
			tmpBarcodeType = BarcodeType.GTIN;
			break;
			
		case "02":
			tmpBarcodeType = BarcodeType.CONTENT;
			break;
		}
		
		if (tmpBarcodeType != BarcodeType.UNKNOWN)
		{
			if (this.getBarcodeType() == BarcodeType.UNKNOWN)
			{
				this.setBarcodeType(tmpBarcodeType);
			}
			else
			{
				throw new RuntimeException("Invalid barcode!");
			}
		}
	}
	
	private void checkBarcodeData(ApplicationIdentifier identifier, String data, boolean containsSeparator)
	{
		if (identifier.getDataLengthType() == AiDataLengthType.FIXED &&
			data.length() != identifier.getMaxLength())
		{
			throw new RuntimeException("Invalid length!");
		}
	}
	
	private void setBarcodeData(ApplicationIdentifier identifier, String data)
	{
		switch (identifier.getAi())
		{
		case "10":
			this.setLot(data);
			break;
		
		case "15":
			this.setBestBefore(data);
			break;
		
		case "17":
			this.setExpiry(data);
			break;
			
		case "37":
			this.setCount(Integer.parseInt(data));
			break;
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
				tryToSetBarcodeType(identifier);
				//System.out.println(sbAi.toString());
				
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
						i += 2;
						break;
					}
				}

				//System.out.println(sbData.toString());
				checkBarcodeData(identifier, sbData.toString(), containsSeparator);
				setBarcodeData(identifier, sbData.toString());
				
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

	public BarcodeType getBarcodeType() {
		return barcodeType;
	}

	private void setBarcodeType(BarcodeType barcodeType) {
		this.barcodeType = barcodeType;
	}

	public String getLot() {
		return lot;
	}

	private void setLot(String lot) {
		this.lot = lot;
	}

	public String getBestBefore() {
		return bestBefore;
	}

	private void setBestBefore(String bestBefore) {
		this.bestBefore = bestBefore;
	}

	public String getExpiry() {
		return expiry;
	}

	private void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public int getCount() {
		return count;
	}

	private void setCount(int count) {
		this.count = count;
	}
}
