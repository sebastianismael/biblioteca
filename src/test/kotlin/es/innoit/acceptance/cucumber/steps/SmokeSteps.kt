package es.innoit.acceptance.cucumber.steps

import es.innoit.ApplicationTest
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.cucumber.spring.CucumberContextConfiguration
import org.amshove.kluent.shouldBeEqualTo

@CucumberContextConfiguration
class SmokeSteps: ApplicationTest() {
    private lateinit var json: String

    @When("^hago la prueba de conectividad con el sitio$")
    fun smokeInvoke() {
        json = restTemplate!!.getForObject("$url/isAlive", String::class.java)
    }

    @Then("^obtengo una respuesta exitosa$")
    fun successfulAnswer() {
        json shouldBeEqualTo "=)"
    }
}
