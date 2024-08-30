package es.innoit.acceptance.cucumber.steps

import es.innoit.ApplicationTest
import es.innoit.delivery.controllers.Order
import es.innoit.domain.model.ShipmentType
import es.innoit.domain.model.ShipmentType.FREE
import es.innoit.domain.model.ShipmentType.STANDARD
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.assertj.core.api.Assertions.assertThat
import java.util.*

class FreeShipmentSteps : ApplicationTest() {
    private var clientType = ""
    private val products: MutableMap<String, Int> = HashMap()
    private var shipmentPrice = -1
    private val order = Order()

    @Given("^el comprador es un cliente (.*)$")
    fun asignClientTypeToOrder(clientType: String) {
        this.clientType = clientType
    }

    @When("^realiza la compra de (.*) (.*)$")
    fun addProductToOrder(amount: Int, product: String) {
        addToOrder(product, amount)
    }

    @Then("^obtiene entrega (.*)$")
    fun validateShipmentPrice(shipmentType: String) {
        shipmentPrice = getShipmentPrice()
        validateShipmentPriceWith(shipmentType)
    }

    private fun translate(shipmentType: String) =
        when (shipmentType.uppercase(Locale.getDefault())) {
            "GRATUITA" -> FREE.name
            else -> STANDARD.name
        }

    private fun validateShipmentPriceWith(shipmentType: String) {
        assertThat(shipmentPrice).isEqualTo(ShipmentType.valueOf(translate(shipmentType)).price())
    }

    private fun getShipmentPrice(): Int {
        order.products = products
        order.clientType = clientType
        return restTemplate!!.postForObject("$url/calcular-costo-envio", order, Int::class.java)
    }

    private fun addToOrder(item: String, amount: Int) {
        products[item] = amount
    }
}
