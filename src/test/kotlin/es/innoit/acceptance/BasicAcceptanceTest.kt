package es.innoit.acceptance


import es.innoit.ApplicationTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BasicAcceptanceTest: ApplicationTest() {

    @Test
    fun smoke() {
        val json = restTemplate!!.getForObject("$url/isAlive", String::class.java)
        assertThat(json).isEqualTo("=)")
    }

}