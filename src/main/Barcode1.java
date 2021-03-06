package main;

import main.constants.Separators;

public class Barcode1 {

	public static void main(String[] args) {
		
		System.out.println("Barcode program");
		
		//System.out.println(Character.isDigit('*'));
		//System.out.println(Gtin13.isValid("599709996722*"));
		
		/*Gtin13 g1 = new Gtin13("5997099967220");
		System.out.println(g1.getGtin13());*/
		
		ApplicationIdentifiers identifiers = new ApplicationIdentifiers();
		
		Gs1Barcode g2 = new Gs1Barcode("0105997099967220151712311012345", Separators.SEPARATOR_SPACE, identifiers);
		System.out.println(g2.getBarcodeType());
		System.out.println(g2.getGtin13().getGtin());
		System.out.println(g2.getGtin14().getGtin());
		System.out.println(g2.getBestBefore() + " / " + g2.getExpiry());
		System.out.println(g2.getLot());
		System.out.println();
		
		Gs1Barcode g3 = new Gs1Barcode("01059970999672201012345 15201231", Separators.SEPARATOR_SPACE, identifiers);
		System.out.println(g3.getBarcodeType());
		System.out.println(g3.getGtin13().getGtin());
		System.out.println(g3.getGtin14().getGtin());
		System.out.println(g3.getBestBefore() + " / " + g3.getExpiry());
		System.out.println(g3.getLot());
		System.out.println();
		
		/*Gs1Barcode g4 = new Gs1Barcode("010599709996722002059970999672201012345 15201231", Separators.SEPARATOR_SPACE, identifiers);
		System.out.println();*/
		
		Gs1Barcode g5 = new Gs1Barcode("020599582367392817111009102262 3720", Separators.SEPARATOR_SPACE, identifiers);
		System.out.println(g5.getBarcodeType());
		System.out.println(g5.getGtin13().getGtin());
		System.out.println(g5.getGtin14().getGtin());
		System.out.println(g5.getBestBefore() + " / " + g5.getExpiry());
		System.out.println(g5.getLot());
		System.out.println(g5.getCount());
		System.out.println();
		
		Gs1Barcode g6 = new Gs1Barcode("019599709996722331030015001012345 15201231", Separators.SEPARATOR_SPACE, identifiers);
		System.out.println(g6.getBarcodeType());
		System.out.println(g6.getGtin13().getGtin());
		System.out.println(g6.getGtin14().getGtin());
		System.out.println(g6.getBestBefore() + " / " + g6.getExpiry());
		System.out.println(g6.getLot());
		System.out.println(g6.getNetWeight());
		System.out.println();
		
		// Gtin14 gtin14 = new Gtin14("05997099967225");
		
		Gs1Barcode g7 = new Gs1Barcode("01959970999672233103001500100123456789012345678 17201231", Separators.SEPARATOR_SPACE, identifiers);
		System.out.println(g7.getBarcodeType());
		System.out.println(g7.getGtin13().getGtin());
		System.out.println(g7.getGtin14().getGtin());
		System.out.println(g7.getBestBefore() + " / " + g7.getExpiry());
		System.out.println(g7.getDate());
		System.out.println(g7.getLot());
		System.out.println(g7.getNetWeight());
		System.out.println();
		
		Gs1Barcode g8 = new Gs1Barcode("01059970999725381720080510408010103", Separators.SEPARATOR_SPACE, identifiers);
		System.out.println(g8.getLot());
		System.out.println();
		
		Gs1Barcode g9 = new Gs1Barcode("0205995823721070152203031022203 37150", Separators.SEPARATOR_SPACE, identifiers);
		System.out.println(g9.getBarcodeType());
		System.out.println(g9.getGtin13().getGtin());
		System.out.println(g9.getGtin14().getGtin());
		System.out.println(g9.getBestBefore() + " / " + g9.getExpiry());
		System.out.println(g9.getDate());
		System.out.println(g9.getLot());
		System.out.println();
		
		Gs1Barcode g10 = new Gs1Barcode("0105997099967220", Separators.SEPARATOR_SPACE, identifiers);
		System.out.println(g10.getBarcodeType());
		System.out.println(g10.getGtin13().getGtin());
		System.out.println(g10.getGtin14().getGtin());
	}
}
