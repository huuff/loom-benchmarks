package xyz.haff.loombenchmarks.data_rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import static org.springframework.http.HttpMethod.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;



/**
 * Disable modifying methods
 */
@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.getExposureConfiguration()
                .withAssociationExposure((metadata, methods) -> methods.disable(POST, PUT, PATCH, DELETE))
                .withItemExposure(((metadata, httpMethods) -> httpMethods.disable(POST, PUT, PATCH, DELETE)))
                .withCollectionExposure(((metadata, httpMethods) -> httpMethods.disable(POST, PUT, PATCH, DELETE)))
        ;
    }
}
