package id.co.bcaf.pinjol_keren.services;

import id.co.bcaf.pinjol_keren.models.account.User;
import id.co.bcaf.pinjol_keren.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll(){
        List<User> userList = userRepository.findAll();
        return userList;
    }
}
