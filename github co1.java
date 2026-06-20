import java.util.Scanner;

public class CyberThreatRiskMonitoringSystem {

    private static int riskScore = 0;

    public static void checkFailedLogins(int failedLogins) {
        if (failedLogins > 10) {
            System.out.println("[CRITICAL] Possible Brute Force Attack Detected!");
            riskScore += 40;
        } else if (failedLogins > 5) {
            System.out.println("[WARNING] Multiple Failed Login Attempts Detected!");
            riskScore += 20;
        } else {
            System.out.println("[SAFE] Login Activity Normal.");
        }
    }

    public static void checkNetworkTraffic(double traffic) {
        if (traffic > 1000) {
            System.out.println("[WARNING] Unusual Network Traffic Spike Detected!");
            riskScore += 30;
        } else {
            System.out.println("[SAFE] Network Traffic Normal.");
        }
    }

    public static void checkMalware(boolean malwareFound) {
        if (malwareFound) {
            System.out.println("[CRITICAL] Malware Activity Detected!");
            riskScore += 50;
        } else {
            System.out.println("[SAFE] No Malware Detected.");
        }
    }

    public static void checkUnauthorizedAccess(boolean unauthorizedAccess) {
        if (unauthorizedAccess) {
            System.out.println("[CRITICAL] Unauthorized Access Attempt Detected!");
            riskScore += 40;
        } else {
            System.out.println("[SAFE] No Unauthorized Access.");
        }
    }

    public static void generateRiskReport() {
        System.out.println("\n========== CYBER THREAT REPORT ==========");
        System.out.println("Total Risk Score: " + riskScore);

        if (riskScore >= 80) {
            System.out.println("Threat Level: HIGH");
            System.out.println("Immediate Security Action Required!");
        } else if (riskScore >= 40) {
            System.out.println("Threat Level: MEDIUM");
            System.out.println("Monitor the System Closely.");
        } else {
            System.out.println("Threat Level: LOW");
            System.out.println("System is Secure.");
        }

        System.out.println("=========================================");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Cyber Threat Risk Monitoring System =====");

        System.out.print("Enter Number of Failed Login Attempts: ");
        int failedLogins = sc.nextInt();

        System.out.print("Enter Network Traffic (MB): ");
        double networkTraffic = sc.nextDouble();

        System.out.print("Malware Detected? (true/false): ");
        boolean malwareDetected = sc.nextBoolean();

        System.out.print("Unauthorized Access Attempt? (true/false): ");
        boolean unauthorizedAccess = sc.nextBoolean();

        System.out.println("\n----- Threat Analysis -----");

        checkFailedLogins(failedLogins);
        checkNetworkTraffic(networkTraffic);
        checkMalware(malwareDetected);
        checkUnauthorizedAccess(unauthorizedAccess);

        generateRiskReport();

        sc.close();
    }
}
