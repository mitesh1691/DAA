import java.util.*;

public class FractionalKnapsack {
    public static void fractionalKnapsack(ArrayList<KnapsackItem> items, int capacity) {
        items.sort(Comparator.comparing(KnapsackItem::getRatio).reversed());

        int usedCapacity = 0;
        double totalValue = 0.0;

        for (KnapsackItem item : items) {
            if (usedCapacity + item.getWeight() <= capacity) {
                usedCapacity += item.getWeight();
                System.out.println("Taken: KnapsackItem{index=" + item.getIndex() + ", value=" + item.getValue() +
                        ", weight=" + item.getWeight() + ", ratio=" + item.getRatio() + "}");
                totalValue += item.getValue();
            } else {
                int remainingCapacity = capacity - usedCapacity;
                double fractionValue = (double) remainingCapacity * item.getRatio();
                System.out.println("Taken Fractional item: " + item.getIndex() + ", Taken fractional value: " + fractionValue +
                        ", used weight = " + remainingCapacity + ", ratio = " + item.getRatio());

                usedCapacity += remainingCapacity;
                totalValue += fractionValue;
            }

            if (usedCapacity == capacity) {
                break;
            }
        }

        System.out.println("Total value added in the knapsack: " + totalValue);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the knapsack capacity: ");
        int capacity = sc.nextInt();

        System.out.print("Enter the number of items: ");
        int n = sc.nextInt();

        ArrayList<KnapsackItem> items = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight of the item " + (i + 1) + ": ");
            int weight = sc.nextInt();
            System.out.print("Enter value of the item " + (i + 1) + ": ");
            int value = sc.nextInt();

            items.add(new KnapsackItem(i, weight, value));
        }

        sc.close();
        fractionalKnapsack(items, capacity);
    }
}
class KnapsackItem {
    int index;
    int value;
    int weight;
    double ratio;

    public KnapsackItem(int index, int weight, int value) {
        this.index = index;
        this.weight = weight;
        this.value = value;
        this.ratio = (double) value / weight;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    public double getRatio() {
        return ratio;
    }
}


//output:
//        Enter the knapsack capacity: 10
//        Enter the number of items: 5
//        Enter weight of the item 1: 3
//        Enter value of the item 1: 10
//        Enter weight of the item 2: 3
//        Enter value of the item 2: 15
//        Enter weight of the item 3: 2
//        Enter value of the item 3: 10
//        Enter weight of the item 4: 5
//        Enter value of the item 4: 12
//        Enter weight of the item 5: 1
//        Enter value of the item 5: 8
//        Taken: KnapsackItem{index=4, value=8, weight=1, ratio=8.0}
//        Taken: KnapsackItem{index=1, value=15, weight=3, ratio=5.0}
//        Taken: KnapsackItem{index=2, value=10, weight=2, ratio=5.0}
//        Taken: KnapsackItem{index=0, value=10, weight=3, ratio=3.3333333333333335}
//        Taken Fractional item: 3, Taken fractional value: 2.4, used weight = 1, ratio = 2.4
//        Total value added in the knapsack: 45.4
//
//        Process finished with exit code 0
