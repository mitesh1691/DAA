import java.util.Scanner;
import java.util.Arrays;

public class FractionalKnapsack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the knapsack capacity: ");
        double capacity = scanner.nextDouble();

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        KnapsackItem[] items = new KnapsackItem[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter weight of item " + (i + 1) + ":");
            double weight = scanner.nextDouble();
            System.out.println("Enter value of item " + (i + 1) + ":");
            double value = scanner.nextDouble();
            items[i] = new KnapsackItem(i + 1, weight, value);
        }

        double maxValue = fractionalKnapsack(items, capacity);
        System.out.println("Total value added in the knapsack: " + maxValue);

        scanner.close();
    }

    public static double fractionalKnapsack(KnapsackItem[] items, double capacity) {
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double maxTotalValue = 0.0;
        double currentCapacity = capacity;

        for (KnapsackItem item : items) {
            if (currentCapacity <= 0) {
                break;
            }

            double fraction = Math.min(item.weight, currentCapacity);
            maxTotalValue += fraction * item.ratio;
            currentCapacity -= fraction;

            if (fraction > 0) {
                System.out.println("Taken: KnapsackItem{index=" + item.index + ", value=" + item.value +
                        ", weight=" + item.weight + ", ratio=" + item.ratio + "}");
            }
        }

        if (currentCapacity > 0) {
            System.out.println("Taken Fractional item: " + items[0].index + ", Taken fractional value: " + currentCapacity * items[0].ratio + ", used weight =" + currentCapacity + ", ratio = " + items[0].ratio);
        }

        return maxTotalValue;
    }
}

class KnapsackItem {
    int index;
    double value;
    double weight;
    double ratio;

    public KnapsackItem(int index, double weight, double value) {
        this.index = index;
        this.weight = weight;
        this.value = value;
        this.ratio = value / weight;
    }
}

//    Enter the knapsack capacity: 10
//        Enter the number of items: 5
//        Enter weight of item 1:
//        3
//        Enter value of item 1:
//        10
//        Enter weight of item 2:
//        3
//        Enter value of item 2:
//        15
//        Enter weight of item 3:
//        2
//        Enter value of item 3:
//        10
//        Enter weight of item 4:
//        5
//        Enter value of item 4:
//        12
//        Enter weight of item 5:
//        1
//        Enter value of item 5:
//        8
//        Taken: KnapsackItem{index=5, value=8.0, weight=1.0, ratio=8.0}
//        Taken: KnapsackItem{index=2, value=15.0, weight=3.0, ratio=5.0}
//        Taken: KnapsackItem{index=3, value=10.0, weight=2.0, ratio=5.0}
//        Taken: KnapsackItem{index=1, value=10.0, weight=3.0, ratio=3.3333333333333335}
//        Taken: KnapsackItem{index=4, value=12.0, weight=5.0, ratio=2.4}
//        Total value added in the knapsack: 45.4
//
//        Process finished with exit code 0
