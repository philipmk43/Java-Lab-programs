package com.Lab1;
import java.util.Scanner;

public class Lab1 {
    private String ccNumber;

    // Constructor to initialize credit card number
    public Lab1(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    // Method to validate the credit card number
    public void validateCard() {
        if (ccNumber.length() < 8 || ccNumber.length() > 9) {
            System.out.println("Invalid credit card number. Number should have 8 to 9 digits.");
            return;
        }

        // Convert the credit card number into a character array
        char[] cardArray = ccNumber.toCharArray();

        // Step a: Remove the last digit and store it
        int lastDigit = Character.getNumericValue(cardArray[cardArray.length - 1]);
        String remainingNumber = ccNumber.substring(0, ccNumber.length() - 1);

        // Step b: Reverse the remaining digits
        String reversedNumber = new StringBuilder(remainingNumber).reverse().toString();
        char[] reversedArray = reversedNumber.toCharArray();

        // Step c: Double digits in odd-numbered positions and sum the digits if the result is two digits
        int sum = 0;
        for (int i = 0; i < reversedArray.length; i++) {
            int digit = Character.getNumericValue(reversedArray[i]);

            // Double the digits in odd-numbered positions (1st, 3rd, 5th, etc.)
            if (i % 2 == 0) {
                digit *= 2;
                if (digit > 9) {
                    digit = digit / 10 + digit % 10;  // Add the digits of the result if it's a two-digit number
                }
            }
            sum += digit;
        }

        // Step e: Subtract the last digit obtained in step a from 10
        int result = 10 - (sum % 10);

        // Step f: Compare result with the last digit obtained in step a
        switch (result == lastDigit ? 1 : 0) {
            case 1:
                System.out.println("Valid credit card number.");
                break;
            case 0:
                System.out.println("Invalid credit card number.");
                break;
        }
    }

    public static void main(String[] args) {
        // Get input from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your credit card number: ");
        String ccNumber = sc.nextLine();

        // Create an instance of CreditCardValidator and validate the credit card
        Lab1 validator = new Lab1(ccNumber);
        validator.validateCard();
    }
}
