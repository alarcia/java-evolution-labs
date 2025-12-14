package lab01_syntax_cleanup.modern;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TextProcessor {

    public static void main(String[] args) {
        var processor = new TextProcessor();
        processor.generateReport("Financial", 2024);

        // Using the correct relative path from project root
        processor.readFileContent("resources/notes.txt");
    }

    public void generateReport(String reportName, int year) {
        // 1. Inference & Immutable Lists
        // 'var' reduces visual noise. List.of() creates an unmodifiable list in one line.
        var headers = List.of("ID", "Amount", "Cost");

        // 2. Text Blocks (Java 15+)
        // Preserves format, eliminates escaping hell, and uses .formatted() for clear injection.
        var jsonRequest = """
                {
                  "report": "%s",
                  "year": %d,
                  "isActive": true,
                  "items": [
                    "%s",
                    "%s"
                  ]
                }""".formatted(reportName, year, headers.get(0), headers.get(1));

        System.out.println("Sending Modern JSON:\n" + jsonRequest);

        // 3. String improvements (Java 11+)
        // isBlank() handles nulls and whitespace safely.
        var rawInput = "  user: admin  ";
        if (rawInput != null && !rawInput.isBlank()) {
            System.out.println("Processed: " + rawInput.strip().toUpperCase());
        }
    }

    // 4. Modern I/O (Java 11+)
    // Reads the entire file content into a String with a single method call.
    // Automatically handles closing resources.
    public void readFileContent(String fileName) {
        try {
            var content = Files.readString(Path.of(fileName));
            System.out.println("File read:\n" + content);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}