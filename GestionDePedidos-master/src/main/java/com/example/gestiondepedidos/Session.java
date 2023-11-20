package com.example.gestiondepedidos;

import com.example.gestiondepedidos.domain.pedido.Pedido;
import com.example.gestiondepedidos.domain.usuario.Usuario;
import lombok.Getter;
import lombok.Setter;

public class Session {
    @Getter
    @Setter
    private static Usuario currentUser;

    @Getter
    @Setter
    private static Pedido currentOrder;
}