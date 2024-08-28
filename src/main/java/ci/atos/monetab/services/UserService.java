package ci.atos.monetab.services;

import ci.atos.monetab.models.Student;
import ci.atos.monetab.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();

    User save(User user);

    Optional<User> getUserById(long id);

    User updateUser(User user);
}
