/*
 * SMELL: Complicated (Conditional) Expression
 *   -- You have an expression that is not clear or hard to understand.
 * 
 * TREATMENT: Extract Variable (aka Introduce Explaining Variable)
 *   -- Put the result of the expression or part of the expression 
 *      in a temporary variable with a name that explains the purpose.
 *   -- Extract method(or Replace Temp with Query) can be considered.
 */
package scp02.extract.variable.after;

import java.util.Scanner;

public class Demo {

	static float getDiscountRate(int month) { 
		
		float discountRate = 0.0F;
		
		if (isSpring(month))
			 discountRate = 0.2F;
		else if (isSummer(month))
			 discountRate = 0.5F;
		else if (isFall(month))
			 discountRate = 0.2F;
		else
			 discountRate = 0.1F;
		return discountRate ;
	}

	private static boolean isFall(int month) {
		return month>= 9 && month<= 11;
	}

	private static boolean isSummer(int month) {
		return month>= 6 && month<= 8;
	}

	private static boolean isSpring(int month) {
		return month>= 3 && month<= 5;
	}
	
	//region Another Example
	static String platform = "macOS";
	static String browser = "IExplorer";
	static int resize = 0; // if resize > 0 then wasResized
	
	static boolean wasInitialized() { return true; }
	
	static void renderBanner() {
		boolean isMacOS = platform.toUpperCase().indexOf("MAC") > -1;
		boolean isIE = browser.toUpperCase().indexOf("IE") > -1;
		boolean wasResized = resize > 0;
		if (isMacOS && isIE && wasInitialized() && wasResized )
		{
			// do something
		}
	}
	//endRegion 

		
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Discount Rate: " 
			+ getDiscountRate(new Scanner(System.in).nextInt()));
	}

}
