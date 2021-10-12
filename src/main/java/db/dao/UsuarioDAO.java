package db.dao;

import db.EntityManagerHelper;
import entities.Usuario;

public class UsuarioDAO {
   // public static int usuarioValido(String user, String password){
        //EntityManagerHelper.beginTransaction();
            //EntityManagerHelper.getEntityManager().find(user, password);
    //}

    public static void save(Usuario usuario){
        EntityManagerHelper.beginTransaction();

            EntityManagerHelper.getEntityManager().persist(usuario);

        EntityManagerHelper.commit();
    }
}
