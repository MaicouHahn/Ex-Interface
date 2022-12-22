package model.services;

public class UsTaxServices {
	public double tax(double amount) {

		if (amount <= 100.0) {
			return amount * 0.33;
		} else {
			return amount * 0.21;
		}
	}
}
