import java.util.Scanner;

public class NetworkTrafficSpikeDetection {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of traffic records: ");
        int n = sc.nextInt();

        int[] traffic = new int[n];

        System.out.println("Enter traffic values (Mbps):");
        for (int i = 0; i < n; i++) {
            traffic[i] = sc.nextInt();
        }

        System.out.print("Enter spike threshold (Mbps): ");
        int threshold = sc.nextInt();

        System.out.println("\nTraffic Analysis Report");
        System.out.println("------------------------");

        boolean spikeFound = false;

        for (int i = 1; i < n; i++) {
            int increase = traffic[i] - traffic[i - 1];

            if (increase > threshold) {
                spikeFound = true;
                System.out.println(
                    "Spike Detected at Record " + (i + 1) +
                    " | Previous Traffic: " + traffic[i - 1] + " Mbps" +
                    " | Current Traffic: " + traffic[i] + " Mbps" +
                    " | Increase: " + increase + " Mbps"
                );
            }
        }

        if (!spikeFound) {
            System.out.println("No Traffic Spikes Detected.");
        }

        sc.close();
    }
}