package co.com.sofka.utils.services;

public enum PokemonURL {
    BULBASAUR("https://pokeapi.co/api/v2/pokemon/1/"),
    IVYSAUR("https://pokeapi.co/api/v2/pokemon/2/"),
    VENUSAUR("https://pokeapi.co/api/v2/pokemon/3/"),
    CHARMANDER("https://pokeapi.co/api/v2/pokemon/4/"),
    CHARMELEON("https://pokeapi.co/api/v2/pokemon/5/"),
    CHARIZARD("https://pokeapi.co/api/v2/pokemon/6/"),
    SQUIRTLE("https://pokeapi.co/api/v2/pokemon/7/"),
    WARTORTLE("https://pokeapi.co/api/v2/pokemon/8/"),
    BLASTOISE("https://pokeapi.co/api/v2/pokemon/9/");

    private final String value;

    public String getValue() {
        return value;
    }

    PokemonURL(String value) {
        this.value = value;
    }
}
