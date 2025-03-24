package id.co.bcaf.pinjol_keren.controllers;

import id.co.bcaf.pinjol_keren.models.account.User;
import id.co.bcaf.pinjol_keren.models.apps.Employee;
import id.co.bcaf.pinjol_keren.services.EmployeeService;
import id.co.bcaf.pinjol_keren.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;

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

    @GetMapping("/getEmployeeByBranchId/{branchId}")
    public ResponseEntity<Map<String, Object>> getEmployeeByBranchId(@PathVariable UUID branchId) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        Map<String, Object> data = new HashMap<>();

        List<Employee> employeeList = employeeService.getEmployeeByBranchId(branchId);

        data.put("employeeList", employeeList);

        response.put("data", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
