package co.com.sofka.stepdefinitions.services.rest.reqres;

import co.com.sofka.models.UserPut;
import co.com.sofka.questions.ResponseQuestionReqres;
import co.com.sofka.questions.ResponseStatusCode;
import co.com.sofka.stepdefinitions.ServiceSetup;
import co.com.sofka.utils.services.UserBody;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import static co.com.sofka.tasks.DoDelete.doDelete;
import static co.com.sofka.tasks.DoPut.doPut;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ReqresStepdefinition extends ServiceSetup {

    public static Logger log = Logger.getLogger(ReqresStepdefinition.class);

    //Scenario 1
    @Given("el usuario esta en la pagina y desea actualizar su informacion")
    public void elUsuarioEstaEnLaPaginaYDeseaActualizarSuInformacion() {
        try {
            setUpReqres();
            log.info("Se ajustan los setups del primer scenario de Reqres");
        } catch (Exception e) {
            log.error("Error en la inicializacion de los set up primer scenario de Reqres");
        }
    }

    @When("el usuario escribe y presiona put")
    public void elUsuarioEscribeYPresionaPut() {
        try {
            actor.attemptsTo(doPut()
                    .withTheResource(RESOURCE_REQRES)
                    .andTheBodyRequest(UserBody.BODY.getValue()));
            log.info("El actor realiza el put para actualizar datos en el recurso de Reqres");
        } catch (Exception e) {
            log.error("error en la realizacion del put de Reqres");
        }

    }

    @Then("el usuario vera que su informacion fue actualizada")
    public void elUsuarioVeraQueSuInformacionFueActualizada() {
        try {
            actor.should(seeThat("El codigo de respuesta", ResponseStatusCode.was(), equalTo(200)),
                    seeThat("El nombre del trabajo es: ", usuario -> user().getJob(), equalTo("zion resident")));
            log.info("El usuario verifica lo obtenido en el primer scenario de Reqres");
        } catch (Exception e) {
            log.error("Error en la verificacion del primer scenario de Reqres");
        }
    }

    //Scenario 2
    @Given("el usuario esta en la pagina y desea borrar su informacion")
    public void elUsuarioEstaEnLaPaginaYDeseaBorrarSuInformacion() {
        try {
            setUpReqres();
            log.info("Se ajustan los setups del segundo scenario de Reqres");
        } catch (Exception e) {
            log.error("Error en la inicializacion de los set up segundo scenario de Reqres");
        }
    }

    @When("el usuario presiona delete")
    public void elUsuarioPresionaDelete() {
        try {
            actor.attemptsTo(doDelete().withTheResource(RESOURCE_REQRES));
            log.info("El actor realiza el delete de Reqres");
        } catch (Exception e) {
            log.error("error en la realizacion del delete de Reqres");
        }
    }

    @Then("el usuario vera que su informacion fue borrada con la respuesta {int}")
    public void elUsuarioVeraQueSuInformacionFueBorrada(Integer respuesta) {
        try {
            actor.should(seeThat("El codigo de respuesta", ResponseStatusCode.was(), equalTo(respuesta)));
            log.info("El usuario verifica lo obtenido en el segundo scenario de Reqres");
        } catch (Exception e) {
            log.error("Error en la verificacion del segundo scenario de Reqres");
        }
    }
    private UserPut user() {
        return new ResponseQuestionReqres().answeredBy(actor);
    }
}
