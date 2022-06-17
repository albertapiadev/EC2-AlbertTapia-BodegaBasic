package com.tapia.bodega.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name ="bodega")
@Table
@NoArgsConstructor
@Getter
@Setter
public class Bodega {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBodega;
    private String nombre;
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "id_producto",
            nullable = false,
            unique = true,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_producto) references productos(id_producto)"))
    private Producto producto;


}
