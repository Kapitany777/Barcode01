package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.ApplicationIdentifier;
import main.ApplicationIdentifiers;
import main.enums.AiDataFormat;
import main.enums.AiDataLengthType;
import main.enums.AiDataType;

class TestApplicationIdentifiers {

	@Test
	void ApplicationIdentifiersContainsAi01() {
		ApplicationIdentifiers ids = new ApplicationIdentifiers();

		boolean contains = ids.contains("01");

		assertTrue(contains);
	}

	@Test
	void ApplicationIdentifiersNotContainsAi800() {
		ApplicationIdentifiers ids = new ApplicationIdentifiers();

		boolean contains = ids.contains("800");

		assertFalse(contains);
	}

	@Test
	void GetApplicationIdentifierAi01ReturnsNotNull() {
		ApplicationIdentifiers ids = new ApplicationIdentifiers();

		ApplicationIdentifier id = ids.getIdentifier("01");

		assertNotNull(id);
	}

	@Test
	void GetApplicationIdentifierAi01ReturnsAi01() {
		ApplicationIdentifiers ids = new ApplicationIdentifiers();

		ApplicationIdentifier id = ids.getIdentifier("01");

		assertAll(
				() -> assertEquals("01", id.getAi()),
				() -> assertEquals(AiDataLengthType.FIXED, id.getDataLengthType()),
				() -> assertEquals(14, id.getMaxLength()),
				() -> assertEquals(AiDataFormat.NUMERIC, id.getDataFormat()),
				() -> assertEquals(AiDataType.NUMBER, id.getDataType()),
				() -> assertEquals("GTIN", id.getDataTitle()));
	}

	@Test
	void GetApplicationIdentifierAi800ReturnsNull() {
		ApplicationIdentifiers ids = new ApplicationIdentifiers();

		ApplicationIdentifier id = ids.getIdentifier("800");

		assertNull(id);
	}
}
