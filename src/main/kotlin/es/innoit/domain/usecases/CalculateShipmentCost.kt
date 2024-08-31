package es.innoit.domain.usecases

import es.innoit.domain.model.ShipmentType.FREE
import es.innoit.domain.model.ShipmentType.STANDARD
import org.springframework.stereotype.Component


private val VIP = "VIP"
private val BOOKS = "libros"
private val MINIMAL_AMOUNT_TO_FREE_SHIPMENT = 5

@Component
class CalculateShipmentCost {

    operator fun invoke(products: Map<String, Int>, client: String): Int { // operator!
        if (isEmpty(products)) throw Exception("El pedido no contiene productos")

        if (client.isVIP()) { // para explicar extension functions
            if (enounghBooksAmountToFreeShipment(products)) {
                if (justAUniqueProductType(products)) return FREE.price()
            }
        }
        return STANDARD.price()
    }

    private fun isEmpty(products: Map<String, Int>) = products.isEmpty()

    private fun justAUniqueProductType(products: Map<String, Int>) = products.size == 1

    private fun enounghBooksAmountToFreeShipment(products: Map<String, Int>) = // manejo de maps con indices
        products[BOOKS]?.let { amount ->
            amount >= MINIMAL_AMOUNT_TO_FREE_SHIPMENT
        }?: false

}

private fun String.isVIP() = this.equals(VIP, ignoreCase = true)
