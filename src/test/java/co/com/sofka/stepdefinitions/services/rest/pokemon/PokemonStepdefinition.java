package co.com.sofka.stepdefinitions.services.rest.pokemon;

import co.com.sofka.models.ResultPokemon;
import co.com.sofka.questions.ResponseQuestionPokemon;
import co.com.sofka.questions.ResponseStatusCode;
import co.com.sofka.stepdefinitions.ServiceSetup;

import co.com.sofka.utils.services.PokeList;
import co.com.sofka.utils.services.PokemonURL;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import static co.com.sofka.tasks.DoDelete.doDelete;
import static co.com.sofka.tasks.DoGet.doGet;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class PokemonStepdefinition extends ServiceSetup {


    public static Logger log = Logger.getLogger(PokemonStepdefinition.class);

    //Scenario 1
    @Given("El usuario quiere saber la lista de Pokemons que le faltan")
    public void elUsuarioQuiereSaberLaListaDePokemonsQueLeFaltan() {
        try {
            super.setUpPokemon();
            log.info("Se ajustan los setups del primer scenario de Pokemon");
        } catch (Exception e) {
            log.error("error en la inicializacion primer scenario de Pokemon");
        }
    }

    @When("el usuario busca en el pokedex")
    public void elUsuarioBuscaEnElPokedex() {
        try {
            actor.attemptsTo(doGet().withTheResource(RESOURCE_POKEMON));
            log.info("El actor realiza el get en el recurso de Pokemon");
        } catch (Exception e) {
            log.error("error en la realizacion del get de pokemon");
        }
    }

    @Then("el usuario debera ver una lista de Pokemons")
    public void elUsuarioDeberaVerUnaListaDePokemons() {
        try {
            actor.should(seeThat("El codigo de respuesta", ResponseStatusCode.was(), equalTo(200)),
                    seeThat("La Url del pokemon es: ", poke -> pokemon().getUrl(), equalTo(PokemonURL.CHARIZARD.getValue())));
            log.info("El maestro pokemon verifica lo obtenido en el primer scenario de pokemon");
        } catch (Exception e) {
            log.error("Error en la verificacion del primer scenario de pokemon");
        }
    }

    //Scenario 2
    @Given("El usuario quiere borrar un Pokemon")
    public void elUsuarioQuiereBorrarUnPokemon() {
        try {
            super.setUpPokemon();
            log.info("Se ajustan los setups del segundo scenario de Pokemon");
        } catch (Exception e) {
            log.error("error en la inicializacion segundo scenario de Pokemon");
        }
    }

    @When("el usuario intenta borrar un pokemon de la pokedex")
    public void elUsuarioIntentaBorrarUnPokemonDeLaPokedex() {
        try {
            actor.attemptsTo(doDelete().withTheResource(RESOURCE_POKEMON));
            log.info("El actor realiza el delete en el recurso de Pokemon");
        } catch (Exception e) {
            log.error("error en la realizacion del delete de pokemon");
        }
    }

    @Then("el usuario debera ver el error {int}")
    public void elUsuarioDeberaVerElError(Integer error) {
        try {
            actor.should(seeThat("El codigo de respuesta", ResponseStatusCode.was(), equalTo(error)));
            log.info("El maestro pokemon verifica lo obtenido en el segundo scenario de pokemon");
        } catch (Exception e) {
            log.error("Error en la verificacion del segundo scenario de pokemon");
        }
    }

    private ResultPokemon pokemon() {
        return new ResponseQuestionPokemon().answeredBy(actor).getResults().stream().filter(x -> x.getName().equals(PokeList.CHARIZARD.getValue())).findFirst().get();
    }
}
