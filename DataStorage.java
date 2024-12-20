package StudentPortal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataStorage {
    private static final String FILE_NAME = "C:/Users/jaada/Desktop/StudentPortal/src/UserData.txt";



    public static List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String email;
            while ((email = br.readLine()) != null) { // Read email
                String matricNumber = br.readLine();
                String password = br.readLine();
                String subjectsLine = br.readLine();
                String clubsLine = br.readLine();

                // Validate data integrity
                if (matricNumber == null || password == null || subjectsLine == null || clubsLine == null) {
                    System.err.println("Error: Malformed or incomplete user data. Skipping...");
                    break; // Exit loop if data is corrupted
                }

                // Process subjects and clubs
                String[] subjects = subjectsLine.split(", ");
                String[] clubs = clubsLine.split(", ");

                // Create user and add to list
                List<String> academicSubjects = List.of(subjects);
                List<String> coCurricularClubs = List.of(clubs);
                users.add(new User(email, matricNumber, password, academicSubjects, coCurricularClubs));

                // Read blank line separating users (if present)
                br.readLine();
            }
        } catch (IOException e) {
            System.err.println("Error loading users: " + e.getMessage());
        }
        return users;
    }



    public static void saveUsers(List<User> users) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (User user : users) {
                bw.write(user.toString()); // Use the User's toString method
                bw.newLine(); // Add an extra blank line to separate users
            }
        } catch (IOException e) {
            System.err.println("Error saving users: " + e.getMessage());
        }
    }

}
