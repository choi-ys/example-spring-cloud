package springcloud.config.client.internal.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : choi-ys
 * @date : 2021/10/17 2:18 오후
 */
@RestController
public class InternalConfigClientController {

    @Value("${jwt.signature}")
    private String signature;

    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.subject}")
    private String subject;

    @Value("${jwt.audience}")
    private String audience;

    @Value("${jwt.access-token-validity-in-seconds-term}")
    private Long access_token_validity_in_seconds_term;

    @Value("${jwt.refresh-token-validity-in-seconds-term}")
    private Long refresh_token_validity_in_seconds_term;

    /**
     * http://localhost:8082/test
     */
    @GetMapping("/test")
    public Map<String, Object> test() {
        Map<String, Object> jwtProperties = new HashMap<>();
        jwtProperties.put("signature", signature);
        jwtProperties.put("issuer", issuer);
        jwtProperties.put("subject", subject);
        jwtProperties.put("audience", audience);
        jwtProperties.put("signature", signature);
        jwtProperties.put("access-token-validity-in-seconds-term", access_token_validity_in_seconds_term);
        jwtProperties.put("refresh-token-validity-in-seconds-term", refresh_token_validity_in_seconds_term);
        return jwtProperties;
    }
}