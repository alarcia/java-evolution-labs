package lab06_advanced_pattern_matching.legacy;

public class LoanSystem {

    // 1. OPEN HIERARCHY
    // Anyone can extend this. The compiler creates no guarantees.
    interface Loan {}

    static class HomeLoan implements Loan {
        private final double amount;
        private final double interest;
        public HomeLoan(double amount, double interest) { this.amount = amount; this.interest = interest; }
        public double getAmount() { return amount; }
        public double getInterest() { return interest; }
    }

    static class CarLoan implements Loan {
        private final double amount;
        public CarLoan(double amount) { this.amount = amount; }
        public double getAmount() { return amount; }
    }

    public static void main(String[] args) {
        LoanSystem system = new LoanSystem();
        system.calculateInterest(new HomeLoan(100000, 2.5));
    }

    public void calculateInterest(Loan loan) {
        // LEGACY WAY
        if (loan instanceof HomeLoan) {
            HomeLoan hl = (HomeLoan) loan; // Cast
            // Manual extraction (Getters)
            double total = hl.getAmount() * (hl.getInterest() / 100);
            System.out.println("Home Loan Interest: " + total);
        }
        else if (loan instanceof CarLoan) {
            CarLoan cl = (CarLoan) loan; // Cast
            // Logic specific to CarLoan
            System.out.println("Car Loan fixed fee: " + (cl.getAmount() * 0.05));
        }
        else {
            // This MUST be handled because 'Loan' is open.
            // Someone could create 'BoatLoan' without us knowing.
            System.out.println("Unknown loan type");
        }
    }
}