package main;

import main.enums.AiDataFormat;
import main.enums.AiDataLengthType;
import main.enums.AiDataType;

public class ApplicationIdentifier
{
	private String ai;
	private AiDataLengthType dataLengthType;
	private int maxLength;
	private AiDataFormat dataFormat;
	private AiDataType dataType;
	private String dataTitle;
	
	public ApplicationIdentifier(
			String ai,
			AiDataLengthType dataLengthType,
			int maxLength,
			AiDataFormat dataFormat,
			AiDataType dataType,
			String dataTitle)
	{
		this.ai = ai;
		this.dataLengthType = dataLengthType;
		this.maxLength = maxLength;
		this.dataFormat = dataFormat;
		this.dataType = dataType;
		this.dataTitle = dataTitle;
	}

	public String getAi() {
		return ai;
	}

	public AiDataLengthType getDataLengthType() {
		return dataLengthType;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public AiDataFormat getDataFormat() {
		return dataFormat;
	}

	public AiDataType getDataType() {
		return dataType;
	}
	
	public String getDataTitle() {
		return dataTitle;
	}
}
