import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of Fibonacci numbers to generate: ");
        int n = scanner.nextInt();
        scanner.close();

        System.out.println("Fibonacci numbers using recursion:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciRecursive(i) + " ");
        }

        System.out.println("\nFibonacci numbers without recursion:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciNonRecursive(i) + " ");
        }
    }

    // Recursive Fibonacci calculation
    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }
    }

    // Non-recursive Fibonacci calculation
    public static int fibonacciNonRecursive(int n) {
        if (n <= 1) {
            return n;
        } else {
            int a = 0;
            int b = 1;
            int result = 0;
            for (int i = 2; i <= n; i++) {
                result = a + b;
                a = b;
                b = result;
            }
            return result;
        }
    }
}
