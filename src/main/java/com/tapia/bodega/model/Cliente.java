package com.tapia.bodega.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="cliente")
@Table
@NoArgsConstructor
@Getter
@Setter
public class Cliente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    private String nombre;
    private String direccion;
    private String dni;

    @ManyToMany(mappedBy = "cliente", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Producto> productos = new ArrayList<Producto>();

}
