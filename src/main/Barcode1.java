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
		System.out.println(g2.getBarcodeType());
		System.out.println(g2.getBestBefore() + " / " + g2.getExpiry());
		System.out.println(g2.getLot());
		
		System.out.println();
		
		Gs1Barcode g3 = new Gs1Barcode("01059970999672201012345 15201231", ' ', identifiers);
		System.out.println(g3.getBarcodeType());
		System.out.println(g3.getBestBefore() + " / " + g3.getExpiry());
		System.out.println(g3.getLot());
		System.out.println();
		
		/*Gs1Barcode g4 = new Gs1Barcode("010599709996722002059970999672201012345 15201231", ' ', identifiers);
		System.out.println();*/
		
		Gs1Barcode g5 = new Gs1Barcode("020599582367392817111009102262 3720", ' ', identifiers);
		System.out.println(g5.getBarcodeType());
		System.out.println(g5.getBestBefore() + " / " + g5.getExpiry());
		System.out.println(g5.getLot());
		System.out.println(g5.getCount());
		System.out.println();
	}
}
