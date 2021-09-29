package springcloud.hello.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : choi-ys
 * @date : 2021-09-29 오후 5:29
 */
@RestController
@RequestMapping(value = "header")
public class HeaderServiceController {

    @GetMapping
    public ResponseEntity retrieveHeaderService(@RequestHeader(value = "X-HEADER-API-VERSION") String apiVersion) {
        return ResponseEntity.ok("header service version : " + apiVersion);
    }
}
