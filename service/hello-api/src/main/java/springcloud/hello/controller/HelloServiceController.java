package springcloud.hello.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : choi-ys
 * @date : 2021-09-29 오후 5:29
 */
@RestController
@RequestMapping(value = "hello")
public class HelloServiceController {

    @GetMapping
    public ResponseEntity retrieveHelloService(){
        return ResponseEntity.ok("hello");
    }
}
