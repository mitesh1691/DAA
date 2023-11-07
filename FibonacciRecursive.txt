import java.util.Scanner;

public class FibonacciRecursive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        System.out.println("Fibonacci Series up to " + n + ":");
        for (int i = 0; i <= n; i++) {
            int fibonacciValue = fibonacci(i);
            System.out.print(fibonacciValue + " ");
        }

        int fibonacciN = fibonacci(n);
        System.out.println("\nFibonacci value at position " + n + " is: " + fibonacciN);

        scanner.close();
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
