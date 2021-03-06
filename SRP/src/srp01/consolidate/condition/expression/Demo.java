/*
 * SMELL: A Sequence of Condition Tests With The Same Result
 *   -- You have a sequence of conditional tests with the same result.
 * 
 * TREATMENT: Consolidate Conditional Expression
 *   -- Combine them into a single conditional expression.
 *   -- It Makes the check clearer.
 *   -- May continue refactoring with "Extract Method".
 *   
  */
package srp01.consolidate.condition.expression;

class Payout {
	  // ...

	  public int seniority;
	  public int monthsDisabled;
	  public boolean isPartTime;

	  public double disabilityAmount() {
	    if (seniority < 2) {	// not eligible for disability
	      return 0;
	    }
	    if (monthsDisabled > 12) { // not eligible for disability
	      return 0;
	    }
	    if (isPartTime) { // not eligible for disability
	      return 0;
	    }
	    // compute the disability amount
	    // ...
	    return 1234.0; // dummy
	  }

	  public double vacationAmount() {
	    if (onVacation()) {
	      if (lengthOfService() > 10) {
	        return 1;
	      }
	    }
	    return 0.5;
	  }

	private int lengthOfService() {
		return 0; // dummy
	}

	private boolean onVacation() {
		return false; // dummy
	}
}
