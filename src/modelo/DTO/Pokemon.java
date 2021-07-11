package modelo.DTO;

public class Pokemon {

    //Atributos
    private nombrePokemon nombre;
    private tipoPokemon tipo;
    private int vida;
    private int pokedexNacional;
    private int habilidad;
    private int mov1;
    private int mov2;
    private int mov3;
    private int mov4;
    private String nombreMov1;
    private String nombreMov2;
    private String nombreMov3;
    private String nombreMov4;

    //Constructor
    public Pokemon(nombrePokemon nombre, tipoPokemon tipo, int vida, int pokedexNacional, int habilidad, int mov1, int mov2, int mov3, int mov4, String nombreMov1, String nombreMov2, String nombreMov3, String nombreMov4) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.vida = vida;
        this.pokedexNacional = pokedexNacional;
        this.habilidad = habilidad;
        this.mov1 = mov1;
        this.mov2 = mov2;
        this.mov3 = mov3;
        this.mov4 = mov4;
        this.nombreMov1 = nombreMov1;
        this.nombreMov2 = nombreMov2;
        this.nombreMov3 = nombreMov3;
        this.nombreMov4 = nombreMov4;
    }
}
