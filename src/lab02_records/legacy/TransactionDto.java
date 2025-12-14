package lab02_records.legacy;

import java.time.LocalDateTime;
import java.util.Objects;

public class TransactionDto {
    private final String id;
    private final double amount;
    private final String type;
    private final LocalDateTime timestamp;

    public TransactionDto(String id, double amount, String type, LocalDateTime timestamp) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.timestamp = timestamp;
    }

    // Getters (No setters, because we want immutability)
    public String getId() { return id; }
    public double getAmount() { return amount; }
    public String getType() { return type; }
    public LocalDateTime getTimestamp() { return timestamp; }

    // toString() - Essential for logging
    @Override
    public String toString() {
        return "TransactionDto{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    // equals() and hashCode() - Essential for Comparisons and HashMaps
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionDto that = (TransactionDto) o;
        return Double.compare(that.amount, amount) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(type, that.type) &&
                Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, type, timestamp);
    }

    // Simple test inside the class
    public static void main(String[] args) {
        TransactionDto t1 = new TransactionDto("TX001", 100.50, "CREDIT", LocalDateTime.now());
        System.out.println("Legacy DTO created: " + t1);
    }
}