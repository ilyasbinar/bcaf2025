package id.co.bcaf.pinjol_keren.model.apps;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.UUID;

@Getter
@Setter
@Entity
@SQLDelete(sql = "update branch set deleted = true where id =?")
@SQLRestriction("deleted = false")
@Table(name = "branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String phone;
    private String address;
    private String province;

    private double latitude;
    private double longitude;

//    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Employee> employeeList = new ArrayList<>();

    private boolean deleted = Boolean.FALSE;
}
