package es.innoit.domain.usecases

import es.innoit.domain.model.ShipmentType.FREE
import es.innoit.domain.model.ShipmentType.STANDARD
import org.amshove.kluent.invoking
import org.amshove.kluent.shouldBe
import org.amshove.kluent.shouldThrow
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

private const val VIP = "VIP"
private const val BOOKS = "libros"
private const val DVD = "DVD"
private const val REGULAR = "REGULAR"

internal class CalculateShipmentCostTest {
    private val calculateShipmentCost = CalculateShipmentCost()

    @Test
    fun shouldThrowErrorIfNotExistProducts() {
        invoking { calculateShipmentCost(mapOf(), "") } shouldThrow Exception::class
    }

    @Test
    fun shouldGetFreeShippingIfVIPClientBuy5Books(){
        val cost = calculateShipmentCost(mapOf(BOOKS to 5), client = VIP) // naming parameters para semantica de tests
        cost shouldBe FREE.price
    }

    @Test
    fun shouldGetStandardShippingIfNotVIPClient(){
        val cost = calculateShipmentCost(mapOf(BOOKS to 15), client = REGULAR)
        cost shouldBe STANDARD.price
    }

    @Test
    fun shouldGetStandardShippingIfVIPClientBuy4Books(){
        val cost = calculateShipmentCost(mapOf(BOOKS to 4), client = VIP)
        cost shouldBe STANDARD.price
    }

    @Test
    fun shouldGetStandardShippingIfVIPClientBuy5Dvds(){
        val cost = calculateShipmentCost(mapOf(DVD to 5), client = VIP)
        cost shouldBe STANDARD.price
    }

    @Test
    fun shouldGetStandardShippingIfVIPClientBuy5BooksAnd1Dvd(){
        val cost = calculateShipmentCost(mapOf(BOOKS to 5, DVD to 1), client = VIP)
        cost shouldBe STANDARD.price
    }

}

