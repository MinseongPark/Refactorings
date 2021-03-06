/*
 * SMELL: Implicit Assertion, Complex Conditional Expression
 *   -- For a portion of code to work correctly, 
 *      certain conditions or values must be true.
 *   -- A section of code assumes something about the state of 
 *      the program. Sometimes the assumptions are stated with a comment
 * 
 * TREATMENT: Introduce Assertion
 *   -- Make the assumption explicit with an assertion.
  */
package scp06.introduce.assertions.before;

class Project
{
	public double getMemberExpenseLimit()
	{
		return 1234.0;
	}
}

public class Demo
{
	private static final double NULL_EXPENSE = -1.0;
	private double expenseLimit;
	private Project primaryProject;

	public double getExpenseLimit()
	{
		// should have either expense limit or a primary project
		return (expenseLimit != NULL_EXPENSE) ? 
				expenseLimit : primaryProject.getMemberExpenseLimit();
	}

	//region Do not use assertions to check the parameters of a public method
	// -- the assert construct does not throw an exception of the specified type.
	// -- It can throw only an "AssertionError".
	public void setRefreshRate(int rate)
	{
		// Enforce specified precondition in public method
		//assert (rate > 0 && rate <= MAX_REFRESH_RATE);

		if (rate <= 0 || rate > MAX_REFRESH_RATE)
			throw new IllegalArgumentException("Illegal rate: " + rate);
		setRefreshInterval(1000 / rate);
	}
	//endregion

	//region "OK to use for private method
	private static final int MAX_REFRESH_RATE = 0;

	private void setRefreshInterval(int interval)
	{
		// Confirm adherence to precondition in nonpublic method
		assert interval > 0 && interval <= 1000 / MAX_REFRESH_RATE : interval;

		// ... Set the refresh interval
	}
	//endregion
}
