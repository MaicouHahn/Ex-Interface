package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxServices;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		System.out.println("Enter the Rental Data: ");
		System.out.print("Car Model: ");
		String carmodel = scan.nextLine();
		System.out.println("Rental Beggining Date (DD/MM/YYYY): ");
		LocalDateTime start = LocalDateTime.parse(scan.nextLine(), fmt);
		System.out.println("Rental End Date (DD/MM/YYYY): ");
		LocalDateTime finish = LocalDateTime.parse(scan.nextLine(), fmt);

		CarRental cr = new CarRental(start, finish, new Vehicle(carmodel));
		
		System.out.println("Enter the Price per Hour");
		double pricePerHour=scan.nextDouble();
		System.out.println("Enter the Price per Day");
		double pricePerDay=scan.nextDouble();
		
		RentalService rentallService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxServices());
		
		rentallService.processInvoice(cr);
		
		System.out.println("Bill: ");
		System.out.println("Basic payment: "+cr.getInvoice().getBasicPayment());
		System.out.println("Tax: "+cr.getInvoice().getTax());
		System.out.println("TotalPayment: "+cr.getInvoice().getTotalPayment());
		
		rentallService.processInvoice(cr);
		
		scan.close();
	}

}
