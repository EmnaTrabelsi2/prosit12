import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentManagement management = new StudentManagement();
        List<Student> students = new ArrayList<>(
                Arrays.asList(
                        new Student(3, "Alice", 21),
                        new Student(1, "Bob", 20),
                        new Student(2, "Charlie", 22)
                )
        );

        // Afficher tous les étudiants
        System.out.println("Tous les étudiants :");
        management.displayStudents(students, System.out::println);

        // Filtrer et afficher les étudiants âgés de plus de 20 ans
        System.out.println("\nÉtudiants avec âge > 20 :");
        management.displayStudentsByFilter(students, s -> s.getAge() > 20, System.out::println);

        // Récupérer les noms des étudiants
        System.out.println("\nNoms des étudiants :");
        String names = management.returnStudentsNames(students, Student::getName);
        System.out.println(names);

        // Créer un nouvel étudiant
        System.out.println("\nCréation d'un nouvel étudiant :");
        Student newStudent = management.createStudent(() -> new Student(4, "Diana", 23));
        System.out.println(newStudent);

        // Trier les étudiants par ID
        System.out.println("\nÉtudiants triés par ID :");
        List<Student> sortedStudents = management.sortStudentsById(students, Comparator.comparingInt(Student::getId));
        sortedStudents.forEach(System.out::println);

        // Convertir en stream et afficher
        System.out.println("\nConversion en Stream et affichage :");
        management.convertToStream(students).forEach(System.out::println);
    }
}

