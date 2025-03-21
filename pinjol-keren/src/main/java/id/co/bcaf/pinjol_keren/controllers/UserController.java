package id.co.bcaf.pinjol_keren.controllers;

import id.co.bcaf.pinjol_keren.models.account.User;
import id.co.bcaf.pinjol_keren.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAll(){
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        Map<String, Object> data = new HashMap<>();

        List<User> userList = userService.getAll();


        data.put("userList", userList);

        response.put("data", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
