package main;

public class Barcode1 {

	public static void main(String[] args) {
		
		System.out.println("Barcode program");
		
		//System.out.println(Character.isDigit('*'));
		//System.out.println(Gtin13.isValid("599709996722*"));
		
		Gtin13 g1 = new Gtin13("5997099967220");
		System.out.println(g1.getGtin13());
	}
}
