package co.com.sofka.questions;

import co.com.sofka.models.UserPut;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseQuestionReqres implements Question {

    @Override
    public UserPut answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(UserPut.class);
    }
}
