package ci.atos.monetab.repositories;

import ci.atos.monetab.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
