package com.example.tretapp.data.DB;

import com.example.tretapp.data.Usuari;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataBaseFunctions {
    private final Connection conn;

    public DataBaseFunctions() {
        this.conn = DataBaseConnector.getConnection();
    }

    public List<Usuari> getUsuaris() {
        List<Usuari> usuaris = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM usuari;");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                usuaris.add(new Usuari(result.getString("nom"),result.getString("contrasena"),result.getString("gruplimpiesa")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuaris;
    }

    public void anadirUsuari(Usuari usuari){
        try {
            PreparedStatement statement = conn.prepareStatement("insert into usuari values(?,?,?);");
            statement.setString(1, usuari.getNom());
            statement.setString(2, usuari.getContrasena());
            statement.setString(3, usuari.getGrup());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Devuelve 0 si no está registrado
    //Devuelve 1 si la contrasena es incorrecta
    //Devuelve 2 si todo es correcto
    //Devuelve 3 por defecto
    public int iniciarSesion(Usuari usuari) {
        List<Usuari> usuarios = getUsuaris();
        boolean esta = false;
        for (Usuari u: usuarios){
            if (u.getNom().compareTo(usuari.getNom()) == 0){
                esta = true;
            }
        }
        if (!esta){
            return 0;
        }
        String pwd = "";
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT contrasena FROM usuari where nom" +
                    "= ?;");
            statement.setString(1, usuari.getNom());
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                pwd = result.getString(1);
            }
            if (!pwd.equals(usuari.getContrasena())) {
                return 1;
            } else {
                return 2;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 3;
    }
//
//    //0 si la vieja contraseña no es correcta
//    //1 si se cambia la contraseña
//    //2 por defecto
//    //3 si la nueva contraseña no es válida
//    public int actualizarContrasena(String usuario, String viejaContrasena, String nuevaContrasena) {
//        if (nuevaContrasena.equals("")) {
//            return 3;
//        }
//        String pwd = "";
//        try {
//            PreparedStatement statement = conn.prepareStatement("SELECT contrase¤a FROM usuario where nombre" +
//                    "= ?;");
//            statement.setString(1, usuario);
//            ResultSet result = statement.executeQuery();
//            while (result.next()) {
//                pwd = result.getString(1);
//            }
//            if (!pwd.equals(viejaContrasena)) {
//                return 0;
//            } else {
//                PreparedStatement statement1 = conn.prepareStatement("UPDATE usuario SET contrase¤a = ? WHERE " +
//                        "nombre = ?;");
//                statement1.setString(1, nuevaContrasena);
//                statement1.setString(2, usuario);
//                statement1.executeUpdate();
//                return 1;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return 2;
//    }
//
//    public Usuario getUsuario(String nombre, String contrasena) throws SQLException {
//        try {
//            PreparedStatement statement = conn.prepareStatement("SELECT * FROM usuario WHERE nombre=?");
//            statement.setString(1, nombre);
//            ResultSet resultSetUsuario = statement.executeQuery();
//            if (!resultSetUsuario.next()) return null;
//            // Aqui se añadiran todos los otros datos que falten en usuario (ej: usuario.setEmail("email")),
//            // de momento la BBDD solo guarda nombre y contraseña
//            // Tambien falta la comprovación de la contraseña
//            // (ej: if( !contraseña.equals(resultSet.getString(2)) ) throw new ContraseñaIncorrectaException(); )
//            return new Usuario(resultSetUsuario.getString(1), resultSetUsuario.getString(2));
//        } catch (SQLException e2) {
//            e2.printStackTrace();
//        }
//        return null;
//    }
//
//    public void deleteUsuario(String nombre, String contrasena) throws SQLException {
//        try {
//            PreparedStatement statement = conn.prepareStatement("DELETE FROM usuario_ubicaciones WHERE nombre=?");
//            statement.setString(1, nombre);
//            statement.executeUpdate();
//
//            statement = conn.prepareStatement("DELETE FROM usuario_servicios WHERE usuario=?");
//            statement.setString(1, nombre);
//            statement.executeUpdate();
//
//            statement = conn.prepareStatement("DELETE FROM historial_ubicaciones WHERE nombreusuario=?");
//            statement.setString(1, nombre);
//            statement.executeUpdate();
//
//            statement = conn.prepareStatement("DELETE FROM usuario WHERE nombre=?");
//            statement.setString(1, nombre);
//            statement.executeUpdate();
//        } catch (SQLException e2) {
//            e2.printStackTrace();
//        }
//    }
}