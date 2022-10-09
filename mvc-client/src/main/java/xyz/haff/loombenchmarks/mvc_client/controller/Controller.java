package xyz.haff.loombenchmarks.mvc_client.controller;

import lombok.RequiredArgsConstructor;
import org.openapitools.client.ApiClient;
import org.openapitools.client.api.BookEntityEntityControllerApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class Controller {
    private final BookEntityEntityControllerApi apiClient;

    @GetMapping
    public ResponseEntity<Object> random() throws Exception {
        var result = apiClient.getCollectionResourceBookentityGet1(1, 20, List.of());

        return ResponseEntity.ok(result);
    }
}
