package id.co.bcaf.pinjol_keren.dto;

import id.co.bcaf.pinjol_keren.model.account.Customer;
import id.co.bcaf.pinjol_keren.model.account.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerUserDTO extends PageRequestDto{
    private String name;
    private String username; // Email sebagai username
    private String status;
    private String address;
    private String phone;

    public CustomerUserDTO(User user, Customer customer) {
//        this.name = user.getName();
        this.username = user.getUsername();
        this.status = user.getStatus().name(); // Jika status adalah enum, gunakan .name()
        this.address = customer.getAddress();
//        this.phone = customer.getPhone();
    }
}

