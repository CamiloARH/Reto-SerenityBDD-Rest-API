package co.com.sofka.runners.services.rest;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/services/rest/pokemon/pokemon.feature"
                , "src/test/resources/features/services/rest/reqres/reqres.feature"},
        glue = {"co.com.sofka.stepdefinitions.services.rest.pokemon", "co.com.sofka.stepdefinitions.services.rest.reqres"}
)

public class RestCucumber {
}
