package es.innoit.delivery.controllers

import es.innoit.domain.usecases.ShipmentCostCalculator
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class LibraryController(
    private val shipmentCostCalculator: ShipmentCostCalculator
) {
    @PostMapping(path = ["/calcular-costo-envio"])
    fun calculatePrice(@RequestBody order: Order) = shipmentCostCalculator.calculate(order.products, order.clientType)
}


class Order (
    var shipmentAddress: String = "",
    var clientType: String = "",
    var products: Map<String, Int> = mapOf(),
)