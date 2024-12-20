package StudentPortal;
import java.util.List;
import java.util.Scanner;

public class UserAuth {
    private List<User> users;

    public UserAuth(List<User> users) {
        this.users = users;
    }

    public void registerUser(Scanner scanner) {
        System.out.print("Enter student email: ");
        String email = scanner.nextLine();
        System.out.print("Enter matric number: ");
        String matricNumber = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter academic subjects (separate with semicolons): ");
        List<String> subjects = List.of(scanner.nextLine().split(";"));

        System.out.print("Enter co-curricular clubs (separate with semicolons): ");
        List<String> clubs = List.of(scanner.nextLine().split(";"));

        User newUser = new User(email, matricNumber, password, subjects, clubs);
        users.add(newUser);
        System.out.println("Registration successful!");
    }

    public User loginUser(Scanner scanner) {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getStudentEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Login successful!");
                return user;
            }
        }
        System.out.println("Invalid email or password.");
        return null;
    }
}
