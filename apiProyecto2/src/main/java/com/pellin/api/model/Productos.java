package com.pellin.api.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 * @author eloipelmon
 */
@Table(name = "Productos")
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Productos {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private double precio;
}