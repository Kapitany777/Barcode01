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
		identifiers.add(new ApplicationIdentifier("15", AiDataLengthType.FIXED, 6, AiDataFormat.NUMERIC, AiDataType.DATE, "BEST BEFORE"));
		identifiers.add(new ApplicationIdentifier("17", AiDataLengthType.FIXED, 6, AiDataFormat.NUMERIC, AiDataType.DATE, "EXPIRY"));
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
