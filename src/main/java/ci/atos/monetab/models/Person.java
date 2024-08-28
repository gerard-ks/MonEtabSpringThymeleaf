package ci.atos.monetab.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "person_type")
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nom")
    private String firstName;
    @Column(name = "prenom")
    private String lastName;
    @Column(name = "dateNaissance")
    private Date dateOfBirth;
    @Column(name = "genre")
    private String gender;
    @Column(name = "telephone")
    private String phone;
}
