import java.util.Scanner;

public class FibonacciIterative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        System.out.println("Fibonacci Series up to " + n + ":");
        for (int i = 0; i <= n; i++) {
            int fibonacciValue = fibonacciIterative(i);
            System.out.print(fibonacciValue + " ");
        }

        int fibonacciN = fibonacciIterative(n);
        System.out.println("\nFibonacci value at position " + n + " is: " + fibonacciN);

        scanner.close();
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) {
            return n;
        }

        int fib1 = 0;
        int fib2 = 1;
        int fibonacciValue = 0;

        for (int i = 2; i <= n; i++) {
            fibonacciValue = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibonacciValue;
        }

        return fibonacciValue;
    }
}
