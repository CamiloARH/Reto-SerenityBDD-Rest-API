package co.com.sofka.stepdefinitions.services.rest.pokemon;

import co.com.sofka.models.ResultPokemon;
import co.com.sofka.questions.ResponseQuestionPokemon;
import co.com.sofka.questions.ResponseStatusCode;
import co.com.sofka.stepdefinitions.ServiceSetup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.tasks.DoDelete.doDelete;
import static co.com.sofka.tasks.DoGet.doGet;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class PokemonStepdefinition extends ServiceSetup {


    //Scenario 1
    @Given("El usuario quiere saber la lista de Pokemons que le faltan")
    public void elUsuarioQuiereSaberLaListaDePokemonsQueLeFaltan() {
        super.setUpPokemon();
    }

    @When("el usuario busca en el pokedex")
    public void elUsuarioBuscaEnElPokedex() {
        actor.attemptsTo(doGet().withTheResource(RESOURCE_POKEMON));
    }

    @Then("el usuario debera ver una lista de Pokemons")
    public void elUsuarioDeberaVerUnaListaDePokemons() {
        ResultPokemon pokemon = new ResponseQuestionPokemon().answeredBy(actor).getResults().stream().filter(x -> x.getName().equals("charizard")).findFirst().get();
        actor.should(seeThat("El codigo de respuesta", ResponseStatusCode.was(), equalTo(200)),
                seeThat("La Url del pokemon es: ", poke -> pokemon.getUrl(), equalTo("https://pokeapi.co/api/v2/pokemon/6/")));
    }

    //Scenario 2
    @Given("El usuario quiere borrar un Pokemon")
    public void elUsuarioQuiereBorrarUnPokemon() {
        super.setUpPokemon();
    }

    @When("el usuario intenta borrar un pokemon de la pokedex")
    public void elUsuarioIntentaBorrarUnPokemonDeLaPokedex() {
        actor.attemptsTo(doDelete().withTheResource(RESOURCE_POKEMON));
    }

    @Then("el usuario debera ver el error {int}")
    public void elUsuarioDeberaVerElError(Integer error) {
        actor.should(seeThat("El codigo de respuesta", ResponseStatusCode.was(), equalTo(404)));
    }

}
