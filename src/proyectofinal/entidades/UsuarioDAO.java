
package proyectofinal.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Leo
 */
public class UsuarioDAO {
    
    private Usuario usuario;

    public UsuarioDAO(Usuario usuario) {
        this.usuario = usuario;
    }
        
    public void registrar(){
        
        Connection connection = DbConexion.getConnection();
        String insertSQL = "INSERT INTO db_usuarios (nombre, usuario, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, this.usuario.getNombre());
            preparedStatement.setString(2, this.usuario.getUser());
            preparedStatement.setString(3, this.usuario.getPassword());
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public boolean login(){
        
        Connection connection = DbConexion.getConnection();
        String selectSQL = "SELECT * FROM db_usuarios WHERE usuario = ? AND password = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, this.usuario.getUser());
            preparedStatement.setString(2, this.usuario.getPassword());
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_usuario");
                String name = resultSet.getString("nombre");
                String user = resultSet.getString("usuario");
                String pass = resultSet.getString("password");
                
                Usuario usuario = new Usuario();
                usuario.setId(id);
                
                return usuario.getId() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;   
    }
}
