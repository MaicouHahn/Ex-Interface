package model.services;

import java.time.Duration;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
	private Double pricePernHour;
	private Double pricePernDay;
	private TaxServices taxService;

	public RentalService(Double pricePernHour, Double pricePernDay, TaxServices taxService) {
		this.pricePernHour = pricePernHour;
		this.pricePernDay = pricePernDay;
		this.taxService = taxService;
	}

	public void processInvoice(CarRental carRental) {
		
		double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
		double hours = minutes/60;
		
		double basicPayment;
		
		if(hours <=12) {
			basicPayment = pricePernHour* Math.ceil(hours);//arredonda para cima
		}else {
			
			basicPayment = pricePernDay* Math.ceil(hours/24);//arredonda para cima

		}
		
		double tax = taxService.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}
}
