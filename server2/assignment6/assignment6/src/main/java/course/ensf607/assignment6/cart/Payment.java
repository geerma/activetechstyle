package course.ensf607.assignment6.cart;

import course.ensf607.assignment6.billing.Billing;

public class Payment {
	
	public static Boolean checkOut(Cart cart, Billing billing) {
		Boolean isApproved = true;
		if (isApproved) {
			return true;
		}
		else {
			return false;
		}
	}

}
