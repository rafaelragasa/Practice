import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) { // Automatically close the scanner resource
            System.out.println("Enter a number:");
            if (scanner.hasNextInt()) { // Check if the next input is an integer
                int num = scanner.nextInt();
                // I Validate user input to ensure it is non-negative
                if (num < 0) {
                    System.out.println("Please enter a non-negative number.");
                } else {
                    BigInteger factorialResult = factorial(BigInteger.valueOf(num));
                    System.out.println("The factorial of " + num + " is " + factorialResult);
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
            }
        } catch (Exception e) {
            // Handle potential exceptions such as InputMismatchException
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // I used an iterative approach to avoid potential stack overflow with large inputs
    public static BigInteger factorial(BigInteger num) {
        BigInteger result = BigInteger.ONE;
        for (BigInteger i = BigInteger.ONE; i.compareTo(num) <= 0; i = i.add(BigInteger.ONE)) {
            result = result.multiply(i);
        }
        return result;
    }
}
