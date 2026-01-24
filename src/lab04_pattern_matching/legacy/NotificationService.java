package lab04_pattern_matching.legacy;

public class NotificationService {

    // Classic POJOs representing messages
    static class Email {
        String msg;
        String email;
        public Email(String msg, String email) { this.msg = msg; this.email = email; }
    }

    static class SMS {
        String msg;
        String phone;
        public SMS(String msg, String phone) { this.msg = msg; this.phone = phone; }
    }

    public static void main(String[] args) {
        NotificationService service = new NotificationService();
        service.send(new Email("Hello", "admin@corp.com"));
        service.send(new SMS("Alert", "600-000-000"));
        service.send("Just a String");
    }

    public void send(Object notification) {
        // LEGACY PATTERN: "Test - Cast - Use"
        // 1. Check the type
        if (notification instanceof Email) {
            // 2. We MUST cast it manually to access fields
            Email email = (Email) notification;
            System.out.println("Sending Email to " + email.email + ": " + email.msg);

        } else if (notification instanceof SMS) {
            // 2. Repeated casting logic
            SMS sms = (SMS) notification;
            System.out.println("Sending SMS to " + sms.phone + ": " + sms.msg);

        } else {
            System.out.println("Unknown notification type");
        }
    }
}