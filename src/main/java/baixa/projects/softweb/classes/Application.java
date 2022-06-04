package baixa.projects.softweb.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "applications")
@AllArgsConstructor
public class Application{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Short_description")
    private String shortDescription;

    @Column(name = "Description")
    private String description;

    @Column(name = "Logo_Path")
    private String logoPath;

    @Column(name = "Last_Update")
    private Date lastUpdate;

    @ManyToOne
    @JoinColumn(name = "License")
    private License license;

    @ManyToOne
    @JoinColumn(name = "Developer_ID")
    private Developer developer;

    @OneToMany(mappedBy = "application", fetch = FetchType.EAGER)
    private Set<ApplicationImage> images;

    @OneToMany(mappedBy = "application", fetch = FetchType.EAGER)
    private Set<ApplicationsSystems> applicationsSystems;

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", description='" + description + '\'' +
                ", logoPath='" + logoPath + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", license='" + license + '\'' +
                ", developer=" + developer +
                '}';
    }
}
