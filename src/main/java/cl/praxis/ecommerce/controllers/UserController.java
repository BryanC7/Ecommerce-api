package cl.praxis.ecommerce.controllers;

import cl.praxis.ecommerce.entities.UserEntity;
import cl.praxis.ecommerce.services.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserDetailServiceImpl userDetailService;

    @GetMapping("")
    public List<UserEntity> getAllUsers() {
        return userDetailService.getAll();
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userDetailService.getById(id);
    }

    @PostMapping("/new")
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userDetailService.create(user);
    }

    @PutMapping("/update/{id}")
    public UserEntity updateUser(@RequestBody UserEntity user, @PathVariable Long id) {
        UserEntity userUpdated = userDetailService.getById(id);

        userUpdated.setName(user.getName());
        userUpdated.setLastName(user.getLastName());
        userUpdated.setEmail(user.getEmail());
        userUpdated.setPassword(user.getPassword());
        userUpdated.setPhone(user.getPhone());
        userUpdated.setRegisterDate(user.getRegisterDate());

        return userDetailService.update(userUpdated);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userDetailService.delete(id);
    }
}
