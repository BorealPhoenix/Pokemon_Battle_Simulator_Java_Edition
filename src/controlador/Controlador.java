package controlador;

import modelo.DTO.Pokemon;
import modelo.DTO.nombrePokemon;
import modelo.DTO.tipoPokemon;
import modelo.DTO.tiposMovimiento;
import vista.Vista;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;

public class Controlador {
    //Atributos
    private Vista vista;
    private Pokemon pokemonRival;
    private Pokemon pokemonPropio;
    private ArrayList<Pokemon> listaRivales= new ArrayList<>();

    
    
    
    //Constructor
    public Controlador(Vista vista) {
        this.vista = vista;

        //Cuando se pulse el boton star en el panel principal cambia a la pantalla de seleccion
        vista.getButtonStart().addActionListener(e->{
            vista.getFrame().remove(vista.getIntroPanel());
            vista.getFrame().add(vista.getCombatPanel());
            vista.getFrame().revalidate();
            vista.getFrame().repaint();
            vista.getInfoPanel().setVisible(false);
            controlarBotonesSelect(); //Controlamos los botones de seleccion de pokemon en el panel de seleccion
            controlarBotonesInfo(); //Controlamos los botones de informacion de pokemon en el panel de seleccion
            cargarListaPokemonRivales(); //Cargamos la lista que nos servira para llevar la cuenta de los pokemon rivales derrotados
            controlarBotonesPreCombate(); //Controlamos los botones del panel de preCombate (Info Pokemon Rival y Luchar)
            controlarBotonesPostCombate(); //Controlamos los botones del panel de postCombate
        });

    }

    private void cargarListaPokemonRivales() {
        Pokemon Lycanroc = new Pokemon(nombrePokemon.Lycanroc, tipoPokemon.Roca, 200,40, 80
                , 75, 60, "Roca Veloz", "Triturar", "Avalancha", "Mordisco"
                , tiposMovimiento.Roca, tiposMovimiento.Siniestro, tiposMovimiento.Roca, tiposMovimiento.Siniestro);
        System.out.println("Lycanroc");

        Pokemon Scyther = new Pokemon(nombrePokemon.Scyther, tipoPokemon.Bicho_Volador, 200, 60, 80, 75, 40
                , "Ataque Ala", "Tijera X", "Tajo Aéreo", "Corte Furia",
                tiposMovimiento.Volador, tiposMovimiento.Bicho, tiposMovimiento.Volador, tiposMovimiento.Bicho);
        System.out.println("Scyther");

       Pokemon Raikou = new Pokemon(nombrePokemon.Raikou, tipoPokemon.Electrico, 200, 80, 40, 110, 80
                , "Paranormal", "Golpe Roca", "Trueno", "Chispazo",
                tiposMovimiento.Psiquico, tiposMovimiento.Lucha, tiposMovimiento.Electrico, tiposMovimiento.Electrico);
        System.out.println("Raikou");
        listaRivales.add(Lycanroc);
        listaRivales.add(Scyther);
        listaRivales.add(Raikou);

    }

    private void controlarBotonesPostCombate() {


// TODO: 16/09/2021 Quitar la restriccion
        vista.getButtonAbandonar().setEnabled(false);

        //BOTON SELECCIONAR OTRO POKEMON
        vista.getButtonSeleccionarPokemonPropio().addActionListener(e->{ //BOTON SELECCIONAR

            //NUESTRO POKEMON PIERDE
            if (pokemonPropio.getVida()==0) {
                if (pokemonPropio.getNombre().toString().equalsIgnoreCase("Lucario")) {
                    vista.getFrame().remove(vista.getCombatPanel()); //Nos cargamos el panel de combate
                    vista.getFrame().add(vista.getCentralPanel()); //Cambiamos al panel de Seleccion de pokemon
                    vista.getFrame().revalidate();
                    vista.getFrame().repaint();
                    vista.getInfoPanel().setVisible(false); //Hacemos invisible el panel de informacion de los pokemon
                    vista.getButtonSelectLucario().setText("Fuera de Combate"); //Cambiamos el texto al boton de luchar con Lucario
                    vista.getLucarioIntro().setEnabled(false); //Ponemos en gris la imagen de Lucario
                    vista.getButtonSelectLucario().setEnabled(false); //Como el pokemon ha sido derrotado, no se puede volver a usar
                    controlarBotonesInfo(); //Preparamos la informacion de los pokemon en el panel de seleccion

                }

                if (pokemonPropio.getNombre().toString().equalsIgnoreCase("Zeraora")) {
                    vista.getFrame().remove(vista.getCombatPanel()); //Nos cargamos el panel de combate
                    vista.getFrame().add(vista.getCentralPanel()); //Cambiamos al panel de Seleccion de pokemon
                    vista.getFrame().revalidate();
                    vista.getFrame().repaint();
                    vista.getInfoPanel().setVisible(false); //Hacemos invisible el panel de informacion de los pokemon
                    vista.getButtonSelectZeraora().setText("Fuera de Combate");
                    vista.getButtonSelectZeraora().setEnabled(false); //Como el pokemon ha sido derrotado, no se puede volver a usar
                    controlarBotonesInfo(); //Preparamos la informacion de los pokemon en el panel de seleccion

                }

                if (pokemonPropio.getNombre().toString().equalsIgnoreCase("Zoroark")) {
                    vista.getFrame().remove(vista.getCombatPanel()); //Nos cargamos el panel de combate
                    vista.getFrame().add(vista.getCentralPanel()); //Cambiamos al panel de Seleccion de pokemon
                    vista.getFrame().revalidate();
                    vista.getFrame().repaint();
                    vista.getInfoPanel().setVisible(false); //Hacemos invisible el panel de informacion de los pokemon
                    vista.getButtonSelectZoroark().setText("Fuera de Combate");
                    vista.getButtonSelectZoroark().setEnabled(false); //Como el pokemon ha sido derrotado, no se puede volver a usar
                    controlarBotonesInfo(); //Preparamos la informacion de los pokemon en el panel de seleccion

                }
            }

            //EL POKEMON RIVAL PIERDE
            if (pokemonRival.getVida()==0) {
                if (pokemonPropio.getNombre().toString().equalsIgnoreCase("Lucario")) {
                    vista.getFrame().remove(vista.getCombatPanel()); //Nos cargamos el panel de combate
                    vista.getFrame().add(vista.getCentralPanel()); //Cambiamos al panel de Seleccion de pokemon
                    vista.getFrame().revalidate();
                    vista.getFrame().repaint();
                    vista.getInfoPanel().setVisible(false); //Hacemos invisible el panel de informacion de los pokemon
                    controlarBotonesInfo(); //Preparamos la informacion de los pokemon en el panel de seleccion

                }

                if (pokemonPropio.getNombre().toString().equalsIgnoreCase("Zeraora")) {
                    vista.getFrame().remove(vista.getCombatPanel()); //Nos cargamos el panel de combate
                    vista.getFrame().add(vista.getCentralPanel()); //Cambiamos al panel de Seleccion de pokemon
                    vista.getFrame().revalidate();
                    vista.getFrame().repaint();
                    vista.getInfoPanel().setVisible(false); //Hacemos invisible el panel de informacion de los pokemon
                    controlarBotonesInfo(); //Preparamos la informacion de los pokemon en el panel de seleccion

                }

                if (pokemonPropio.getNombre().toString().equalsIgnoreCase("Zoroark")) {
                    vista.getFrame().remove(vista.getCombatPanel()); //Nos cargamos el panel de combate
                    vista.getFrame().add(vista.getCentralPanel()); //Cambiamos al panel de Seleccion de pokemon
                    vista.getFrame().revalidate();
                    vista.getFrame().repaint();
                    vista.getInfoPanel().setVisible(false); //Hacemos invisible el panel de informacion de los pokemon
                    controlarBotonesInfo(); //Preparamos la informacion de los pokemon en el panel de seleccion

                }
            }
        });

        //BOTON DE SEGUIR LUCHANDO CON EL MISMO POKEMON
        vista.getButtonAbandonar().addActionListener(e->{

            seleccionarNuevoPokemonRival();
            vista.getButtonAbandonar().setVisible(false);
            vista.getButtonSeleccionarPokemonPropio().setVisible(false);


            if (pokemonRival.getNombre().toString().equalsIgnoreCase("Lycanroc")) {
               vista.getFrame().remove(vista.getCombatPanel());
               vista.getFrame().add(vista.getCombatPanel());
               vista.getFrame().revalidate();
               vista.getFrame().repaint();
               vista.getBackgroundImageLabel().setEnabled(false);
               vista.getPreCombatPanel().setVisible(true);
            }

            if (pokemonRival.getNombre().toString().equalsIgnoreCase("Raikou")){
                vista.getFrame().remove(vista.getCombatPanel());
                vista.getFrame().add(vista.getCombatPanel());
                vista.getFrame().revalidate();
                vista.getFrame().repaint();
                vista.getPreCombatPanel().setVisible(true);
            }

            if (pokemonRival.getNombre().toString().equalsIgnoreCase("Scyther")){
                JLabel labelScyther = new JLabel("");
                labelScyther.setIcon(new ImageIcon("img/lucariovsscyther.jpg"));
                vista.getBackgroundImageLabel().removeAll();
                vista.getCombatPanel().add(labelScyther);
                vista.getPreCombatPanel().setVisible(true);
            }
        });


    }

    private void seleccionarNuevoPokemonRival() {
        //Comprobamos el nombre del pokemon eliminado y lo quitamos de la lista
         if (pokemonRival.getNombre().toString().equalsIgnoreCase("Lycanroc")){
             listaRivales.remove(0); //Eliminamos el rival de la lista

             while (true) { //Escogemos un rival que sea distinto al que acabamos de eliminar, y luego como no se volvera a entrar a este if no afectara el 3 rival
                 pokemonRival = escogerPokemonRival();
                 if (!pokemonRival.getNombre().toString().equalsIgnoreCase("Lycanroc")){
                     break;
                 }
             }
             return; //Lo sacamos del metodo porque sino borra tambien en nuevo pokemon rival escogido
         }
        if (pokemonRival.getNombre().toString().equalsIgnoreCase("Scyther")){
            listaRivales.remove(1); //Eliminamos el rival de la lista
            while (true) { //Escogemos un rival que sea distinto al que acabamos de eliminar, y luego como no se volvera a entrar a este if no afectara el 3 rival
                pokemonRival = escogerPokemonRival();
                if (!pokemonRival.getNombre().toString().equalsIgnoreCase("Lycanroc")){
                    break;
                }
            }
            return; //Lo sacamos del metodo porque sino borra tambien en nuevo pokemon rival escogido
        }
        if (pokemonRival.getNombre().toString().equalsIgnoreCase("Raikou")){
            listaRivales.remove(2); //Eliminamos el rival de la lista
            while (true) { //Escogemos un rival que sea distinto al que acabamos de eliminar, y luego como no se volvera a entrar a este if no afectara el 3 rival
                pokemonRival = escogerPokemonRival();
                if (!pokemonRival.getNombre().toString().equalsIgnoreCase("Lycanroc")){
                    break;
                }
            }
            return; //Lo sacamos del metodo porque sino borra tambien en nuevo pokemon rival escogido
        }


    }

    private void controlarBotonesPreCombate() {
        //Evento de respuesta de Informacion del Pokemon Rival
        vista.getButtonInfoPokemonRival().addActionListener(e->{

            //Seteamos la informacion del pokemon rival en los textFields
            if (pokemonRival.getNombre().toString().equalsIgnoreCase("Lycanroc")){
                vista.getNombrePokemonRivalTextField().setText(pokemonRival.getNombre().toString());
                vista.getTipoPOkemonRivalTextField().setText(pokemonRival.getTipo().toString());
                vista.getVidaPokemonRivalTextField().setText(String.valueOf(pokemonRival.getVida()));
                vista.getHabilidadPokemonRivalTextField().setText("Un Pokémon tranquilo y prudente. Su melena de piedra es tan afilada como una cuchilla.");
                vista.getPokedecPokemonRivalTextField().setText("745");
                vista.getGeneracionPokemonRivalTextField().setText("7");
                vista.getInfoPokemonRivalPanel().setVisible(true);
            }

            if (pokemonRival.getNombre().toString().equalsIgnoreCase("Scyther")){
                //Seteamos la informacion del pokemon rival en los textFields
                vista.getNombrePokemonRivalTextField().setText(pokemonRival.getNombre().toString());
                vista.getTipoPOkemonRivalTextField().setText("Bicho/Volador");
                vista.getVidaPokemonRivalTextField().setText(String.valueOf(pokemonRival.getVida()));
                vista.getHabilidadPokemonRivalTextField().setText("Sus guadañas se vuelven más afiladas con cada combate. Es capaz de rebanar troncos gruesos de un tajo.");
                vista.getPokedecPokemonRivalTextField().setText("123");
                vista.getGeneracionPokemonRivalTextField().setText("1");
                vista.getInfoPokemonRivalPanel().setVisible(true);
            }

            if (pokemonRival.getNombre().toString().equalsIgnoreCase("Raikou")){
                //Seteamos la informacion del pokemon rival en los textFields
                vista.getNombrePokemonRivalTextField().setText(pokemonRival.getNombre().toString());
                vista.getTipoPOkemonRivalTextField().setText(pokemonRival.getTipo().toString());
                vista.getVidaPokemonRivalTextField().setText(String.valueOf(pokemonRival.getVida()));
                vista.getHabilidadPokemonRivalTextField().setText("Raikou tiene la velocidad del rayo. Los rugidos de este Pokémon emiten ondas de choque que se esparcen vibrando por el aire y sacuden el suelo como si fueran auténticas descargas de rayo.");
                vista.getPokedecPokemonRivalTextField().setText("243");
                vista.getGeneracionPokemonRivalTextField().setText("2");
                vista.getInfoPokemonRivalPanel().setVisible(true);
            }
        });

        //Controlamos el boton de cancelar Informacion
        vista.getOcultarInfoPokemonRivalButton().addActionListener(f->{
            vista.getTextFieldInfoPokemon().setText("");
            vista.getTextFieldTipoPokemon().setText("");
            vista.getTextFieldPokedex().setText("");
            vista.getTextAreaInfoHabilidad().setText("");
            vista.getTextFieldInfoGeneracion().setText("");
            vista.getInfoPokemonRivalPanel().setVisible(false);

        });

        //Ocultamos El boton de seleccion de nuevo pokemon y el de abandonar combate (Solo disponibles en K.O.)
        vista.getButtonAbandonar().setVisible(false);
        vista.getButtonSeleccionarPokemonPropio().setVisible(false);

        //Controlamos el evento de luchar= Comienza el combate
        vista.getButtonFight().addActionListener(e->{

            //Activamos los botones de los movimientos
            vista.getButtonAtaque1().setEnabled(true);
            vista.getButtonAtaque2().setEnabled(true);
            vista.getButtonAtaque3().setEnabled(true);
            vista.getButtonAtaque4().setEnabled(true);

            //Ocultamos el panel Pre-Combate
            vista.getPreCombatPanel().setVisible(false);

            //Seteamos un texto arriba
            vista.getTextFieldNarrador().setText("QUE COMIENZE EL COMBATE!!!");

            //Llamamos a la clase del combate
            combateLucario(pokemonRival, pokemonPropio);
        });
    }

    private void controlarBotonesSelect() {
        //BOTON SELECT LUCARIO
        vista.getButtonSelectLucario().addActionListener(e->{
            vista.getFrame().remove(vista.getCentralPanel());
            vista.getFrame().add(vista.getCombatPanel());
            vista.getFrame().revalidate();
            vista.getFrame().repaint();
            vista.getInfoPanel().setVisible(false);


            pokemonPropio= new Pokemon(nombrePokemon.Lucario, tipoPokemon.Lucha_Acero, 200, 80, 120,
                    25, 120, "Esfera Aural", "A Bocajarro", "Ataque Óseo", "Onda Certera"
                    ,tiposMovimiento.Lucha ,tiposMovimiento.Lucha, tiposMovimiento.Tierra, tiposMovimiento.Lucha );
            vista.getButtonAtaque1().setText(pokemonPropio.getNombreMov1());
            vista.getButtonAtaque2().setText(pokemonPropio.getNombreMov2());
            vista.getButtonAtaque3().setText(pokemonPropio.getNombreMov3());
            vista.getButtonAtaque4().setText(pokemonPropio.getNombreMov4());

            pokemonRival =escogerPokemonRival();

            if (pokemonRival.getNombre().toString().equalsIgnoreCase("Scyther")){
                //creamos panel con lucarioVSscyther.jpg
                // TODO: 09/09/21 Solucionar problema con el border side de la imagen para que salga entera

                JLabel labelScyther = new JLabel("");
                labelScyther.setIcon(new ImageIcon("img/lucariovsscyther.jpg"));
                vista.getBackgroundImageLabel().removeAll();
                vista.getCombatPanel().add(labelScyther);

                //seteamos un texto a modo de narrador
                vista.getTextFieldNarrador().setText("El Entrenador Juan saca a "+ pokemonRival.getNombre());


                //seteamos la vida inicial de ambos pokemon
                vista.getTextFieldVidaPokemon().setText(String.valueOf(pokemonPropio.getVida()));

                //Seteamos la visibilidad del panel de informacion y el de precombate
                vista.getPreCombatPanel().setVisible(true);
                vista.getInfoPokemonRivalPanel().setVisible(false);
            }

            if (pokemonRival.getNombre().toString().equalsIgnoreCase("Lycanroc")){
                //creamos panel con lucarioVSlycanroc.jpg
                vista.getBackgroundImageLabel().setEnabled(false);


                //seteamos un texto a modo de narrador
                vista.getTextFieldNarrador().setText("El Entrenador Juan saca a "+ pokemonRival.getNombre());

                //seteamos la vida inicial de ambos pokemon
                vista.getTextFieldVidaPokemon().setText(String.valueOf(pokemonPropio.getVida()));
                vista.getTextFieldVidaPokemonRival().setText(String.valueOf(pokemonRival.getVida()));

                //Seteamos la visibilidad del panel de informacion y el de precombate
                vista.getPreCombatPanel().setVisible(true);
                vista.getInfoPokemonRivalPanel().setVisible(false);
            }

            if (pokemonRival.getNombre().toString().equalsIgnoreCase("Raikou")){
                //Esta seteado a la imagen de raikou por defecto

                //seteamos un texto a modo de narrador
                vista.getTextFieldNarrador().setText("El Entrenador Juan saca a "+ pokemonRival.getNombre());

                //seteamos la vida inicial de ambos pokemon
                vista.getTextFieldVidaPokemon().setText(String.valueOf(pokemonPropio.getVida()));
                vista.getTextFieldVidaPokemonRival().setText(String.valueOf(pokemonRival.getVida()));

                //Seteamos la visibilidad del panel de informacion y el de precombate
                vista.getPreCombatPanel().setVisible(true);
                vista.getInfoPokemonRivalPanel().setVisible(false);

            }

        });

        //BOTON SELECT ZERAORA
        vista.getButtonSelectZeraora().addActionListener(e->{
            JOptionPane.showMessageDialog(vista.getFrame(),"Zeraora no esta disponible aún","Select Zeraora",JOptionPane.WARNING_MESSAGE);
        });

        //BOTON SELECT ZOROARK
        vista.getButtonSelectZoroark().addActionListener(e->{
            JOptionPane.showMessageDialog(vista.getFrame(),"Zoroark no esta disponible aún","Select Zoroark",JOptionPane.WARNING_MESSAGE);
        });
    }

    private void controlarBotonesInfo() {
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
        vista.getTextFieldInfoGeneracion().setText("7");

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

    private Pokemon escogerPokemonRival() {
        //Variable privada del pokemonEscogido
        Pokemon pokemonEscogido = null;
        //Se elegirá con un Math random cualquiera
        int random = (int) (Math.random()*10-1);

        //Si <=3 :Lycanroc | >3 <=6: Scyther | >6 <=9: Raikou
        if (random<=3){
            pokemonEscogido = new Pokemon(nombrePokemon.Lycanroc, tipoPokemon.Roca, 200,40, 80
                    , 75, 60, "Roca Veloz", "Triturar", "Avalancha", "Mordisco"
                    , tiposMovimiento.Roca, tiposMovimiento.Siniestro, tiposMovimiento.Roca, tiposMovimiento.Siniestro);
            System.out.println("Lycanroc");


        }
        if (random >3 && random<=6){
            pokemonEscogido = new Pokemon(nombrePokemon.Scyther, tipoPokemon.Bicho_Volador, 200, 60, 80, 75, 40
                    , "Ataque Ala", "Tijera X", "Tajo Aéreo", "Corte Furia",
                    tiposMovimiento.Volador, tiposMovimiento.Bicho, tiposMovimiento.Volador, tiposMovimiento.Bicho);
            System.out.println("Scyther");

        }
        if (random>6 && random<=9){
            pokemonEscogido = new Pokemon(nombrePokemon.Raikou, tipoPokemon.Electrico, 200, 80, 40, 110, 80
                    , "Paranormal", "Golpe Roca", "Trueno", "Chispazo",
                    tiposMovimiento.Psiquico, tiposMovimiento.Lucha, tiposMovimiento.Electrico, tiposMovimiento.Electrico);
            System.out.println("Raikou");
        }
        System.out.println(random);

        return pokemonEscogido;
    }

    private void combateLucario(Pokemon pokemonRival, Pokemon pokemon) {

        //BARRAS DE VIDA TOP PANEL
        vista.getTextFieldVidaPokemon().setText(String.valueOf(pokemon.getVida()));
        vista.getTextFieldVidaPokemonRival().setText(String.valueOf(pokemonRival.getVida()));

        //Hacemos Visible los botones de ataque para cuando se inicie la siguiente ronda de ataque
        vista.getButtonAtaque1().setEnabled(true);
        vista.getButtonAtaque2().setEnabled(true);
        vista.getButtonAtaque3().setEnabled(true);
        vista.getButtonAtaque4().setEnabled(true);



        //ATAQUE 1: Esfera Aural = 80 Potencia (Debil contra Scyther)
        vista.getButtonAtaque1().addActionListener(e->{

            //Deshabilitamos los botones para evitar doble pulsacion a distintos ataques
            vista.getButtonAtaque1().setEnabled(false);
            vista.getButtonAtaque2().setEnabled(false);
            vista.getButtonAtaque3().setEnabled(false);
            vista.getButtonAtaque4().setEnabled(false);
            int vidaRestante=0;

            //Debilidad contra Bicho/Volador (20% reduccion)
            if (pokemonRival.getTipo().toString().equals("Bicho_Volador")){
                vidaRestante = pokemonRival.getVida()- (int) (pokemon.getMov1()-pokemon.getMov1()*0.2);
                pokemonRival.setVida(vidaRestante);
                vista.getTextFieldVidaPokemonRival().setText(String.valueOf(vidaRestante));

                //Salida por consola
                System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getNombreMov1() + " contra "+ pokemonRival.getNombre());
                System.out.println(pokemon.getNombreMov1() + " es poco eficaz contra " + pokemonRival.getNombre());

                //Salida en el campo de narracion
                vista.getTextFieldNarrador().setText(pokemon.getNombre()+" ha usado "+pokemon.getNombreMov1() + " contra "+ pokemonRival.getNombre()
                        +". "+pokemon.getNombreMov1() + " es poco eficaz contra " + pokemonRival.getNombre());



            } else {
                //Sin debilidad
                vidaRestante = pokemonRival.getVida() - pokemon.getMov1();
                pokemonRival.setVida(vidaRestante);

                vista.getTextFieldVidaPokemonRival().setText(String.valueOf(vidaRestante));

                System.out.println(pokemon.getNombre() + " ha usado " + pokemon.getNombreMov1() + " contra " + pokemonRival.getNombre());

                vista.getTextFieldNarrador().setText(pokemon.getNombre() + " ha usado " + pokemon.getNombreMov1() + " contra " + pokemonRival.getNombre());
            }

            //Realizamos el ataque del rival
            System.out.println("ATAQUE DEL POKEMON RIVAL!!");
            ataquePokemonRivalLucario(pokemonRival,pokemon);

            //Hacemos Visible los botones de ataque para cuando se inicie la siguiente ronda de ataque
            vista.getButtonAtaque1().setEnabled(true);
            vista.getButtonAtaque2().setEnabled(true);
            vista.getButtonAtaque3().setEnabled(true);
            vista.getButtonAtaque4().setEnabled(true);

            //Si alguno de los dos pokemon alcanzan 0 o menos vida se acaba el combate
            comprobarVidaPokemon();

        });


        //ATAQUE 2: A Bocajarro: 120 (Debil contral bicho/volador)
        vista.getButtonAtaque2().addActionListener(e->{

            //Deshabilitamos los botones para que no se realize ningún ataque entre medias de pulsar 1
            vista.getButtonAtaque1().setEnabled(false);
            vista.getButtonAtaque2().setEnabled(false);
            vista.getButtonAtaque3().setEnabled(false);
            vista.getButtonAtaque4().setEnabled(false);
            int vidaRestante=0;

            //Debilidad contra Bicho/Volador (20% reduccion)
            if (pokemonRival.getTipo().toString().equals("Bicho_Volador")){
                vidaRestante = pokemonRival.getVida()- (int) (pokemon.getMov2()-pokemon.getMov2()*0.2);
                pokemonRival.setVida(vidaRestante);
                vista.getTextFieldVidaPokemonRival().setText(String.valueOf(vidaRestante));

                //Salida por consola
                System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getNombreMov2() + " contra "+ pokemonRival.getNombre());
                System.out.println(pokemon.getNombreMov2() + " es poco eficaz contra " + pokemonRival.getNombre());

                //Salida campo de narracion
                vista.getTextFieldNarrador().setText(pokemon.getNombre()+" ha usado "+pokemon.getNombreMov2() + " contra "+ pokemonRival.getNombre()
                        + ". "+pokemon.getNombreMov2() + " es poco eficaz contra " + pokemonRival.getNombre() );
            } else {

                //Sin debilidad
                vidaRestante = pokemonRival.getVida() - pokemon.getMov2();
                pokemonRival.setVida(vidaRestante);

                vista.getTextFieldVidaPokemonRival().setText(String.valueOf(vidaRestante));

                System.out.println(pokemon.getNombre() + " ha usado " + pokemon.getNombreMov2() + " contra " + pokemonRival.getNombre());
                vista.getTextFieldNarrador().setText(pokemon.getNombre() + " ha usado " + pokemon.getNombreMov2() + " contra " + pokemonRival.getNombre());
            }

            //Ataque del rival
            ataquePokemonRivalLucario(pokemonRival,pokemon);

            //Hacemos Visible los botones de ataque para cuando se inicie la siguiente ronda de ataque
            vista.getButtonAtaque1().setEnabled(true);
            vista.getButtonAtaque2().setEnabled(true);
            vista.getButtonAtaque3().setEnabled(true);
            vista.getButtonAtaque4().setEnabled(true);


            //Si alguno de los dos pokemon alcanzan 0 o menos vida se acaba el combate
            comprobarVidaPokemon();

        });


        //ATAQUE 3: Ataque Oseo: 25 (Debil contral bicho/volador, Fuerte contra Electrico y Roca)
        vista.getButtonAtaque3().addActionListener(e->{

            //Deshabilitamos los botones para evitar pulsar 2 botones a la vez
            vista.getButtonAtaque1().setEnabled(false);
            vista.getButtonAtaque2().setEnabled(false);
            vista.getButtonAtaque3().setEnabled(false);
            vista.getButtonAtaque4().setEnabled(false);
            int vidaRestante=0;

            //Calculamos el numero de golpes de Ataque Óseo
            int random = (int) (Math.random()*3);
            if (random==0){
                random=2;
            }
            System.out.println("Numero de Golpes Ataque Óseo: " + random);

            //Segun el numero de golpes determinado, el ataque se realizará dichas veces
            for (int i = 0; i <random; i++) {

                //Debilidad contra Bicho/Volador (20% reduccion)
                if (pokemonRival.getTipo().toString().equals("Bicho_Volador")) {
                    vidaRestante = pokemonRival.getVida() - (int) (pokemon.getMov3() - pokemon.getMov3() * 0.2);
                    pokemonRival.setVida(vidaRestante);
                    vista.getTextFieldVidaPokemonRival().setText(String.valueOf(vidaRestante));

                    //Salida por consola
                    System.out.println(pokemon.getNombre() + " ha usado " + pokemon.getNombreMov3() + " contra " + pokemonRival.getNombre());
                    System.out.println(pokemon.getNombreMov3() + " es poco eficaz contra " + pokemonRival.getNombre());

                    //Salida campo narracion
                    vista.getTextFieldNarrador().setText(pokemon.getNombre() + " ha usado " + pokemon.getNombreMov3() + " contra " + pokemonRival.getNombre()
                            + ". " + pokemon.getNombreMov3() + " es poco eficaz contra " + pokemonRival.getNombre());
                }

                //Fortaleza contra Electrico y Roca (50% aumento)
                if (pokemonRival.getTipo().toString().equalsIgnoreCase("Electrico") ||
                        pokemonRival.getTipo().toString().equalsIgnoreCase("Roca")) {

                    vidaRestante = pokemonRival.getVida() - (int) (pokemon.getMov3() * 0.5 + pokemon.getMov3());
                    pokemonRival.setVida(vidaRestante);
                    vista.getTextFieldVidaPokemonRival().setText(String.valueOf(vidaRestante));

                    //Salida por consola
                    System.out.println(pokemon.getNombre() + " ha usado " + pokemon.getNombreMov3() + " contra " + pokemonRival.getNombre());
                    System.out.println("Es supereficaz!!!");

                    //Salida campo de narracion
                    vista.getTextFieldNarrador().setText(pokemon.getNombre() + " ha usado " + pokemon.getNombreMov3() + " contra " + pokemonRival.getNombre()
                            + ". Es supereficaz!!!");
                } else {
                    //Sin debilidad
                    vidaRestante = pokemonRival.getVida() - pokemon.getMov3();
                    pokemonRival.setVida(vidaRestante);
                    vista.getTextFieldVidaPokemonRival().setText(String.valueOf(vidaRestante));
                    System.out.println(pokemon.getNombre() + " ha usado " + pokemon.getNombreMov3() + " contra " + pokemonRival.getNombre());
                    vista.getTextFieldNarrador().setText(pokemon.getNombre() + " ha usado " + pokemon.getNombreMov3() + " contra " + pokemonRival.getNombre());
                }
            }

            //Ataque del rival
            ataquePokemonRivalLucario(pokemonRival,pokemon);

            //Hacemos Visible los botones de ataque para cuando se inicie la siguiente ronda de ataque
            vista.getButtonAtaque1().setEnabled(true);
            vista.getButtonAtaque2().setEnabled(true);
            vista.getButtonAtaque3().setEnabled(true);
            vista.getButtonAtaque4().setEnabled(true);

            //Si alguno de los dos pokemon alcanzan 0 o menos vida se acaba el combate
            comprobarVidaPokemon();
        });

        //ATAQUE 4: Onda Certera: 120 (Debil contral bicho/volador)
        vista.getButtonAtaque4().addActionListener(e->{

            //Deshabilitamos los botones para evitar 2 pulsaciones seguidas
            vista.getButtonAtaque1().setEnabled(false);
            vista.getButtonAtaque2().setEnabled(false);
            vista.getButtonAtaque3().setEnabled(false);
            vista.getButtonAtaque4().setEnabled(false);
            int vidaRestante=0;

            //Debilidad contra Bicho/Volador (20% reduccion)
            if (pokemonRival.getTipo().toString().equals("Bicho_Volador")){
                vidaRestante = pokemonRival.getVida()- (int) (pokemon.getMov4()-pokemon.getMov4()*0.2);
                pokemonRival.setVida(vidaRestante);
                vista.getTextFieldVidaPokemonRival().setText(String.valueOf(vidaRestante));

                //Salida por consola
                System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getNombreMov4() + " contra "+ pokemonRival.getNombre());
                System.out.println(pokemon.getNombreMov4() + " es poco eficaz contra " + pokemonRival.getNombre());

                //Salida campo narracion
                vista.getTextFieldNarrador().setText(pokemon.getNombre()+" ha usado "+pokemon.getNombreMov4() + " contra "+ pokemonRival.getNombre()
                        +". "+ pokemon.getNombreMov4() + " es poco eficaz contra " + pokemonRival.getNombre());

            } else {
                //Sin debilidad
                vidaRestante = pokemonRival.getVida() - pokemon.getMov4();
                pokemonRival.setVida(vidaRestante);
                vista.getTextFieldVidaPokemonRival().setText(String.valueOf(vidaRestante));
                System.out.println(pokemon.getNombre() + " ha usado " + pokemon.getNombreMov4() + " contra " + pokemonRival.getNombre());
                vista.getTextFieldNarrador().setText(pokemon.getNombre() + " ha usado " + pokemon.getNombreMov4() + " contra " + pokemonRival.getNombre());
            }

            //Ataque del rival
            ataquePokemonRivalLucario(pokemonRival,pokemon);

            //Hacemos Visible los botones de ataque para cuando se inicie la siguiente ronda de ataque
            vista.getButtonAtaque1().setEnabled(true);
            vista.getButtonAtaque2().setEnabled(true);
            vista.getButtonAtaque3().setEnabled(true);
            vista.getButtonAtaque4().setEnabled(true);


            //Si alguno de los dos pokemon alcanzan 0 o menos vida se acaba el combate
            comprobarVidaPokemon();
        });

    }

    private void ataquePokemonRivalLucario(Pokemon pokemonRival, Pokemon pokemon) {

        //Si alguno de los 2 pokemon se quedan sin vida, se acaba el combate
        if (pokemonPropio.getVida() <= 0 || pokemonRival.getVida() <= 0) {

            System.out.println("Fin del combate");

            //Seteamos el campo del narrador para indicar el fin del combate
            if (pokemonPropio.getVida() <= 0) {
                vista.getTextFieldNarrador().setText(pokemonPropio.getNombre().toString() + " esta fuera de combate!!!!    " + pokemonRival.getNombre()+" gana!!!");
                vista.getTextFieldVidaPokemon().setText("0");
            }
            if (pokemonRival.getVida() <= 0) {
                vista.getTextFieldNarrador().setText(pokemonRival.getNombre().toString() + " esta fuera de combate!!!!    " + pokemonPropio.getNombre()+" gana!!!");
                vista.getTextFieldVidaPokemonRival().setText("0");
            }

            //Deshabilitamos los botones de los movimientos
            vista.getButtonAtaque1().setEnabled(false);
            vista.getButtonAtaque2().setEnabled(false);
            vista.getButtonAtaque3().setEnabled(false);
            vista.getButtonAtaque4().setEnabled(false);

            //Salimos del combate rival
            return;
        }


        //El ataque se realizara aleatoriamente con un Math.Random
        int random = (int) (Math.random()*4);
        int vidaRestante=0;

        //Si sale 0 el pokemon no atacaba
        if (random==0){
            random=2;
        }

        //Posibles Ataques: Roca Veloz (Lyc), Ataque Ala (Sc), Paranormal (Rk)
        //Roca Veloz= Debil contra Lucario, Ataque Ala y Paranormal = Fuerte contra Lucario
        if (random==1) {

            if (pokemonRival.getTipoMov1().toString().equalsIgnoreCase("Psiquico") ||
                    pokemonRival.getTipoMov1().toString().equalsIgnoreCase("Volador")) {

                //Incremento de un 50% del daño si es fuerte contra Lucario
                vidaRestante = pokemon.getVida() - (int) (pokemonRival.getMov1() * 0.50 + pokemonRival.getMov1());
                pokemon.setVida(vidaRestante);
                vista.getTextFieldVidaPokemon().setText(String.valueOf(vidaRestante));

                //Salida por consola
                System.out.println(pokemonRival.getNombre() + " ha usado " + pokemonRival.getNombreMov1()
                        + " contra " + pokemon.getNombre());
                System.out.println("Ha sido supereficaz!!");

                //Salida campo de narracion
                vista.getTextFieldNarrador().setText(pokemonRival.getNombre() + " ha usado " + pokemonRival.getNombreMov1() + " contra " + pokemon.getNombre()
                        + ". Ha sido superficaz!!!");

                return;
            }



            //Reduccion de un 20% si es debil contra Lucario
            if (pokemonRival.getTipoMov1().toString().equalsIgnoreCase("Roca")) {
                vidaRestante = pokemon.getVida() - (int) (pokemonRival.getMov1() - pokemonRival.getMov1() * 0.20);
                pokemon.setVida(vidaRestante);
                vista.getTextFieldVidaPokemon().setText(String.valueOf(vidaRestante));

                //Salida por consola
                System.out.println(pokemonRival.getNombre() + " ha usado " + pokemonRival.getNombreMov1()
                        + " contra " + pokemon.getNombre());
                System.out.println("Ha sido poco eficaz...");

                //Salida campo narracion
                vista.getTextFieldNarrador().setText(pokemonRival.getNombre() + " ha usado " + pokemonRival.getNombreMov1() + " contra " + pokemon.getNombre()
                        + ". " + pokemonRival.getNombreMov1() + " es poco eficaz contra " + pokemon.getNombre());

                return;
            }


            vidaRestante = pokemon.getVida() - pokemonRival.getMov1();
            pokemon.setVida(vidaRestante);
            vista.getTextFieldVidaPokemon().setText(String.valueOf(vidaRestante));
            System.out.println(pokemonRival.getNombre() + " ha usado " + pokemonRival.getNombreMov1()
                    + " contra " + pokemon.getNombre());
            vista.getTextFieldNarrador().setText(pokemonRival.getNombre() + " ha usado " + pokemonRival.getNombreMov1() + " contra " + pokemon.getNombre());
        }

        //Posibles Ataques: Triturar (Lyc), Tijera X (Sc), Golpe Roca (Rk)
        //Triturar y Tijera X (bicho y siniestro) = Debil contra Lucario,
        if (random==2){
            //Reduccion de un 20% de daño contra Lucario
            if (pokemonRival.getTipoMov2().toString().equalsIgnoreCase("Bicho")||
                    pokemonRival.getTipoMov2().toString().equalsIgnoreCase("Siniestro")){
                vidaRestante = pokemon.getVida()-(int) (pokemonRival.getMov2()-pokemonRival.getMov2()*0.20);
                pokemon.setVida(vidaRestante);
                vista.getTextFieldVidaPokemon().setText(String.valueOf(vidaRestante));

                //Salida por consola
                System.out.println(pokemonRival.getNombre()+" ha usado " + pokemonRival.getNombreMov2()
                        + " contra "+ pokemon.getNombre());
                System.out.println("Ha sido poco eficaz...");

                //Salida campo narracion
                vista.getTextFieldNarrador().setText(pokemonRival.getNombre()+" ha usado "+pokemonRival.getNombreMov2() + " contra "+ pokemon.getNombre()
                        +". "+pokemonRival.getNombreMov2() + " es poco eficaz contra " + pokemon.getNombre());

                return;
            }

            vidaRestante= pokemon.getVida()- pokemonRival.getMov2();
            pokemon.setVida(vidaRestante);
            vista.getTextFieldVidaPokemon().setText(String.valueOf(vidaRestante));

            System.out.println(pokemonRival.getNombre()+" ha usado " + pokemonRival.getNombreMov2()
                    + " contra "+ pokemon.getNombre());
            vista.getTextFieldNarrador().setText(pokemonRival.getNombre()+" ha usado "+pokemonRival.getNombreMov2() + " contra "+ pokemon.getNombre());
        }

        //Posibles Ataques: Avalancha (Lyc), Tajo Areo (Sc), Trueno (Rk)
        //Avalancha (Roca) = Debil contra Lucario ----Tajo Areo (Volador) = Fuerte contra Lucario
        if (random==3){

            if (pokemonRival.getTipoMov3().toString().equalsIgnoreCase("Volador")){
                //incremento del 50% de daño contra Lucario
                vidaRestante = pokemon.getVida()-(int) (pokemonRival.getMov3()*0.50+pokemonRival.getMov3());
                pokemon.setVida(vidaRestante);
                vista.getTextFieldVidaPokemon().setText(String.valueOf(vidaRestante));

                //Salida por consola
                System.out.println(pokemonRival.getNombre()+" ha usado " + pokemonRival.getNombreMov3()
                        + " contra "+ pokemon.getNombre());
                System.out.println("Ha sido supereficaz!!");

                //Salida campo narracion
                vista.getTextFieldNarrador().setText(pokemonRival.getNombre()+" ha usado "+pokemonRival.getNombreMov3() + " contra "+ pokemon.getNombre()
                        +". Ha sido supereficaz!!!");
                return;
            }

            //Reduccion del 20% de daño contra Lucario
            if (pokemonRival.getTipoMov3().toString().equalsIgnoreCase("Roca")){
                vidaRestante = pokemon.getVida()-(int) (pokemonRival.getMov3()-pokemonRival.getMov3()*0.20);
                pokemon.setVida(vidaRestante);
                vista.getTextFieldVidaPokemon().setText(String.valueOf(vidaRestante));

                //Salida por consola
                System.out.println(pokemonRival.getNombre()+" ha usado " + pokemonRival.getNombreMov3()
                        + " contra "+ pokemon.getNombre());
                System.out.println("Ha sido poco eficaz...");

                //Salida campo narracion
                vista.getTextFieldNarrador().setText(pokemonRival.getNombre()+" ha usado "+pokemonRival.getNombreMov3() + " contra "+ pokemon.getNombre()
                        +". "+pokemonRival.getNombreMov3() + " es poco eficaz contra " + pokemon.getNombre());
                return;
            }

            vidaRestante= pokemon.getVida() - pokemonRival.getMov3();
            pokemon.setVida(vidaRestante);
            vista.getTextFieldVidaPokemon().setText(String.valueOf(vidaRestante));

            System.out.println(pokemonRival.getNombre()+" ha usado " + pokemonRival.getNombreMov3()
                    + " contra "+ pokemon.getNombre());
            vista.getTextFieldNarrador().setText(pokemonRival.getNombre()+" ha usado "+pokemonRival.getNombreMov3() + " contra "+ pokemon.getNombre());
        }

        //Posibles Ataques= Mordisco (Lyc), Corte Furia (Sc), Chispazo (Rk)
        //Mordisco y Cortes Furia (Siniestro, Bicho): Debil contra Lucario
        if (random==4){
            //Reduccion de un 20% de daño contra Lucario
            if (pokemonRival.getTipoMov4().toString().equalsIgnoreCase("Siniestro")||
                    pokemonRival.getTipoMov4().toString().equalsIgnoreCase("Bicho")){
                vidaRestante = pokemon.getVida()-(int) (pokemonRival.getMov4()-pokemonRival.getMov4()*0.20);
                pokemon.setVida(vidaRestante);
                vista.getTextFieldVidaPokemon().setText(String.valueOf(vidaRestante));

                //Salida por consola
                System.out.println(pokemonRival.getNombre()+" ha usado " + pokemonRival.getNombreMov4()
                        + " contra "+ pokemon.getNombre());
                System.out.println("Ha sido poco eficaz...");

                //Salida campo narracion
                vista.getTextFieldNarrador().setText(pokemonRival.getNombre()+" ha usado "+pokemonRival.getNombreMov4() + " contra "+ pokemon.getNombre()
                        +". "+pokemonRival.getNombreMov4() + " es poco eficaz contra " + pokemon.getNombre());
                return;
            }

            vidaRestante= pokemon.getVida()- pokemonRival.getMov4();
            pokemon.setVida(vidaRestante);
            vista.getTextFieldVidaPokemon().setText(String.valueOf(vidaRestante));

            System.out.println(pokemonRival.getNombre()+" ha usado " + pokemonRival.getNombreMov4()
                    + " contra "+ pokemon.getNombre());
            vista.getTextFieldNarrador().setText(pokemonRival.getNombre()+" ha usado "+pokemonRival.getNombreMov4() + " contra "+ pokemon.getNombre());
        }

    }

    private void comprobarVidaPokemon () {
        //Si alguno de los 2 pokemon tienen una vida igual o inferior a 0, fin dle combate
        if (pokemonPropio.getVida() <= 0 || pokemonRival.getVida() <= 0) {

            System.out.println("Fin del combate");

            //POKEMON PROPIO FUERA DE COMBATE
            if (pokemonPropio.getVida() <= 0) {
                vista.getTextFieldNarrador().setText(pokemonPropio.getNombre().toString() + " esta fuera de combate!!!!    " + pokemonRival.getNombre()+" gana!!!");
                vista.getTextFieldVidaPokemon().setText("0");

                //Hacemos visibles los botones para seleccionar nuevo pokemon o abandonar combate
                vista.getButtonAbandonar().setVisible(true);
                vista.getButtonSeleccionarPokemonPropio().setVisible(true);

                //BOTON ABANDONAR
                vista.getButtonAbandonar().addActionListener(e->{
                    System.exit(1); //Cerramos el juego directamente
                });
            }
            if (pokemonRival.getVida() <= 0) {
                //Hacemos visibles los botones para seleccionar nuevo pokemon o abandonar combate
                vista.getButtonAbandonar().setVisible(true);
                vista.getButtonAbandonar().setText("Seguir Luchando");
                vista.getButtonSeleccionarPokemonPropio().setVisible(true);


                vista.getTextFieldNarrador().setText(pokemonRival.getNombre().toString() + " esta fuera de combate!!!!    " + pokemonPropio.getNombre()+" gana!!!");
                vista.getTextFieldVidaPokemonRival().setText("0");
            }

            //Deshabilitamos los botones de los movimientos
            vista.getButtonAtaque1().setEnabled(false);
            vista.getButtonAtaque2().setEnabled(false);
            vista.getButtonAtaque3().setEnabled(false);
            vista.getButtonAtaque4().setEnabled(false);


        }
    }



}
