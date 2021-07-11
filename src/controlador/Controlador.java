package controlador;

import modelo.DTO.Pokemon;
import modelo.DTO.nombrePokemon;
import modelo.DTO.tipoPokemon;
import vista.Vista;

public class Controlador {
    //Atributos
    private Vista vista;
    private Pokemon pokemon;
    
    
    
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
        //Evento Botón Info Lucario
        vista.getButtonInfoLucario().addActionListener(e->{
            vista.getInfoPanel().setVisible(true);
            mostrarInfoLucario();
        });
    }

    private void mostrarInfoLucario() {
        //Boton de Ocultar Info
        vista.getButtonOcultarInfo().addActionListener(e->{
            vista.getTextFieldInfoPokemon().setText("");
            vista.getTextFieldTipoPokemon().setText("");
            vista.getTextFieldPokedex().setText("");
            vista.getTextFieldHabilidad().setText("");
            vista.getTextFieldInfoPokemon().setText("");
            vista.getInfoPanel().setVisible(false);
        });

        //Info Lucario
        vista.getTextFieldInfoPokemon().setText("Lucario");
        vista.getTextFieldTipoPokemon().setText("Lucha/Acero");
        vista.getTextFieldInfoVida().setText("200");
        vista.getTextFieldPokedex().setText("448");
        vista.getTextFieldHabilidad().setText("Puede sentir el Aura de los demás Pokemon");

    }
}
