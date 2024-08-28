package ci.atos.monetab.services;

import ci.atos.monetab.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();

    Student save(Student student);

    Optional<Student> getStudentById(long id);

    Student updateStudent(Student student);

    void deleteStudent(long id);
}
