package ci.atos.monetab.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "eleve")
@DiscriminatorValue(value = "eleve")
public class Student extends Person {
    @Column(name = "classe")
    private String classroom;
    @Column(name = "matricule", unique = true)
    private String serialNumber;

    @OneToOne
    private Address address;
}
