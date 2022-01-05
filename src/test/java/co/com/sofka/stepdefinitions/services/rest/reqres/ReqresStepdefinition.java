package co.com.sofka.stepdefinitions.services.rest.reqres;

import co.com.sofka.models.UserPut;
import co.com.sofka.questions.ResponseQuestionReqres;
import co.com.sofka.questions.ResponseStatusCode;
import co.com.sofka.stepdefinitions.ServiceSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.tasks.DoDelete.doDelete;
import static co.com.sofka.tasks.DoPut.doPut;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ReqresStepdefinition extends ServiceSetup {

    //Scenario 1
    @Given("el usuario esta en la pagina y desea actualizar su informacion")
    public void elUsuarioEstaEnLaPaginaYDeseaActualizarSuInformacion() {
        setUpReqres();
    }

    @When("el usuario escribe y presiona put")
    public void elUsuarioEscribeYPresionaPut() {
        actor.attemptsTo(doPut()
                .withTheResource(RESOURCE_REQRES)
                .andTheBodyRequest("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}"));
    }

    @Then("el usuario vera que su informacion fue actualizada")
    public void elUsuarioVeraQueSuInformacionFueActualizada() {
        UserPut user = new ResponseQuestionReqres().answeredBy(actor);
        actor.should(seeThat("El codigo de respuesta", ResponseStatusCode.was(), equalTo(200)),
                seeThat("El nombre del trabajo es: ", poke -> user.getJob(), equalTo("zion resident")));

    }

    //Scenario 2
    @Given("el usuario esta en la pagina y desea borrar su informacion")
    public void elUsuarioEstaEnLaPaginaYDeseaBorrarSuInformacion() {
        setUpReqres();
    }

    @When("el usuario presiona delete")
    public void elUsuarioPresionaDelete() {
        actor.attemptsTo(doDelete().withTheResource(RESOURCE_REQRES));
    }

    @Then("el usuario vera que su informacion fue borrada")
    public void elUsuarioVeraQueSuInformacionFueBorrada() {
        actor.should(seeThat("El codigo de respuesta", ResponseStatusCode.was(), equalTo(204)));
    }

}
