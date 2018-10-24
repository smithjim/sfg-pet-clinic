package jim.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="speciaility")
public class Speciality extends BaseEntity {

    @Column(name="description")
    private String description;

    @ManyToMany(mappedBy = "specialities")
    private Set<Vet> vets;

}
