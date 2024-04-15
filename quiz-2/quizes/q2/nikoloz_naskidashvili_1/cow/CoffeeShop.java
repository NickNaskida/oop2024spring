package quizes.q2.nikoloz_naskidashvili_1.cow;

public class CoffeeShop {

    public static void main(String[] args) {
        int pricePerCoffee = 250; // tetri
        int numCoffeeSold = 100;
        int totalCostOfBeans = 15000; // tetri
        int taxes = 63 * 1000; // tetri
        int waterBills = 98; // tetri
        int GasBills = 45; // tetri
        int electricityBills = 195 * 100; // tetri
        int parkingRent = 21 * 100; // tetri

        int otherExpenses = taxes + waterBills + GasBills + electricityBills + parkingRent;
        int totalExpenses = totalCostOfBeans + otherExpenses;

        double profit = calculateProfit(pricePerCoffee, numCoffeeSold, totalCostOfBeans, otherExpenses);

        System.out.printf("Total expenses: %.2f GEL\n", totalExpenses / 100.0);
        System.out.printf("Other expenses: %.2f GEL\n", otherExpenses / 100.0);
        System.out.printf("Profit: %.2f GEL\n", profit);
    }

    public static double calculateProfit(int pricePerCoffee, int numCoffeeSold, int totalCostOfBeans, int otherExpenses) {
        return (pricePerCoffee * numCoffeeSold - totalCostOfBeans - otherExpenses) / 100.0;
    }
}
