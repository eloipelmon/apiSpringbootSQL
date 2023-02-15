package com.pellin.api.controller;

import com.pellin.api.model.Usuarios;
import com.pellin.api.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eloipelmon
 */
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    
    @GetMapping("/usuarios")
    public List<Usuarios> listUsers() {
        return userService.listUsers();
    }
    
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuarios> getProduct(@PathVariable Integer id){
        try{
            Usuarios user =userService.getUserById(id);
            return ResponseEntity.ok(user);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/usuarios")
    public void newUser (@RequestBody Usuarios user){
        userService.saveUser(user);
    }
    
    @PutMapping("/usuarios/{id}")
    public ResponseEntity<?> editUser(@RequestBody Usuarios user,@PathVariable Integer id){
        try{
            Usuarios ExistingUser =userService.getUserById(id);
            ExistingUser.setLogin(user.getLogin());
            ExistingUser.setEmail(user.getEmail());
            ExistingUser.setPassword(user.getPassword());
            
            userService.saveUser(ExistingUser);
            return new ResponseEntity<Usuarios>(user,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Usuarios>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/usuarios/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }
}