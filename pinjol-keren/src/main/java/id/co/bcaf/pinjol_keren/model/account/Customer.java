package id.co.bcaf.pinjol_keren.model.account;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String address;
    private String phone;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true) // Reference to `users.id`
    private User user;
}
