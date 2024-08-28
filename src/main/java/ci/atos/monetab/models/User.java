package ci.atos.monetab.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "utilisateur")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String pseudo;
    @Column(name = "motDePasse", nullable = false)
    private String password;
    @Column(name = "dateCreation", nullable = false)
    private Date createdAt;

    @Transient
    private String confirmPassword;
}
