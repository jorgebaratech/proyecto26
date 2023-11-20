package com.example.gestiondepedidos.domain.item;

import com.example.gestiondepedidos.domain.pedido.Pedido;
import com.example.gestiondepedidos.domain.productos.Producto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Clase que presenta un com.example.gestiondepedidos.domain.com.example.gestiondepedidos.domain.pedido.pedido.item en la ap`licacion de pedidos
 * Esta clase almacena información sobre el ítem, incluyendo su identificación, código de com.example.gestiondepedidos.domain.pedido.pedido al que pertenece, producto asociado y cantidad.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "item")
public class Item implements Serializable {
    /**
     * Identificador unico del com.example.gestiondepedidos.domain.com.example.gestiondepedidos.domain.pedido.pedido.item
     */
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Codigo de com.example.gestiondepedidos.domain.pedido.pedido al que pertenece el com.example.gestiondepedidos.domain.com.example.gestiondepedidos.domain.pedido.pedido.item
     */
    @ManyToOne
    @JoinColumn (name = "codigo_pedido", referencedColumnName = "codigo")
    private Pedido codigo;

    /**
     * Producto asociado con el com.example.gestiondepedidos.domain.com.example.gestiondepedidos.domain.pedido.pedido.item
     */
    @ManyToOne()
    @JoinColumn(name="producto_id")
    private Producto product_id;

    /**
     * Cantidad de productos en el com.example.gestiondepedidos.domain.com.example.gestiondepedidos.domain.pedido.pedido.item
     */
    @Column (name = "cantidad")
    private Integer cantidad;

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", pedido=" + codigo.getCodigo() +
                ", producto=" + product_id.getNombre() +
                ", cantidad=" + cantidad +
                '}';
    }
}