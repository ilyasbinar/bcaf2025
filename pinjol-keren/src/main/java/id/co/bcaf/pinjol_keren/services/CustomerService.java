package id.co.bcaf.pinjol_keren.services;

import id.co.bcaf.pinjol_keren.dto.account.CustomerRegistrationDTO;
import id.co.bcaf.pinjol_keren.model.account.Customer;
import id.co.bcaf.pinjol_keren.model.account.User;
import id.co.bcaf.pinjol_keren.model.account.UserStatus;
import id.co.bcaf.pinjol_keren.repositories.CustomerRepository;
import id.co.bcaf.pinjol_keren.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public Customer registerCustomer(CustomerRegistrationDTO dto) {
        // Cek apakah email sudah terdaftar
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("Email sudah terdaftar");
        }
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword())); // Hash password
        user.setPassword(dto.getPassword());
        user.setPhoneNumber(dto.getPhone());
        user.setStatus(UserStatus.ACTIVE); // Default status: AKTIF

        user = userRepository.save(user);

        // Buat objek Customer baru
        Customer customer = new Customer();
        customer.setAddress(dto.getAddress());
        customer.setUser(user);
        customer = customerRepository.save(customer);

        return customer;
    }
}
