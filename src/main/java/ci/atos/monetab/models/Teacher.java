package ci.atos.monetab.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "professeur")
@DiscriminatorValue(value = "professeur")
public class Teacher extends Person {
    private boolean vacant;
    @Column(name = "matiere")
    private String course;
    
    @OneToOne
    private Address address;
}
