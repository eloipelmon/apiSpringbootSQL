package com.pellin.api.repository;

import com.pellin.api.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eloipelmon
 */
@Repository
public interface ProductRepository extends JpaRepository<Productos, Integer> {
    
}
