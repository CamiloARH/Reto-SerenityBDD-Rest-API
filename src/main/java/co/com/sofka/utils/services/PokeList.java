package co.com.sofka.utils.services;

public enum PokeList {
    BULBASAUR("bulbasaur"),
    IVYSAUR("ivysaur"),
    VENUSAUR("venusaur"),
    CHARMANDER("charmander"),
    CHARMELEON("charmeleon"),
    CHARIZARD("charizard"),
    SQUIRTLE("squirtle"),
    WARTORTLE("wartortle"),
    BLASTOISE("blastoise");


    private final String value;

    public String getValue() {
        return value;
    }

    PokeList(String value) {
        this.value = value;
    }

}
