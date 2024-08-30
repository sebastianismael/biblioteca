package es.innoit.acceptance


import es.innoit.ApplicationTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class BasicAcceptanceTest: ApplicationTest() {

    @Test
    fun smoke() {
        val json = restTemplate.getForObject("$url/isAlive", String::class.java)
        assertThat(json).isEqualTo("=)")
    }

}