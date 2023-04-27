package com.sebastianabril.pos.api.service;

import com.sebastianabril.pos.api.auth.SecurityConfig;
import com.sebastianabril.pos.api.entity.Role;
import com.sebastianabril.pos.api.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.sebastianabril.pos.api.repository.RoleRepository;
import com.sebastianabril.pos.api.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private RoleRepository  roleRepository;
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    public UserService(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User save( String name, String lastName, String email, String password, Integer roleId){
        // verifico que el rol existe
        Role roleUser = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("The Role with id: "+roleId+" does not exist"));

        //verificar que el email sea unico
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isPresent()){
            throw new RuntimeException("The e-mail "+email+" is already registered, try another one");
        }

        String encodePassword = passwordEncoder.encode(password);

        User user = new User(null, name, lastName, email, encodePassword , roleUser);

        return userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
