package lab03_switch_expressions.modern;

public class PaymentSystem {

    public enum PaymentMethod {
        CREDIT_CARD, PAYPAL, BANK_TRANSFER, CRYPTO
    }

    public static void main(String[] args) {
        var system = new PaymentSystem();
        system.processPayment(PaymentMethod.PAYPAL, 100.0);
        system.processPayment(PaymentMethod.CRYPTO, 100.0);
        system.processPayment(PaymentMethod.BANK_TRANSFER, 100.0);
    }

    public void processPayment(PaymentMethod method, double amount) {
        // 1. SWITCH EXPRESSION
        // Assigns the result directly to 'fee'.
        // Uses "->" (Arrow syntax). No fall-through, no 'break' needed.
        var fee = switch (method) {
            case CREDIT_CARD   -> amount * 0.02;
            case BANK_TRANSFER -> 0.0;
            case CRYPTO        -> amount * 0.01;

            // 2. MULTI-LINE BLOCK + YIELD
            // If you need logic inside a case, use a block { ... }
            // 'yield' returns the value (it's like 'return' but for switch).
            case PAYPAL -> {
                System.out.println("Connecting to PayPal API...");
                yield amount * 0.05;
            }
        };

        // 3. EXHAUSTIVENESS CHECK
        // Notice there is NO 'default'.
        // Since we covered all Enum cases, Java compiles.
        // If a case is missing, the compiler will throw ERROR immediately.
        // This prevents business logic bugs when adding new payment types.

        var status = (fee == 0.0) ? "FREE" : "FEE_APPLIED";

        System.out.printf("Modern Payment: Fee=%.2f, Status=%s%n", fee, status);
    }
}