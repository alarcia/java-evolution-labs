package lab02_records.modern;

import java.time.LocalDateTime;

// 1. THE DECLARATION
// "public record" defines the class and its final fields in one go.
// Java automatically generates: constructor, accessors, equals(), hashCode(), and toString().
public record TransactionDto(
        String id,
        double amount,
        String type,
        LocalDateTime timestamp
) {

    // 2. COMPACT CONSTRUCTOR (Optional)
    // You don't need to write the constructor arguments or assignment (this.x = x).
    // Use this strictly for validation.
    public TransactionDto {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID cannot be empty");
        }
    }

    // 3. TESTING INSIDE (Just to demo)
    public static void main(String[] args) {
        var now = LocalDateTime.now();

        // Creating instances
        var t1 = new TransactionDto("TX001", 100.50, "CREDIT", now);
        var t2 = new TransactionDto("TX001", 100.50, "CREDIT", now);

        // a) toString() is already beautiful
        System.out.println("Record: " + t1);

        // b) equals() works perfectly by checking data, not memory
        System.out.println("Are they equal? " + t1.equals(t2)); // Prints true

        // c) Accessors are fluent (no 'get' prefix)
        System.out.println("Amount: " + t1.amount()); // Not getAmount()
    }
}