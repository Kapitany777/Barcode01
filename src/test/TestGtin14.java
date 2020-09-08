package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import main.Gtin14;
import main.exceptions.Gtin14Exception;

class TestGtin14 {

	@ParameterizedTest
	@CsvSource(value = {"05997099967220,05997099967220",
	                    "03830029801138,03830029801138",
	                    "05995823520086,05995823520086",
	                    "15997099951936,15997099951936",
	                    "15997099969757,15997099969757",
	                    "95997099967223,95997099967223"})
	void ValidGTIN14(String input, String expected)
	{
		Gtin14 gtin14 = new Gtin14(input);
		
		assertEquals(expected, gtin14.getGtin());
	}
	
	@ParameterizedTest
	@CsvSource(value = {"05997099967221",
	                    "03830029801132",
	                    "05995823520083",
	                    "15997099951934",
	                    "15997099969755"})
	void InvalidCheckDigitThrowsGtin14Exception(String input)
	{
		Exception exception = assertThrows(Gtin14Exception.class, () -> { new Gtin14(input); });
		assertTrue(exception.getMessage().contains("Invalid check digit"));
	}
	
	@Test
	void TooShortGtinThrowsGtin14Exception()
	{
		final String gtin = "59970999";
		
		Exception exception = assertThrows(Gtin14Exception.class, () -> { new Gtin14(gtin); });
		assertTrue(exception.getMessage().contains("Invalid GTIN"));
	}

	@Test
	void TooLongGtinThrowsGtin14Exception()
	{
		final String gtin = "59970999123456789";
		
		Exception exception = assertThrows(Gtin14Exception.class, () -> { new Gtin14(gtin); });
		assertTrue(exception.getMessage().contains("Invalid GTIN"));
	}
	
	@Test
	void InvalidCharacterThrowsGtin14Exception()
	{
		final String gtin = "0599709996722*";
		
		Exception exception = assertThrows(Gtin14Exception.class, () -> { new Gtin14(gtin); });
		assertTrue(exception.getMessage().contains("Invalid character"));
	}
}
