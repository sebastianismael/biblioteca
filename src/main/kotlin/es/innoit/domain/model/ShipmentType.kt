package es.innoit.domain.model

enum class ShipmentType(val price: Int) {
    FREE(0), STANDARD(100);

    fun price() = price
}
