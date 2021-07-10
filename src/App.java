import controlador.Controlador;
import vista.Vista;

public class App {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Vista vista = new Vista();

                new Controlador(vista);
            }
        });
    }
}
