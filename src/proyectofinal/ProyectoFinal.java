
package proyectofinal;

import java.util.ArrayList;
import java.util.List;
import proyectofinal.entidades.DbConexion;
import proyectofinal.entidades.Persona;
import proyectofinal.pantallas.Login;

public class ProyectoFinal {

    public static List<Persona> listaContactosGlobal = new ArrayList<>();
    public static final String ACCOUNT_SID = "ACCOUNT_SID";
    public static final String AUTH_TOKEN = "AUTH_TOKEN";

    public static void main(String[] args) { 
        
        DbConexion.getConnection();

        Login login = new Login();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    
    }
}