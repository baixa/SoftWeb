package baixa.projects.softweb.classes;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "developers")
@AllArgsConstructor
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Username")
    private String username;

    @Column(name = "FullName")
    private String fullName;

    @Column(name = "Password")
    private String password;

    @Column(name = "Is_Admin")
    private boolean isAdmin;

    @OneToMany(mappedBy = "developer")
    private List<Application> applications = new ArrayList<>();

    public Developer() {

    }
}
