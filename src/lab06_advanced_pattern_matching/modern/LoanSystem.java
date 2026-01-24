package lab06_advanced_pattern_matching.modern;

public class LoanSystem {

    // 1. SEALED INTERFACE
    // The "permits" clause restricts the hierarchy.
    // ONLY HomeLoan and CarLoan can implement this.
    sealed interface Loan permits HomeLoan, CarLoan {}

    // 2. RECORDS match perfectly with Sealed Interfaces
    record HomeLoan(double amount, double interest) implements Loan {}
    record CarLoan(double amount) implements Loan {}

    public static void main(String[] args) {
        var system = new LoanSystem();
        system.calculateInterest(new HomeLoan(100000, 2.5));
    }

    public void calculateInterest(Loan loan) {
        // 3. SWITCH + RECORD PATTERN (Deconstruction)

        switch (loan) {
            // "HomeLoan(var a, var i)" -> Extracts fields directly into variables 'a' and 'i'.
            // No getters used!
            case HomeLoan(var a, var i) ->
                    System.out.println("Modern Home Loan: " + (a * (i / 100)));

            // Extract only what you need
            case CarLoan(var a) ->
                    System.out.println("Modern Car Loan: " + (a * 0.05));
        }

        // 4. EXHAUSTIVENESS
        // NO 'default' case.
        // The compiler knows 'Loan' is sealed and we covered all permitted types.
    }
}