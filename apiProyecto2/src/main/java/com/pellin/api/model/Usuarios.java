package com.pellin.api.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author eloipelmon
 */
@Entity
@Table(name = "Usuarios")
@Data @NoArgsConstructor @AllArgsConstructor
public class Usuarios {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String email;
    private String password;
}
