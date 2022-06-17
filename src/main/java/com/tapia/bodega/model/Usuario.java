package com.tapia.bodega.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name="usuarios")
@Table
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    private String usuario;
    private String password;
    private String rol;

}
