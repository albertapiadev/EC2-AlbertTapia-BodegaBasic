package com.tapia.bodega.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name="productos")
@NoArgsConstructor
@Getter
@Setter
public class Producto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;
    private String producto;
    private String descripcion;
    private String precio;
    private String stock;

    @OneToMany(mappedBy = "producto")
    private List<Bodega> bodega =new ArrayList<Bodega>();



    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name="producto_cliente",
            joinColumns =
            @JoinColumn(
                    name="id_cliente",
                    nullable = false,
                    unique = true,
                    foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_cliente) references cliente (id_cliente)")),

            inverseJoinColumns =
            @JoinColumn(
                    name="id_producto",
                    nullable = false,
                    unique = true,
                    foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_producto) references productos (id_producto)"))
    )
    private List<Cliente> cliente = new ArrayList<Cliente>();



}
