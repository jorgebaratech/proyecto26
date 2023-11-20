package com.example.gestiondepedidos.domain.usuario;

import com.example.gestiondepedidos.domain.DAO;
import com.example.gestiondepedidos.domain.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class UsuarioDAO implements DAO<Usuario> {
    @Override
    public ArrayList<Usuario> loadAll() {
        var salida = new ArrayList<Usuario>(0);

        try (Session s = HibernateUtil.getSessionFactory().getCurrentSession()){
            Query<Usuario> q = s.createQuery("from Usuario", Usuario.class);
            salida = (ArrayList<Usuario>) q.getResultList();
        }

        return salida;
    }

    @Override
    public Usuario get(Long id) {
        return  null;
    }

    @Override
    public Usuario save(Usuario data) {
        return null;
    }

    @Override
    public void update(Usuario data) {

    }

    @Override
    public void delete(Usuario data) {

    }

    public Usuario validateUser (String email, String pass){
        Usuario result = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Usuario> q = session.createQuery("from Usuario where email=:u and contrasenya=:p", Usuario.class);
            q.setParameter("u", email);
            q.setParameter("p", pass);

            try {
                result = q.getSingleResult();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }
}
