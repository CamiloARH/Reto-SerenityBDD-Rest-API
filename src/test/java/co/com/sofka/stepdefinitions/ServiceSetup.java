package co.com.sofka.stepdefinitions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.HashMap;

public class ServiceSetup {
    protected static final String URL_BASE_POKEMON = "https://pokeapi.co";
    protected static final String RESOURCE_POKEMON = "/api/v2/pokemon?limit=10&offset=0";
    protected static final String URL_BASE_REQRES = "https://reqres.in";
    protected static final String RESOURCE_REQRES = "/api/users/2";
    protected Actor actor = new Actor("Camilo");

    protected void setUpPokemon(){
        actorCanPokemon();
    }
    private void actorCanPokemon(){
        actor.can(CallAnApi.at(URL_BASE_POKEMON));
    }
    protected void setUpReqres(){
        actorCanReqres();
    }
    private void actorCanReqres(){
        actor.can(CallAnApi.at(URL_BASE_REQRES));
    }

}
