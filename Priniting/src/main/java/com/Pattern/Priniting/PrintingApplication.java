package com.Pattern.Priniting;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class PrintingApplication {
	public static void main(String[] args) {
				Scanner scanner = new Scanner(System.in);
				boolean continueGenerating = true;

				while (continueGenerating) {
					System.out.println("Select a pattern type by entering the corresponding number:");
					System.out.println("1. Right-Angle Triangle Pattern");
					System.out.println("2. Inverted Right-Angle Triangle Pattern");
					System.out.println("3. Pyramid Number Pattern");
					System.out.println("4. Inverted Pyramid Number Pattern");
					System.out.println("5. Diamond Number Pattern");
					System.out.println("6. Hollow Diamond Number Pattern");
					System.out.println("7. Pascal’s Triangle Pattern");
					System.out.println("8. Floyd’s Triangle Pattern");
					System.out.println("9. Palindromic Number Pattern");
					System.out.println("10. Binary Number Pyramid Pattern");


					System.out.print("Enter your choice: " );
					int patternType = scanner.nextInt();

					System.out.print("Enter the number of rows: ");
					int rows = scanner.nextInt();

					switch (patternType) {
						case 1:
							rightAngleTriangle(rows);
							break;
						case 2:
							invertedRightAngleTriangle(rows);
							break;
						case 3:
							pyramid(rows);
							break;
						case 4:
							invertedPyramid(rows);
							break;
						case 5:
							diamond(rows);
							break;
						case 6:
							hollowDiamond(rows);
							break;
						case 7:
							pascalTriangle(rows);
							break;
						case 8:
							floydTriangle(rows);
							break;
						case 9:
							palindromicPattern(rows);
							break;
						case 10:
							binaryPyramid(rows);
							break;
						default:
							System.out.println("Invalid pattern type selected.");
					}

					System.out.print("Would you like to generate another pattern? (yes/no): ");
					String response = scanner.next();
					if (!response.equalsIgnoreCase("yes")) {
						continueGenerating = false;
					}
				}

				scanner.close();
			}

			public static void rightAngleTriangle(int rows) {
				for (int i = 1; i <= rows; i++) {
					for (int j = 1; j <= i; j++) {
						System.out.print(j + " ");
					}
					System.out.println();
				}
			}

			public static void invertedRightAngleTriangle(int rows) {
				for (int i = rows; i >= 1; i--) {
					for (int j = 1; j <= i; j++) {
						System.out.print(j + " ");
					}
					System.out.println();
				}
			}

			public static void pyramid(int rows) {
				for (int i = 1; i <= rows; i++) {
					for (int j = i; j < rows; j++) {
						System.out.print("  ");
					}
					for (int k = 1; k <= (2 * i - 1); k++) {
						System.out.print(k + " ");
					}
					System.out.println();
				}
			}

			public static void invertedPyramid(int rows) {
				for (int i = rows; i >= 1; i--) {
					for (int j = rows; j > i; j--) {
						System.out.print("  ");
					}
					for (int k = 1; k <= (2 * i - 1); k++) {
						System.out.print(k + " ");
					}
					System.out.println();
				}
			}

			public static void diamond(int rows) {
				pyramid(rows);
				for (int i = rows - 1; i >= 1; i--) {
					for (int j = rows; j > i; j--) {
						System.out.print("  ");
					}
					for (int k = 1; k <= (2 * i - 1); k++) {
						System.out.print(k + " ");
					}
					System.out.println();
				}
			}

			public static void hollowDiamond(int rows) {
				for (int i = 1; i <= rows; i++) {
					for (int j = rows; j > i; j--) {
						System.out.print(" ");
					}
					for (int k = 1; k <= (2 * i - 1); k++) {
						if (k == 1 || k == (2 * i - 1)) {
							System.out.print("*");
						} else {
							System.out.print(" ");
						}
					}
					System.out.println();
				}
				for (int i = rows - 1; i >= 1; i--) {
					for (int j = rows; j > i; j--) {
						System.out.print(" ");
					}
					for (int k = 1; k <= (2 * i - 1); k++) {
						if (k == 1 || k == (2 * i - 1)) {
							System.out.print("*");
						} else {
							System.out.print(" ");
						}
					}
					System.out.println();
				}
			}

			public static void pascalTriangle(int rows) {
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < rows - i; j++) {

						System.out.print(" ");
					}
					int number = 1;
					for (int k = 0; k <= i; k++) {
						System.out.print(number + " ");
						number = number * (i - k) / (k + 1);
					}
					System.out.println();
				}
			}

			public static void floydTriangle(int rows) {
				int number = 1;
				for (int i = 1; i <= rows; i++) {
					for (int j = 1; j <= i; j++) {
						System.out.print(number + " ");
						number++;
					}
					System.out.println();
				}
			}

			public static void palindromicPattern(int rows) {
				for (int i = 1; i <= rows; i++) {
					for (int j = rows; j > i; j--) {
						System.out.print(" ");
					}
					int k = i;
					for (int j = 1; j <= i; j++) {
						System.out.print(k-- + " ");
					}
					k = 2;
					for (int j = 1; j < i; j++) {
						System.out.print(k++ + " ");
					}
					System.out.println();
				}
			}

			public static void binaryPyramid(int rows) {
				for (int i = 1; i <= rows; i++) {
					for (int j = rows; j > i; j--) {
						System.out.print(" ");
					}
					for (int j = 1; j <= i; j++) {
						System.out.print((j % 2) + " ");
					}
					for (int j = i - 1; j >= 1; j--) {
						System.out.print((j % 2) + " ");
					}
					System.out.println();
				}
			}
		}