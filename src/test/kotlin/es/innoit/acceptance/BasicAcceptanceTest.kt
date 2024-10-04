package es.innoit.acceptance


import es.innoit.ApplicationTest
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class BasicAcceptanceTest: ApplicationTest() {

    @Test
    fun smoke() {
        val json = restTemplate!!.getForObject("$url/isAlive", String::class.java)
        json shouldBeEqualTo "=)"
    }

}