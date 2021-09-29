package springcloud.gateway.route;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestConstructor;

import java.net.URI;

import static java.lang.String.format;

/**
 * @author : choi-ys
 * @date : 2021-09-29 오후 5:43
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class RoutingTest {

    private TestRestTemplate client;

    @LocalServerPort
    int port;

    private URI uri(String path) {
        try {
            return new URI(format("http://localhost:%d%s", port, path));
        } catch (Exception ex) {
            throw new IllegalArgumentException();
        }
    }

    @Test
    @DisplayName("[Route:hello-api]hello-service")
    void routingForHelloApiHelloService() {
        client = new TestRestTemplate();
        ResponseEntity<String> responseEntity = client.getForEntity(uri("/hello"), String.class);
        System.out.println(responseEntity.getBody());
    }

    @Test
    @DisplayName("[Route:hello-api]new-service")
    void routingForHelloApiNewService() {
        client = new TestRestTemplate();
        ResponseEntity<String> responseEntity = client.getForEntity(uri("/new"), String.class);
        System.out.println(responseEntity.getBody());
    }

    @Test
    @DisplayName("[Route:hello-api]header-service")
    void routingForHelloApiHeaderService() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-HEADER-API-VERSION", "1.0.0");
        HttpEntity entity = new HttpEntity(null, headers);
        client = new TestRestTemplate();
        ResponseEntity<String> responseEntity = client.exchange(uri("/header"), HttpMethod.GET, entity, String.class);

        System.out.println(responseEntity.getBody());
    }
}
