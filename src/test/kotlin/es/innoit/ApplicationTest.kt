package es.innoit

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
open class ApplicationTest {

    protected var url = ""

    @LocalServerPort
    protected var port = 0

    @Autowired
    protected var restTemplate: TestRestTemplate? = null

    @BeforeEach
    fun init() {
        url = "http://localhost:$port"
    }

}
