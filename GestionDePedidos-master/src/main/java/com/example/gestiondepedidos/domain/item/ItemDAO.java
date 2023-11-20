package com.example.gestiondepedidos.domain.item;

import com.example.gestiondepedidos.domain.DAO;
import jakarta.persistence.SecondaryTable;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemDAO implements DAO<Item> {

    public static final HashMap<String,String> QUERY_ATTR;

    static {
        QUERY_ATTR = new HashMap<>();
        QUERY_ATTR.put("id","select distinct(com.example.gestiondepedidos.domain.com.example.gestiondepedidos.domain.pedido.pedido.item.id) form Item com.example.gestiondepedidos.domain.com.example.gestiondepedidos.domain.pedido.pedido.item");
        QUERY_ATTR.put("codigo_pedido","select distinct(com.example.gestiondepedidos.domain.com.example.gestiondepedidos.domain.pedido.pedido.item.codigo_pedido) form Item com.example.gestiondepedidos.domain.com.example.gestiondepedidos.domain.pedido.pedido.item");
        QUERY_ATTR.put("producto_id","select distinct(com.example.gestiondepedidos.domain.com.example.gestiondepedidos.domain.pedido.pedido.item.producto_id) form Item com.example.gestiondepedidos.domain.com.example.gestiondepedidos.domain.pedido.pedido.item");
        QUERY_ATTR.put("cantidad","select distinct(com.example.gestiondepedidos.domain.com.example.gestiondepedidos.domain.pedido.pedido.item.cantidad) form Item com.example.gestiondepedidos.domain.com.example.gestiondepedidos.domain.pedido.pedido.item");
    }
    @Override
    public ArrayList<Item> loadAll() {
        return null;
    }

    @Override
    public Item get(Long id) {
        return null;
    }

    @Override
    public Item save(Item data) {
        return null;
    }

    @Override
    public void update(Item data) {

    }

    @Override
    public void delete(Item data) {

    }
}