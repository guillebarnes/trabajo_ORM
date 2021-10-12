package db.dao;

import db.EntityManagerHelper;
import entities.Usuario;

public class UsuarioDAO {
    public static Long usuarioValido(String user, String password){
        EntityManagerHelper.beginTransaction();
            return (Long) EntityManagerHelper.getEntityManager()
                    .createQuery("SELECT COUNT(*) FROM usuario WHERE usuario_nombre = '" + user + "' AND usuario_password = '" + password +"'")
                    .getSingleResult();
    }

    public static void save(Usuario usuario){
        EntityManagerHelper.beginTransaction();

            EntityManagerHelper.getEntityManager().persist(usuario);

        EntityManagerHelper.commit();
    }
}
