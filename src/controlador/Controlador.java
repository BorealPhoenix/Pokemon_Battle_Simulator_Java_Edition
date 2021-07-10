package controlador;

import vista.Vista;

public class Controlador {
    //Atributos
    private Vista vista;
    
    
    
    //Constructor

    public Controlador(Vista vista) {
        this.vista = vista;
        controladorPaneles();
        registrarEventos();
    }

    private void controladorPaneles() {
        vista.getTopPanel().setVisible(false);
        vista.getBottomPanel().setVisible(false);
        vista.getInfoPanel().setVisible(false);
    }

    private void registrarEventos() {
    }
}
