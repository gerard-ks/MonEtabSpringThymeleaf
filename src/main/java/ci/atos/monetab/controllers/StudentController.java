package ci.atos.monetab.controllers;

import ci.atos.monetab.models.Student;
import ci.atos.monetab.models.Teacher;
import ci.atos.monetab.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

import static org.hibernate.query.sqm.tree.SqmNode.log;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/students")
    public String indexStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "/layout/students";
    }

    @GetMapping("/students/add")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "/layout/add-student";
    }

    @PostMapping("/students/saveFormStudent")
    public String saveFormStudent(Student student) {
        studentService.save(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudents(@PathVariable Long id, Model model) {

        Optional<Student> student = studentService.getStudentById(id);

        if (student.isPresent()) {
            model.addAttribute("student", student.get());
            return "/layout/edit-student";
        }

        return "redirect:/students";
    }

    @PostMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        student.ifPresent(value -> studentService.deleteStudent(value.getId()));
        log.info("supprimé avec succès !!!");
        return "redirect:/students";
    }
}
