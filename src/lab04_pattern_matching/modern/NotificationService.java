package lab04_pattern_matching.modern;

public class NotificationService {

    // 1. Using Records for data (concise & immutable)
    record Email(String msg, String email) {}
    record SMS(String msg, String phone) {}

    public static void main(String[] args) {
        var service = new NotificationService();
        service.send(new Email("Hello", "admin@corp.com"));
        service.send(new SMS("Alert", "600-000-000"));
        service.send("Just a String");
    }

    public void send(Object notification) {
        // MODERN PATTERN MATCHING (Java 21)

        // This switch works on TYPE, not just value.
        // case Email e -> : Checks if it is Email AND also casts it to variable 'e' automatically.

        switch (notification) {
            case Email e ->
                    System.out.println("Modern Email to " + e.email() + ": " + e.msg());

            case SMS s ->
                    System.out.println("Modern SMS to " + s.phone() + ": " + s.msg());

            case String str when str.startsWith("Error") ->
                    System.out.println("Logging Error: " + str);

            case String str ->
                    System.out.println("Unknown String message: " + str);

            case null ->
                    System.out.println("Received null notification!");

            default ->
                    System.out.println("Discarding unknown object: " + notification.getClass());
        }
    }
}