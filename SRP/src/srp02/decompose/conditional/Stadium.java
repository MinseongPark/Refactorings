/*
 * SMELL: Complicated Conditional
 *   -- You have a complex conditional (if-then/else or switch).
 * 
 * TREATMENT: Decompose Conditional
 *   -- Decompose the complicated parts of the conditional 
 *   	into separate methods: the condition, then and else.
 *   -- May apply "Extract Method" (Make code clearer by 
 *   	decomposing it and replacing chunks of code with 
 *   	a method with meaningful name.
 *   
  */
package srp02.decompose.conditional;

import java.time.LocalDate;

class Stadium {
	private static final LocalDate SUMMER_START = LocalDate.of(2016, 6, 1);
	private static final LocalDate SUMMER_END = LocalDate.of(2016, 7, 31);
	// ...
	public double summerRate;
	public double winterRate;
	public double winterServiceCharge;

	public double getTicketPrice(LocalDate date, int quantity) {
		double charge;
		if (date.isBefore(SUMMER_START) || date.isAfter(SUMMER_END) ) { // not summer
			charge = quantity * winterRate + winterServiceCharge;
		} else {
			charge = quantity * summerRate;
		}
		return charge;
	}

}
