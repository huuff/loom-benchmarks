package xyz.haff.loombenchmarks.mvc_client.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.haff.loombenchmarks.mvc_client.service.RandomPageService;


@RestController
@RequiredArgsConstructor
public class Controller {
    private final RandomPageService randomPageService;

    @GetMapping
    public ResponseEntity<Object> random() throws Exception {
        return ResponseEntity.ok(randomPageService.randomPage());
    }
}
