package ci.atos.monetab.controllers;

import ci.atos.monetab.models.Address;
import ci.atos.monetab.models.Teacher;
import ci.atos.monetab.services.TeacherService;
import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

import static org.hibernate.query.sqm.tree.SqmNode.log;

@Controller
@Slf4j
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @GetMapping("/teachers")
    public String index(Model model) {
        List<Teacher> teachers = teacherService.getAllTeachers();
        model.addAttribute("teachers", teachers);
        return "/layout/teachers";
    }

    @PostMapping("/teachers/saveFormTeacher")
    public String saveFormTeacher(Teacher teacher) {
        teacherService.save(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/teachers/add")
    public String addTeacher(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "/layout/add-teacher";
    }

    @GetMapping("/teachers/edit/{id}")
    public String editTeacher(@PathVariable Long id, Model model) {

        Optional<Teacher> teacher = teacherService.getTeacherById(id);

        if (teacher.isPresent()) {
            model.addAttribute("teacher", teacher.get());
            return "/layout/edit-teacher";
        }

        return "redirect:/teachers";
    }

    @PostMapping("/teachers/delete/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        Optional<Teacher> teacher = teacherService.getTeacherById(id);
        teacher.ifPresent(value -> teacherService.deleteTeacher(value.getId()));
        log.info("supprimé avec succès !!!");
        return "redirect:/teachers";
    }
}
