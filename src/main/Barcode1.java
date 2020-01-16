package main;

public class Barcode1 {

	public static void main(String[] args) {
		
		System.out.println("Barcode program");
		
		//System.out.println(Character.isDigit('*'));
		//System.out.println(Gtin13.isValid("599709996722*"));
		
		Gtin13 g1 = new Gtin13("5997099967220");
		System.out.println(g1.getGtin13());
		
		ApplicationIdentifiers identifiers = new ApplicationIdentifiers();
		
		Gs1Barcode g2 = new Gs1Barcode("0105997099967220151712311012345", ' ', identifiers);
		System.out.println();
		
		Gs1Barcode g3 = new Gs1Barcode("01059970999672201012345 15201231", ' ', identifiers);
		System.out.println();
	}
}
