package vista;

import javax.swing.*;
import java.awt.*;

public class Vista {
    private JPanel mainPanel;
    private JPanel bottomPanel;
    private JPanel topPanel;
    private JPanel infoPanel;
    private JPanel centralPanel;
    private JLabel vidaLabel;
    private JTextField textFieldVidaPokemon;
    private JLabel vidaRivalLabel;
    private JTextField textFieldVidaPokemonRival;
    private JTextField textFieldAtaque1;
    private JTextField textFieldAtaque2;
    private JTextField textFieldAtaque3;
    private JTextField textFieldAtaque4;
    private JButton buttonAtaque1;
    private JButton buttonAtaque2;
    private JButton buttonAtaque3;
    private JButton buttonAtaque4;
    private JLabel nombreLabel;
    private JTextField textFieldInfoPokemon;
    private JLabel tipoPokemonLabel;
    private JTextField textFieldTipoPokemon;
    private JLabel InfoVidaLabel;
    private JTextField textFieldInfoVida;
    private JLabel PokedexLabel;
    private JTextField textFieldPokedex;
    private JLabel HabilidadLabel;
    private JTextField textFieldHabilidad;
    private JButton buttonOcultarInfo;
    private JLabel InfoLabel;
    private JLabel SeleccionPokemonLabel;
    private JLabel lucarioIntro;
    private JButton buttonSelectLucario;
    private JButton buttonInfoLucario;
    private JButton buttonSelectZeraora;
    private JButton buttonInfoZeraora;
    private JButton buttonSelectZoroark;
    private JButton buttonInfoZoroark;
    private JLabel zeraoraIntro;
    private JLabel zoroarkIntro;


    //Getters de Botones, TextField y panel Añadir

    public JPanel getBottomPanel() {
        return bottomPanel;
    }

    public JPanel getTopPanel() {
        return topPanel;
    }

    public JPanel getInfoPanel() {
        return infoPanel;
    }

    public JPanel getCentralPanel() {
        return centralPanel;
    }

    public JTextField getTextFieldVidaPokemon() {
        return textFieldVidaPokemon;
    }

    public JTextField getTextFieldVidaPokemonRival() {
        return textFieldVidaPokemonRival;
    }

    public JTextField getTextFieldAtaque1() {
        return textFieldAtaque1;
    }

    public JTextField getTextFieldAtaque2() {
        return textFieldAtaque2;
    }

    public JTextField getTextFieldAtaque3() {
        return textFieldAtaque3;
    }

    public JTextField getTextFieldAtaque4() {
        return textFieldAtaque4;
    }

    public JButton getButtonAtaque1() {
        return buttonAtaque1;
    }

    public JButton getButtonAtaque2() {
        return buttonAtaque2;
    }

    public JButton getButtonAtaque3() {
        return buttonAtaque3;
    }

    public JButton getButtonAtaque4() {
        return buttonAtaque4;
    }

    public JTextField getTextFieldInfoPokemon() {
        return textFieldInfoPokemon;
    }

    public JTextField getTextFieldTipoPokemon() {
        return textFieldTipoPokemon;
    }

    public JTextField getTextFieldInfoVida() {
        return textFieldInfoVida;
    }

    public JTextField getTextFieldPokedex() {
        return textFieldPokedex;
    }

    public JTextField getTextFieldHabilidad() {
        return textFieldHabilidad;
    }

    public JButton getButtonOcultarInfo() {
        return buttonOcultarInfo;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JButton getButtonSelectLucario() {
        return buttonSelectLucario;
    }

    public JButton getButtonInfoLucario() {
        return buttonInfoLucario;
    }

    public JButton getButtonSelectZeraora() {
        return buttonSelectZeraora;
    }

    public JButton getButtonInfoZeraora() {
        return buttonInfoZeraora;
    }

    public JButton getButtonSelectZoroark() {
        return buttonSelectZoroark;
    }

    public JButton getButtonInfoZoroark() {
        return buttonInfoZoroark;
    }

    //Arranque de la ventana principal
    public Vista (){
        JFrame frame = new JFrame();
        frame.setTitle("Pokemon Battle Simulator Java Edition");
        frame.setContentPane(mainPanel);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(dimension.width, dimension.height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}



