import java.io.*;
import java.util.*;

public class EnrolledSubjects {
    public static void main(String[] args) {
        // Step 1: Read the AcademicSubjects.txt file and create a mapping
        Map<String, String> subjectMapping = new HashMap<>();
        String filePath = "C:\\Users\\ggg\\Downloads\\Enrolledsubject\\AcademicSubjects.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    subjectMapping.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Step 2: List of enrolled subject codes for the student
        List<String> enrolledSubjects = Arrays.asList(
            "3472", "4551", "4541", "6531", "1119", "1249", "1103", "1449", "1225", "4531"
        );

        // Step 3: Map the enrolled subject codes to their names
        List<Subject> mappedSubjects = new ArrayList<>();
        for (String code : enrolledSubjects) {
            String name = subjectMapping.get(code);
            if (name != null) {
                mappedSubjects.add(new Subject(code, name));
            }
        }

        // Step 4: Sort the subjects by name
        mappedSubjects.sort(Comparator.comparing(Subject::getName));

        // Step 5: Display the results
        System.out.println("Enrolled Subjects:");
        System.out.println("=".repeat(72));
        for (Subject subject : mappedSubjects) {
            System.out.println(subject.getCode() + ": " + subject.getName());
        }
    }

    // Helper class to store subject details
    static class Subject {
        private String code;
        private String name;

        public Subject(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }
}
