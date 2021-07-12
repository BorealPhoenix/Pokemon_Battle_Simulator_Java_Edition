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
        controladorPanelesIniciales();
        registrarEventos();
    }

    private void controladorPanelesIniciales() {
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
        
        //Evento Escoger Lucario
        vista.getButtonSelectLucario().addActionListener(e->{
            vista.getBottomPanel().setVisible(true);
            vista.getTopPanel().setVisible(true);
            vista.getCentralPanel().setEnabled(false);
            vista.getCentralPanel().setVisible(false);
            
            
            pokemon= new Pokemon(nombrePokemon.Lucario, tipoPokemon.Lucha_Acero, 200, 80, 120,
                    25, 120, "Esfera Aural", "A Bocajarro", "Ataque Óseo", "Onda Certera");
        });
        
        
        vista.getButtonAtaque1().setText("Esfera Aural");
        vista.getButtonAtaque2().setText("A Bocajarro");
        vista.getButtonAtaque3().setText("Ataque Óseo");
        vista.getButtonAtaque4().setText("Onda Certera");
        
        combateLucario(escogerPokemonRival(), pokemon);
    }

    private void combateLucario(Pokemon escogerPokemonRival, Pokemon pokemon) {
    }


    private Pokemon escogerPokemonRival() {
        //Se elegirá con un Math random cualquiera
        int random = (int) (Math.random()*10-1);
        
        //Si <3=Lycanroc, >3 <6= Scyther, >6 <=9 = Raikou
        if (random<=3){
            pokemon = new Pokemon(nombrePokemon.Lycanroc, tipoPokemon.Roca, 200,40, 80
            , 75, 60, "Roca Veloz", "Triturar", "Avalancha", "Mordisco");
            System.out.println("Lycanroc");
        }
        if (random >3 && random<=6){
            pokemon = new Pokemon(nombrePokemon.Scyther, tipoPokemon.Bicho_Volador, 200, 60, 80, 75, 40
                    , "Ataque Ala", "Tijera X", "Tajo Aéreo", "Corte Furia");
            System.out.println("Scyther");
        }
        if (random>6 && random<=9){
            pokemon = new Pokemon(nombrePokemon.Raikou, tipoPokemon.Electrico, 200, 80, 40, 110, 80
            , "Paranormal", "Golpe Roca", "Trueno", "Chispazo");
            System.out.println("Raikou");
        }
        System.out.println(random);

        return pokemon;
    }

    private void mostrarInfoZoroark() {
        //Boton de Ocultar Info
        vista.getButtonOcultarInfo().addActionListener(e-> {
            vista.getTextFieldInfoPokemon().setText("");
            vista.getTextFieldTipoPokemon().setText("");
            vista.getTextFieldPokedex().setText("");
            vista.getTextAreaInfoHabilidad().setText("");
            vista.getTextFieldInfoGeneracion().setText("");
            vista.getInfoPanel().setVisible(false);
        });

        //Info Zoroark
        vista.getTextFieldInfoPokemon().setText("Zoroark");
        vista.getTextFieldTipoPokemon().setText("Siniestro");
        vista.getTextFieldInfoVida().setText("200");
        vista.getTextFieldPokedex().setText("570");
        vista.getTextAreaInfoHabilidad().setText("Cuida de sus semejantes. " +
                "Provoca ilusiones terroríficas para proteger tanto su guarida como a su manada de sus adversarios.");
        vista.getTextAreaInfoHabilidad().setLineWrap(true);
        vista.getTextFieldInfoGeneracion().setText("5");

        //Evitamos que sea editable
        vista.getTextFieldInfoPokemon().setEditable(false);
        vista.getTextFieldTipoPokemon().setEditable(false);
        vista.getTextFieldInfoVida().setEditable(false);
        vista.getTextFieldPokedex().setEditable(false);
        vista.getTextAreaInfoHabilidad().setEditable(false);
        vista.getTextFieldInfoGeneracion().setEditable(false);
    }

    private void mostrarInfoZeraora() {
        //Boton de Ocultar Info
        vista.getButtonOcultarInfo().addActionListener(e-> {
            vista.getTextFieldInfoPokemon().setText("");
            vista.getTextFieldTipoPokemon().setText("");
            vista.getTextFieldPokedex().setText("");
            vista.getTextAreaInfoHabilidad().setText("");
            vista.getTextFieldInfoGeneracion().setText("");
            vista.getInfoPanel().setVisible(false);
        });

        //Info Zeraora
        vista.getTextFieldInfoPokemon().setText("Zeraora");
        vista.getTextFieldTipoPokemon().setText("Electrico");
        vista.getTextFieldInfoVida().setText("200");
        vista.getTextFieldPokedex().setText("807");
        vista.getTextAreaInfoHabilidad().setText("Hace jirones al oponente con sus garras electrificadas. " +
                "Aunque este esquive los golpes, acaba electrocutado por las descargas");
        vista.getTextAreaInfoHabilidad().setLineWrap(true);
        vista.getTextFieldInfoGeneracion().setText("8");

        //Evitamos que sea editable
        vista.getTextFieldInfoPokemon().setEditable(false);
        vista.getTextFieldTipoPokemon().setEditable(false);
        vista.getTextFieldInfoVida().setEditable(false);
        vista.getTextFieldPokedex().setEditable(false);
        vista.getTextAreaInfoHabilidad().setEditable(false);
        vista.getTextFieldInfoGeneracion().setEditable(false);
    }

    private void mostrarInfoLucario() {
        //Boton de Ocultar Info
        vista.getButtonOcultarInfo().addActionListener(e->{
            vista.getTextFieldInfoPokemon().setText("");
            vista.getTextFieldTipoPokemon().setText("");
            vista.getTextFieldPokedex().setText("");
            vista.getTextAreaInfoHabilidad().setText("");
            vista.getTextFieldInfoGeneracion().setText("");
            vista.getInfoPanel().setVisible(false);
        });

        //Info Lucario
        vista.getTextFieldInfoPokemon().setText("Lucario");
        vista.getTextFieldTipoPokemon().setText("Lucha/Acero");
        vista.getTextFieldInfoVida().setText("200");
        vista.getTextFieldPokedex().setText("448");
        vista.getTextAreaInfoHabilidad().setText("Caza a sus presas manipulando una energía, " +
                "denominada  a cuya potencia es capaz incluso de hacer añicos rocas enormes.");
        vista.getTextAreaInfoHabilidad().setLineWrap(true);
        vista.getTextFieldInfoGeneracion().setText("4");

        //Evitamos que sea editable
        vista.getTextFieldInfoPokemon().setEditable(false);
        vista.getTextFieldTipoPokemon().setEditable(false);
        vista.getTextFieldInfoVida().setEditable(false);
        vista.getTextFieldPokedex().setEditable(false);
        vista.getTextAreaInfoHabilidad().setEditable(false);
        vista.getTextFieldInfoGeneracion().setEditable(false);

    }
}
