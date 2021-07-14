package controlador;

import modelo.DTO.Pokemon;
import modelo.DTO.nombrePokemon;
import modelo.DTO.tipoPokemon;
import modelo.DTO.tiposMovimiento;
import vista.Vista;

import javax.swing.*;
import java.awt.*;

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
            vista.getCentralPanel().removeAll();
            
            
            pokemon= new Pokemon(nombrePokemon.Lucario, tipoPokemon.Lucha_Acero, 200, 80, 120,
                    25, 120, "Esfera Aural", "A Bocajarro", "Ataque Óseo", "Onda Certera"
            ,tiposMovimiento.Lucha ,tiposMovimiento.Lucha, tiposMovimiento.Tierra, tiposMovimiento.Lucha );
            vista.getButtonAtaque1().setText("Esfera Aural");
            vista.getButtonAtaque2().setText("A Bocajarro");
            vista.getButtonAtaque3().setText("Ataque Óseo");
            vista.getButtonAtaque4().setText("Onda Certera");

            Pokemon pokemonRival =escogerPokemonRival();


            if (pokemonRival.getNombre().toString().equalsIgnoreCase("Scyther")){
                //creamos panel con lucarioVSscyther.jpg
                JPanel lucarioScyther = new JPanel();
                JLabel lucariovsscyther = new JLabel();
                lucariovsscyther.setIcon(new ImageIcon("img/lucarioVSscyther.png"));
                lucarioScyther.add(lucariovsscyther);
                vista.getCentralPanel().add(lucarioScyther);

                vista.getCentralPanel().invalidate();
                vista.getCentralPanel().repaint();
                lucarioScyther.setVisible(true);

            }

            if (pokemonRival.getNombre().toString().equalsIgnoreCase("Lycanroc")){
                //creamos panel con lucarioVSlycanroc.jpg
                JPanel lucarioLycanroc = new JPanel();
                JLabel lucariovslycanroc = new JLabel();
                lucariovslycanroc.setIcon(new ImageIcon("img/lucarioVSlycanroc.png"));
                lucarioLycanroc.add(lucariovslycanroc);
                vista.getCentralPanel().add(lucarioLycanroc);
                vista.getCentralPanel().invalidate();
                vista.getCentralPanel().repaint();
                lucarioLycanroc.setVisible(true);
            }

            if (pokemonRival.getNombre().toString().equalsIgnoreCase("Raikou")){
                //creamos panel con lucarioVSraikou.jpg
                JPanel lucarioRaikou = new JPanel();
                JLabel lucariovsraikou = new JLabel();
                lucariovsraikou.setIcon(new ImageIcon("img/lucarioVSraikou.png"));
                lucarioRaikou.add(lucariovsraikou);
                vista.getCentralPanel().add(lucarioRaikou);

                vista.getCentralPanel().validate();
                vista.getCentralPanel().repaint();
                lucarioRaikou.setVisible(true);
            }

         //   combateLucario(pokemonRival, pokemon);


        });
        
        //Evento Escoger Zeraora


    }

    private void combateLucario(Pokemon pokemonRival, Pokemon pokemon) {

        //Mientras tengan vida sigue el combate
        while (pokemon.getVida()<0 || pokemonRival.getVida()<0){

            //BARRAS DE VIDA TOP PANEL
            vista.getTextFieldVidaPokemon().setText(String.valueOf(pokemon.getVida()));
            vista.getTextFieldVidaPokemonRival().setText(String.valueOf(pokemonRival.getVida()));

            //Hacemos Visible los botones de ataque para cuando se inicie la siguiente ronda de ataque
            vista.getButtonAtaque1().setVisible(true);
            vista.getButtonAtaque2().setVisible(true);
            vista.getButtonAtaque3().setVisible(true);
            vista.getButtonAtaque4().setVisible(true);



            //ATAQUE 1: Esfera Aural = 80 Potencia (Debil contra Scyther)
            vista.getButtonAtaque1().addActionListener(e->{
                vista.getButtonAtaque2().setVisible(false);
                vista.getButtonAtaque3().setVisible(false);
                vista.getButtonAtaque4().setVisible(false);
            int vidaRestante=0;

            //Debilidad contra Bicho/Volador (20% reduccion)
            if (pokemonRival.getTipo().toString().equals("Bicho_Volador")){
                vidaRestante = pokemonRival.getVida()- (int) (pokemon.getMov1()*0.2);
                pokemonRival.setVida(vidaRestante);
                System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getMov1() + " contra "+ pokemon.getNombre());
                System.out.println(pokemon.getMov1() + " es poco eficaz contra " + pokemonRival.getNombre());

            }

            //Sin debilidad
                vidaRestante= pokemonRival.getVida()- pokemon.getMov1();
                System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getMov1() + " contra "+ pokemon.getNombre());


                //Realizamos el ataque del rival
            ataquePokemonRival(pokemon,pokemonRival);

            });


            //ATAQUE 2: A Bocajarro: 120 (Debil contral bicho/volador)
            vista.getButtonAtaque2().addActionListener(e->{
                vista.getButtonAtaque1().setVisible(false);
                vista.getButtonAtaque3().setVisible(false);
                vista.getButtonAtaque4().setVisible(false);
                int vidaRestante=0;

                //Debilidad contra Bicho/Volador (20% reduccion)
                if (pokemonRival.getTipo().toString().equals("Bicho_Volador")){
                    vidaRestante = pokemonRival.getVida()- (int) (pokemon.getMov2()*0.2);
                    pokemonRival.setVida(vidaRestante);
     System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getMov2() + " contra "+ pokemon.getNombre());
                    System.out.println(pokemon.getMov2() + " es poco eficaz contra " + pokemonRival.getNombre());

                }

                //Sin debilidad
                vidaRestante= pokemonRival.getVida()- pokemon.getMov2();
                System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getMov2() + " contra "+ pokemon.getNombre());

                //Ataque del rival
                ataquePokemonRival(pokemon, pokemonRival);
            });


            //ATAQUE 3: Ataque Oseo: 25 (Debil contral bicho/volador, Fuerte contra Electrico y Roca)
            vista.getButtonAtaque3().addActionListener(e->{
                vista.getButtonAtaque1().setVisible(false);
                vista.getButtonAtaque2().setVisible(false);
                vista.getButtonAtaque4().setVisible(false);
                int vidaRestante=0;

                //Debilidad contra Bicho/Volador (20% reduccion)
                if (pokemonRival.getTipo().toString().equals("Bicho_Volador")){
                    vidaRestante = pokemonRival.getVida()- (int) (pokemon.getMov3()*0.2);
                    pokemonRival.setVida(vidaRestante);

                    System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getMov3() + " contra "+ pokemon.getNombre());
                    System.out.println(pokemon.getMov3() + " es poco eficaz contra " + pokemonRival.getNombre());
                }

                //Fortaleza contra Electrico y Roca (50% aumento)
                if (pokemonRival.getTipo().toString().equalsIgnoreCase("Electrico") ||
                        pokemonRival.getTipo().toString().equalsIgnoreCase("Roca")){

                    vidaRestante = pokemonRival.getVida()- (int) (pokemon.getMov3()*0.5+ pokemon.getMov3());
                    pokemonRival.setVida(vidaRestante);

                    System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getMov3() + " contra "+ pokemon.getNombre());
                    System.out.println("Es supereficaz!!!");
                }


                //Sin debilidad
                vidaRestante= pokemonRival.getVida()- pokemon.getMov3();
                System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getMov3() + " contra "+ pokemon.getNombre());

                //Ataque del rival
                ataquePokemonRival(pokemon, pokemonRival);
            });

            //ATAQUE 4: Onda Certera: 120 (Debil contral bicho/volador)
            vista.getButtonAtaque4().addActionListener(e->{
                vista.getButtonAtaque1().setVisible(false);
                vista.getButtonAtaque3().setVisible(false);
                vista.getButtonAtaque2().setVisible(false);
                int vidaRestante=0;

                //Debilidad contra Bicho/Volador (20% reduccion)
                if (pokemonRival.getTipo().toString().equals("Bicho_Volador")){
                    vidaRestante = pokemonRival.getVida()- (int) (pokemon.getMov4()*0.2);
                    pokemonRival.setVida(vidaRestante);
                    System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getMov4() + " contra "+ pokemon.getNombre());
                    System.out.println(pokemon.getMov4() + " es poco eficaz contra " + pokemonRival.getNombre());

                }

                //Sin debilidad
                vidaRestante= pokemonRival.getVida()- pokemon.getMov4();
                System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getMov4() + " contra "+ pokemon.getNombre());

                //Ataque del rival
                ataquePokemonRival(pokemon, pokemonRival);
            });
        }

    }

    private void combateZeraora(Pokemon pokemonRival, Pokemon pokemon) {

        //Mientras tengan vida sigue el combate
        while (pokemon.getVida()<0 || pokemonRival.getVida()<0){

            //BARRAS DE VIDA TOP PANEL
            vista.getTextFieldVidaPokemon().setText(String.valueOf(pokemon.getVida()));
            vista.getTextFieldVidaPokemonRival().setText(String.valueOf(pokemonRival.getVida()));

            //Hacemos Visible los botones de ataque para cuando se inicie la siguiente ronda de ataque
            vista.getButtonAtaque1().setVisible(true);
            vista.getButtonAtaque2().setVisible(true);
            vista.getButtonAtaque3().setVisible(true);
            vista.getButtonAtaque4().setVisible(true);



            //ATAQUE 1: Ataque Fulgor = 120  (Fuerte contra Scyther, debil contra Lyc y Rk)
            vista.getButtonAtaque1().addActionListener(e->{
                vista.getButtonAtaque2().setVisible(false);
                vista.getButtonAtaque3().setVisible(false);
                vista.getButtonAtaque4().setVisible(false);
                int vidaRestante=0;

                //Fortaleza contra Bicho/Volador (50% aumento)
                if (pokemonRival.getTipo().toString().equals("Bicho_Volador")){
                    vidaRestante = pokemonRival.getVida()- (int) (pokemon.getMov1()*0.5+ pokemon.getMov1());
                    pokemonRival.setVida(vidaRestante);
                    System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getMov1() + " contra "+ pokemon.getNombre());
                    System.out.println("Es supereficaz!!!");

                }

                //Debilidad contra Roca y Electrico (20% reduccion)
                if (pokemonRival.getTipo().toString().equalsIgnoreCase("Electrico")||
                    pokemonRival.getTipo().toString().equalsIgnoreCase("Roca")){

                    vidaRestante = pokemonRival.getVida()- (int) (pokemon.getMov1()*0.2);
                    pokemonRival.setVida(vidaRestante);
                    System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getMov1() + " contra "+ pokemon.getNombre());
                    System.out.println(pokemon.getMov1() + " es poco eficaz contra " + pokemonRival.getNombre());
                }

                //Sin debilidad
                vidaRestante= pokemonRival.getVida()- pokemon.getMov1();
                System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getMov1() + " contra "+ pokemon.getNombre());


                //Realizamos el ataque del rival
                ataquePokemonRival(pokemon,pokemonRival);

            });


            //ATAQUE 2: Rayo: 120 (Fuerte contra Scyther, debil contra Lyc y Rk)
            vista.getButtonAtaque2().addActionListener(e->{
                vista.getButtonAtaque1().setVisible(false);
                vista.getButtonAtaque3().setVisible(false);
                vista.getButtonAtaque4().setVisible(false);
                int vidaRestante=0;

                //Fortaleza contra Bicho/Volador (50% aumento)
                if (pokemonRival.getTipo().toString().equals("Bicho_Volador")){
                    vidaRestante = pokemonRival.getVida()- (int) (pokemon.getMov2()*0.5+ pokemon.getMov1());
                    pokemonRival.setVida(vidaRestante);
                    System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getMov2() + " contra "+ pokemon.getNombre());
                    System.out.println("Es supereficaz!!!");

                }

                //Debilidad contra Roca y Electrico (20% reduccion)
                if (pokemonRival.getTipo().toString().equalsIgnoreCase("Electrico")||
                        pokemonRival.getTipo().toString().equalsIgnoreCase("Roca")){

                    vidaRestante = pokemonRival.getVida()- (int) (pokemon.getMov2()*0.2);
                    pokemonRival.setVida(vidaRestante);
                    System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getMov2() + " contra "+ pokemon.getNombre());
                    System.out.println(pokemon.getMov2() + " es poco eficaz contra " + pokemonRival.getNombre());
                }

                //Sin debilidad
                vidaRestante= pokemonRival.getVida()- pokemon.getMov1();
                System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getMov2() + " contra "+ pokemon.getNombre());


                //Realizamos el ataque del rival
                ataquePokemonRival(pokemon,pokemonRival);
            });


            //ATAQUE 3: Puños Plasma: 100 (Fuerte contra bicho/volador, Debil contra Electrico y Roca)
            vista.getButtonAtaque3().addActionListener(e->{
                vista.getButtonAtaque1().setVisible(false);
                vista.getButtonAtaque2().setVisible(false);
                vista.getButtonAtaque4().setVisible(false);
                int vidaRestante=0;

                //Fortaleza contra Bicho/Volador (50% aumento)
                if (pokemonRival.getTipo().toString().equals("Bicho_Volador")){
                    vidaRestante = pokemonRival.getVida()- (int) (pokemon.getMov3()*0.5+ pokemon.getMov1());
                    pokemonRival.setVida(vidaRestante);
                    System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getMov3() + " contra "+ pokemon.getNombre());
                    System.out.println("Es supereficaz!!!");

                }

                //Debilidad contra Roca y Electrico (20% reduccion)
                if (pokemonRival.getTipo().toString().equalsIgnoreCase("Electrico")||
                        pokemonRival.getTipo().toString().equalsIgnoreCase("Roca")){

                    vidaRestante = pokemonRival.getVida()- (int) (pokemon.getMov3()*0.2);
                    pokemonRival.setVida(vidaRestante);
                    System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getMov3() + " contra "+ pokemon.getNombre());
                    System.out.println(pokemon.getMov3() + " es poco eficaz contra " + pokemonRival.getNombre());
                }

                //Sin debilidad
                vidaRestante= pokemonRival.getVida()- pokemon.getMov3();
                System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getMov3() + " contra "+ pokemon.getNombre());


                //Realizamos el ataque del rival
                ataquePokemonRival(pokemon,pokemonRival);
            });

            //ATAQUE 4: A Bocajarro: 120 (Debil contral bicho/volador)
            vista.getButtonAtaque4().addActionListener(e->{
                vista.getButtonAtaque1().setVisible(false);
                vista.getButtonAtaque3().setVisible(false);
                vista.getButtonAtaque2().setVisible(false);
                int vidaRestante=0;

                //Debilidad contra Bicho/Volador (20% reduccion)
                if (pokemonRival.getTipo().toString().equals("Bicho_Volador")){
                    vidaRestante = pokemonRival.getVida()- (int) (pokemon.getMov4()*0.2);
                    pokemonRival.setVida(vidaRestante);
                    System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getMov4() + " contra "+ pokemon.getNombre());
                    System.out.println(pokemon.getMov4() + " es poco eficaz contra " + pokemonRival.getNombre());

                }

                //Sin debilidad
                vidaRestante= pokemonRival.getVida()- pokemon.getMov4();
                System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getMov4() + " contra "+ pokemon.getNombre());

                //Ataque del rival
                ataquePokemonRival(pokemon, pokemonRival);
            });
        }

    }

    private void combateZoroark(Pokemon pokemonRival, Pokemon pokemon) {

        //Mientras tengan vida sigue el combate
        while (pokemon.getVida()<0 || pokemonRival.getVida()<0){

            //BARRAS DE VIDA TOP PANEL
            vista.getTextFieldVidaPokemon().setText(String.valueOf(pokemon.getVida()));
            vista.getTextFieldVidaPokemonRival().setText(String.valueOf(pokemonRival.getVida()));

            //Hacemos Visible los botones de ataque para cuando se inicie la siguiente ronda de ataque
            vista.getButtonAtaque1().setVisible(true);
            vista.getButtonAtaque2().setVisible(true);
            vista.getButtonAtaque3().setVisible(true);
            vista.getButtonAtaque4().setVisible(true);



            //ATAQUE 1: Pulso Noche = 85  (Debil contra Lucario)
            vista.getButtonAtaque1().addActionListener(e->{
                vista.getButtonAtaque2().setVisible(false);
                vista.getButtonAtaque3().setVisible(false);
                vista.getButtonAtaque4().setVisible(false);
                int vidaRestante=0;

                //Debilidad contra Lucha_Acero (20% reduccion)
                if (pokemonRival.getTipo().toString().equalsIgnoreCase("Lucha_Acero")){

                    vidaRestante = pokemonRival.getVida()- (int) (pokemon.getMov1()*0.2);
                    pokemonRival.setVida(vidaRestante);
                    System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getMov1() + " contra "+ pokemon.getNombre());
                    System.out.println(pokemon.getMov1() + " es poco eficaz contra " + pokemonRival.getNombre());
                }

                //Sin debilidad
                vidaRestante= pokemonRival.getVida()- pokemon.getMov1();
                System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getMov1() + " contra "+ pokemon.getNombre());


                //Realizamos el ataque del rival
                ataquePokemonRival(pokemon,pokemonRival);

            });


            //ATAQUE 2: Pulso Umbrio: 80 (Debil contra Lucario)
            vista.getButtonAtaque2().addActionListener(e->{
                vista.getButtonAtaque1().setVisible(false);
                vista.getButtonAtaque3().setVisible(false);
                vista.getButtonAtaque4().setVisible(false);
                int vidaRestante=0;
                    //Debilidad contra Lucha_Acero (20% reduccion)
                if (pokemonRival.getTipo().toString().equalsIgnoreCase("Lucha_Acero")){

                    vidaRestante = pokemonRival.getVida()- (int) (pokemon.getMov1()*0.2);
                    pokemonRival.setVida(vidaRestante);
                    System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getMov2() + " contra "+ pokemon.getNombre());
                    System.out.println(pokemon.getMov2() + " es poco eficaz contra " + pokemonRival.getNombre());
                }

                //Sin debilidad
                vidaRestante= pokemonRival.getVida()- pokemon.getMov2();
                System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getMov2() + " contra "+ pokemon.getNombre());


                //Realizamos el ataque del rival
                ataquePokemonRival(pokemon,pokemonRival);

            });


            //ATAQUE 3: Corte: 50 (Debil contra Lucario y Lycanroc)
            vista.getButtonAtaque3().addActionListener(e->{
                vista.getButtonAtaque1().setVisible(false);
                vista.getButtonAtaque2().setVisible(false);
                vista.getButtonAtaque4().setVisible(false);
                int vidaRestante=0;

                //Debilidad contra Lucha_Acero y Roca (20% reduccion)
                if (pokemonRival.getTipo().toString().equalsIgnoreCase("Lucha_Acero")||
                    pokemonRival.getTipo().toString().equalsIgnoreCase("Roca")){

                    vidaRestante = pokemonRival.getVida()- (int) (pokemon.getMov3()*0.2);
                    pokemonRival.setVida(vidaRestante);
                    System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getMov3() + " contra "+ pokemon.getNombre());
                    System.out.println(pokemon.getMov3() + " es poco eficaz contra " + pokemonRival.getNombre());
                }

                //Sin debilidad
                vidaRestante= pokemonRival.getVida()- pokemon.getMov3();
                System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getMov3() + " contra "+ pokemon.getNombre());


                //Realizamos el ataque del rival
                ataquePokemonRival(pokemon,pokemonRival);
            });

            //ATAQUE 4:Bola Sombra: 80 (Fuerte contral bicho/volador)
            vista.getButtonAtaque4().addActionListener(e->{
                vista.getButtonAtaque1().setVisible(false);
                vista.getButtonAtaque3().setVisible(false);
                vista.getButtonAtaque2().setVisible(false);
                int vidaRestante=0;

                //Fortaleza contra Bicho/Volador (50% reduccion)
                if (pokemonRival.getTipo().toString().equals("Bicho_Volador")){
                    vidaRestante = pokemonRival.getVida()- (int) (pokemon.getMov4()*0.5+ pokemon.getMov4());
                    pokemonRival.setVida(vidaRestante);
                    System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getMov4() + " contra "+ pokemon.getNombre());
                    System.out.println("Es supereficaz!!!");

                }

                //Sin debilidad
                vidaRestante= pokemonRival.getVida()- pokemon.getMov4();
                System.out.println(pokemon.getNombre()+" ha usado "+pokemon.getMov4() + " contra "+ pokemon.getNombre());

                //Ataque del rival
                ataquePokemonRival(pokemon, pokemonRival);
            });
        }

    }

    private void ataquePokemonRival(Pokemon pokemon, Pokemon pokemonRival) {
        //El ataque se realizara aleatoriamente con un Math.Random
        int random = (int) (Math.random()*4);
        int vidaRestante=0;


        //Posibles Ataques: Roca Veloz (Lyc), Ataque Ala (Sc), Paranormal (Rk)
        //Roca Veloz= Debil contra Lucario, Ataque Ala y Paranormal = Fuerte contra Lucario
        if (random==1){

            if (tiposMovimiento.Roca.toString().equalsIgnoreCase("Roca")||
                tiposMovimiento.Volador.toString().equalsIgnoreCase("Volador")){
                //Incremento de un 50% del daño si es fuerte contra Lucario
                vidaRestante = pokemon.getVida()-(int) (pokemonRival.getMov1()*0.50+pokemonRival.getMov1());
                pokemon.setVida(vidaRestante);

                System.out.println(pokemonRival.getNombre()+" ha usado " + pokemonRival.getNombreMov1()
                + " contra "+ pokemon.getNombre());
                System.out.println("Ha sido supereficaz!!");
            }

                //Reduccion de un 20% si es debil contra Lucario
            if (tiposMovimiento.Roca.toString().equalsIgnoreCase("Roca")){
                vidaRestante = pokemon.getVida()-(int) (pokemonRival.getMov1()*0.20);
                pokemon.setVida(vidaRestante);

                System.out.println(pokemonRival.getNombre()+" ha usado " + pokemonRival.getNombreMov1()
                        + " contra "+ pokemon.getNombre());
                System.out.println("Ha sido poco eficaz...");

            }


            vidaRestante = pokemon.getVida()-pokemonRival.getMov1();
            pokemon.setVida(vidaRestante);
            System.out.println(pokemonRival.getNombre()+" ha usado " + pokemonRival.getNombreMov1()
                    + " contra "+ pokemon.getNombre());

        }

        //Posibles Ataques: Triturar (Lyc), Tijera X (Sc), Golpe Roca (Rk)
        //Triturar y Tijera X (bicho y siniestro) = Debil contra Lucario,
        if (random==2){
            //Reduccion de un 20% de daño contra Lucario
            if (tiposMovimiento.Bicho.toString().equalsIgnoreCase("Bicho")||
                tiposMovimiento.Siniestro.toString().equalsIgnoreCase("Siniestro")){
                vidaRestante = pokemon.getVida()-(int) (pokemonRival.getMov2()*0.20);
                pokemon.setVida(vidaRestante);

                System.out.println(pokemonRival.getNombre()+" ha usado " + pokemonRival.getNombreMov2()
                        + " contra "+ pokemon.getNombre());
                System.out.println("Ha sido poco eficaz...");
            }

            vidaRestante= pokemon.getVida()- pokemonRival.getMov2();
            pokemon.setVida(vidaRestante);

            System.out.println(pokemonRival.getNombre()+" ha usado " + pokemonRival.getNombreMov2()
                    + " contra "+ pokemon.getNombre());
        }

        //Posibles Ataques: Avalancha (Lyc), Tajo Areo (Sc), Trueno (Rk)
        //Avalancha (Roca) = Debil contra Lucario ----Tajo Areo (Volador) = Fuerte contra Lucario
        if (random==3){

            if (tiposMovimiento.Volador.toString().equalsIgnoreCase("Volador")){
                    //incremento del 50% de daño contra Lucario
                vidaRestante = pokemon.getVida()-(int) (pokemonRival.getMov3()*0.50+pokemonRival.getMov3());
                pokemon.setVida(vidaRestante);

                System.out.println(pokemonRival.getNombre()+" ha usado " + pokemonRival.getNombreMov3()
                        + " contra "+ pokemon.getNombre());
                System.out.println("Ha sido supereficaz!!");
            }

            //Reduccion del 20% de daño contra Lucario
            if (tiposMovimiento.Roca.toString().equalsIgnoreCase("Roca")){
                vidaRestante = pokemon.getVida()-(int) (pokemonRival.getMov3()*0.20);
                pokemon.setVida(vidaRestante);

                System.out.println(pokemonRival.getNombre()+" ha usado " + pokemonRival.getNombreMov3()
                        + " contra "+ pokemon.getNombre());
                System.out.println("Ha sido poco eficaz...");
            }

            vidaRestante= pokemon.getVida() - pokemonRival.getMov3();
            pokemon.setVida(vidaRestante);

            System.out.println(pokemonRival.getNombre()+" ha usado " + pokemonRival.getNombreMov3()
                    + " contra "+ pokemon.getNombre());
        }

        //Posibles Ataques= Mordisco (Lyc), Corte Furia (Sc), Chispazo (Rk)
        //Mordisco y Cortes Furia (Siniestro, Bicho): Debol contra Lucario
        if (random==4){
            //Reduccion de un 20% de daño contra Lucario
            if (tiposMovimiento.Siniestro.toString().equalsIgnoreCase("Siniestro")||
                    tiposMovimiento.Bicho.toString().equalsIgnoreCase("Bicho")){
                vidaRestante = pokemon.getVida()-(int) (pokemonRival.getMov4()*0.20);
                pokemon.setVida(vidaRestante);

                System.out.println(pokemonRival.getNombre()+" ha usado " + pokemonRival.getNombreMov4()
                        + " contra "+ pokemon.getNombre());
                System.out.println("Ha sido poco eficaz...");
            }

            vidaRestante= pokemon.getVida()- pokemonRival.getMov4();
            pokemon.setVida(vidaRestante);

            System.out.println(pokemonRival.getNombre()+" ha usado " + pokemonRival.getNombreMov4()
                    + " contra "+ pokemon.getNombre());
        }

    }


    private Pokemon escogerPokemonRival() {
        //Se elegirá con un Math random cualquiera
        int random = (int) (Math.random()*10-1);
        
        //Si <=3 :Lycanroc | >3 <=6: Scyther | >6 <=9: Raikou
        if (random<=3){
            pokemon = new Pokemon(nombrePokemon.Lycanroc, tipoPokemon.Roca, 200,40, 80
            , 75, 60, "Roca Veloz", "Triturar", "Avalancha", "Mordisco"
            , tiposMovimiento.Roca, tiposMovimiento.Siniestro, tiposMovimiento.Roca, tiposMovimiento.Siniestro);
            System.out.println("Lycanroc");
        }
        if (random >3 && random<=6){
            pokemon = new Pokemon(nombrePokemon.Scyther, tipoPokemon.Bicho_Volador, 200, 60, 80, 75, 40
                    , "Ataque Ala", "Tijera X", "Tajo Aéreo", "Corte Furia",
                    tiposMovimiento.Volador, tiposMovimiento.Bicho, tiposMovimiento.Volador, tiposMovimiento.Bicho);
            System.out.println("Scyther");
        }
        if (random>6 && random<=9){
            pokemon = new Pokemon(nombrePokemon.Raikou, tipoPokemon.Electrico, 200, 80, 40, 110, 80
            , "Paranormal", "Golpe Roca", "Trueno", "Chispazo",
                    tiposMovimiento.Psiquico, tiposMovimiento.Lucha, tiposMovimiento.Electrico, tiposMovimiento.Electrico);
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
