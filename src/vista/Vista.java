package vista;

import javax.swing.*;
import java.awt.*;

public class Vista {
    private JPanel mainPanel;
    private JPanel buttonsMovementPanel;
    private JPanel topPanel;
    private JPanel infoPanel;
    private JPanel introPanel;
    private JPanel combatPanel;
    private JTextField textFieldVidaPokemon;
    private JTextField textFieldVidaPokemonRival;
    private JButton buttonAtaque1;
    private JButton buttonAtaque2;
    private JButton buttonAtaque3;
    private JButton buttonAtaque4;
    private JTextField textFieldInfoPokemon;
    private JTextField textFieldTipoPokemon;
    private JTextField textFieldInfoVida;
    private JTextField textFieldPokedex;
    private JButton buttonOcultarInfo;
    private JLabel lucarioIntro;
    private JButton buttonSelectLucario;
    private JButton buttonInfoLucario;
    private JButton buttonSelectZeraora;
    private JButton buttonInfoZeraora;
    private JButton buttonSelectZoroark;
    private JButton buttonInfoZoroark;
    private JLabel zeraoraIntro;
    private JLabel zoroarkIntro;
    private JTextField textFieldInfoGeneracion;
    private JTextArea textAreaInfoHabilidad;
    private JLabel vidaLabel;
    private JLabel vidaRivalLabel;
    private JPanel bottomPanel;
    private JLabel backgroundImageLabel;
    private JLabel introImage;
    private JButton buttonStart;
    private JTextField textFieldNarrador;
    private JLabel nombreLabel;
    private JLabel tipoPokemonLabel;
    private JLabel InfoVidaLabel;
    private JLabel PokedexLabel;
    private JLabel HabilidadLabel;
    private JLabel InfoLabel;
    private JLabel InfoGeneracionLabel;
    private JLabel SeleccionPokemonLabel;
    private JPanel centralPanel;
    private JFrame frame;
    private JPanel selecctionlPanel;


    //Getters de Botones, TextField y paneles

    public JPanel getBottomPanel() {
        return buttonsMovementPanel;
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

    public JPanel getCombatPanel() {
        return combatPanel;
    }

    public JPanel getIntroPanel() {
        return introPanel;
    }

    public JTextField getTextFieldVidaPokemon() {
        return textFieldVidaPokemon;
    }

    public JTextField getTextFieldVidaPokemonRival() {
        return textFieldVidaPokemonRival;
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

    public JTextField getTextFieldInfoGeneracion() {
        return textFieldInfoGeneracion;
    }

    public JTextArea getTextAreaInfoHabilidad() {
        return textAreaInfoHabilidad;
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

    public JLabel getLucarioIntro() {
        return lucarioIntro;
    }

    public JLabel getZeraoraIntro() {
        return zeraoraIntro;
    }

    public JLabel getZoroarkIntro() {
        return zoroarkIntro;
    }


    public JPanel getButtonsMovementPanel() {
        return buttonsMovementPanel;
    }

    public JButton getButtonStart() {
        return buttonStart;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JLabel getBackgroundImageLabel() {
        return backgroundImageLabel;
    }

    public JTextField getTextFieldNarrador() {
        return textFieldNarrador;
    }


    //Arranque de la ventana principal
    public Vista (){
         frame = new JFrame();

        frame.setTitle("Pokemon Battle Simulator Java Edition");
        frame.setContentPane(mainPanel);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(dimension.width, dimension.height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}



