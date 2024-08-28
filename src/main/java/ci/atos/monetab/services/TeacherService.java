package ci.atos.monetab.services;

import ci.atos.monetab.models.Student;
import ci.atos.monetab.models.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    List<Teacher> getAllTeachers();

    Teacher save(Teacher teacher);

    Optional<Teacher> getTeacherById(long id);

    Teacher updateTeacher(Teacher teacher);

    void deleteTeacher(long id);
}
