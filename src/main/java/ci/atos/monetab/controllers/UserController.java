package ci.atos.monetab.controllers;

import ci.atos.monetab.models.Teacher;
import ci.atos.monetab.models.User;
import ci.atos.monetab.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String index(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "/layout/users";
    }

    @GetMapping("/users/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "/layout/add-user";
    }

    @PostMapping("/users/saveFormUser")
    public String saveFormUser(@ModelAttribute User user, BindingResult result) {

        if (!user.getPassword().equals(user.getConfirmPassword())) {
            result.rejectValue("confirmPassword", "error.user", "Les mots de passe ne correspondent pas");
            return "redirect:/users/add";
        }

        user.setCreatedAt(new Date());
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        Optional<User> user = userService.getUserById(id);

        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "/layout/edit-user";
        }

        return "redirect:/users";
    }
}
