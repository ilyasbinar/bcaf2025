package id.co.bcaf.pinjol_keren.models.apps;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.UUID;

@Getter
@Setter
@Entity
@SQLDelete(sql = "update employee set deleted = true where id =?")
@SQLRestriction("deleted = false")
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String email;
    private String nip;

    @ManyToOne(targetEntity = Branch.class)
    @JoinColumn(name = "id_branch")
    private Branch branch;

    private boolean deleted = Boolean.FALSE;
}
