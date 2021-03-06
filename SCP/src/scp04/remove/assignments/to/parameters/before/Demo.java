/*
 * SMELL: Non Const Parameters
 *   -- Some value is assigned to a parameter inside method's body.
 *   -- Same problem as DD-anomaly.
 * 
 * TREATMENT: Remove Assignment To Parameters
 *   -- Use a local variable(s) instead of a parameter.
 *   -- You can enforce this convention with the final/const keyword
  */
package scp04.remove.assignments.to.parameters.before;

public class Demo {
	int getDiscount(int inputVal, int quantity, int yearToDate) {
		if (inputVal > 50) {
		    inputVal -= 2;
		}
		if (quantity > 100) {
		    inputVal -= 1;
		}
		if (yearToDate > 10000) {
		    inputVal -= 4;
		}
		return inputVal;
	}
}
