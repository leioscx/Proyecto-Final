
package proyectofinal;

import java.util.ArrayList;
import java.util.List;
import proyectofinal.entidades.Persona;
import proyectofinal.pantallas.Login;

public class ProyectoFinal {

    public static List<Persona> listaContactosGlobal = new ArrayList<>();

    public static void main(String[] args) {
        
        Login login = new Login();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        
    }
    
}
