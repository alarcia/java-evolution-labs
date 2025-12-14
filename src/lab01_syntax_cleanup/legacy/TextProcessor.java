package lab01_syntax_cleanup.legacy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextProcessor {

    static void main(String[] args) {
        TextProcessor processor = new TextProcessor();
        processor.generateReport("Financial", 2024);

        // Simulating a read operation
        processor.readFileContent("notes.txt");
    }
    public void generateReport(String reportName, int year) {
        // 1. Verbose type declarations (The "Diamond Operator" helped, but it's still long)
        // Imagine if these were complex types like Map<String, List<Integer>>
        List<String> headers = new ArrayList<String>();
        headers.add("ID");
        headers.add("Amount");
        headers.add("Cost");

        // 2. "Hellish" String concatenation (Hard to read and maintain)
        String jsonRequest = "{\n" +
                "  \"report\": \"" + reportName + "\",\n" +
                "  \"year\": " + year + ",\n" +
                "  \"isActive\": true,\n" +
                "  \"items\": [\n" +
                "    \"" + headers.get(0) + "\",\n" +
                "    \"" + headers.get(1) + "\"\n" +
                "  ]\n" +
                "}";

        System.out.println("Sending Legacy JSON:\n" + jsonRequest);

        // 3. Manual String processing
        String rawInput = "  user: admin  ";
        if (rawInput != null && !rawInput.trim().isEmpty()) {
            System.out.println("Processed: " + rawInput.trim().toUpperCase());
        }
    }

    // 4. Classic file reading (Noisy try-catch and line-by-line reading)
    public void readFileContent(String path) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File read: " + content.toString());
    }
}