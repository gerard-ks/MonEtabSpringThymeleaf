package ci.atos.monetab;

import ci.atos.monetab.models.Address;
import ci.atos.monetab.models.Student;
import ci.atos.monetab.models.Teacher;
import ci.atos.monetab.models.User;
import ci.atos.monetab.repositories.AddressRepository;
import ci.atos.monetab.repositories.StudentRepository;
import ci.atos.monetab.services.StudentService;
import ci.atos.monetab.services.TeacherService;
import ci.atos.monetab.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class MonEtabApplication {


    public static void main(String[] args) {
        SpringApplication.run(MonEtabApplication.class, args);
    }

    @Bean
    public CommandLineRunner runAtStartup(AddressRepository addressRepository,
                                          StudentService studentService,
                                          TeacherService teacherService,
                                          UserService userService) {

        return args -> {

          /*  User user = new User();
            user.setPseudo("testeur");
            user.setPassword("12345678");
            user.setCreatedAt(new Date());

            userService.save(user);*/

  /*
            Address address = new Address();
            address.setStreet("COCODY");
            address.setCity("ABIDJAN");
            address.setCountry("Côte d'ivoire");
            Address saveAddress = addressRepository.save(address);



            Student student = new Student();
            student.setFirstName("Alex");
            student.setLastName("Smith");
            student.setClassroom("JAVA");
            student.setAddress(saveAddress);
            student.setGender("M");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dateOfBirth = sdf.parse("01/01/1990");
            student.setDateOfBirth(dateOfBirth);
            student.setSerialNumber("1AAAAAA");
            student.setPhone("0101010101");
            studentService.save(student);


            Teacher teacher = new Teacher();
            teacher.setFirstName("Lee");
            teacher.setLastName("Bob");
            teacher.setGender("M");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dateOfBirth = sdf.parse("01/01/1999");
            teacher.setDateOfBirth(dateOfBirth);
            teacher.setAddress(saveAddress);
            teacher.setPhone("0201010101");
            teacher.setCourse("JAVA");
            teacher.setVacant(true);
            teacherService.save(teacher);

              */
        };
    }
}
