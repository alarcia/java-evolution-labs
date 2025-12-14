package lab03_switch_expressions.legacy;

public class PaymentSystem {

    public enum PaymentMethod {
        CREDIT_CARD, PAYPAL, BANK_TRANSFER, CRYPTO
    }

    public static void main(String[] args) {
        PaymentSystem system = new PaymentSystem();
        system.processPayment(PaymentMethod.PAYPAL, 100.0);
    }

    public void processPayment(PaymentMethod method, double amount) {
        double fee = 0;
        String status = "";

        // LEGACY SWITCH:
        // 1. Verbose (all those "case", "break", ":")
        // 2. Error-prone: If I forget a 'break', it executes the next case!
        switch (method) {
            case CREDIT_CARD:
                fee = amount * 0.02;
                status = "PROCESSED";
                break;
            case PAYPAL:
                fee = amount * 0.05;
                status = "PENDING_APPROVAL";
                break;
            case BANK_TRANSFER:
                fee = 0; // No fee
                status = "PROCESSED";
                break;
            // Case CRYPTO is missing! The code compiles, but logic is incomplete.
            // Also, notice we are mutating 'fee' and 'status' variables.
            default:
                fee = amount * 0.10;
                status = "UNKNOWN";
        }

        System.out.printf("Legacy Payment: Fee=%.2f, Status=%s%n", fee, status);
    }
}