package ci.atos.monetab.services.Impl;

import ci.atos.monetab.models.Address;
import ci.atos.monetab.models.Teacher;
import ci.atos.monetab.repositories.AddressRepository;
import ci.atos.monetab.repositories.TeacherRepository;
import ci.atos.monetab.services.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository, AddressRepository addressRepository) {
        this.teacherRepository = teacherRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher save(Teacher teacher) {
        Address address = new Address();
        address.setCity(teacher.getAddress().getCity());
        Address savedAddress = addressRepository.save(address);
        teacher.setAddress(savedAddress);
        return teacherRepository.save(teacher);
    }

    @Override
    public Optional<Teacher> getTeacherById(long id) {
        return teacherRepository.findById(id);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {

        Teacher searchedTeacher = teacherRepository.findById(teacher.getId()).orElse(null);

        if (searchedTeacher != null) {
            searchedTeacher.setFirstName(teacher.getFirstName());
            searchedTeacher.setLastName(teacher.getLastName());
            searchedTeacher.setGender(teacher.getGender());
            searchedTeacher.setPhone(teacher.getPhone());
            searchedTeacher.setAddress(teacher.getAddress());
            searchedTeacher.setCourse(teacher.getCourse());
            searchedTeacher.setVacant(teacher.isVacant());
            searchedTeacher.setDateOfBirth(teacher.getDateOfBirth());
            return teacherRepository.save(searchedTeacher);
        }

        return null;
    }

    @Override
    public void deleteTeacher(long id) {
        teacherRepository.deleteById(id);
    }
}
