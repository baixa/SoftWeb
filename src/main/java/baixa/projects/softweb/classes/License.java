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
@Table(name = "license")
@AllArgsConstructor
public class License {
    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "Name")
    private String name;

    @OneToMany(mappedBy = "license", fetch = FetchType.EAGER)
    private Set<Application> applications;

    @Override
    public String toString() {
        return "License{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
