package main.exceptions;

public class Gtin13Exception extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public Gtin13Exception() {
	}

	public Gtin13Exception(String msg) {
		super(msg);
	}

	public Gtin13Exception(Throwable cause) {
		super(cause);
	}

	public Gtin13Exception(String msg, Throwable cause) {
		super(msg, cause);
	}
}
