package springcloud.kakao.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : choi-ys
 * @date : 2021-09-30 오후 7:40
 */
@RestController
public class KakaoInstanceController {

    @Value("${spring.application.name}")
    private String APPLICATION_NAME;

    private final DiscoveryClient discoveryClient;

    public KakaoInstanceController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/instance")
    public String client() {
        List<ServiceInstance> instances = discoveryClient.getInstances(APPLICATION_NAME);
        ServiceInstance selectedServiceInstance = instances.get(0);
        return APPLICATION_NAME
                .concat(":")
                .concat(selectedServiceInstance.getInstanceId())
                .concat(":" + selectedServiceInstance.getPort());
    }
}
