package es.innoit.domain.usecases

import es.innoit.domain.model.ShipmentType.FREE
import es.innoit.domain.model.ShipmentType.STANDARD
import org.springframework.stereotype.Component


private const val VIP = "VIP"
private const val BOOKS = "libros"
private const val MINIMAL_AMOUNT_TO_FREE_SHIPMENT = 5

@Component
class CalculateShipmentCost {

    operator fun invoke(products: Map<String, Int>, client: String): Int { // operator!
        if (products.isEmpty()) throw Exception("El pedido no contiene productos")
        // client.isVIP(): para explicar extension functions
        return if(client.isVIP() && existEnoughBooksAmountToFreeShipment(products) && justAUniqueProductType(products))
            FREE.price()
        else STANDARD.price()
    }

    private fun justAUniqueProductType(products: Map<String, Int>) = products.size == 1

    private fun existEnoughBooksAmountToFreeShipment(products: Map<String, Int>) = // manejo de maps con indices
        products[BOOKS]?.let { amount ->
            amount >= MINIMAL_AMOUNT_TO_FREE_SHIPMENT
        } ?: false
}

private fun String.isVIP() = this.equals(VIP, ignoreCase = true)
