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

        //Evento Boton Info Zeraora
        vista.getButtonInfoZeraora().addActionListener(e->{
            vista.getInfoPanel().setVisible(true);
            mostrarInfoZeraora();
        });

        //Evento Boton Info Zoroark
        vista.getButtonInfoZoroark().addActionListener(e->{
            vista.getInfoPanel().setVisible(true);
            mostrarInfoZoroark();
        });
    }

    private void mostrarInfoZoroark() {
        //Boton de Ocultar Info
        vista.getButtonOcultarInfo().addActionListener(e-> {
            vista.getTextFieldInfoPokemon().setText("");
            vista.getTextFieldTipoPokemon().setText("");
            vista.getTextFieldPokedex().setText("");
            vista.getTextFieldHabilidad().setText("");
            vista.getTextFieldInfoPokemon().setText("");
            vista.getInfoPanel().setVisible(false);
        });

        //Info Zoroark
        vista.getTextFieldInfoPokemon().setText("Zoroark");
        vista.getTextFieldTipoPokemon().setText("Siniestro");
        vista.getTextFieldInfoVida().setText("200");
        vista.getTextFieldPokedex().setText("570");
        vista.getTextFieldHabilidad().setText("Cuida de sus semejantes. " +
                "Provoca ilusiones terroríficas para proteger tanto su guarida como a su manada de sus adversarios.");
    }

    private void mostrarInfoZeraora() {
        //Boton de Ocultar Info
        vista.getButtonOcultarInfo().addActionListener(e-> {
            vista.getTextFieldInfoPokemon().setText("");
            vista.getTextFieldTipoPokemon().setText("");
            vista.getTextFieldPokedex().setText("");
            vista.getTextFieldHabilidad().setText("");
            vista.getTextFieldInfoPokemon().setText("");
            vista.getInfoPanel().setVisible(false);
        });

        //Info Zeraora
        vista.getTextFieldInfoPokemon().setText("Zeraora");
        vista.getTextFieldTipoPokemon().setText("Electrico");
        vista.getTextFieldInfoVida().setText("200");
        vista.getTextFieldPokedex().setText("807");
        vista.getTextFieldHabilidad().setText("Hace jirones al oponente con sus garras electrificadas. " +
                "Aunque este esquive los golpes, acaba electrocutado por las descargas");
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
        vista.getTextFieldHabilidad().setText("Caza a sus presas manipulando una energía, denominada aura," +
                        " cuya potencia es capaz incluso de hacer añicos rocas enormes.");

    }
}
