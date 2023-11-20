package com.example.gestiondepedidos.domain.usuario;

import com.example.gestiondepedidos.domain.pedido.Pedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "contraseña")
    private String contraseña;

    @Column(name = "email")
    private String email;

    @OneToMany (mappedBy = "usuario", fetch = FetchType.EAGER)
    private List<Pedido> pedidos = new ArrayList<>();

}