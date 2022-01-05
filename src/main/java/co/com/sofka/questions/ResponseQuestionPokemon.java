package co.com.sofka.questions;

import co.com.sofka.models.Pokedex;
import co.com.sofka.models.UserPut;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseQuestionPokemon implements Question{

    @Override
    public Pokedex answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(Pokedex.class);
    }

}
