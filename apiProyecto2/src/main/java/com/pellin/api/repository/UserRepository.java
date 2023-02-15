package com.pellin.api.repository;

import com.pellin.api.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eloipelmon
 */
@Repository
public interface UserRepository extends JpaRepository<Usuarios, Integer> {
    
}
