package springbootmigrations.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springbootmigrations.exceptions.CustomerNotFoundException;
import springbootmigrations.exceptions.RoleNotFoundException;

@RestController
public class UserController {

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody @Valid UserRequest userRequest) {
        System.out.println(userRequest.toString());
        return ResponseEntity.ok("user created");
    }

    @PostMapping("/transaction")
    public ResponseEntity<String> transaction()  {
        throw new CustomerNotFoundException("the user not found");
    }

    @PostMapping("/rol")
    public ResponseEntity<String> rol()  {
        throw new RoleNotFoundException("ROL not found");
    }
}

