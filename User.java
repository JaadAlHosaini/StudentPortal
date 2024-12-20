package StudentPortal;

import java.util.List;

public class User {
    private String studentEmail;
    private String matricNumber;
    private String password;
    private List<String> academicSubjects;
    private List<String> coCurricularClubs;

    public User(String studentEmail, String matricNumber, String password,
                List<String> academicSubjects, List<String> coCurricularClubs) {
        this.studentEmail = studentEmail;
        this.matricNumber = matricNumber;
        this.password = password;
        this.academicSubjects = academicSubjects;
        this.coCurricularClubs = coCurricularClubs;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public String getMatricNumber() {
        return matricNumber;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getAcademicSubjects() {
        return academicSubjects;
    }

    public List<String> getCoCurricularClubs() {
        return coCurricularClubs;
    }

    @Override
    public String toString() {
        return studentEmail + "\n" + matricNumber + "\n" + password + "\n" +
                String.join(", ", academicSubjects) + "\n" +
                String.join(", ", coCurricularClubs) + "\n";
    }
}

