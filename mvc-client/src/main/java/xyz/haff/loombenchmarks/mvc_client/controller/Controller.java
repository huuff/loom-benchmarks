package xyz.haff.loombenchmarks.mvc_client.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequiredArgsConstructor
public class Controller {
    private final RestTemplate restTemplate;
    @Value("${TARGET_URL}")
    private String url;

    @GetMapping
    public ResponseEntity<String> random() {
        var result = restTemplate.getForObject(url, String.class);

        return ResponseEntity.ok(result);
    }
}
