package baixa.projects.softweb.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "operation_systems")
@AllArgsConstructor
public class OperationSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Name")
    private String name;

    @OneToMany(mappedBy = "system", fetch = FetchType.EAGER)
    private Set<ApplicationsSystems> applicationsSystems;

    @Override
    public String toString() {
        return "OperationSystem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
