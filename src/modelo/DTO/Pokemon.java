package modelo.DTO;

public class Pokemon {

    //Atributos
    private nombrePokemon nombre;
    private tipoPokemon tipo;
    private int vida;

    private int mov1;
    private int mov2;
    private int mov3;
    private int mov4;
    private String nombreMov1;
    private String nombreMov2;
    private String nombreMov3;
    private String nombreMov4;
    private tiposMovimiento tipoMov1;
    private tiposMovimiento tipoMov2;
    private tiposMovimiento tipoMov13;
    private tiposMovimiento tipoMov4;

    //Constructor

    public Pokemon(nombrePokemon nombre, tipoPokemon tipo, int vida, int mov1, int mov2, int mov3, int mov4, String nombreMov1, String nombreMov2, String nombreMov3, String nombreMov4, tiposMovimiento tipoMov1, tiposMovimiento tipoMov2, tiposMovimiento tipoMov13, tiposMovimiento tipoMov4) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.vida = vida;
        this.mov1 = mov1;
        this.mov2 = mov2;
        this.mov3 = mov3;
        this.mov4 = mov4;
        this.nombreMov1 = nombreMov1;
        this.nombreMov2 = nombreMov2;
        this.nombreMov3 = nombreMov3;
        this.nombreMov4 = nombreMov4;
        this.tipoMov1 = tipoMov1;
        this.tipoMov2 = tipoMov2;
        this.tipoMov13 = tipoMov13;
        this.tipoMov4 = tipoMov4;
    }




    //getters y setters
    public nombrePokemon getNombre() {
        return nombre;
    }

    public tipoPokemon getTipo() {
        return tipo;
    }

    public int getVida() {
        return vida;
    }

    public int getMov1() {
        return mov1;
    }

    public int getMov2() {
        return mov2;
    }

    public int getMov3() {
        return mov3;
    }

    public int getMov4() {
        return mov4;
    }

    public String getNombreMov1() {
        return nombreMov1;
    }

    public String getNombreMov2() {
        return nombreMov2;
    }

    public String getNombreMov3() {
        return nombreMov3;
    }

    public String getNombreMov4() {
        return nombreMov4;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}
