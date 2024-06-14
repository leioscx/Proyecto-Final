
package proyectofinal;

import proyectofinal.pantallas.Login;

public class ProyectoFinal {

    public static String usuario = "leomontalvo";
    public static String password = "montalvo";

    public static void main(String[] args) {
        
        Login login = new Login();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        
    }
    
}
