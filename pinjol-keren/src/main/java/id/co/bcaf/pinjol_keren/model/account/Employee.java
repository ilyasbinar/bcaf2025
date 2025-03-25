package id.co.bcaf.pinjol_keren.model.account;

import id.co.bcaf.pinjol_keren.model.apps.Branch;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String position;
    private String department;

    @Column(nullable = false, unique = true)
    private String nip; // Nomor Induk Pegawai

    @OneToOne
    @JoinColumn(name = "user_id", unique = true) // Reference to `users.id`
    private User user;

    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false) // Reference to `branch.id`
    private Branch branch;
}
