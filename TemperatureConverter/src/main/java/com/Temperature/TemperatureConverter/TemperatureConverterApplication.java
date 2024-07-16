package com.Temperature.TemperatureConverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TemperatureConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemperatureConverterApplication.class, args);

		Scanner scanner = new Scanner(System.in);
		boolean running = true;

		while (running) {
			System.out.println("-----------Welcome to Temperature Converter-----------");
			System.out.println("1. Convert Fahrenheit to Celsius");
			System.out.println("2. Convert Celsius to Fahrenheit");
			System.out.println("3. Convert Celsius to Kelvin");
			System.out.println("4. Convert Kelvin to Celsius");
			System.out.println("5. Convert Fahrenheit to Kelvin");
			System.out.println("6. Convert Kelvin to Fahrenheit");
			System.out.println("7. Exit");
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
				case 1:
					// Convert Fahrenheit to Celsius
					System.out.print("Enter temperature in Fahrenheit: ");
					String fahrenheit = scanner.nextLine();
					if (fahrenheit.matches("\\d+")) {
						double convertingDouble = Double.parseDouble ( fahrenheit);
						double celsiusFromFahrenheit = fahrenheitToCelsius ( convertingDouble );
						System.out.printf ( "%.2f Fahrenheit is %.2f Celsius%n" , convertingDouble , celsiusFromFahrenheit );
						break;
					}
					else
					{
						System.out.println ("Please enter a valid temperature in Fahrenheit" );
					}
					break;

				case 2:
					// Convert Celsius to Fahrenheit
					System.out.print("Enter temperature in Celsius: ");
					String celsius = scanner.nextLine();
					if(celsius.matches("\\d+")) {
						double convertingCelsius = Double.parseDouble ( celsius );
						double fahrenheitFromCelsius = celsiusToFahrenheit ( convertingCelsius );
						System.out.printf ( "%.2f Celsius is %.2f Fahrenheit%n" , convertingCelsius , fahrenheitFromCelsius );
						break;
					}
					else
					{
						System.out.println ("Please enter a valid temperature in Celsius" );
					}
					break;

				case 3:
					// Convert Celsius to Kelvin
					System.out.print("Enter temperature in Celsius: ");
					String celsiusForKelvin = scanner.nextLine();
					if(celsiusForKelvin.matches("\\d+")) {
						double convertingCelsius = Double.parseDouble(celsiusForKelvin);
						double kelvinFromCelsius = celsiusToKelvin(convertingCelsius);
						System.out.printf("%.2f Celsius is %.2f Kelvin%n", convertingCelsius, kelvinFromCelsius);
						break;
					}
					else
					{
						System.out.println ( "Please enter a valid temperature in Celsius" );
					}
					break;

				case 4:
					// Convert Kelvin to Celsius
					System.out.print("Enter temperature in Kelvin: ");
					String kelvin = scanner.nextLine();
					if(kelvin.matches("\\d+")) {
						double convertingKelvin = Double.parseDouble ( kelvin );
						double celsiusFromKelvin = kelvinToCelsius ( convertingKelvin );
						System.out.printf ( "%.2f Kelvin is %.2f Celsius%n" , convertingKelvin , celsiusFromKelvin );
						break;
					}
					else
					{
						System.out.println ( "Please enter a valid temperature in Kelvin" );
					}
					break;

				case 5:
					// Convert Fahrenheit to Kelvin
					System.out.print("Enter temperature in Fahrenheit: ");
					String fahrenheitForKelvin = scanner.nextLine();
					if(fahrenheitForKelvin.matches("\\d+")) {
						double convertingFahrenheitForKelvin = Double.parseDouble ( fahrenheitForKelvin )    ;
						double kelvinFromFahrenheit = fahrenheitToKelvin(convertingFahrenheitForKelvin);
						System.out.printf("%.2f Fahrenheit is %.2f Kelvin%n", convertingFahrenheitForKelvin, kelvinFromFahrenheit);
						break;
					}
					else
					{
						System.out.println ( "Please enter a valid temperature in Fahrenheit" );
					}

					break;
				case 6:
					// Convert Kelvin to Fahrenheit
					System.out.print("Enter temperature in Kelvin: ");
					String convertingKelvin = scanner.nextLine();
					if(convertingKelvin.matches("\\d+")) {
						double kelvinForFahrenheit = Double.parseDouble(convertingKelvin);
						double fahrenheitFromKelvin = kelvinToFahrenheit ( kelvinForFahrenheit );
						System.out.printf ( "%.2f Kelvin is %.2f Fahrenheit%n" , kelvinForFahrenheit , fahrenheitFromKelvin );
						break;
					}
					else
					{
						System.out.println ( "Please enter a valid temperature in Kelvin" );
					}
					break;
				case 7:
					running = false;
					System.out.println("Exiting program. Goodbye!");
					break;

				default:
					System.out.println("Invalid choice. Please try again.");
					break;
			}
			if (choice != 7) {
				System.out.print("Do you need to perform another conversion? (yes/no): ");
				String answer = scanner.next ();
				if (answer.equalsIgnoreCase("no")) {
					running = false;
					System.out.println("Thank you for using the Temperature Converter!");
				}
				if(!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")) {
					running = false;
					System.out.println ("Invalid Answer. Please try again." );
					System.out.print("Do you need to perform another conversion? (yes/no): ");
					String answer1 = scanner.next ();
					if (answer1.equalsIgnoreCase("no")) {
						running = false;
						System.out.println("Thank you for using the Temperature Converter!");
					}
					else {
						running = true;
					}

				}
			}
		}

		scanner.close();
	}

	// Celsius to Fahrenheit
	public static double celsiusToFahrenheit(double celsius) {
		return (celsius * 9 / 5) + 32;
	}

	// Fahrenheit to Celsius
	public static double fahrenheitToCelsius(double fahrenheit) {
		return (fahrenheit - 32) * 5 / 9;
	}

	// Celsius to Kelvin
	public static double celsiusToKelvin(double celsius) {
		return celsius + 273.15;
	}

	// Kelvin to Celsius
	public static double kelvinToCelsius(double kelvin) {
		return kelvin - 273.15;
	}

	// Fahrenheit to Kelvin
	public static double fahrenheitToKelvin(double fahrenheit) {
		return (fahrenheit - 32) * 5 / 9 + 273.15;
	}

	// Kelvin to Fahrenheit
	public static double kelvinToFahrenheit(double kelvin) {
		return (kelvin - 273.15) * 9 / 5 + 32;
	}
}