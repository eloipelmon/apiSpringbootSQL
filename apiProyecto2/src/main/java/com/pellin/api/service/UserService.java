package com.pellin.api.service;

import com.pellin.api.model.Usuarios;
import com.pellin.api.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eloipelmon
 */
@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    
    public List<Usuarios>listUsers(){
        return repository.findAll();
    }
    
    public void saveUser(Usuarios user){
        repository.save(user);
    }
    
    public Usuarios getUserById(Integer id){
        return repository.findById(id).get();
    }
    
    public void deleteUser(Integer id){
        repository.deleteById(id);
    }
}
