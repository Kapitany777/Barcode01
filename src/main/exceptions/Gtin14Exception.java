package main.exceptions;

public class Gtin14Exception extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public Gtin14Exception() {
	}

	public Gtin14Exception(String msg) {
		super(msg);
	}

	public Gtin14Exception(Throwable cause) {
		super(cause);
	}

	public Gtin14Exception(String msg, Throwable cause) {
		super(msg, cause);
	}
}
