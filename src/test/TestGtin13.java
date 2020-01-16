package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import main.Gtin13;
import main.exceptions.Gtin13Exception;

class TestGtin13 {

	@Test
	void TooShortGtinThrowsGtin13Exception()
	{
		final String gtin = "59970999";
		
		Exception exception = assertThrows(Gtin13Exception.class, () -> { new Gtin13(gtin); });
		assertTrue(exception.getMessage().contains("Invalid GTIN"));
	}
	
	@Test
	void TooLongGtinThrowsGtin13Exception()
	{
		final String gtin = "59970999123456789";
		
		Exception exception = assertThrows(Gtin13Exception.class, () -> { new Gtin13(gtin); });
		assertTrue(exception.getMessage().contains("Invalid GTIN"));
	}

	@Test
	void InvalidCharacterThrowsGtin13Exception()
	{
		final String gtin = "599709996722*";
		
		Exception exception = assertThrows(Gtin13Exception.class, () -> { new Gtin13(gtin); });
		assertTrue(exception.getMessage().contains("Invalid character"));
	}
	
	@ParameterizedTest
	@CsvSource(value = {"599709996722,5997099967220",
			            "599582352070,5995823520703",
			            "599582371690,5995823716908",
						"325622026928,3256220269285",
						"383002980842,3830029808427"})
	void CalculateGtinWhen12Chars(String input, String expected)
	{
		Gtin13 gtin13 = new Gtin13(input);
		
		assertEquals(expected, gtin13.getGtin13());
	}
	
	@ParameterizedTest
	@CsvSource(value = {"5997099967220,5997099967220",
			            "5995823520703,5995823520703",
			            "5995823716908,5995823716908",
						"3256220269285,3256220269285",
						"3830029808427,3830029808427"})
	void CalculateGtinWhen13Chars(String input, String expected)
	{
		Gtin13 gtin13 = new Gtin13(input);
		
		assertEquals(expected, gtin13.getGtin13());
	}
	
	@ParameterizedTest
	@CsvSource(value = {"05997099967220,5997099967220",
			            "15995823520703,5995823520703",
			            "25995823716908,5995823716908",
						"33256220269285,3256220269285",
						"43830029808427,3830029808427"})
	void CalculateGtinWhen14Chars(String input, String expected)
	{
		Gtin13 gtin13 = new Gtin13(input);
		
		assertEquals(expected, gtin13.getGtin13());
	}
}
