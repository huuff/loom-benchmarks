package xyz.haff.loombenchmarks.mvc_client.config;

import org.openapitools.client.ApiClient;
import org.openapitools.client.api.BookEntityEntityControllerApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {
    @Value("${TARGET_URL}")
    private String url;

    @Bean
    public BookEntityEntityControllerApi apiClient() {
        return new BookEntityEntityControllerApi(new ApiClient().setBasePath(url));
    }
}
