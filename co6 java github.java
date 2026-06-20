import java.util.Scanner;

public class RodCuttingProfitMaximization {

    // Function to find maximum profit
    public static int maxProfit(int[] price, int n) {
        int[] dp = new int[n + 1];

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int maxValue = Integer.MIN_VALUE;

            for (int j = 0; j < i; j++) {
                maxValue = Math.max(maxValue, price[j] + dp[i - j - 1]);
            }

            dp[i] = maxValue;
        }

        return dp[n];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rod length: ");
        int n = sc.nextInt();

        int[] price = new int[n];

        System.out.println("Enter prices for lengths 1 to " + n + ":");

        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }

        int result = maxProfit(price, n);

        System.out.println("Maximum Obtainable Profit = " + result);

        sc.close();
    }
}