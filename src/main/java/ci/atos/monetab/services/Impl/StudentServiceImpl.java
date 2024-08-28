package ci.atos.monetab.services.Impl;

import ci.atos.monetab.models.Address;
import ci.atos.monetab.models.Student;
import ci.atos.monetab.models.Teacher;
import ci.atos.monetab.repositories.AddressRepository;
import ci.atos.monetab.repositories.StudentRepository;
import ci.atos.monetab.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;
    private final AddressRepository addressRepository;

    public StudentServiceImpl(StudentRepository studentRepository, AddressRepository addressRepository) {
        this.studentRepository = studentRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student save(Student student) {
        Address address = new Address();
        address.setCity(student.getAddress().getCity());
        Address savedAddress = addressRepository.save(address);
        student.setAddress(savedAddress);
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> getStudentById(long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student updateStudent(Student student) {
        return null;
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }
}
