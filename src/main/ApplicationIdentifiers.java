package main;
import java.util.ArrayList;

import main.enums.AiDataFormat;
import main.enums.AiDataLengthType;
import main.enums.AiDataType;

import java.util.*;

public class ApplicationIdentifiers
{
	private ArrayList<ApplicationIdentifier> identifiers = new ArrayList<>();
	
	public ApplicationIdentifiers()
	{
		createIdentifiers();
	}
	
	private void createIdentifiers()
	{
		identifiers.add(new ApplicationIdentifier("00", AiDataLengthType.FIXED, 14, AiDataFormat.NUMERIC, AiDataType.NUMBER, "SSCC"));
		identifiers.add(new ApplicationIdentifier("01", AiDataLengthType.FIXED, 14, AiDataFormat.NUMERIC, AiDataType.NUMBER, "GTIN"));
		identifiers.add(new ApplicationIdentifier("02", AiDataLengthType.FIXED, 14, AiDataFormat.NUMERIC, AiDataType.NUMBER, "CONTENT"));
		identifiers.add(new ApplicationIdentifier("10", AiDataLengthType.VARIABLE, 20, AiDataFormat.ANYCHARACTER, AiDataType.STRING, "BATCH/LOT"));
		identifiers.add(new ApplicationIdentifier("11", AiDataLengthType.FIXED, 6, AiDataFormat.NUMERIC, AiDataType.DATE, "PROD DATE"));
		identifiers.add(new ApplicationIdentifier("12", AiDataLengthType.FIXED, 6, AiDataFormat.NUMERIC, AiDataType.DATE, "DUE DATE"));
		identifiers.add(new ApplicationIdentifier("13", AiDataLengthType.FIXED, 6, AiDataFormat.NUMERIC, AiDataType.DATE, "PACK DATE"));
		identifiers.add(new ApplicationIdentifier("15", AiDataLengthType.FIXED, 6, AiDataFormat.NUMERIC, AiDataType.DATE, "BEST BEFORE"));
		identifiers.add(new ApplicationIdentifier("17", AiDataLengthType.FIXED, 6, AiDataFormat.NUMERIC, AiDataType.DATE, "EXPIRY"));
		identifiers.add(new ApplicationIdentifier("20", AiDataLengthType.FIXED, 2, AiDataFormat.NUMERIC, AiDataType.NUMBER, "VARIANT"));
		identifiers.add(new ApplicationIdentifier("21", AiDataLengthType.VARIABLE, 20, AiDataFormat.ANYCHARACTER, AiDataType.STRING, "SERIAL"));
		identifiers.add(new ApplicationIdentifier("240", AiDataLengthType.VARIABLE, 30, AiDataFormat.ANYCHARACTER, AiDataType.STRING, "ADDITIONAL ID"));
		identifiers.add(new ApplicationIdentifier("250", AiDataLengthType.VARIABLE, 30, AiDataFormat.ANYCHARACTER, AiDataType.STRING, "SECONDARY SERIAL"));
		identifiers.add(new ApplicationIdentifier("310", AiDataLengthType.FIXED, 7, AiDataFormat.NUMERIC, AiDataType.NUMBER, "NET WEIGHT (KG)"));
		identifiers.add(new ApplicationIdentifier("37", AiDataLengthType.VARIABLE, 8, AiDataFormat.NUMERIC, AiDataType.NUMBER, "COUNT"));
		identifiers.add(new ApplicationIdentifier("400", AiDataLengthType.VARIABLE, 30, AiDataFormat.ANYCHARACTER, AiDataType.STRING, "ORDER NUMBER"));
		identifiers.add(new ApplicationIdentifier("426", AiDataLengthType.FIXED, 3, AiDataFormat.NUMERIC, AiDataType.NUMBER, "COUNTRY, FULL PROCESS"));
		identifiers.add(new ApplicationIdentifier("7006", AiDataLengthType.VARIABLE, 6, AiDataFormat.NUMERIC, AiDataType.DATE, "FIRST FREEZE DATE"));
		identifiers.add(new ApplicationIdentifier("7007", AiDataLengthType.VARIABLE, 6, AiDataFormat.NUMERIC, AiDataType.DATE, "HARVEST DATE"));
	}
	
	public boolean contains(String ai)
	{
		return identifiers.stream().filter(x -> x.getAi().equals(ai)).count() > 0;
	}
	
	public ApplicationIdentifier getIdentifier(String ai)
	{
		Optional<ApplicationIdentifier> id =
				identifiers.stream().filter(x -> x.getAi().equals(ai)).findFirst();
		
		if (id.isPresent())
		{
			return id.get();
		}
		
		return null;
	}
}
