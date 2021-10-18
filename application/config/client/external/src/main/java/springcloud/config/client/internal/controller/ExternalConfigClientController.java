package springcloud.config.client.internal.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : choi-ys
 * @date : 2021/10/17 2:18 오후
 */
@RestController
public class ExternalConfigClientController {

    @Value("${who.am.i}")
    private String identity;

    /**
     * https://github.com/yaboong/spring-cloud-config-repository
     * http://localhost:8081/test
     */
    @GetMapping("/test")
    public String test() {
        return identity;
    }
}